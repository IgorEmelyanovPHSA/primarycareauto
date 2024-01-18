package primarycare.pages;

import io.restassured.http.ContentType;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APICreateContactContactRelations {
    public String insertPrimaryContactContactRelations (String healthCloudGA__RelatedContact__c,
                                                        String healthCloudGA__Contact__c,
                                                        String healthCloudGA__Role__c
                                        ){
        APIEstablishSFConnection sfConnection = new APIEstablishSFConnection();
        String acc_token = sfConnection.establishConnection();
        System.out.println("Connection for SF Establish with Status code 200");
        System.out.println("access_token is:" +acc_token);

        Map<String, Object> mapper =  new HashMap<String,Object>();
        mapper.put("HealthCloudGA__RelatedContact__c", healthCloudGA__RelatedContact__c);
        mapper.put("HealthCloudGA__Contact__c", healthCloudGA__Contact__c);
        mapper.put("HealthCloudGA__Role__c", healthCloudGA__Role__c);

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
                        post("https://healthbc--spr24qa.sandbox.my.salesforce.com/services/data/v57.0/sobjects/HealthCloudGA__ContactContactRelation__c").
                        then().statusCode(201).log().body().extract().path("id");
        //then().log().body();
        //return null;
    }
}
