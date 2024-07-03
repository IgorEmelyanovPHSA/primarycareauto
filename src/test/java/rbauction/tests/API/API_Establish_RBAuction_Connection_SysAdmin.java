package rbauction.tests.API;

import org.testng.annotations.Test;
import rbauction.pages.APIEstablishRBAuctionConnection;
import rbauction.tests.API_BaseTest_RBAuction;


public class API_Establish_RBAuction_Connection_SysAdmin extends API_BaseTest_RBAuction {

    @Test
    public void API_Can_Establish_connection_Status_Code_200_as_SysAdmin(){
        TestcaseID = "252563"; //C252563
        APIEstablishRBAuctionConnection sfConnection = new APIEstablishRBAuctionConnection();
        log("Start establishing connection");
        String acc_token = sfConnection.establishConnection();
        log("Connection to SF successful!Status Code is 200");
        log("access_token is: "+ acc_token +" ");

    }

}
