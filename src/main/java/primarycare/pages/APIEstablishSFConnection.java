package primarycare.pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIEstablishSFConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","3MVG9gtjsZa8aaSUKMQ9wdf6_zF5y7o_Cs1rUi.bWtRgLtcxoIv1n4SCi5A015IJ2Lsr5.czN_GiexfsiI4v7")
                    .param("client_secret","95296F6AEF3E2255386C5BE4B4B5C824D9D1597DD0B51CB5615B5419E8CDCD39")
                    .param("username","igor.emelyanov@phsa.ca.previewqa")
                    .param("password","Technology1990!!!!!!")
                    .header("Accept","application/json")
                    .header("Content-type","application/x-www-form-urlencoded").
                    when().
                    post("https://healthbc--previewqa.sandbox.my.salesforce.com/services/oauth2/token")
                    .then()
                    .assertThat().statusCode(200).log().body().extract().path("access_token");
    }

}
