package primarycare.pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIEstablishSFConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","3MVG9696SH3dTknJ3r45T1i4A0dVqUb4Br70AGFNRqyFvoql3q1ePUFP0qtG89S_X_EaQzvhEvfnPPiZS2WGG")
                    .param("client_secret","AB21CBA9EB085A613A1843E48F074CE3D2609475971D0DB2D00ACB9FB5209343")
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
