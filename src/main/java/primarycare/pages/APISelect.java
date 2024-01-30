package primarycare.pages;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class APISelect {
    String fieldEmpaneledPatientValue;
    public String selectSQL (String sql_request, String fieldName)
    {
        APIEstablishSFConnection sfConnection = new APIEstablishSFConnection();
        String acc_token = sfConnection.establishConnection();
        System.out.println("access_token is:" +acc_token);
        System.out.println("Connection for SF Establish with Status code 200");
        System.out.println("SQL request is:" +sql_request);

        List<Map<String, Object>> recordsArray =
                given().
                        contentType(ContentType.JSON).
                        header("Authorization", "Bearer "+acc_token).
                        get("https://healthbc--hlthbcqax.sandbox.my.salesforce.com/services/data/v57.0/query?q="+sql_request+"").
                        then().extract().path("records");
        // then().log().body();

        String fieldValue = (String)recordsArray.get(0).get(fieldName);
        return  fieldValue;
        //return null;
    }

    public String selectPersonAccountIDSQL (String sql_request, String personContactID)
    {
        APIEstablishSFConnection sfConnection = new APIEstablishSFConnection();
        String acc_token = sfConnection.establishConnection();
        System.out.println("access_token is:" +acc_token);
        System.out.println("Connection for SF Establish with Status code 200");
        System.out.println("SQL request is:" +sql_request);

        List<Map<String, Object>> recordsArray =
                given().
                        contentType(ContentType.JSON).
                        header("Authorization", "Bearer "+acc_token).
                        get("https://healthbc--hlthbcqax.sandbox.my.salesforce.com/services/data/v57.0/query?q="+sql_request+"").
                        then().statusCode(200).extract().path("records");
        //then().log().body();
        //then().statusCode(200).log().body().extract().path("id");

        String fieldValue = (String)recordsArray.get(0).get(personContactID);
        return  fieldValue;
        //return null;
    }

    public String selectPractitionerFacilityIdIDSQL (String sql_request, String practitionerFacilityID)
    {
        APIEstablishSFConnection sfConnection = new APIEstablishSFConnection();
        String acc_token = sfConnection.establishConnection();
        System.out.println("access_token is:" +acc_token);
        System.out.println("Connection for SF Establish with Status code 200");
        System.out.println("SQL request is:" +sql_request);

        List<Map<String, Object>> recordsArray =
                given().
                        contentType(ContentType.JSON).
                        header("Authorization", "Bearer "+acc_token).
                        get("https://healthbc--hlthbcqax.sandbox.my.salesforce.com/services/data/v57.0/query?q="+sql_request+"").
                        then().statusCode(200).extract().path("records");
        //then().log().body();
        //then().statusCode(200).log().body().extract().path("id");

        if(recordsArray.size()==0){
            System.out.println("Duplicate Practitioner Facility Id not found");
            return null;
        }
        else{
            String fieldValue = (String)recordsArray.get(0).get(practitionerFacilityID);
            return  fieldValue;
        }

        //return null;
    }

    public String selectPatientAccountIdByPHN (String sql_request, String patientAccountId)
    {
        APIEstablishSFConnection sfConnection = new APIEstablishSFConnection();
        String acc_token = sfConnection.establishConnection();
        System.out.println("access_token is:" +acc_token);
        System.out.println("Connection for SF Establish with Status code 200");
        System.out.println("SQL request is:" +sql_request);

        List<Map<String, Object>> recordsArray =
                given().
                        contentType(ContentType.JSON).
                        header("Authorization", "Bearer "+acc_token).
                        get("https://healthbc--hlthbcqax.sandbox.my.salesforce.com/services/data/v57.0/query?q="+sql_request+"").
                        then().statusCode(200).extract().path("records");
        //then().log().body();
        //then().statusCode(200).log().body().extract().path("id");

        String fieldValue = (String)recordsArray.get(0).get(patientAccountId);
        return  fieldValue;
        //return null;
    }
    public String selectEmpaneledPatientRecordIdByPHN (String sql_request, String empaneledPatientRecordId)
    {
        APIEstablishSFConnection sfConnection = new APIEstablishSFConnection();
        String acc_token = sfConnection.establishConnection();
        System.out.println("access_token is:" +acc_token);
        System.out.println("Connection for SF Establish with Status code 200");
        System.out.println("SQL request is:" +sql_request);

        List<Map<String, Object>> recordsArray =
                given().
                        contentType(ContentType.JSON).
                        header("Authorization", "Bearer "+acc_token).
                        get("https://healthbc--hlthbcqax.sandbox.my.salesforce.com/services/data/v57.0/query?q="+sql_request+"").
                        then().statusCode(200).extract().path("records");
        //then().log().body();
        //then().statusCode(200).log().body().extract().path("id");

        try {
            fieldEmpaneledPatientValue = (String) recordsArray.get(0).get(empaneledPatientRecordId);
            //return fieldEmpaneledPatientValue;
        } catch (Exception e){
            System.out.println("Seems no empaneled Patient Records for 'Procasso Garth':" +fieldEmpaneledPatientValue);
        }
        return fieldEmpaneledPatientValue;
        //return null;
    }

}
