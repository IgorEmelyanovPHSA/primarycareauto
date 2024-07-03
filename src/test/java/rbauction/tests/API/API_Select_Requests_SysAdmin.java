package rbauction.tests.API;

import org.testng.Assert;
import org.testng.annotations.Test;
import rbauction.pages.APISelect;
import rbauction.tests.BaseTest_RBAuction;

public class API_Select_Requests_SysAdmin {
    public String name = "IgorAPI_Account_138";
    public String accId = "0015900000Y2deOAAR";


    @Test
    public void API_Can_Select_From_Account_as_SysAdmin(){

        APISelect sqlQuery = new APISelect();
        BaseTest_RBAuction.log("Select account Name from Account.");
        String accountNameReturned = sqlQuery.selectSQL("SELECT Name from Account WHERE id = '"+accId+"'", "Name");
        BaseTest_RBAuction.log("Selected Account Name from Account is: " +accountNameReturned);
        Assert.assertEquals(accountNameReturned, name);
    }
}
