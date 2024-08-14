package primarycare.pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIEstablishSFConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","3MVG9TZvGM_0NqB3jIQBgLtpf33EOHiwDfuTAjsEz7CkivqWsmn_uLfjvz1YE67dBVHp0jtyJcFc5VqdPslU1")
                    .param("client_secret","C8EFD945C889F20A7CA4374CF745C96F561ADDA5A2089DECF72CD943273014F8")
                    .param("username","igor.emelyanov@phsa.ca.hlthbcqax")
                    .param("password","Technology1990!!!!!!")
                    .header("Accept","application/json")
                    .header("Content-type","application/x-www-form-urlencoded").
                    when().
                    post("https://healthbc--hlthbcqax.sandbox.my.salesforce.com/services/oauth2/token")
                    .then()
                    .assertThat().statusCode(200).log().body().extract().path("access_token");
    }

}
