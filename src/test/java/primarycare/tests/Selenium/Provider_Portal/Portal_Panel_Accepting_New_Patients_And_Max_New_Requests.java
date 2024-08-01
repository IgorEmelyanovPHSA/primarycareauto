package primarycare.tests.Selenium.Provider_Portal;

import primarycare.pages.Utils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import primarycare.pages.ProviderPortalHomePage;
import primarycare.tests.BaseTest_PrimaryCare;
import primarycare.tests.Utilities.TestListener;

import java.util.Random;

import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class Portal_Panel_Accepting_New_Patients_And_Max_New_Requests extends BaseTest_PrimaryCare {
    private String clinicName_1 = "CASTLEGAR MED FAMILY CLINIC";
    private String physicalAddress_Street_1 = "1840 8 AVE,";
    private String physicalAddress_City_PostCode_1 = "Castlegar, BC, V1N 2Y2";
    private String clinicPhoneNumber_1 = "2503652161";
    private String Role = "Director";
    //private String isPrimary = "True"; is it Primary for Practitioner?

    //private String clinic_Name_2 = "CASTLEGAR MED ASSOCIATES11111";

    //private String desiredPanelSize = "999";
    private int desiredPanelSize = ((1 + new Random().nextInt(2)) * 1000) + new Random().nextInt(1000);
    private int monthlyCapacityRate = ((1 + new Random().nextInt(2)) * 1000) + new Random().nextInt(1000);
    private String isAcceptingNewPatients = "Yes";
    //private String maxNewRequests = "88888";
    int maxNew = new Random().nextInt(1000) + 1000;
    String maxNewRequests = String.format("%04d", maxNew);


    @Test(priority = 1)
    public void Can_View_Edit_DIRECTORs_fields_Panel_Size_Accepting_New_Patients_And_Max_New_Requests_in_Portal() throws Exception {
        TestcaseID = "254213"; //C254213
        log("Target Environment: "+ Utils.getTargetEnvironment());

        //CommonMethods com = new CommonMethods(getDriver());

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

        //log("/*3.----Click 'View' in CASTLEGAR MED FAMILY CLINIC Panel --*/");
        //providerPortalHomePage.clickView();
        //Thread.sleep(1000);

        log("/*3.----Click 'My Panel' link --*/");
        providerPortalHomePage.clickRostering();
        Thread.sleep(5000);

        log("/*4.----Click Edit --*/");
        providerPortalHomePage.clickEdit();
        Thread.sleep(1000);

        log("/*5.----Enter random Monthly Capacity Rate: " + monthlyCapacityRate + "--*/");
        providerPortalHomePage.enterMonthlyCapacityRate(monthlyCapacityRate);
        Thread.sleep(1000);

        log("/*6.----Enter random Desired Panel Size: " + desiredPanelSize + "--*/");
        providerPortalHomePage.enterDesiredPanelSize(desiredPanelSize);
        Thread.sleep(1000);

        //log("/*6.----Select Accepting new Patients: " + isAcceptingNewPatients + "--*/");
        //providerPortalHomePage.selectAcceptingNewPatientsOption(isAcceptingNewPatients);
        //Thread.sleep(1000);

        //log("/*7.----Enter random Max New Requests: " + maxNewRequests + "--*/");
        //providerPortalHomePage.enterMaxNewRequests(maxNewRequests);
        //Thread.sleep(1000);

        log("/*8.----Click Save --*/");
        providerPortalHomePage.clickSaveMaxNewPatientsForm();
        Thread.sleep(5000);

//        log("/*9.---- Validate Desired Panel Size  ---*/");
//        String desiredPanelSizeExpected = new DecimalFormat("##,###").format(desiredPanelSize);
//        String desiredPanelSizeActual = providerPortalHomePage.getActualDesiredPanelSizeForValidation();
//        log("/*---Desired Panel Size actual is: " + desiredPanelSizeActual + " --*/");
//        assertEquals(desiredPanelSizeActual, desiredPanelSizeExpected);
//        Thread.sleep(2000);

        log("/*10.---- Validate isAccepting new Patients  ---*/");
       // String acceptingNewPatientsActual = providerPortalHomePage.getActualIsAcceptingNewPatientsForValidation();
       // log("/*---Accepting new Patients actual is: " + acceptingNewPatientsActual + " --*/");
       // assertEquals(acceptingNewPatientsActual, isAcceptingNewPatients);
       // Thread.sleep(2000);

        log("/*11.---- Validate Max New Requests  ---*/");
        /////double maxNewRequests_To_Double = Double.parseDouble(maxNewRequests);
        /////DecimalFormat formatter = new DecimalFormat("##,###");
        /////String maxNewRequestsExpected = formatter.format(maxNewRequests_To_Double);
        //String maxNewRequestsExpected = maxNewRequests;
        //String maxNewRequestsActual = providerPortalHomePage.getActualMaxNewRequestsForValidation();
        //log("/*---Max New Requests actual is: " + maxNewRequestsActual + " --*/");
        //assertEquals(maxNewRequestsActual, maxNewRequestsExpected);
        //Thread.sleep(2000);

    }





}
