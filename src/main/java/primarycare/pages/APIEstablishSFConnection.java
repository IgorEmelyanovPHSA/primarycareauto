package primarycare.pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIEstablishSFConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","3MVG9TZvGM_0NqB2vPdwrdEfeaPYQtQdiDkCZd2Oy3qsElj92yQjY01ZR70__SdVohYZLYI5367Fuixo6Xihy")
                    .param("client_secret","14BB6C6E0BDFAEA91E44B92A31BA7CA94BB717AA45AE72279533C0159F661DF7")
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
