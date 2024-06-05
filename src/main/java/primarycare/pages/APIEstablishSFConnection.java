package primarycare.pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIEstablishSFConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","3MVG9zArFGyjNjy3.weH7TWJt4n7N_U4Cbnq7qDU5_BioSoKflS._.rlmBvy6mnPdXDpulSEAPQcs_OyZ0HB8")
                    .param("client_secret","D8A8B1BF92981860C264C61AB71058B5D589D4FEDD5E79E5CF00E170A18D4D16")
                    .param("username","igor.emelyanov@phsa.ca.hotfixqa")
                    .param("password","Technology1990!!!!!!")
                    .header("Accept","application/json")
                    .header("Content-type","application/x-www-form-urlencoded").
                    when().
                    post("https://healthbc--hotfixqa.sandbox.my.salesforce.com/services/oauth2/token")
                    .then()
                    .assertThat().statusCode(200).log().body().extract().path("access_token");
    }

}
