package primarycare.pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIEstablishSFConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","3MVG9696SH3dTknKdVKLGb0BfjY5cOVPY1t1D4KeuO7TfwK03CIB84qncqeZLld2icTFQjf6y1QeXiW3uFA_.")
                    .param("client_secret","A3D14372ED4A446CDC20A29A23B707F49B584B6AE3BF1E81D58B5FD3B48A8475")
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
