package primarycare.tests.Selenium.Provider_Portal;

import primarycare.pages.Utils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import primarycare.pages.APIDelete;
import primarycare.pages.APISelect;
import primarycare.pages.ProviderPortalHomePage;
import primarycare.tests.BaseTest_PrimaryCare;
import primarycare.tests.Utilities.TestListener;

import java.util.Random;

import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class Portal_Delegation_Activities_To_Staff extends BaseTest_PrimaryCare {
    //Pre setup -  for select and Delete Practitioner Facility and Facility Network
    private String MoA_practitionerFacilityName = "Agnes Phillip | NORTH SHORE PRIMARY CARE MED HOME";
    public String practitionerFacility_accId;
    private String practitioner_MoA = "Agnes Phillip";
    private String practitionerMoASystemRole = "Medical Office Assistant";
    private String practitionerRole = "Medical Office Assistant";
    private String practitionerGrantedByFacilityPanelName = "Karen F. Beegan Panel";
    private String practitionerGrantedByRole = "Director";

    /////////prep for Test3 - Accept New Patients and Max New Request
    //private int desiredPanelSize = ((1 + new Random().nextInt(2)) * 10000) + new Random().nextInt(10000);
    private String isAcceptingNewPatients = "Yes";
    int maxNew = new Random().nextInt(1000) + 1000;
    String maxNewRequests = String.format("%04d", maxNew);
    //////////

    public void API_Precondition_Delete_Practitioner_Facility_and_Network_in_Salesforce_as_SysAdmin(){
        //log("/*0.---Preconditioning API dups removal from Current Staff for Practitioner Facility 'Agnes Phillip | NORTH SHORE PRIMARY CARE MED HOME'--*/");
        APISelect sqlQuery = new APISelect();
        log("Select Practitioner Facility Id from HealthcarePractitionerFacility.");
        String practitionerFacilityID = sqlQuery.selectPractitionerFacilityIdIDSQL("SELECT Id from HealthcarePractitionerFacility WHERE Name = '"+MoA_practitionerFacilityName+"'", "Id");
        log("Selected Practitioner Facility Id from HealthcarePractitionerFacility is: " +practitionerFacilityID);
        //Assert.assertEquals(accountNameReturned, name);
        log("Status Code 200 - Practitioner Facility Id SELECTED request - successfully");
        practitionerFacility_accId = practitionerFacilityID;
        //
        //log("Select Healthcare Facility Network Id from HealthcareFacilityNetwork.");
        //String healthcareFacilityNetworkID = sqlQuery.selectPractitionerFacilityIdIDSQL("SELECT Id from HealthcareFacilityNetwork WHERE Name = '"+healthcareFacilityNetworkName+"'", "Id");
        //log("Selected Healthcare Facility Network Id from HealthcareFacilityNetwork is: " +healthcareFacilityNetworkID);
        //log("Status Code 200 - Healthcare Facility Network Id SELECTED request - successfully");
        //healthCareFacilityNetwork_Id = healthcareFacilityNetworkID;

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
            //log("Delete PractitionerFacility from HealthcareFacilityNetwork.");
            //String apiResponse_2 = apidelete_practitionerFacility.deleteHealthcareFacilityNetwork(healthCareFacilityNetwork_Id);
            //log("Deleted PractitionerFacility from HealthcareFacilityNetwork is: " +healthCareFacilityNetwork_Id);
            //log(apiResponse_2);
            //log("Status Code 204 - HealthcareFacilityNetwork  Deleted - successfully");
        }
    }


    @Test(priority = 1)
    public void Pre_Add_MoA_Agnes_Phillip_To_Clinics_Current_Staff_in_Portal () throws Exception {
        TestcaseID = "272337"; //C272337
        log("Target Environment: "+ Utils.getTargetEnvironment());

        log("/*0.---Preconditioning API dups removal from Current Staff for Practitioner Facility 'Agnes Phillip | NORTH SHORE PRIMARY CARE MED HOME'--*/");
        API_Precondition_Delete_Practitioner_Facility_and_Network_in_Salesforce_as_SysAdmin();

        log("/*1.---Login to Provider Portal Home page as an Director --*/");
        ProviderPortalHomePage providerPortalHomePage= loginPage.loginProviderPortalHomePageAsDirector();
        Thread.sleep(5000);

        log("/*1.1.----Verify that Provider Portal Home page displayed --*/");
        boolean isPortalProviderHomePageDisplayed =  providerPortalHomePage.isPortalProviderHomePageDisplayed_MoA();
        if (!isPortalProviderHomePageDisplayed){
            throw new RuntimeException("Exception: Portal Provider Home Page "  + "has not shown up!!!");
        }
        Thread.sleep(2000);

        log("/*2.----Click Home link to see all Clinic Associated Panels --*/");
        //cpMainPage.verifyIsCommunityPortalHomePageDisplayed();
        providerPortalHomePage.clickHomeLink();
        Thread.sleep(5000);

        log("/*3.----Click on facility 'NORTH SHORE PRIMARY CARE MED HOME' --*/");
        providerPortalHomePage.clickOnFacility();
        Thread.sleep(5000);

        log("/*4.----Click Add Staff --*/");
        providerPortalHomePage.clickAddStaff();
        Thread.sleep(2000);

        log("/*5.----Select Role: " + practitionerMoASystemRole + "--*/");
        providerPortalHomePage.selectMOARoleOption(practitionerMoASystemRole);
        Thread.sleep(5000);

        log("/*6.----Chose the Practitioner: " + practitioner_MoA + "--*/");
        providerPortalHomePage.selectMoAAgnesPhillipPractitioner(practitioner_MoA);
        Thread.sleep(5000);

        log("/*7..----Click Save --*/");
        providerPortalHomePage.clickSaveNewStaffMember();
        Thread.sleep(2000);

        log("/*8.---- Validate that Practitioner Facility Name 'Agnes Phillip | NORTH SHORE PRIMARY CARE MED HOME' appears in Current Staff  ---*/");
        String practitionerFacilityNameActual = providerPortalHomePage.getActualMoAPractitionerFacilityNameForValidation();
        log("/*---Practitioner Facility Name actual is: " + practitionerFacilityNameActual + " --*/");
        assertEquals(practitionerFacilityNameActual, MoA_practitionerFacilityName);
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void Can_DELEGATE_Activities_Director_To_MoA_In_Portal () throws Exception {
        TestcaseID = "272337"; //C272337
        log("Target Environment: "+ Utils.getTargetEnvironment());

        log("/*1.---Login to Provider Portal Home page as an Director: Lori-Ann May Bus --*/");
        ProviderPortalHomePage providerPortalHomePage= loginPage.loginProviderPortalHomePageAsDirector();
        Thread.sleep(5000);

        log("/*1.1.----Verify that Provider Portal Home page displayed --*/");
        boolean isPortalProviderHomePageDisplayed =  providerPortalHomePage.isPortalProviderHomePageDisplayed_MoA();
        if (!isPortalProviderHomePageDisplayed){
            throw new RuntimeException("Exception: Portal Provider Home Page "  + "has not shown up!!!");
        }
        Thread.sleep(2000);

        log("/*2.----Click Home link to see all Clinic Associated Panels --*/");
        providerPortalHomePage.clickHomeLink();
        Thread.sleep(5000);

        log("/*3.----Click 'Panel Sharing' link of the 'NORTH SHORE PRIMARY CARE MED HOME' --*/");
        providerPortalHomePage.clickPanelSharing();
        Thread.sleep(5000);

        log("/*4.----Click on 'Give Access To' Tab --*/");
        providerPortalHomePage.clickGiveAccessToTab();
        Thread.sleep(5000);

        log("/*5.----Get 'Manage My Panel&Profile' of MoA 'Agnes Phillip' record cell  --*/");
        log("/-------and get checkbox Status --*/");
        log("/-------and Set to True 'Manage My Panel & Profile' Delegation Checkbox --*/");
        providerPortalHomePage.setToTrueDelegationCheckBox(practitioner_MoA, practitionerRole);
        Thread.sleep(5000);

    }

    @Test(priority = 3)
    public void As_Delegated_MoA_By_Director_Can_Update_Accepting_New_Patients_and_Max_New_Requests_In_Portal () throws Exception {
        TestcaseID = "272383"; //C272383
        log("Target Environment: "+ Utils.getTargetEnvironment());

        log("/*1.---Login to Provider Portal Home page as an MoA: Agnes Phillip --*/");
        ProviderPortalHomePage providerPortalHomePage= loginPage.loginProviderPortalHomePageAsMoA();
        Thread.sleep(5000);

        log("/*1.1.----Verify that Provider Portal Home page displayed --*/");
        boolean isPortalProviderHomePageDisplayed =  providerPortalHomePage.isPortalProviderHomePageDisplayed_MoA();
        if (!isPortalProviderHomePageDisplayed){
            throw new RuntimeException("Exception: Portal Provider Home Page "  + "has not shown up!!!");
        }
        Thread.sleep(2000);

        log("/*2.----Click Home link to see all Clinic Associated Panels --*/");
        providerPortalHomePage.clickHomeLink();
        Thread.sleep(5000);

        log("/*3.----Click on FlexCard 'NORTH SHORE PRIMARY CARE MED HOME' -> 'Panel Sharing' link  --*/");
        providerPortalHomePage.clickMoAPanelSharing();
        Thread.sleep(5000);

        log("/*4.----Click on Panel Sharing Tab -> GrantedAccessBy column link 'Karen F. Beegan Panel' --*/");
        providerPortalHomePage.clickOnPractitionerGrantedAccessByTableRow(practitionerGrantedByFacilityPanelName,practitionerGrantedByRole);
        Thread.sleep(5000);

        log("/*5.----Click Edit --*/");
        providerPortalHomePage.clickEdit();
        Thread.sleep(1000);

        log("/*6.----Select Accepting new Patients: " + isAcceptingNewPatients + "--*/");
        providerPortalHomePage.selectAcceptingNewPatientsOption(isAcceptingNewPatients);
        Thread.sleep(1000);

        log("/*7.----Enter random Max New Requests: " + maxNewRequests + "--*/");
        providerPortalHomePage.enterMaxNewRequests(maxNewRequests);
        Thread.sleep(1000);

        log("/*8.----Click Save --*/");
        providerPortalHomePage.clickSave();
        Thread.sleep(5000);

        log("/*9.---- Validate isAccepting new Patients  ---*/");
        String acceptingNewPatientsActual = providerPortalHomePage.getActualIsAcceptingNewPatientsForValidation();
        log("/*---Accepting new Patients actual is: " + acceptingNewPatientsActual + " --*/");
        assertEquals(acceptingNewPatientsActual, isAcceptingNewPatients);
        Thread.sleep(2000);

        log("/*10.---- Validate Max New Requests  ---*/");
        String maxNewRequestsExpected = maxNewRequests;
        String maxNewRequestsActual = providerPortalHomePage.getActualMaxNewRequestsForValidation();
        log("/*---Max New Requests actual is: " + maxNewRequestsActual + " --*/");
        assertEquals(maxNewRequestsActual, maxNewRequestsExpected);
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void As_Delegated_MoA_By_Director_Can_Remove_Empaneled_Patients_To_Another_Clinic_In_Portal () throws Exception {
        TestcaseID = "252239"; //C252239
    }

    @Test(priority = 5)
    public void As_Delegated_MoA_By_Director_Can_Edit_All_Profile_Fields_In_Portal () throws Exception {
        TestcaseID = "272563"; //C272563
        //edit all fields that a provider/director can edit on their profile
    }

    @Test(priority = 6)
    public void  As_Delegated_MoA_By_Director_Can_NOT_Assign_More_Delegates_On_My_Behalf_In_Portal () throws Exception {
        TestcaseID = "272564"; //C272564
    }


}
