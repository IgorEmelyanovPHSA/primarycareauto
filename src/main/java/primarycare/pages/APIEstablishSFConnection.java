package primarycare.pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIEstablishSFConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","3MVG9696SH3dTknJ2iuIrzoypRle6o1DMfQM0GRF0kjOGMCmroZBJDog4xPHidWsX2MzKpCxdsXy7g1A1iT7Z")
                    .param("client_secret","BE355B8080446CC5223A4A0E6E399F5752BAEF9D7774BDFB7CFA3E448DD3660B")
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
