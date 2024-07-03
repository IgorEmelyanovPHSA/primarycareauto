package rbauction.tests.Selenium.RBAuction_Website_search;

import rbauction.pages.CommonMethods;
import rbauction.pages.HealthCloudConsolePage;
import rbauction.tests.Utilities.TestListener;
import rbauction.pages.Utils;
import rbauction.tests.BaseTest_RBAuction;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import rbauction.pages.RBAuctionPage;

import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class RBAuction_Title_Page_Navigate_Search_Results extends BaseTest_RBAuction {
    //private String legalFirstName = "Sandy";

    @Test(priority = 1)
    public void Can_Do_Search_For_My_F150_Platinum_in_RBAuction_website () throws Exception {
        //TestcaseID = "251780"; //C251780
        log("Target Environment: "+ Utils.getTargetEnvironment());

        //CommonMethods com = new CommonMethods(getDriver());

        log("/*0.---Pre-conditioning API call to remove duplicate  account if found--*/");
        //ApiQueries.apiCallToRemovePatientAccount(email_search_API, legalLastName, legalFirstName);

        log("/*1.---Open the Title main page)--*/");
        RBAuctionPage portalRBAuctionPage= loginPage.openRBAuctionPage();
        Thread.sleep(5000);

        //log("/*2.---- Validate that the Title page has displayed --*/");
        //PortalHealthConnectRegistryPage.validateRegisterToGetDoctorPageDisplayed();
        //Thread.sleep(1000);

        log("/*2.----Verify that the RBAuction page has displayed --*/");
       // boolean isPortalRegisterToGetDoctorPageDisplayed =  PortalHealthConnectRegistryPage.isRegisterToGetDoctorPageDisplayed();
        //if (!isPortalRegisterToGetDoctorPageDisplayed){
            //throw new RuntimeException("Exception: the Portal Register 'to get doctor' page "  + "has not shown up!!!");
        //}
        //Thread.sleep(2000);

        //log("/*3.---Click Next button--*/");
        //portalHealthConnectRegistryPage.clickNextButton();
        //Thread.sleep(1000);


    }



    //@Test(priority = 2)
    public void Post_conditions_step_Remove_Dups_Patient_account() throws Exception {
        //TestcaseID = "251774"; //C251774
        //log("/---API call to remove duplicate Patient's account if found--*/");
        //ApiQueries.apiCallToRemovePatientAccount(email, legalLastName, legalFirstName);
    }
}
