package primarycare.tests.Selenium.Provider_Portal;

import primarycare.pages.Utils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import primarycare.pages.ProviderPortalHomePage;
import primarycare.tests.BaseTest_PrimaryCare;
import primarycare.tests.Utilities.TestListener;

@Listeners({TestListener.class})
public class Portal_Support_Users extends BaseTest_PrimaryCare{

    @Test(priority = 1)
    public void Provider_Portal_Clinic_Details_Visibility_for_Staff_TIER1() throws Exception {
        TestcaseID = "286636"; //C286636
        log("Target Environment: "+ Utils.getTargetEnvironment());

        log("/*1.---Login to Provider Portal Home page as an Director --*/");
        ProviderPortalHomePage providerPortalHomePage= loginPage.loginProviderPortalHomePageAsDirector();
        Thread.sleep(5000);

        log("/*1.1.----Verify that Provider Portal Home page displayed --*/");
        boolean isPortalProviderHomePageDisplayed =  providerPortalHomePage.isPortalProviderHomePageDisplayed();
        if (!isPortalProviderHomePageDisplayed){
            throw new RuntimeException("Exception: Portal Provider Home Page "  + "has not shown up!!!");
        }
        Thread.sleep(2000);

        log("/*2.----Click Home link to see all Clinic Associated Panels --*/");
        //cpMainPage.verifyIsCommunityPortalHomePageDisplayed();
        providerPortalHomePage.clickHomeLink();
        Thread.sleep(5000);

    }
}
