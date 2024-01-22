package primarycare.tests.Selenium.Provider_Portal;

import primarycare.pages.Utils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import primarycare.pages.APIDelete;
import primarycare.pages.APISelect;
import primarycare.pages.ProviderPortalHomePage;
import primarycare.tests.BaseTest_PrimaryCare;
import primarycare.tests.Utilities.TestListener;


import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class Portal_Add_Remove_ReAdd_Current_Staff_as_a_Director extends BaseTest_PrimaryCare {
    //Pre setup -  for select and Delete Practitioner Facility and Facility Network
    private String practitionerFacilityName = "Kristine Fisher | CASTLEGAR MED FAMILY CLINIC";
    private String healthcareFacilityNetworkName = "Kristine Fisher | Panel | CASTLEGAR MED FAMILY CLINIC";
    public String practitionerFacility_accId;
    public String healthCareFacilityNetwork_Id;
    private String practitionerRole = "Provider";

    private String role = "Provider";
    private String practitioner = "Kristine Hnatyshyn Fisher";

    public void API_Precondition_Delete_Practitioner_Facility_and_Network_in_Salesforce_as_SysAdmin(){
        //log("/*0.---Pre-Condition API Remove 'Kristine Hnatyshyn Fisher' from CurrentStaff --*/");
        APISelect sqlQuery = new APISelect();
        log("Select Practitioner Facility Id from HealthcarePractitionerFacility.");
        String practitionerFacilityID = sqlQuery.selectPractitionerFacilityIdIDSQL("SELECT Id from HealthcarePractitionerFacility WHERE Name = '"+practitionerFacilityName+"'", "Id");
        log("Selected Practitioner Facility Id from HealthcarePractitionerFacility is: " +practitionerFacilityID);
        //Assert.assertEquals(accountNameReturned, name);
        log("Status Code 200 - Practitioner Facility Id SELECTED request - successfully");
        practitionerFacility_accId = practitionerFacilityID;
        //
        log("Select Healthcare Facility Network Id from HealthcareFacilityNetwork.");
        String healthcareFacilityNetworkID = sqlQuery.selectPractitionerFacilityIdIDSQL("SELECT Id from HealthcareFacilityNetwork WHERE Name = '"+healthcareFacilityNetworkName+"'", "Id");
        log("Selected Healthcare Facility Network Id from HealthcareFacilityNetwork is: " +healthcareFacilityNetworkID);
        //Assert.assertEquals(accountNameReturned, name);
        log("Status Code 200 - Healthcare Facility Network Id SELECTED request - successfully");
        healthCareFacilityNetwork_Id = healthcareFacilityNetworkID;

        if(practitionerFacilityID==null){
            log("Finish API Preconditioning because no duplicates. ");
        }
        else {
            //remove from HCPF
            APIDelete apidelete_practitionerFacility = new APIDelete();
            log("Delete PractitionerFacility from HealthcarePractitionerFacility.");
            String apiResponse_1 = apidelete_practitionerFacility.deletePractitionerFacility(practitionerFacility_accId);
            log("Deleted PractitionerFacility from HealthcarePractitionerFacility is: " +practitionerFacility_accId);
            log(apiResponse_1);
            log("Status Code 204 - Director's Associated HealthPractitionerFacility  Deleted - successfully");
            //and remove form HFN
            log("Delete PractitionerFacility from HealthcareFacilityNetwork.");
            String apiResponse_2 = apidelete_practitionerFacility.deleteHealthcareFacilityNetwork(healthCareFacilityNetwork_Id);
            log("Deleted PractitionerFacility from HealthcareFacilityNetwork is: " +healthCareFacilityNetwork_Id);
            log(apiResponse_2);
            log("Status Code 204 - HealthcareFacilityNetwork  Deleted - successfully");
        }
    }

    @Test(priority = 1)
    public void Can_Add_Current_Staff_to_Directors_Clinic_in_Portal () throws Exception {
        TestcaseID = "261425"; //C261425
        log("Target Environment: "+ Utils.getTargetEnvironment());

        log("/*0.---Preconditioning API dups removal from Current Staff for Practitioner Facility 'Kristine Fisher | CASTLEGAR MED FAMILY CLINIC'--*/");
        API_Precondition_Delete_Practitioner_Facility_and_Network_in_Salesforce_as_SysAdmin();

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

        log("/*3.----Click on facility 'CASTLEGAR MED FAMILY CLINIC' --*/");
        providerPortalHomePage.clickOnFacility();
        Thread.sleep(5000);

        log("/*4.----Click Add Staff --*/");
        providerPortalHomePage.clickAddStaff();
        Thread.sleep(2000);

        log("/*5.----Select Role: " + role + "--*/");
        providerPortalHomePage.selectRoleOption(role);
        Thread.sleep(5000);

        log("/*6.----Chose the Practitioner: " + practitioner + "--*/");
        providerPortalHomePage.selectPractitioner(practitioner);
        Thread.sleep(5000);

        log("/*7..----Click Save --*/");
        providerPortalHomePage.clickSaveNewStaffMember();
        Thread.sleep(2000);

        log("/*8.---- Validate that Practitioner Facility Name 'Kristine Fisher | CASTLEGAR MED FAMILY CLINIC' appears in Current Staff  ---*/");
        String practitionerFacilityNameActual = providerPortalHomePage.getActualPractitionerFacilityNameForValidation();
        log("/*---Practitioner Facility Name actual is: " + practitionerFacilityNameActual + " --*/");
        assertEquals(practitionerFacilityNameActual, practitionerFacilityName);
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void Can_Remove_Current_Staff_to_Directors_Clinic_in_Portal () throws Exception {
        TestcaseID = "273549"; //C273549
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
        Thread.sleep(7000);

        log("/*3.----Click 'CASTLEGAR MED FAMILY CLINIC' Associated Facility --*/");
        providerPortalHomePage.clickOnFacility();
        Thread.sleep(10000);

        log("/*4.----Click on Practitioner Facility 'Kristine Fisher | CASTLEGAR MED FAMILY CLINIC' --*/");
        providerPortalHomePage.clickOnPractitionerFacilityNameLink();
        Thread.sleep(15000);

        log("/*5.----Click 'Edit' Practitioner Facility --*/");
        providerPortalHomePage.clickEditPractitionerFacility();
        Thread.sleep(7000);

        log("/*6.----Enter Yesterday's Day in 'Effective From' --*/");
        providerPortalHomePage.inputYesterdayDayInEffectiveFrom();
        Thread.sleep(5000);

        log("/*7.----Click 'Save' Effective From --*/");
        providerPortalHomePage.clickSaveEffectiveFrom();
        Thread.sleep(5000);

        log("/*8.----Click Home link to see all Clinic Associated Panels --*/");
        //cpMainPage.verifyIsCommunityPortalHomePageDisplayed();
        providerPortalHomePage.clickHomeLink();
        Thread.sleep(5000);

        log("/*9.----Click on facility 'CASTLEGAR MEDICAL CLINIC' --*/");
        providerPortalHomePage.clickOnFacility();
        Thread.sleep(7000);
        //log("/*9.----Click 'Current Staff' for Directors Associated Facility --*/");
        //providerPortalHomePage.clickCurrentStaff();
        //Thread.sleep(5000);

        //log("/*.---- Validate Practitioner Facility -> 'Effective Form' is Yesterday value  ---*/");

        log("/*10.----Found and  Click on Practitioner's Facility 'Kristine Facility' record dropdown menu --*/");
        providerPortalHomePage.clickOnPractitionerFacilityCurrentStaffTabDropDownMenu(practitionerFacilityName, practitionerRole);

        log("/*11.----select Remove from the DropDownMenu dropdown menu --*/");
        providerPortalHomePage.selectRemoveFromDropDownMenu();
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void Can_ReAdd_Current_Staff_to_Directors_Clinic_in_Portal () throws Exception {
        TestcaseID = "273550"; //C273550
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

        log("/*3.----Click 'CASTLEGAR MED FAMILY CLINIC' link for Associated Facility --*/");
        providerPortalHomePage.clickOnFacility();
        Thread.sleep(10000);

        log("/*4.----Click on 'Inactive' Tab --*/");
        providerPortalHomePage.clickPreviousStaffTab();
        Thread.sleep(7000);

        log("/*5.----Click on Practitioner's Facility 'Kristine Facility' dropdown menu --*/");
        providerPortalHomePage.clickOnPractitionerFacilityPreviousTabDropDownMenu(practitionerFacilityName, practitionerRole);
        Thread.sleep(5000);

        log("/*6.----select Re-Add from the DropDownMenu dropdown menu --*/");
        providerPortalHomePage.selectReAddFromDropDownMenu();
        Thread.sleep(5000);

        log("/*7.----Click on 'Providers & Other PAS Users' Tab --*/");
        providerPortalHomePage.clickCurrentStaffTab();
        Thread.sleep(5000);

        log("/*8. ----Refresh 'Providers & Other PAS Users' page --*/");
        providerPortalHomePage.refreshBrowser();
        Thread.sleep(2000);

        log("/*9.---- Validate that Re-Added 'Kristine Hnatyshyn Fisher | PONDEROSA PRIMARY CARE CENTRE' is in Current Staff  ---*/");
        String practitionerFacilityNameActual = providerPortalHomePage.getActualPractitionerFacilityNameForValidation();
        log("/*---Practitioner Facility Name actual is: " + practitionerFacilityNameActual + " --*/");
        assertEquals(practitionerFacilityNameActual, practitionerFacilityName);
        Thread.sleep(2000);


    }

}
