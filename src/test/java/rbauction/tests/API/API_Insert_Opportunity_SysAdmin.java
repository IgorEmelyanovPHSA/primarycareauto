package rbauction.tests.API;

import org.testng.annotations.Test;
import rbauction.pages.APIInsertOpportunity;
import rbauction.tests.BaseTest_RBAuction;

import java.util.Random;

public class API_Insert_Opportunity_SysAdmin {
    public String accountId = "0015900000Y2denAAB";//IgorAPI_Account_440
    //public String accountId = "0015900000Y2deOAAR";//IgorAPI_Account_138
    public String name = "IgorAPI_Opportunity" + new Random().nextInt(1000);
    public String oppStage = "Closed Won";
    public String closeDate = "2023-09-07";

    @Test
    public void API_Can_Insert_Opportunity_to_RBAuction_as_SysAdmin(){
        APIInsertOpportunity apiinsertOpportunity = new APIInsertOpportunity();
        BaseTest_RBAuction.log("Inserting opportunity record.");
        String accountID = apiinsertOpportunity.insertOpportunity(accountId, name, oppStage, closeDate);
        BaseTest_RBAuction.log("Inserted Opportunities id is: " +accountID);

    }
}
