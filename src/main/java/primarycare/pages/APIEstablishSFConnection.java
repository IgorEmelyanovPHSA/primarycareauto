package primarycare.pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIEstablishSFConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","3MVG9TZvGM_0NqB1i2upEIu8wzT6NUlSqQM9BWQzzVfmclRlF3c3yJZKSbIOKAfnzxoVf3G.1LTpnVfwNC0Ey")
                    .param("client_secret","2AA1BDDBBA0C75829986190A7C2B1B2687C565DE8E73844B4BC756826E745192")
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
