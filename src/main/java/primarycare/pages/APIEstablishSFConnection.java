package primarycare.pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIEstablishSFConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","3MVG9696SH3dTknIGlzhu6yTksuL3MI.o0cS0AXUpAIAc99.9kn8cPaDpQhdVqQDWthNqU6ihqVch5vy3otQq")
                    .param("client_secret","9A968C4279F36173D5021AB257E467D918D3E97B08EFB5CFB1A9154103C862B2")
                    .param("username","igor.emelyanov@phsa.ca.hlthbcqax")
                    .param("password","Technology1990!!!!!!")
                    .header("Accept","application/json")
                    .header("Content-type","application/x-www-form-urlencoded").
                    when().
                    post("https://healthbc--hotfixqa.sandbox.my.salesforce.com/services/oauth2/token")
                    .then()
                    .assertThat().statusCode(200).log().body().extract().path("access_token");
    }

}
