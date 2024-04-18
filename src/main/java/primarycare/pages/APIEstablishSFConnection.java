package primarycare.pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIEstablishSFConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","3MVG9TZvGM_0NqB0kG8dlWT8FghKeqiaAQJXdIFBWXYGzuI5wRSXozPQS1sdny00CsMvnHUTMY6EqTK05v7ky")
                    .param("client_secret","E7DF8A516D4EF341BA12FEEE7AD95DCCFFA28D61652523DC6CD0EB819C4FAD10")
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
