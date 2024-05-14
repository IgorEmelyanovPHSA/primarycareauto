package primarycare.pages;

import io.restassured.http.ContentType;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APICreateCase {
    public String insertUnattachedCase (String caseRecordTypeId,
                                        String caseAccountId,
                                        String casePrimaryCareNetwork__c,
                                        String caseReason,
                                        String caseOrigin,
                                        String personContactId,
                                        String caseStatus){
        APIEstablishSFConnection sfConnection = new APIEstablishSFConnection();
        String acc_token = sfConnection.establishConnection();
        System.out.println("Connection for SF Establish with Status code 200");
        System.out.println("access_token is:" +acc_token);

        Map<String, Object> mapper =  new HashMap<String,Object>();
        mapper.put("RecordTypeId", caseRecordTypeId);
        mapper.put("AccountId", caseAccountId);
        mapper.put("Primary_Care_Network__c", casePrimaryCareNetwork__c);
        mapper.put("Reason", caseReason);
        mapper.put("Origin", caseOrigin);
        mapper.put("ContactId", personContactId);
        mapper.put("Status", caseStatus);

        JSONObject requester = new JSONObject(mapper);
        System.out.println("Account JSON is:" +requester.toString());

        return
                given().
                        contentType(ContentType.JSON).
                        accept(ContentType.JSON).
                        header("Authorization", "Bearer "+acc_token).
                        header("Content-Type", "application/json").
                        body(requester.toString()).
                        when().
                        post("https://healthbc--previewqa.sandbox.my.salesforce.com/services/data/v57.0/sobjects/Case").
                        then().statusCode(201).log().body().extract().path("id");
        //then().log().body();
        //return null;
    }

    public String insertAttachedCase (String caseRecordTypeId,
                                        String caseAccountId,
                                        String casePrimaryCareNetwork__c,
                                        String caseReason,
                                        String caseOrigin,
                                        String personContactId,
                                        String caseStatus,
                                        String practitionerAttached__c){
        APIEstablishSFConnection sfConnection = new APIEstablishSFConnection();
        String acc_token = sfConnection.establishConnection();
        System.out.println("Connection for SF Establish with Status code 200");
        System.out.println("access_token is:" +acc_token);

        Map<String, Object> mapper =  new HashMap<String,Object>();
        mapper.put("RecordTypeId", caseRecordTypeId);
        mapper.put("AccountId", caseAccountId);
        mapper.put("Primary_Care_Network__c", casePrimaryCareNetwork__c);
        mapper.put("Reason", caseReason);
        mapper.put("Origin", caseOrigin);
        mapper.put("ContactId", personContactId);
        mapper.put("Status", caseStatus);
        mapper.put("Practitioner_Attached__c", practitionerAttached__c);

        JSONObject requester = new JSONObject(mapper);
        System.out.println("Account JSON is:" +requester.toString());

        return
                given().
                        contentType(ContentType.JSON).
                        accept(ContentType.JSON).
                        header("Authorization", "Bearer "+acc_token).
                        header("Content-Type", "application/json").
                        body(requester.toString()).
                        when().
                        post("https://healthbc--previewqa.sandbox.my.salesforce.com/services/data/v57.0/sobjects/Case").
                        then().statusCode(201).log().body().extract().path("id");
        //then().log().body();
        //return null;
    }

}
