package rbauction.pages;

import static io.restassured.RestAssured.*;


public class APIEstablishRBAuctionConnection {
    public String establishConnection(){
            return
                given().
                    urlEncodingEnabled(true)
                    .param("grant_type","password")
                    .param("client_id","777777777777777Klh5tYp5Y_8Xg15C0R_Sa1S7ri5jjflULCe8KcuWkdQx4YwHUMjVE67T0")
                    .param("client_secret","777777777777D6D291EDB8C37B848E803D70B8AA84")
                    .param("username","igor.emelyanov@rbauction.com")
                    .param("password","7777777777")
                    .header("Accept","application/json")
                    .header("Content-type","application/x-www-form-urlencoded").
                    when().
                    post("https://rbauction_qax.sandbox.my.salesforce.com/services/oauth2/token")
                    .then()
                    .assertThat().statusCode(200).log().body().extract().path("access_token");
    }

}
