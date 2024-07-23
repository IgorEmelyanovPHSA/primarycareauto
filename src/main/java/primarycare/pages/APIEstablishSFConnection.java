package primarycare.pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIEstablishSFConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","3MVG9TZvGM_0NqB1sPoa6RRAECHB5DP53HdXbdBC8wYHrnH0sdMXAF9u1M1nnxgzTm1HRbO9JIqJRRZu0aSEb")
                    .param("client_secret","0A7D7C5F0073D7972BA5FD47FF5D63D7EF87F935D6D7A3CE3F824E1861653853")
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
