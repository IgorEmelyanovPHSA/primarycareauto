package primarycare.tests.Selenium.Provider_Portal;

import primarycare.pages.Utils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import primarycare.pages.ProviderPortalHomePage;
import primarycare.tests.BaseTest_PrimaryCare;
import primarycare.tests.Utilities.TestListener;

@Listeners({TestListener.class})
public class Portal_Support_Users extends BaseTest_PrimaryCare{

    String clinicName = "CASTLEGAR MED FAMILY CLINIC";

    @Test(priority = 1)
    public void Provider_Portal_Clinic_Details_Visibility_for_Staff_TIER1() throws Exception {
        TestcaseID = "286636"; //C286636
        log("Target Environment: "+ Utils.getTargetEnvironment());

        log("/*1.---Login to Provider Portal Home page as an Tier 1 --*/");
        ProviderPortalHomePage providerPortalHomePage= loginPage.loginProviderPortalHomePageAsTier1();
        Thread.sleep(5000);

        log("/*2.----Verify that Provider Portal Home page displayed --*/");
        boolean isPortalProviderHomePageDisplayed =  providerPortalHomePage.isPortalProviderHomePageDisplayed_TIER1();
        if (!isPortalProviderHomePageDisplayed){
            throw new RuntimeException("Exception: Portal Provider Home Page "  + "has not shown up!!!");
        }
        Thread.sleep(2000);

        //log("/*3.----Click on 'Clinic & Provider Registry' link --*/");
        //providerPortalHomePage.clickClinicAndProviderRegistryLink();
        //Thread.sleep(5000);
        //or -->
        log("/*3.----Click 'Search all clinics in BC' link in the bottom of page --*/");
        providerPortalHomePage.clickSearchAllClinicsInBCLink();
        Thread.sleep(5000);

        log("/*4.----Enter Clinic Name in Search box 'CASTLEGAR MED FAMILY CLINIC'--*/");
        providerPortalHomePage.enterClinicNameInSearchBox(clinicName);
        Thread.sleep(5000);

        log("/*4.----Click Search --*/");
        providerPortalHomePage.clickSearchForClinics();
        Thread.sleep(5000);

    }
}
