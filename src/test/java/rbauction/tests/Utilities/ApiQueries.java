package rbauction.tests.Utilities;

import rbauction.pages.Utils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import rbauction.tests.BaseTest_RBAuction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ApiQueries {

    private static String USERNAME;
    private static String PASSWORD;
    private static String LOGINURL;
    private static String CLIENTID;
    private static String CLIENTSECRET;

    static final String GRANTSERVICE = "/services/oauth2/token?grant_type=password";
    private static String REST_ENDPOINT = "/services/data" ;
    private static String API_VERSION = "/v56.0" ;
    private static String baseUri;
    private static Header oauthHeader;
    private static Header prettyPrintHeader = new BasicHeader("X-PrettyPrint", "1");

    static {
        try {
            USERNAME     = Utils.getEnvConfigProperty("api_user");
            PASSWORD     = Utils.getEnvConfigProperty("api_user_pw");
            LOGINURL     = Utils.getEnvConfigProperty("api_url");
            CLIENTID     = Utils.getEnvConfigProperty("api_clientId");
            CLIENTSECRET = Utils.getEnvConfigProperty("api_clientSecret");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getOauthToken() throws Exception {
        HttpClient httpclient = HttpClientBuilder.create().build();

        // Assemble the login request URL
        String loginURL = LOGINURL +
                GRANTSERVICE +
                "&client_id=" + CLIENTID +
                "&client_secret=" + CLIENTSECRET +
                "&username=" + USERNAME +
                "&password=" + PASSWORD;

        // Login requests must be POSTs
        HttpPost httpPost = new HttpPost(loginURL);
        HttpResponse response = null;

        try {
            // Execute the login POST request
            response = httpclient.execute(httpPost);
        } catch (ClientProtocolException cpException) {
            cpException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        // verify response is HTTP OK
        final int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != HttpStatus.SC_OK) {
            BaseTest_RBAuction.log("Error authenticating to Force.com: "+statusCode);
            // Error is in EntityUtils.toString(response.getEntity())
            throw new Exception("API request failed");
        }

        String getResult = null;
        try {
            getResult = EntityUtils.toString(response.getEntity());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        JSONObject jsonObject = null;
        String loginAccessToken = null;
        String loginInstanceUrl = null;

        try {
            jsonObject = (JSONObject) new JSONTokener(getResult).nextValue();
            loginAccessToken = jsonObject.getString("access_token");
            loginInstanceUrl = jsonObject.getString("instance_url");
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }

        BaseTest_RBAuction.log("Access Token " +loginAccessToken );
        BaseTest_RBAuction.log("URL returned by SalesForce For Query " +loginInstanceUrl );

        // release connection
        httpPost.releaseConnection();
        return loginAccessToken;
    }

    // Query to get unique link using REST HttpGet
    public static String queryToGetUniqueLink(String uniqueNumber) throws Exception {
        String BCH_Unique_Link__c_value = null;
        String oauthToken = getOauthToken();

        String query ="/query?q=SELECT+BCH_Unique_Link__c+FROM+Account+WHERE+BCH_Registration_Confirmation_Number__c='"+uniqueNumber+"'";

        baseUri = LOGINURL + REST_ENDPOINT + API_VERSION ;
        oauthHeader = new BasicHeader("Authorization", "OAuth " + oauthToken) ;
        String uri = baseUri + query;
        BaseTest_RBAuction.log("oauthToken: " + oauthToken);
        BaseTest_RBAuction.log("baseUri: "+ baseUri);
        BaseTest_RBAuction.log("Query URI: " + uri);

        try {
            //Set up the HTTP objects needed to make the request.
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(uri);
            httpGet.addHeader(oauthHeader);
            httpGet.addHeader(prettyPrintHeader);

            // Make the request.
            HttpResponse response = httpClient.execute(httpGet);

            // Process the result
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String response_string = EntityUtils.toString(response.getEntity());
                try {
                    JSONObject json = new JSONObject(response_string);
                    BaseTest_RBAuction.log("JSON result of Query:\n" + json.toString(1));
                    JSONArray j = json.getJSONArray("records");
                    for (int i = 0; i < j.length(); i++){
                        BCH_Unique_Link__c_value = json.getJSONArray("records").getJSONObject(i).getString("BCH_Unique_Link__c");
                        BaseTest_RBAuction.log("Unique link: " + BCH_Unique_Link__c_value);
                    }
                } catch (JSONException je) {
                    je.printStackTrace();
                }
            } else {
                BaseTest_RBAuction.log("Query was unsuccessful. Status code returned is " + statusCode);
                BaseTest_RBAuction.log("An error has occured. Http status: " + response.getStatusLine().getStatusCode());
                BaseTest_RBAuction.log(getBody(response.getEntity().getContent()));
                throw new Exception("API request failed");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        } catch (Exception e) { //reference to custom throws new Exception
            e.printStackTrace();
        }
        return BCH_Unique_Link__c_value;
    }

    private static String getBody(InputStream inputStream) {
        String result = "";
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(inputStream)
            );
            String inputLine;
            while ( (inputLine = in.readLine() ) != null ) {
                result += inputLine;
                result += "\n";
            }
            in.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return result;
    }

    public static String queryToGetAccountId(String PersonEmail, String LastName, String FirstName) throws Exception {
        BaseTest_RBAuction.log("/*---Query to get AccountId record--*/ ");
        String AccountId = null;
        String oauthToken = getOauthToken();

        String query ="/query?q=SELECT+ID+FROM+Account+WHERE+PersonEmail='"+PersonEmail+"'+AND+LastName='"+LastName+"'+AND+FirstName='"+FirstName+"'+Limit+3";

        baseUri = LOGINURL + REST_ENDPOINT + API_VERSION ;
        oauthHeader = new BasicHeader("Authorization", "OAuth " + oauthToken) ;
        String uri = baseUri + query;
        BaseTest_RBAuction.log("oauthToken: " + oauthToken);
        BaseTest_RBAuction.log("baseUri: "+ baseUri);
        BaseTest_RBAuction.log("Query URI: " + uri);

        try {
            //Set up the HTTP objects needed to make the request.
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(uri);
            httpGet.addHeader(oauthHeader);
            httpGet.addHeader(prettyPrintHeader);

            // Make the request.
            HttpResponse response = httpClient.execute(httpGet);

            // Process the result
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String response_string = EntityUtils.toString(response.getEntity());
                try {
                    JSONObject json = new JSONObject(response_string);
                    BaseTest_RBAuction.log("JSON result of Query:\n" + json.toString(1));
                    JSONArray j = json.getJSONArray("records");
                    for (int i = 0; i < j.length(); i++){
                        AccountId = json.getJSONArray("records").getJSONObject(i).getString("Id");
                        BaseTest_RBAuction.log("AccountId: " + AccountId);
                    }
                } catch (JSONException je) {
                    je.printStackTrace();
                }
            } else {
                BaseTest_RBAuction.log("Query was unsuccessful. Status code returned is " + statusCode);
                BaseTest_RBAuction.log("An error has occured. Http status: " + response.getStatusLine().getStatusCode());
                BaseTest_RBAuction.log(getBody(response.getEntity().getContent()));
                throw new Exception("API request failed");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        } catch (Exception e) {  //reference to custom throws new Exception
            e.printStackTrace();
        }
        return AccountId;
    }

    public static ArrayList<String> queryToGetListOfImmunizationRecords(String AccountId) throws Exception {
        BaseTest_RBAuction.log("/*---Query to get immunization record--*/ ");
        ArrayList<String> ImmunizationRecordList = new ArrayList<String>();
        String ImmunizationRecordId = null;
        String oauthToken = getOauthToken();

        String query ="/query?q=SELECT+ID+FROM+Case+WHERE+AccountId='"+AccountId+"'";

        baseUri = LOGINURL + REST_ENDPOINT + API_VERSION ;
        oauthHeader = new BasicHeader("Authorization", "OAuth " + oauthToken) ;
        String uri = baseUri + query;
        BaseTest_RBAuction.log("oauthToken: " + oauthToken);
        BaseTest_RBAuction.log("baseUri: "+ baseUri);
        BaseTest_RBAuction.log("Query URI: " + uri);

        try {
            //Set up the HTTP objects needed to make the request.
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(uri);
            httpGet.addHeader(oauthHeader);
            httpGet.addHeader(prettyPrintHeader);

            // Make the request.
            HttpResponse response = httpClient.execute(httpGet);

            // Process the result
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String response_string = EntityUtils.toString(response.getEntity());
                try {
                    JSONObject json = new JSONObject(response_string);
                    BaseTest_RBAuction.log("JSON result of Query:\n" + json.toString(1));
                    JSONArray j = json.getJSONArray("records");
                    for (int i = 0; i < j.length(); i++){
                        ImmunizationRecordId = json.getJSONArray("records").getJSONObject(i).getString("Id");
                        BaseTest_RBAuction.log("ImmunizationRecordId: " + ImmunizationRecordId);
                        ImmunizationRecordList.add(ImmunizationRecordId);
                    }
                } catch (JSONException je) {
                    je.printStackTrace();
                }
            } else {
                BaseTest_RBAuction.log("Query was unsuccessful. Status code returned is " + statusCode);
                BaseTest_RBAuction.log("An error has occured. Http status: " + response.getStatusLine().getStatusCode());
                BaseTest_RBAuction.log(getBody(response.getEntity().getContent()));
                throw new Exception("API request failed");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        BaseTest_RBAuction.log("Found amount of immunization records: " + ImmunizationRecordList.size());
        return ImmunizationRecordList;
    }

    public static void deleteImmunizationRecord(String immunizationRecordId) throws Exception {
        BaseTest_RBAuction.log("/*---Delete immunization record " +immunizationRecordId +"--*/ ");
        String oauthToken = getOauthToken();
        oauthHeader = new BasicHeader("Authorization", "OAuth " + oauthToken) ;

        baseUri = LOGINURL + REST_ENDPOINT + API_VERSION ;
        String uri = baseUri + "/sobjects/Case/" + immunizationRecordId;
        BaseTest_RBAuction.log("oauthToken: " + oauthToken);
        BaseTest_RBAuction.log("baseUri: "+ baseUri);
        BaseTest_RBAuction.log("Query URI: " + uri);

        try {
            //Set up the objects necessary to make the request.
            HttpClient httpClient = HttpClientBuilder.create().build();

            HttpDelete httpDelete = new HttpDelete(uri);
            httpDelete.addHeader(oauthHeader);
            httpDelete.addHeader(prettyPrintHeader);

            //Make the request
            HttpResponse response = httpClient.execute(httpDelete);

            //Process the response
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 204) {
                BaseTest_RBAuction.log("Delete the immunization record successful.");
            } else {
                BaseTest_RBAuction.log("Immunization record delete NOT successful. Status code is " + statusCode);
            }
        } catch (JSONException e) {
            BaseTest_RBAuction.log("Issue creating JSON or processing results");
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }

    public static void deleteAccount(String AccountId) throws Exception {
        BaseTest_RBAuction.log("/*---Delete participant account " +AccountId +"--*/ ");
        String oauthToken = getOauthToken();
        oauthHeader = new BasicHeader("Authorization", "OAuth " + oauthToken) ;

        baseUri = LOGINURL + REST_ENDPOINT + API_VERSION ;
        String uri = baseUri + "/sobjects/Account/" + AccountId;
        BaseTest_RBAuction.log("oauthToken: " + oauthToken);
        BaseTest_RBAuction.log("baseUri: "+ baseUri);
        BaseTest_RBAuction.log("Query URI: " + uri);

        try {
            //Set up the objects necessary to make the request.
            HttpClient httpClient = HttpClientBuilder.create().build();

            HttpDelete httpDelete = new HttpDelete(uri);
            httpDelete.addHeader(oauthHeader);
            httpDelete.addHeader(prettyPrintHeader);

            //Make the request
            HttpResponse response = httpClient.execute(httpDelete);

            //Process the response
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 204) {
                BaseTest_RBAuction.log("Delete the account successful.");
            } else {
                BaseTest_RBAuction.log("Account delete NOT successful. Status code is " + statusCode);
            }
        } catch (JSONException e) {
            BaseTest_RBAuction.log("Issue creating JSON or processing results");
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }

    public static void apiCallToRemoveDuplicateCitizenParticipantAccount(String PersonEmail, String LastName, String FirstName) throws Exception {
        String AccountId = queryToGetAccountId(PersonEmail,LastName,FirstName);
        if(AccountId==null){
            BaseTest_RBAuction.log("Duplicate account not found");
        }
        else {
            ArrayList<String> listOfImmunizationRecords = queryToGetListOfImmunizationRecords(AccountId);
            if (listOfImmunizationRecords.size() == 0) {
                BaseTest_RBAuction.log("Immunization records not found");
            } else {
                for(int i=0; i < listOfImmunizationRecords.size(); i++){
                    String immunizationRecordId = listOfImmunizationRecords.get(i);
                    BaseTest_RBAuction.log("Immunization record to delete " +immunizationRecordId);
                    deleteImmunizationRecord(immunizationRecordId);
                }
            }
            deleteAccount(AccountId);
        }
    }



    ///////rbauction.com///////
    public static void apiCallToRemovePatientAccount(String PersonEmail, String LastName, String FirstName) throws Exception {
        String AccountId = queryToGetAccountId(PersonEmail,LastName,FirstName);
        if(AccountId==null){
            BaseTest_RBAuction.log("Duplicate Patient account not found");
        }
        else {
            String ContactId = queryToGetContactId(PersonEmail,LastName,FirstName);
            ArrayList<String> listOfCaseRecords = queryToGetListOfCasesRecords(ContactId);
            if (listOfCaseRecords.size() == 0) {
                BaseTest_RBAuction.log("Patient Case records not found");
            } else {
                for(int i=0; i < listOfCaseRecords.size(); i++){
                    String caseRecordId = listOfCaseRecords.get(i);
                    BaseTest_RBAuction.log("Patient Case to delete " +caseRecordId);
                    deleteCaseRecord(caseRecordId);
                }
            }
            deletePatientAccount(AccountId);
        }
    }

    public static String queryToGetContactId(String PersonEmail, String LastName, String FirstName) throws Exception {
        BaseTest_RBAuction.log("/*---Query to get ContactID record from Contact table--*/ ");
        String ContactId = null;
        String oauthToken = getOauthToken();

        String query ="/query?q=SELECT+Id+FROM+Contact+WHERE+Email='"+PersonEmail+"'+AND+LastName='"+LastName+"'+AND+FirstName='"+FirstName+"'+Limit+3";

        baseUri = LOGINURL + REST_ENDPOINT + API_VERSION ;
        oauthHeader = new BasicHeader("Authorization", "OAuth " + oauthToken) ;
        String uri = baseUri + query;
        BaseTest_RBAuction.log("oauthToken: " + oauthToken);
        BaseTest_RBAuction.log("baseUri: "+ baseUri);
        BaseTest_RBAuction.log("Query URI: " + uri);

        try {
            //Set up the HTTP objects needed to make the request.
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(uri);
            httpGet.addHeader(oauthHeader);
            httpGet.addHeader(prettyPrintHeader);

            // Make the request.
            HttpResponse response = httpClient.execute(httpGet);

            // Process the result
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String response_string = EntityUtils.toString(response.getEntity());
                try {
                    JSONObject json = new JSONObject(response_string);
                    BaseTest_RBAuction.log("JSON result of Query:\n" + json.toString(1));
                    JSONArray j = json.getJSONArray("records");
                    for (int i = 0; i < j.length(); i++){
                        ContactId = json.getJSONArray("records").getJSONObject(i).getString("Id");
                        BaseTest_RBAuction.log("ContactId: " + ContactId);
                    }
                } catch (JSONException je) {
                    je.printStackTrace();
                }
            } else {
                BaseTest_RBAuction.log("Query was unsuccessful. Status code returned is " + statusCode);
                BaseTest_RBAuction.log("An error has occurred. Http status: " + response.getStatusLine().getStatusCode());
                BaseTest_RBAuction.log(getBody(response.getEntity().getContent()));
                throw new Exception("API request failed");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        } catch (Exception e) {  //reference to custom throws new Exception
            e.printStackTrace();
        }
        return ContactId;
    }

    public static ArrayList<String> queryToGetListOfCasesRecords(String ContactId) throws Exception {
        BaseTest_RBAuction.log("/*---Query to get case record--*/ ");
        ArrayList<String> CaseRecordList = new ArrayList<String>();
        String CaseRecordId = null;
        String oauthToken = getOauthToken();

        String query ="/query?q=SELECT+ID+FROM+Case+WHERE+ContactId='"+ContactId+"'";

        baseUri = LOGINURL + REST_ENDPOINT + API_VERSION ;
        oauthHeader = new BasicHeader("Authorization", "OAuth " + oauthToken) ;
        String uri = baseUri + query;
        BaseTest_RBAuction.log("oauthToken: " + oauthToken);
        BaseTest_RBAuction.log("baseUri: "+ baseUri);
        BaseTest_RBAuction.log("Query URI: " + uri);

        try {
            //Set up the HTTP objects needed to make the request.
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(uri);
            httpGet.addHeader(oauthHeader);
            httpGet.addHeader(prettyPrintHeader);

            // Make the request.
            HttpResponse response = httpClient.execute(httpGet);

            // Process the result
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                String response_string = EntityUtils.toString(response.getEntity());
                try {
                    JSONObject json = new JSONObject(response_string);
                    BaseTest_RBAuction.log("JSON result of Query:\n" + json.toString(1));
                    JSONArray j = json.getJSONArray("records");
                    for (int i = 0; i < j.length(); i++){
                        CaseRecordId = json.getJSONArray("records").getJSONObject(i).getString("Id");
                        BaseTest_RBAuction.log("CaseRecordId: " + CaseRecordId);
                        CaseRecordList.add(CaseRecordId);
                    }
                } catch (JSONException je) {
                    je.printStackTrace();
                }
            } else {
                BaseTest_RBAuction.log("Query was unsuccessful. Status code returned is " + statusCode);
                BaseTest_RBAuction.log("An error has occured. Http status: " + response.getStatusLine().getStatusCode());
                BaseTest_RBAuction.log(getBody(response.getEntity().getContent()));
                throw new Exception("API request failed");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
        BaseTest_RBAuction.log("Found amount of Case records: " + CaseRecordList.size());
        return CaseRecordList;
    }

    public static void deleteCaseRecord(String caseRecordId) throws Exception {
        BaseTest_RBAuction.log("/*---Delete Patient Case record " +caseRecordId +"--*/ ");
        String oauthToken = getOauthToken();
        oauthHeader = new BasicHeader("Authorization", "OAuth " + oauthToken) ;

        baseUri = LOGINURL + REST_ENDPOINT + API_VERSION ;
        String uri = baseUri + "/sobjects/Case/" + caseRecordId;
        BaseTest_RBAuction.log("oauthToken: " + oauthToken);
        BaseTest_RBAuction.log("baseUri: "+ baseUri);
        BaseTest_RBAuction.log("Query URI: " + uri);

        try {
            //Set up the objects necessary to make the request.
            HttpClient httpClient = HttpClientBuilder.create().build();

            HttpDelete httpDelete = new HttpDelete(uri);
            httpDelete.addHeader(oauthHeader);
            httpDelete.addHeader(prettyPrintHeader);

            //Make the request
            HttpResponse response = httpClient.execute(httpDelete);

            //Process the response
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 204) {
                BaseTest_RBAuction.log("Delete the Patient Case record successful.");
            } else {
                BaseTest_RBAuction.log("Patient Case record delete NOT successful. Status code is " + statusCode);
            }
        } catch (JSONException e) {
            BaseTest_RBAuction.log("Issue creating JSON or processing results");
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }

    public static void deletePatientAccount(String AccountId) throws Exception {
        BaseTest_RBAuction.log("/*---Delete Patient account " +AccountId +"--*/ ");
        String oauthToken = getOauthToken();
        oauthHeader = new BasicHeader("Authorization", "OAuth " + oauthToken) ;

        baseUri = LOGINURL + REST_ENDPOINT + API_VERSION ;
        String uri = baseUri + "/sobjects/Account/" + AccountId;
        BaseTest_RBAuction.log("oauthToken: " + oauthToken);
        BaseTest_RBAuction.log("baseUri: "+ baseUri);
        BaseTest_RBAuction.log("Query URI: " + uri);

        try {
            //Set up the objects necessary to make the request.
            HttpClient httpClient = HttpClientBuilder.create().build();

            HttpDelete httpDelete = new HttpDelete(uri);
            httpDelete.addHeader(oauthHeader);
            httpDelete.addHeader(prettyPrintHeader);

            //Make the request
            HttpResponse response = httpClient.execute(httpDelete);

            //Process the response
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 204) {
                BaseTest_RBAuction.log("Delete the Patient account successful.");
            } else {
                BaseTest_RBAuction.log("Patient account delete NOT successful. Status code is " + statusCode);
            }
        } catch (JSONException e) {
            BaseTest_RBAuction.log("Issue creating JSON or processing results");
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }


}
