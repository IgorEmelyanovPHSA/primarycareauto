package primarycare.pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIEstablishSFConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","3MVG9TZvGM_0NqB3TmjIrAHTADfpcmUWHy3nX3Y8CuWnAMr6nznbhxecYL9v6u4gd0gp9mt5EB5g8ys15AKzy")
                    .param("client_secret","9FACE908FC1F59248CAB3AE31ECE438C2FE93D6B35ADD82F95DA1B7BDA0168AB")
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
