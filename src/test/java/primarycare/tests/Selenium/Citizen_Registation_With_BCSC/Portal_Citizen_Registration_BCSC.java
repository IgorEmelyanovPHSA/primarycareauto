package primarycare.tests.Selenium.Citizen_Registation_With_BCSC;

import primarycare.pages.Utils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import primarycare.pages.PortalBCSCHealthConnectRegistryPage;
import primarycare.tests.BaseTest_PrimaryCare;
import primarycare.tests.Utilities.TestListener;

import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class Portal_Citizen_Registration_BCSC extends BaseTest_PrimaryCare {

    @Test(priority = 1) //depricared
    public void Can_Login_With_BCSC_Card_To_Citizen_Portal () throws Exception {
        TestcaseID = "272338"; //C272338
        log("Target Environment: "+ Utils.getTargetEnvironment());

        log("/*1.---Open PrimaryCareAuthPatientRegistration Page ---*/");
        PortalBCSCHealthConnectRegistryPage portalBCSCHealthConnectRegistryPage = loginPage.openPortalBCSCHealthConnectRegistryPage();
        Thread.sleep(3000);

        log("/*2.---Click 'BCSC Login' button ---*/");
        portalBCSCHealthConnectRegistryPage.clickBCSCLoginButton();
        Thread.sleep(3000);

        log("/*3.---Click 'Test with username and password' button on 'BC Services Card Login' page  ---*/");
        portalBCSCHealthConnectRegistryPage.clickTestWithUsernameAndPasswordButton();
        Thread.sleep(3000);

        log("/*4.---Login as BCSC to Health Connect Registry Home page ---*/");
        portalBCSCHealthConnectRegistryPage.loginAsBCSC();
        Thread.sleep(3000);

        log("/*5.---- Validate that the Register to get doctor page has displayed --*/");
        portalBCSCHealthConnectRegistryPage.validateRegisterYourselfToGetDoctorPageDisplayed();
        Thread.sleep(2000);

        log("/*6.---Click Next button--*/");
        portalBCSCHealthConnectRegistryPage.clickNextButton();
        Thread.sleep(2000);

        log("/*4.--- Validate that the Who is Registering page has displayed --*/");
        portalBCSCHealthConnectRegistryPage.validateWhoIsRegisteringPageDisplayed();
        Thread.sleep(2000);

    }



    //@Test(priority = 2)
    public void Post_conditions_step_Remove_Dups_Patient_account() throws Exception {
        TestcaseID = "251774"; //C251774
        log("/---API call to remove duplicate Patient's account if found--*/");
        //ApiQueries.apiCallToRemovePatientAccount(email, legalLastName, legalFirstName);
    }
}
