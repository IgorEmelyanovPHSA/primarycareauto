package primarycare.pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIEstablishSFConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","3MVG9gtjsZa8aaSXkoiszTyiFqvjA9lUT23kNr_sw6_u5Bm0KvewtzZSVx0l1EdDpglb0ZCs1ZZj8zMJ.r7tN")
                    .param("client_secret","9AB13B0BE09B9D954594F3C7579B5A325FF0AC16ED42784EF41F5093A06BAFB6")
                    .param("username","igor.emelyanov@phsa.ca.spr24qa")
                    .param("password","Technology1990!!!!!!")
                    .header("Accept","application/json")
                    .header("Content-type","application/x-www-form-urlencoded").
                    when().
                    post("https://healthbc--spr24qa.sandbox.my.salesforce.com/services/oauth2/token")
                    .then()
                    .assertThat().statusCode(200).log().body().extract().path("access_token");
    }

}
