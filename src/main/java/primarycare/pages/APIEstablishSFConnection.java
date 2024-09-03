package primarycare.pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIEstablishSFConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","3MVG9696SH3dTknI0LdIdlrTJkGFsxPGY9jCL2vaDwDsMciM7dF76b_xvAbAgGkFL961oRgvWncNQAxY_NdVX")
                    .param("client_secret","629D1616EDD2F178F1D4D2D2A69A21E24A4B6CDFF774618018C80E320446FB86")
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
