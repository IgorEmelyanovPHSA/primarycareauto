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
public class Portal_Manage_Facility_Permissions_To_Staff extends BaseTest_PrimaryCare {
    private String MoA_practitionerFacilityName = "Agnes Phillip | CASTLEGAR MED FAMILY CLINIC";
    private String practitionerMoASystemRole = "Medical Office Assistant";

    //Pre setup -  for select and Delete Practitioner Facility and Facility Network
    //private String healthcareFacilityNetworkName = "Agnes Phillip | Panel | CASTLEGAR MED FAMILY CLINIC";
    public String practitionerFacility_accId;
    public String healthCareFacilityNetwork_Id;

    private String practitioner_MoA = "Agnes Phillip";

    public void API_Precondition_Delete_Practitioner_Facility_and_Network_in_Salesforce_as_SysAdmin(){
        //log("/*0.---Preconditioning API dups removal from Current Staff for Practitioner Facility 'Agnes Phillip | CASTLEGAR MED FAMILY CLINIC'--*/");
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
        TestcaseID = "269648"; //C269648
        log("Target Environment: "+ Utils.getTargetEnvironment());

        log("/*0.---Preconditioning API dups removal from Current Staff for Practitioner Facility 'Agnes Phillip | CASTLEGAR MED FAMILY CLINIC'--*/");
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
        providerPortalHomePage.clickHomeLink();
        Thread.sleep(10000);

        log("/*3.----Click on facility 'CASTLEGAR MED FAMILY CLINIC' --*/");
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

        log("/*8.---- Validate that Practitioner Facility Name 'Agnes Phillip | CASTLEGAR MED FAMILY CLINIC' appears in Current Staff  ---*/");
        String practitionerFacilityNameActual = providerPortalHomePage.getActualMoAPractitionerFacilityNameForValidation();
        log("/*---Practitioner Facility Name actual is: " + practitionerFacilityNameActual + " --*/");
        assertEquals(practitionerFacilityNameActual, MoA_practitionerFacilityName);
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void Can_Checked_Manage_Facility_Permissions_Director_To_MoA_In_Portal () throws Exception {
        TestcaseID = "269648"; //C269648
        log("Target Environment: "+ Utils.getTargetEnvironment());

        //log("/*0.---Preconditioning API dups removal from Current Staff for Practitioner Facility 'Kristine Hnatyshyn Fisher | CASTLEGAR MED FAMILY CLINIC'--*/");
        //API_Precondition_Delete_Practitioner_Facility_and_Network_in_Salesforce_as_SysAdmin();

        log("/*1.---Login to Provider Portal Home page as an Director: Lori-Ann May Bus --*/");
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
        Thread.sleep(7000);

        log("/*4.----Click on Practitioner Facility 'Agnes Phillip | CASTLEGAR MED FAMILY CLINIC' --*/");
        providerPortalHomePage.clickOnMoAPractitionerFacilityCurrentStaffTableRow(MoA_practitionerFacilityName, practitionerMoASystemRole);
        Thread.sleep(7000);

        log("/*5.----Click on 'Details' Tab --*/");
        providerPortalHomePage.clickDetailsTab();
        Thread.sleep(5000);

        log("/*5.----Checked 'Manage Facility' checkbox --*/");
        //verify that it is Checked, if not -> change to checked.
        providerPortalHomePage.checkedManageFacilityCheckBox();
        Thread.sleep(5000);
    }

    //@Test(priority = 2)
    public void Can_Checked_Manage_Facility_Permissions_Director_To_Provider_In_Portal () throws Exception {
    }

    @Test(priority = 3)
    public void Can_Edit_Clinic_Details_As_MoA_With_Checked_Manage_Facility_In_Portal () throws Exception {
        TestcaseID = "272537"; //C272537
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

        log("/*3.----Click on facility 'CASTLEGAR MED FAMILY CLINIC' --*/");
        providerPortalHomePage.clickOnRiverViewMedFamilyFacility();
        Thread.sleep(5000);

        log("/*4.----Click on 'Clinic Details'  --*/");
        providerPortalHomePage.clickOnClinicDetailsLink();
        Thread.sleep(7000);

        log("/*5.----Click Edit --*/");
        providerPortalHomePage.clickEdit();
        Thread.sleep(10000);

        log("/*6.1.----Verify that Edit Clinic Page has displayed --*/");
        providerPortalHomePage.isEditClinicPageDisplayed_MoA();
        Thread.sleep(2000);

        //log("/*6.----Enter different phone number --*/");
        //Thread.sleep(1000);

        //log("/*7.----Enter Website --*/");
        //Thread.sleep(1000);

        //log("/*8.----Add Time Slots --*/");
        //Thread.sleep(1000);

        //log("/*9.----Add Operating Hours --*/");
        //Thread.sleep(1000);

    }

    @Test(priority = 4)
    public void Can_Add_New_Staff_HCPF_As_MoA_With_Checked_Manage_Facility_In_Portal () throws Exception {
        TestcaseID = "272538"; //C272538
        log("Target Environment: "+ Utils.getTargetEnvironment());

        log("/*0.---Preconditioning API dups removal from Current Staff for Practitioner Facility 'someone else but not  Agnes Phillip :) | CASTLEGAR MED FAMILY CLINIC'--*/");
        //API_Precondition_Delete_Practitioner_Facility_and_Network_in_Salesforce_as_SysAdmin();

        //log("/*1.---Login to Provider Portal Home page as an Director --*/");
        //ProviderPortalHomePage providerPortalHomePage= loginPage.loginProviderPortalHomePageAsDirector();
        //Thread.sleep(5000);

        //log("/*2.----Click Home link to see all Clinic Associated Panels --*/");
        //cpMainPage.verifyIsCommunityPortalHomePageDisplayed();
        //providerPortalHomePage.clickHomeLink();
        //Thread.sleep(5000);

        //log("/*3.----Click on facility 'CASTLEGAR MED FAMILY CLINIC' --*/");
        //providerPortalHomePage.clickOnFacility();
        //Thread.sleep(5000);

        //log("/*4.----Click Add Staff --*/");
        //providerPortalHomePage.clickAddStaff();
        //Thread.sleep(2000);

        //log("/*5.----Select Role: " + practitionerMoASystemRole + "--*/");
        //providerPortalHomePage.selectMOARoleOption(practitionerMoASystemRole);
        //Thread.sleep(5000);

        //log("/*6.----Chose the Practitioner: " + practitioner_MoA + "--*/");
        //providerPortalHomePage.selectMoAAgnesPhillipPractitioner(practitioner_MoA);
        //Thread.sleep(5000);

        //log("/*7..----Click Save --*/");
        //providerPortalHomePage.clickSaveNewStaffMember();
        //Thread.sleep(2000);

        //log("/*8.---- Validate that Practitioner Facility Name 'Agnes Phillip | CASTLEGAR MED FAMILY CLINIC' appears in Current Staff  ---*/");
        //String practitionerFacilityNameActual = providerPortalHomePage.getActualMoAPractitionerFacilityNameForValidation();
        //log("/*---Practitioner Facility Name actual is: " + practitionerFacilityNameActual + " --*/");
        //assertEquals(practitionerFacilityNameActual, MoA_practitionerFacilityName);
        //Thread.sleep(2000);

    }

    @Test(priority = 5)
    public void Can_Edit_Staff_HCPF_As_MoA_With_Checked_Manage_Facility_In_Portal () throws Exception {
        TestcaseID = "272541"; //C272541
        log("Target Environment: "+ Utils.getTargetEnvironment());

        log("/*0.---Preconditioning API dups removal from Current Staff for Practitioner Facility 'someone else but not  Agnes Phillip :) | CASTLEGAR MED FAMILY CLINIC'--*/");
        //API_Precondition_Delete_Practitioner_Facility_and_Network_in_Salesforce_as_SysAdmin();

        //log("/*1.---Login to Provider Portal Home page as an Director --*/");
        //ProviderPortalHomePage providerPortalHomePage= loginPage.loginProviderPortalHomePageAsDirector();
        //Thread.sleep(5000);

        //log("/*2.----Click Home link to see all Clinic Associated Panels --*/");
        //cpMainPage.verifyIsCommunityPortalHomePageDisplayed();
        //providerPortalHomePage.clickHomeLink();
        //Thread.sleep(5000);

        //log("/*3.----Click on facility 'CASTLEGAR MED FAMILY CLINIC' --*/");
        //providerPortalHomePage.clickOnFacility();
        //Thread.sleep(5000);

        //log("/*4.----Click Add Staff --*/");
        //providerPortalHomePage.clickAddStaff();
        //Thread.sleep(2000);

        //log("/*5.----Select Role: " + practitionerMoASystemRole + "--*/");
        //providerPortalHomePage.selectMOARoleOption(practitionerMoASystemRole);
        //Thread.sleep(5000);

        //log("/*6.----Chose the Practitioner: " + practitioner_MoA + "--*/");
        //providerPortalHomePage.selectMoAAgnesPhillipPractitioner(practitioner_MoA);
        //Thread.sleep(5000);

        //log("/*7..----Click Save --*/");
        //providerPortalHomePage.clickSaveNewStaffMember();
        //Thread.sleep(2000);

        //log("/*8.---- Validate that Practitioner Facility Name 'Agnes Phillip | CASTLEGAR MED FAMILY CLINIC' appears in Current Staff  ---*/");
        //String practitionerFacilityNameActual = providerPortalHomePage.getActualMoAPractitionerFacilityNameForValidation();
        //log("/*---Practitioner Facility Name actual is: " + practitionerFacilityNameActual + " --*/");
        //assertEquals(practitionerFacilityNameActual, MoA_practitionerFacilityName);
        //Thread.sleep(2000);

    }

    @Test(priority = 6)
    public void Can_Remove_Staff_HCPF_As_MoA_With_Checked_Manage_Facility_In_Portal () throws Exception {
        TestcaseID = "272539"; //C272539
        log("Target Environment: "+ Utils.getTargetEnvironment());

        //log("/*0.---Preconditioning API dups removal from Current Staff for Practitioner Facility 'someone else but not  Agnes Phillip :) | CASTLEGAR MED FAMILY CLINIC'--*/");
        //API_Precondition_Delete_Practitioner_Facility_and_Network_in_Salesforce_as_SysAdmin();

        //log("/*1.---Login to Provider Portal Home page as an Director --*/");
        //ProviderPortalHomePage providerPortalHomePage= loginPage.loginProviderPortalHomePageAsDirector();
        //Thread.sleep(5000);

        //log("/*2.----Click Home link to see all Clinic Associated Panels --*/");
        //cpMainPage.verifyIsCommunityPortalHomePageDisplayed();
        //providerPortalHomePage.clickHomeLink();
        //Thread.sleep(5000);

        //log("/*3.----Click on facility 'CASTLEGAR MED FAMILY CLINIC' --*/");
        //providerPortalHomePage.clickOnFacility();
        //Thread.sleep(5000);

        //log("/*4.----Click Add Staff --*/");
        //providerPortalHomePage.clickAddStaff();
        //Thread.sleep(2000);

        //log("/*5.----Select Role: " + practitionerMoASystemRole + "--*/");
        //providerPortalHomePage.selectMOARoleOption(practitionerMoASystemRole);
        //Thread.sleep(5000);

        //log("/*6.----Chose the Practitioner: " + practitioner_MoA + "--*/");
        //providerPortalHomePage.selectMoAAgnesPhillipPractitioner(practitioner_MoA);
        //Thread.sleep(5000);

        //log("/*7..----Click Save --*/");
        //providerPortalHomePage.clickSaveNewStaffMember();
        //Thread.sleep(2000);

        //log("/*8.---- Validate that Practitioner Facility Name 'Agnes Phillip | CASTLEGAR MED FAMILY CLINIC' appears in Current Staff  ---*/");
        //String practitionerFacilityNameActual = providerPortalHomePage.getActualMoAPractitionerFacilityNameForValidation();
        //log("/*---Practitioner Facility Name actual is: " + practitionerFacilityNameActual + " --*/");
        //assertEquals(practitionerFacilityNameActual, MoA_practitionerFacilityName);
        //Thread.sleep(2000);

    }

    @Test(priority = 7)
    public void Can_Add_Other_Clinic_Staff_FTE_As_MoA_With_Checked_Manage_Facility_In_Portal () throws Exception {
        TestcaseID = "272543"; //C272543
        log("Target Environment: "+ Utils.getTargetEnvironment());

        //log("/*0.---Preconditioning API dups removal from Current Staff for Practitioner Facility 'someone else but not  Agnes Phillip :) | CASTLEGAR MED FAMILY CLINIC'--*/");
        //API_Precondition_Delete_Practitioner_Facility_and_Network_in_Salesforce_as_SysAdmin();

        //log("/*1.---Login to Provider Portal Home page as an Director --*/");
        //ProviderPortalHomePage providerPortalHomePage= loginPage.loginProviderPortalHomePageAsDirector();
        //Thread.sleep(5000);

        //log("/*2.----Click Home link to see all Clinic Associated Panels --*/");
        //cpMainPage.verifyIsCommunityPortalHomePageDisplayed();
        //providerPortalHomePage.clickHomeLink();
        //Thread.sleep(5000);

        //log("/*3.----Click on facility 'CASTLEGAR MED FAMILY CLINIC' --*/");
        //providerPortalHomePage.clickOnFacility();
        //Thread.sleep(5000);

        //log("/*4.----Click Add Staff --*/");
        //providerPortalHomePage.clickAddStaff();
        //Thread.sleep(2000);

        //log("/*5.----Select Role: " + practitionerMoASystemRole + "--*/");
        //providerPortalHomePage.selectMOARoleOption(practitionerMoASystemRole);
        //Thread.sleep(5000);

        //log("/*6.----Chose the Practitioner: " + practitioner_MoA + "--*/");
        //providerPortalHomePage.selectMoAAgnesPhillipPractitioner(practitioner_MoA);
        //Thread.sleep(5000);

        //log("/*7..----Click Save --*/");
        //providerPortalHomePage.clickSaveNewStaffMember();
        //Thread.sleep(2000);

        //log("/*8.---- Validate that Practitioner Facility Name 'Agnes Phillip | CASTLEGAR MED FAMILY CLINIC' appears in Current Staff  ---*/");
        //String practitionerFacilityNameActual = providerPortalHomePage.getActualMoAPractitionerFacilityNameForValidation();
        //log("/*---Practitioner Facility Name actual is: " + practitionerFacilityNameActual + " --*/");
        //assertEquals(practitionerFacilityNameActual, MoA_practitionerFacilityName);
        //Thread.sleep(2000);

    }

    @Test(priority = 8)
    public void Can_Edit_Other_Clinic_Staff_FTE_As_MoA_With_Checked_Manage_Facility_In_Portal () throws Exception {
        TestcaseID = "272544"; //C272544
        log("Target Environment: "+ Utils.getTargetEnvironment());

        //log("/*0.---Preconditioning API dups removal from Current Staff for Practitioner Facility 'someone else but not  Agnes Phillip :) | CASTLEGAR MED FAMILY CLINIC'--*/");
        //API_Precondition_Delete_Practitioner_Facility_and_Network_in_Salesforce_as_SysAdmin();

        //log("/*1.---Login to Provider Portal Home page as an Director --*/");
        //ProviderPortalHomePage providerPortalHomePage= loginPage.loginProviderPortalHomePageAsDirector();
        //Thread.sleep(5000);

        //log("/*2.----Click Home link to see all Clinic Associated Panels --*/");
        //cpMainPage.verifyIsCommunityPortalHomePageDisplayed();
        //providerPortalHomePage.clickHomeLink();
        //Thread.sleep(5000);

        //log("/*3.----Click on facility 'CASTLEGAR MED FAMILY CLINIC' --*/");
        //providerPortalHomePage.clickOnFacility();
        //Thread.sleep(5000);

        //log("/*4.----Click Add Staff --*/");
        //providerPortalHomePage.clickAddStaff();
        //Thread.sleep(2000);

        //log("/*5.----Select Role: " + practitionerMoASystemRole + "--*/");
        //providerPortalHomePage.selectMOARoleOption(practitionerMoASystemRole);
        //Thread.sleep(5000);

        //log("/*6.----Chose the Practitioner: " + practitioner_MoA + "--*/");
        //providerPortalHomePage.selectMoAAgnesPhillipPractitioner(practitioner_MoA);
        //Thread.sleep(5000);

        //log("/*7..----Click Save --*/");
        //providerPortalHomePage.clickSaveNewStaffMember();
        //Thread.sleep(2000);

        //log("/*8.---- Validate that Practitioner Facility Name 'Agnes Phillip | CASTLEGAR MED FAMILY CLINIC' appears in Current Staff  ---*/");
        //String practitionerFacilityNameActual = providerPortalHomePage.getActualMoAPractitionerFacilityNameForValidation();
        //log("/*---Practitioner Facility Name actual is: " + practitionerFacilityNameActual + " --*/");
        //assertEquals(practitionerFacilityNameActual, MoA_practitionerFacilityName);
        //Thread.sleep(2000);

    }

    @Test(priority = 9)
    public void Can_Add_TimeSlots_As_MoA_With_Checked_Manage_Facility_In_Portal () throws Exception {
        TestcaseID = "272800"; //C272800
        log("Target Environment: "+ Utils.getTargetEnvironment());
    }






}
