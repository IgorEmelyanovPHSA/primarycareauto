package primarycare.pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIEstablishSFConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","3MVG9gtjsZa8aaSXpEhPImZgyKlBrmgNTjLXGu0brakMI.F5b7XxPQ8LhgtDEgWQeMMAoXqyeAVyo6SG6TirI")
                    .param("client_secret","461E0C58618A746025575DA3F2F2F856B84AE131C16D7B9F9A555336CF5AAB13")
                    .param("username","igor.emelyanov@phsa.ca.hlthbcuatx")
                    .param("password","Technology1990!!!!!!")
                    .header("Accept","application/json")
                    .header("Content-type","application/x-www-form-urlencoded").
                    when().
                    post("https://healthbc--hlthbcuatx.sandbox.my.salesforce.com/services/oauth2/token")
                    .then()
                    .assertThat().statusCode(200).log().body().extract().path("access_token");
    }

}
