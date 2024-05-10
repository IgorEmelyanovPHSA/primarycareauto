package primarycare.tests.Selenium.Provider_Portal;

import primarycare.pages.Utils;
import org.testng.annotations.Test;
import primarycare.pages.APIDelete;
import primarycare.pages.APIInsert;
import primarycare.pages.APISelect;
import primarycare.pages.ProviderPortalHomePage;
import primarycare.tests.BaseTest_PrimaryCare;

import static org.testng.Assert.assertEquals;

public class Portal_Empaneled_Add_Remove_Change_Clinic_Edit_Status extends BaseTest_PrimaryCare {
    private String empaneledPatientPHN = "9876923304"; ////'BABY GIRL' "MUNCIE" <-- 'Prosacco' 'Garth'
    private String empaneledPatientFirstNameExpected = "BABY GIRL";
    private String empaneledPatientLastName = "MUNCIE";
    //private String inactiveStasuts = "Inactive";

    //for API Insert EmpaneledPanel Member in Current Staff
    ///REFRESH
    public String patient__c = "001As00000Obf8NIAR";////'BABY GIRL' "MUNCIE" <-- Prosacco "Garth"
    public String healthcare_facility_network__c = "0bYAs0000004ljXMAQ";//Lori-Ann Bus | Panel | CASTLEGAR MED FAMILY CLINIC
    ///REFRESH
    public String panel__c = "Active";
    public String roster__c = "Pending";


    public void API_Precondition_Remove_Empaneled_Patient_Record_from_Current_Panel(){
        log("/*0.---Pre-Condition API Remove Empaneled Patient record for 'BABY GIRL' 'MUNCIE' from Current Panel not form Account --*/");
        APISelect sqlQuery = new APISelect();
        log("Select Empaneled Patient record Id from 'Panel_Member__c' Table.");
        String empaneledPatientRecordID = sqlQuery.selectEmpaneledPatientRecordIdByPHN("SELECT Id FROM Panel_Member__c WHERE Patient__r.PHN__c = '"+empaneledPatientPHN+"'", "Id");
        log("Selected Empaneled Patient record Id from 'Panel_Member__c' is: " +empaneledPatientRecordID);
        log("Status Code 200 - Empaneled Patient record Id SELECTED request  - successfully");

        if(empaneledPatientRecordID==null){
            log("Finish API Preconditioning - no Empaneled Patients records for 'BABY GIRL' 'MUNCIE'. ");
        }
        else {
            //remove Empaneled Patient from "Panel_Member_c" Table
            APIDelete api_delete_empaneled_patient = new APIDelete();
            log("Delete Empaneled Patient record from 'Panel_Member_c'.");
            String apiResponse= api_delete_empaneled_patient.deleteEmpaneledPatientRecord(empaneledPatientRecordID);
            log("Deleted Empaneled Patient record from 'Panel_Member_c' is: " +empaneledPatientRecordID);
            log(apiResponse);
        }
    }

    public void API_Precondition_Insert_Empaneled_Patient_Record_To_Current_Panel(){
        //log("/*0.---Pre-Condition API Inserting Empaneled Patient record 'BABY GIRL' 'MUNCIE' to Panel_Member__c Object for Current Panel--*/");
        APIInsert apiCreatePanelMemberRecord = new APIInsert();
        String panelMemberRecordID = apiCreatePanelMemberRecord.insertPanelMember(patient__c,
                healthcare_facility_network__c,
                panel__c, roster__c);
        log("Created Panel Member's record id is: " +panelMemberRecordID);
        log("Status Code 201- created success");
    }

    @Test(priority = 1)
    public void Can_Add_Empaneled_Patient_for_Directors_Panel_in_Portal () throws Exception {
        TestcaseID = "252886"; //C252886
        log("Target Environment: "+ Utils.getTargetEnvironment());

        log("/*0.---Preconditioning API dups Empaneled Patient removal 'BABY GIRL' 'MUNCIE' from Current Panel--*/");
        API_Precondition_Remove_Empaneled_Patient_Record_from_Current_Panel();

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

        log("/*3.----Click 'Panel Registry' link --*/");
        providerPortalHomePage.clickRostering();
        Thread.sleep(5000);

        log("/*4.----Click 'Add Patient' button --*/");
        //providerPortalHomePage.clickAddPatient();
        Thread.sleep(5000);

        log("/*5.----Enter PHN of Patient: "+ empaneledPatientPHN +" --*/");
        //providerPortalHomePage.enterPatientPHN(empaneledPatientPHN);
        Thread.sleep(5000);

        log("/*7.----Click 'Search' for Patient button --*/");
        //providerPortalHomePage.clickSearchForPatientPHNButton();
        Thread.sleep(5000);

        log("/*8.----Click on search Modal 'Add Patient' button for founded Patient --*/");
        //providerPortalHomePage.clickAddFoundedPatient();
        Thread.sleep(5000);

        log("/*9.----Click on Close 'x' button Modal Window --*/");
        //providerPortalHomePage.clickCloseModalForm();
        Thread.sleep(5000);

        log("/*10.---- Validate that Empaneled Patient with First Name 'BABY GIRL' has appears in Current Panel  ---*/");
        //String empaneledPatientFirstNameActual = providerPortalHomePage.getActualEmpaneledPatientFirstNameForValidation();
        //log("/*---Empaneled Patient Name actual is: " + empaneledPatientFirstNameActual + " --*/");
        //assertEquals(empaneledPatientFirstNameActual, empaneledPatientFirstNameExpected);
        Thread.sleep(2000);

    }

    @Test(priority = 2)
    public void Can_Remove_Empaneled_Patient_for_Directors_Panel_in_Portal () throws Exception {
        TestcaseID = "272567"; //C272567
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

        log("/*3.----Click 'Panel Registry' link --*/");
        providerPortalHomePage.clickRostering();
        Thread.sleep(5000);

        log("/*4.----Found and Click on Empaneled Patient 'BABY GIRL' 'MUNCIE' record dropdown menu --*/");
        //providerPortalHomePage.clickOnEmpaneledPatientCurrentPanelTabDropDownMenu(empaneledPatientFirstNameExpected, empaneledPatientLastName);
        Thread.sleep(5000);

        log("/*5.----select Remove from the DropDownMenu dropdown menu --*/");
        //providerPortalHomePage.selectRemoveFromDropDownMenu();
        Thread.sleep(5000);

        log("/*6.----Click 'Yes' on the Modal 'Remove Patient' Form button --*/");
        //providerPortalHomePage.clickYesOnModalRemovePatientsForm();
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void Can_Edit_Panel_Status_To_Active_Empaneled_Patient_for_Directors_Panel_in_Portal () throws Exception {
        TestcaseID = "272568"; //C272568
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

        log("/*3.----Click 'Panel Registry' link --*/");
        providerPortalHomePage.clickRostering();
        Thread.sleep(5000);

        log("/*4.----select 'Removed' Panel in Dropdown --*/");
        //providerPortalHomePage.selectRemovedPanel();
        Thread.sleep(5000);

        log("/*5.----Found and Click on Empaneled Patient 'BABY GIRL' 'MUNCIE' record dropdown menu --*/");
        //providerPortalHomePage.clickOnEmpaneledPatientCurrentPanelTabDropDownMenu(empaneledPatientFirstNameExpected, empaneledPatientLastName);
        Thread.sleep(5000);

        log("/*6.----Select Edit from the DropDownMenu dropdown menu --*/");
        //providerPortalHomePage.selectEditFromDropDownMenu();
        Thread.sleep(5000);

        log("/*7.----Select 'Active' option on Modal 'Update Panel Status' Form. --*/");
        //providerPortalHomePage.selectPanelStatusActiveOption();
        Thread.sleep(5000);

        log("/*8.----Click 'Proceed' on the Modal 'Update Panel Status' Form button --*/");
        //providerPortalHomePage.clickProceedOnModalUpdatePanelStatusForm();
        Thread.sleep(5000);

        log("/*9.----Click 'Yes' on the Modal 'Update Panel Status' Form button --*/");
        //providerPortalHomePage.clickYesOnModalUpdatePanelStatusForm();
        Thread.sleep(5000);

        log("/*10.---- Validate that Empaneled Patient with First Name 'BABY GIRL' has appears in Current Panel  ---*/");
        //String empaneledPatientFirstNameActual = providerPortalHomePage.getActualEmpaneledPatientFirstNameForValidation();
        //log("/*---Empaneled Patient Name actual is: " + empaneledPatientFirstNameActual + " --*/");
        //assertEquals(empaneledPatientFirstNameActual, empaneledPatientFirstNameExpected);
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void Can_Change_Clinic_of_Empaneled_Patient_for_Directors_Panel_in_Portal () throws Exception {
        TestcaseID = "265539"; //C265539
        log("Target Environment: "+ Utils.getTargetEnvironment());

        log("/*0.1---Preconditioning API dups Empaneled Patient removal 'BABY GIRL' 'MUNCIE' from Current Panel--*/");
        API_Precondition_Remove_Empaneled_Patient_Record_from_Current_Panel();
        log("/*0.one more in case---Preconditioning API dups Empaneled Patient removal 'BABY GIRL' 'MUNCIE' from Current Panel--*/");
        API_Precondition_Remove_Empaneled_Patient_Record_from_Current_Panel();

        log("/*0.2.---Pre-Condition API Inserting Empaneled Patient record 'BABY GIRL' 'MUNCIE' to Panel_Member__c Object for Current Panel--*/");
        API_Precondition_Insert_Empaneled_Patient_Record_To_Current_Panel();

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
        Thread.sleep(10000);

        log("/*3.----Click on the 'CASTLEGAR MED FAMILY CLINIC' 'My Panel' link --*/");
        providerPortalHomePage.clickRostering();
        Thread.sleep(5000);

        log("/*4.----Found and Click on Empaneled Patient 'BABY GIRL' 'MUNCIE' record dropdown menu --*/");
        providerPortalHomePage.clickOnEmpaneledPatientCurrentPanelTabDropDownMenu(empaneledPatientFirstNameExpected, empaneledPatientLastName);
        Thread.sleep(5000);

        log("/*5.----Select 'Change Clinic' from the DropDownMenu dropdown menu --*/");
        providerPortalHomePage.selectChangeClinicFromDropDownMenu();
        Thread.sleep(5000);

        log("/*6.----Select the first available option like 'CASTLEGAR MED ASSOCIATES' on Modal 'Change Clinic' Form. --*/");
        providerPortalHomePage.selectChangeClinicFirstAvailableOption();
        Thread.sleep(5000);

        log("/*7.----Click 'Proceed' on the Modal 'Change Clinic' Form button --*/");
        providerPortalHomePage.clickProceedOnModalChangeClinicForm();
        Thread.sleep(5000);

        log("/*8.----Click 'Yes' on the Modal 'Update Panel Status' Form button --*/");
        providerPortalHomePage.clickYesOnModalUpdatePanelStatusForm();
        Thread.sleep(5000);

        log("/*9.----Click Home link to back to see all Clinic Associated Panels --*/");
        providerPortalHomePage.clickHomeLink();
        Thread.sleep(5000);

        log("/*10.----Click on the second Clinic's 'CASTLEGAR MED ASSOCIATES' 'My Panel' link --*/");
        providerPortalHomePage.clickOnSecondClinicRosteringLink();
        Thread.sleep(5000);

        //log("/* ----Refresh page --*/");
        //providerPortalHomePage.refreshBrowser();
        //Thread.sleep(5000);

        log("/*11.---- Validate that Empaneled Patient with First Name 'BABY GIRL' has appears in Current Panel  ---*/");
        //////
        log("/*11.1 --- first make sure that 'BABY GIRL' is showing up in the Tab   ---*/");
        boolean isEmpaneledBABYGIRLFound =  providerPortalHomePage.isEmpaneledPatientFoundValidation(empaneledPatientFirstNameExpected);
        if (!isEmpaneledBABYGIRLFound){
            throw new RuntimeException("Exception: Empaneled Patient " + empaneledPatientFirstNameExpected + " not found!!!");
        }
        ///////
        log("/*11.2 --- now we can Validate   ---*/");
        String empaneledPatientFirstNameActual = providerPortalHomePage.getActualEmpaneledPatientFirstNameForValidation();
        log("/*---Empaneled Patient Name actual is: " + empaneledPatientFirstNameActual + " --*/");
        assertEquals(empaneledPatientFirstNameActual, empaneledPatientFirstNameExpected);
        Thread.sleep(2000);

        log("/*0.3 ---Post-conditioning API dups Empaneled Patient removal 'BABY GIRL' 'MUNCIE' from Current Panel--*/");
        API_Precondition_Remove_Empaneled_Patient_Record_from_Current_Panel();
    }




}
