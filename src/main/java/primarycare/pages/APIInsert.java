package primarycare.pages;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class APIInsert {
    public String insertPanelMember (String patient__c,
                                     String healthcare_facility_network__c,
                                     String panel__c,
                                     String roster__c)
    {
        APIEstablishSFConnection sfConnection = new APIEstablishSFConnection();
        String acc_token = sfConnection.establishConnection();
        System.out.println("Connection for SF Establish with Status code 200");
        System.out.println("access_token is:" +acc_token);

        Map<String, Object> mapper =  new HashMap<String,Object>();
        mapper.put("Patient__c", patient__c);
        mapper.put("Healthcare_Facility_Network__c", healthcare_facility_network__c);
        mapper.put("Panel__c", panel__c);
        mapper.put("Roster__c", roster__c);

        JSONObject requester = new JSONObject(mapper);
        System.out.println("Contact Object JSON is:" +requester.toString());

        return
                given().
                        contentType(ContentType.JSON).
                        accept(ContentType.JSON).
                        header("Authorization", "Bearer "+acc_token).
                        header("Content-Type", "application/json").
                        body(requester.toString()).
                        when().
                        post("https://healthbc--hlthbcqax.sandbox.my.salesforce.com/services/data/v57.0/sobjects/Panel_Member__c").
                        then().statusCode(201).log().body().extract().path("id");
        //then().log().body();
        //return null;
    }
}
