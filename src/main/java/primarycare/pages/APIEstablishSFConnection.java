package primarycare.pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIEstablishSFConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","3MVG9zArFGyjNjy1gyrx6GWoqY9kbAt9WaKxIk6Q.FyVW_FA6SkCSkE.gf8FXx082HVn6qwSrZCc2oAoHU86w")
                    .param("client_secret","95BE793C8C12C80D649F24A0E919B418503191B117E390B68FF2F5D69CA473B3")
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
