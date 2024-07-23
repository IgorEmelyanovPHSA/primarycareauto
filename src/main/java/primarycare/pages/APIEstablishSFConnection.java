package primarycare.pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIEstablishSFConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","3MVG9gtjsZa8aaSUZkeuQesW1Wl4SnkTZQZE.dZb9FwkDJIJBRiONJCEDLsOI.90oabSqRvfkLHLOUIIORWLI")
                    .param("client_secret","EFA50E28C8F5984659E5784968CC4AE4FF8F5298E7685E181597411C790E8F77")
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
