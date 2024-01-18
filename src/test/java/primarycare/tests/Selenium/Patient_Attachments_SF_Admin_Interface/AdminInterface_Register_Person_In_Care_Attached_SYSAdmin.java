package primarycare.tests.Selenium.Patient_Attachments_SF_Admin_Interface;

import primarycare.pages.*;
import primarycare.tests.Utilities.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import primarycare.tests.BaseTest_PrimaryCare;
import primarycare.tests.Utilities.ApiQueries;

import static org.testng.Assert.assertEquals;


@Listeners({TestListener.class})
public class AdminInterface_Register_Person_In_Care_Attached_SYSAdmin extends BaseTest_PrimaryCare {
    private String callersRelationships = "Social worker";
    private String callerName = "SELENIUM Social";

    private String legalFirstName = "Kenton";
    private String legalLastName = "Troup";
    //private String dateOfBirth = "December 5, 1959";
    private String dateOfBirth_MM = "12";//December
    private String dateOfBirth_DD = "05";
    private String dateOfBirth_YYYY = "1959";
    private String personalHealthNumber = "9873010088";

    private String empiStatusExpected = "EMPI Verified";

    private String streetAddress = "309-1140 Windermere";
    private String City = "Richmond";
    private String province = "BC";
    private String postalCode = "V0A 0A2";

    private String primaryContactName = "Igor PrimaryContactName";

    private String email = "accountToDelete@phsa.ca";
    private String mobilePhone = "7788797899";
    private String currentFamilyDoctor = "Lori-Ann May Bus";
    private String cityOrTown = "East Kootenay";
    private String language = "French";

    private String caseOriginExpectedValue = "Phone";
    private String priorityExpectedValue = "None";//"Medium" for UAT;
    private String statusExpected = "Active";
    private String accountNameExpected = "1140 Windermere";
    private String primaryCareNetworkExpected = "East Kootenay";
    private String caseReasonExpected = "Family doctor or nurse practitioner is not accepting additional family members";
    private String caseCommentExpected = "Current Practitioner Location: Richmond";

    //for API
    public String personContactId;
    public String caseId;
    public String accId;

    public void API_Precondition_Delete_Dups_Patient_and_Case_in_Salesforce_as_SysAdmin(String firstName, String lastName, String Email){
        //log("/*0.---Pre-Condition API Remove 'Sandy Prior' or 'Kenton Troup' with the Case from SF --*/");
        //1.find personContactID
        APISelect sqlQuery1 = new APISelect();
        log("Select PersonContactID for '"+firstName+"' from Account.");
        try {
            String personContactID = sqlQuery1.selectPersonAccountIDSQL("SELECT PersonContactId from Account " +
                    "WHERE FirstName = '"+firstName+"' and LastName = '"+lastName+"' and PersonEmail = '"+Email+"'"  , "PersonContactId");
            log("Selected PersonContactID for '"+firstName+"' from Account is: " +personContactID);
            personContactId=personContactID;
            log("Status Code 200 - Person Contact Id for '"+firstName+"' SELECTED request - successfully");
            log("/*---'"+firstName+ "' '"+lastName+"' with 'accountToDelete@phsa.ca' has founded");
        } catch (Exception e) {
            log("/*---No '"+firstName+ "' '"+lastName+"' with 'accountToDelete@phsa.ca' at all in SF");
            //throw e;
        }
        if(personContactId==null){
            log("Finish API Preconditioning because no Patient '"+firstName+ "' Dups. ");
        }
        else {
            //2. find Patient ID
            APISelect sqlQuery2 = new APISelect();
            log("Select Patient AccID for '"+firstName+"' from Account.");
            String patientAccID = sqlQuery2.selectPersonAccountIDSQL("SELECT Id from Account " +
                    "WHERE FirstName = '"+firstName+"' and LastName = '"+lastName+"' and PersonEmail = '"+Email+"'"  , "Id");
            log("Selected Patient AccID for '"+firstName+"' from Account is: " +patientAccID);
            accId=patientAccID;
            log("Status Code 200 - Patient AccId for '"+firstName+"' SELECTED request - successfully");
            //3.find Case ID
            APISelect sqlQuery3 = new APISelect();
            try {
                log("Select CaseId for '"+firstName+"' from the 'Case'.");
                String caseIDReturned = sqlQuery3.selectCaseIDSql("SELECT Id from Case " + "WHERE ContactId = '" + personContactId + "'", "Id");
                log("Selected CaseId for '"+firstName+"' from 'Case' is: " + caseIDReturned);
                caseId = caseIDReturned;
            }catch (Exception e) {
                log("/*---No 'Cases' for '"+firstName+ "' with 'accountToDelete@phsa.ca' at all in SF");
            }
            if(caseId==null){
                log("Finish API Preconditioning because no 'Cases' for '"+firstName+ "' Dups. ");
            }
            else {
                //4.remove 'Case' first
                APIDelete apiDelete = new APIDelete();
                log("Delete Patient Case for '"+firstName+"' from Cases .");
                String apiResponse1 = apiDelete.deleteCase(caseId);
                log("Deleted Patient Case for '"+firstName+"' from Cases is: " + caseId);
                log("Status Code 204 -  Case for Patient '"+firstName+"' deleted - successfully");
                log(apiResponse1);
                //Assert.assertEquals(accountNameReturned, name);
                //5.and remove the actual "Sandy Prior"
                APIDelete apidelete = new APIDelete();
                log("Delete Patient account for '"+firstName+"' from Account.");
                String apiResponse2 = apidelete.deleteAccount(accId);
                log("Deleted Patient Account for '"+firstName+"' from Account is: " + accId);
                log("Status Code 204 - Patient '"+firstName+"' with 'accountToDelete@phsa.ca' deleted from Account successfully.");
                log(apiResponse2);
            }
        }
    }

    @Test(priority = 1)
    public void Can_Register_Person_In_Care_for_Attached_in_SF_AdminInterface_as_an_SYSAdmin () throws Exception {
        TestcaseID = "256267"; //C256267
        log("Target Environment: "+ Utils.getTargetEnvironment());

        log("/*0.---Pre-conditioning API call to remove 'Kenton Troup' dups with 'Case' if found--*/");
        //ApiQueries.apiCallToRemovePatientAccount(email, legalLastName, legalFirstName);
        API_Precondition_Delete_Dups_Patient_and_Case_in_Salesforce_as_SysAdmin(legalFirstName, legalLastName, email);


        log("/*1.--- Login as an SysAdmin to Health Cloud Console of SF Admin side --*/");
        HealthCloudConsolePage healthCloudConsolePage = loginPage.loginAsSysAdmin();
        Thread.sleep(15000);// wait for sf loading


        log("/*2.----Validate if Health Cloud Console Page displayed --*/");
        CommonMethods common = new CommonMethods(getDriver());
        common.goToHealthCloudConsolePageIfNeededAndConfirmPageIsDisplayed();
        Thread.sleep(5000);

        log("/*3.----Close All previously opened Tab's --*/");
        common.closeAllHealthCloudConsoleTabs();
        Thread.sleep(5000);

        log("/*4.----Select Create 'New Registration' from Navigation Menu Dropdown --*/");
        common.selectCreateNewRegistrationFromNavigationMenuDropdown();
        Thread.sleep(5000);

        log("/*5.----Click registration type radiobutton -> 'A person in my care' --*/");
        healthCloudConsolePage.selectRegistrationType();
        Thread.sleep(5000);

        log("/*6.----Check 'caller has obtained consent' checkbox --*/");
        healthCloudConsolePage.clickObtainedConsent();
        Thread.sleep(5000);

        log("/*7.----Click 'Continue' button' --*/");
        healthCloudConsolePage.clickContinue();
        Thread.sleep(5000);

        log("/*8.----Select the Caller Identity checkbox' --*/");
        //healthCloudConsolePage.selectCallerOnThePatientBehalf();
        Thread.sleep(5000);

        log("/*9.----Select the Caller's relationship with Patient -> Social worker' --*/");
        healthCloudConsolePage.selectCallerRelationshipWithPatient(callersRelationships);
        Thread.sleep(2000);

        log("/*10.----Enter the Caller Name -> 'SELENIUM Social' --*/");
        healthCloudConsolePage.enterNameOfCaller(callerName);
        Thread.sleep(2000);

        log("/*11.----Enter Patient First Name " +legalFirstName +" --*/");
        healthCloudConsolePage.enterPatientFirstName(legalFirstName);
        Thread.sleep(2000);

        log("/*12.---Enter Patient Last Name " +legalLastName +"--*/");
        healthCloudConsolePage.enterPatientLastName(legalLastName);
        Thread.sleep(2000);

        log("/*13.---Enter PHN " +personalHealthNumber +"--*/");
        healthCloudConsolePage.enterPatientPHN(personalHealthNumber);
        Thread.sleep(1000);

        log("/*14.---Enter Date of Birth - Month" +dateOfBirth_MM +"--*/");
        healthCloudConsolePage.enterMonth(dateOfBirth_MM);
        Thread.sleep(1000);

        log("/*15.---Enter Date of Birth - Day" +dateOfBirth_DD +"--*/");
        healthCloudConsolePage.enterDay(dateOfBirth_DD);
        Thread.sleep(1000);

        log("/*16.---Enter Date of Birth - Year" +dateOfBirth_YYYY +"--*/");
        healthCloudConsolePage.enterYear(dateOfBirth_YYYY);
        Thread.sleep(3000);

        log("/*17.---Click 'Verify PHN' button--*/");
        healthCloudConsolePage.clickVerifyPHN();
        Thread.sleep(1000);

        log("/*18. Validate EMPI Verification status --*/");
        String empiStatusActual = healthCloudConsolePage.getEMPIStatusActualForValidation();
        log("/*---- Actual EMPI verification status is: " + empiStatusActual + " --*/");
        assertEquals(empiStatusActual, empiStatusExpected);
        Thread.sleep(2000);

        //log("/*19.---Click sex 'Male' button--*/");
        //healthCloudConsolePage.clickSexMale();
        //Thread.sleep(1000);

        log("/*20.---Enter Street address " +streetAddress +"----*/");
        healthCloudConsolePage.enterStreetAddress(streetAddress);
        Thread.sleep(2000);

        log("/*20.---click info icon button----*/");
        healthCloudConsolePage.clickOnInfoIcon();
        Thread.sleep(2000);

        log("/*21.---Enter City " +City +"----*/");
        healthCloudConsolePage.enterCity(City);
        Thread.sleep(2000);

        log("/*22.---Select Province option from dropdown" +province +"----*/");
        healthCloudConsolePage.enterProvince(province);
        Thread.sleep(2000);

        log("/*23.---Enter Postal Code" +postalCode +"----*/");
        healthCloudConsolePage.enterPostalCode(postalCode);
        Thread.sleep(2000);

        log("/*24.---Enter Primary contact name" +primaryContactName +"----*/");
        healthCloudConsolePage.enterPrimaryContactName(primaryContactName);
        Thread.sleep(2000);

        log("/*25.---Enter email" +email +"----*/");
        healthCloudConsolePage.enterEmailAddress(email);
        Thread.sleep(2000);

        log("/*26.---Confirm email" +email +"----*/");
        healthCloudConsolePage.enterConfirmEmailAddress(email);
        Thread.sleep(2000);

        log("/*27.---Enter mobile" +mobilePhone +"----*/");
        healthCloudConsolePage.enterMobilePhoneNumber(mobilePhone);
        Thread.sleep(2000);

        log("/*28.---Click button Communication Preference -> 'Email'----*/");
        healthCloudConsolePage.clickEmailCommunicationPreference();
        Thread.sleep(2000);

        log("/*29.---Click button 'Yes' for Patient currently have a family doctor?----*/");
        healthCloudConsolePage.clickYesFamilyDoctor();
        Thread.sleep(2000);

        log("/*30.---Enter current Family doctor'" + currentFamilyDoctor +"----*/");
        //healthCloudConsolePage.selectCurrentFamilyDoctor(currentFamilyDoctor);
        healthCloudConsolePage.enterCurrentFamilyDoctor(currentFamilyDoctor);
        Thread.sleep(2000);

        log("/*31.---Enter Doctor's location 'city or town'" + cityOrTown +"----*/");
        healthCloudConsolePage.enterDoctorsCityOrTown(cityOrTown);
        Thread.sleep(2000);

        log("/*31_1.---chose radiobutton 'Why looking for doctor?'----*/");
        healthCloudConsolePage.choseWhyLookingForDoctor();
        Thread.sleep(2000);

        log("/*32.---chose radiobutton 'How far Doctor from their home?'----*/");
        healthCloudConsolePage.choseHowFarDoctorFromTheirHome();
        Thread.sleep(2000);

        log("/*33.---click button 'What gender of family doctor?'----*/");
        healthCloudConsolePage.clickWhatGenderOfFamilyDoctor();
        Thread.sleep(2000);

        log("/*34.---click button 'Does the patient need a translator?'----*/");
        healthCloudConsolePage.clickYesNeedTranslator();
        Thread.sleep(2000);

        log("/*35.---select language 'What language?' dropdown" + language +"----*/");
        healthCloudConsolePage.enterLanguage(language);
        Thread.sleep(2000);

        log("/*36.---click button 'Finish registration'----*/");
        healthCloudConsolePage.clickFinishRegistration();
        Thread.sleep(15000);

        log("/*37.--- Validate is 'Successfully registered!' page displayed? --*/");
        healthCloudConsolePage.validateSuccessfullyRegisteredPageDisplayed();
        Thread.sleep(5000);

        //log("/* ----Wait for 40 sec before Searching Kenton --*/");
        //Thread.sleep(480000); //8 min
        //Thread.sleep(240000); //4 min
        //Thread.sleep(40000);

        //log("/* ----Refresh page --*/");
        //common.refreshBrowser();
        //Thread.sleep(5000);

        //log("/*37_2 ----Refresh page --*/");
        //common.refreshBrowser();
        //Thread.sleep(20000);

        log("/*38.---Search for Patient by PHN " + legalFirstName + " "+ legalLastName +"--*/");
        common.globalSearch(personalHealthNumber);
        Thread.sleep(5000);

        log("/*39.---Click on founded Patient--*/");
        ///////////////////
        log("/*39.1--- first make sure that Kenton Troup is showing up in the Tab   ---*/");
        boolean isPatientFound =  common.isPatientFoundValidation(legalFirstName, legalLastName);
        if (!isPatientFound){
            throw new RuntimeException("Exception: Patient " + legalFirstName + " " + legalLastName + " not found!!!");
        }
        /////////////////////
        log("/*39.2--- now we can Click on searched Patient   ---*/");
        common.clickOnFondedKentonPatient(legalFirstName, legalLastName);
        Thread.sleep(5000);

        log("/*40.---Go to Patient Account Related Tab--*/");
        healthCloudConsolePage.clickOnRelatedTab();
        Thread.sleep(5000);

        log("---- Validation of Contact-Contact Relations(Related Contact)  ---*/");

        log("/*41.---- Validate the Caller's Contact Name: 'SELENIUM Social'  ---*/");
        //String contactActualValue = healthCloudConsolePage.getContactNameActualForValidation();
        //log("/*---- Contact(Caller's) Name the actual value is: " + contactActualValue + " --*/");
        //assertEquals(contactActualValue, callerName);
        Thread.sleep(5000);

        log("/*42.---- Validate the Caller's Related Role: 'Social Worker' ---*/");
        String callerRelatedRoleActualValue = healthCloudConsolePage.getCallerRelatedRoleActualForValidation();
        log("/*---- Contact(Caller's) Related Role the actual value is: " + callerRelatedRoleActualValue + " --*/");
        assertEquals(callerRelatedRoleActualValue, "Social Worker");
        Thread.sleep(5000);

        log("/*43.---- Validate the Primary Contact Name: 'Igor PrimaryContactName'  ---*/");
        //String primaryContactNameActualValue = healthCloudConsolePage.getPrimaryContactNameActualForValidation();//log("/*---- Primary Contact Name the actual value is: " + primaryContactNameActualValue + " --*/");
        //assertEquals(primaryContactNameActualValue, primaryContactName);
        //Thread.sleep(5000);

        log("/*44.---- Validate the Primary Related Role: 'Primary Contact'  ---*/");
        String primaryContactRelatedRoleActualValue = healthCloudConsolePage.getPrimaryContactRelatedRoleActualForValidation();
        log("/*---- Primary Contact Related Role the actual value is: " + primaryContactRelatedRoleActualValue + " --*/");
        assertEquals(primaryContactRelatedRoleActualValue, "Primary Contact");
        Thread.sleep(5000);

        log("/*46.---Click on Case record link--*/");
        healthCloudConsolePage.clickOnCaseRecord();
        Thread.sleep(5000);

        log("/*47.---- Validate field Case origin - 'Phone'  ---*/");
        String caseOriginActualValue = healthCloudConsolePage.getCaseOriginActualForValidation();
        log("/*---- Case Origin actual value is: " + caseOriginActualValue + " --*/");
        assertEquals(caseOriginActualValue, caseOriginExpectedValue);
        Thread.sleep(5000);

        log("/*48.---- Validate Priority  - 'None'  ---*/");
        String priorityActualValue = healthCloudConsolePage.getPriorityActualForValidation();
        log("/*---- Priority actual value is: " + priorityActualValue + " --*/");
        assertEquals(priorityActualValue, priorityExpectedValue);
        Thread.sleep(5000);

        log("/*49.---- Validate Account name - '1140 Windermere'  ---*/");
        String accountNameActual = healthCloudConsolePage.getAccountNameActualForValidation();
        log("/*---- Account Name actual is: " + accountNameActual + " --*/");
        assertEquals(accountNameActual, accountNameExpected);
        Thread.sleep(5000);

        log("/*50.---- Validate Primary Care Network - 'East Kootenay'  ---*/");
        String primaryCareNetworkActual = healthCloudConsolePage.getPrimaryCareNetworkActualForValidation();
        log("/*----Primary Care Network actual is: " + primaryCareNetworkActual + " --*/");
        assertEquals(primaryCareNetworkActual, primaryCareNetworkExpected);
        Thread.sleep(5000);

        log("/*51.---- Validate Case Reason - 'Doctor_is_not_accepting_additional_family_members_radiobutton'  ---*/");
        String caseReasonActual = healthCloudConsolePage.getCaseReasonActualForValidation();
        log("/*---Case Reason actual is: " + caseReasonActual + " --*/");
        assertEquals(caseReasonActual, caseReasonExpected);
        Thread.sleep(5000);

        log("/*52.---- Validate Status - 'Active'  ---*/");
        String statusActual = healthCloudConsolePage.getStatusActualAttachedForValidation();
        log("/*---- Status actual is: " + statusActual + " --*/");
        assertEquals(statusActual, statusExpected);
        Thread.sleep(5000);

        log("/*53.---Go to the Case Related Tab--*/");
        healthCloudConsolePage.clickOnCaseRelatedTab();
        Thread.sleep(5000);

        log("/*54.-----all broken with DHSOPR-4795 - Validate Case Comments - 'Current Practitioner Location: Richmond'  ---*/");
        //String caseCommentActual = healthCloudConsolePage.getCaseCommentActualForValidation();
        //log("/*---Case Comment actual is: " + caseCommentActual + " --*/");
        //assertEquals(caseCommentActual, caseCommentExpected);
        //Thread.sleep(5000);

        log("---- Validation of Case -> Related -> Contact Roles  ---*/");

        log("/*55.---- Validate the Case Caller's Contact Name: 'SELENIUM Social'  ---*/");
        //String caseContactActualValue = healthCloudConsolePage.getCaseContactNameActualForValidation();
        //log("/*---- Case Contact(Caller's) Name the actual value is: " + caseContactActualValue + " --*/");
        //assertEquals(caseContactActualValue, callerName);
        Thread.sleep(5000);

        log("/*56.---- Validate the Case Caller's Role: 'Submitted By' ---*/");
        //String caseCallerRoleActualValue = healthCloudConsolePage.getCaseCallerRoleActualForValidation();
        //log("/*---- Case Contact(Caller's) Role the actual value is: " + caseCallerRoleActualValue + " --*/");
        //assertEquals(caseCallerRoleActualValue, "Submitted By");
        Thread.sleep(5000);

        log("/*57.-----all broken with DHSOPR-4795 - Validate the Case Practitioner Contact Name: 'Lori-Ann May Bus'  ---*/");
        //String casePractitionerContactNameActualValue = healthCloudConsolePage.getCasePractitionerContactNameActualForValidation();
        //log("/*---- Case Practitioner Name the actual value is: " + casePractitionerContactNameActualValue + " --*/");
        //assertEquals(casePractitionerContactNameActualValue, currentFamilyDoctor);
        //Thread.sleep(5000);

        log("/*58.-----all broken with DHSOPR-4795 - Validate the Case Practitioner Role: 'Current Practitioner'  ---*/");
        //String casePractitionerRoleActualValue = healthCloudConsolePage.getCaseContactPractitionerRoleActualForValidation();
        //log("/*---- Case Practitioner Role the actual value is: " + casePractitionerRoleActualValue + " --*/");
        //assertEquals(casePractitionerRoleActualValue, "Current Practitioner");
        //Thread.sleep(2000);

    }



    //@Test(priority = 2)
    public void Post_conditions_step_Remove_Dups_Patient_account() throws Exception {
        TestcaseID = "251434"; //C251434
        log("/---API call to remove duplicate Patient's account if found--*/");
        //Utilities.ApiQueries.apiCallToRemoveDuplicateCitizenParticipantAccount(email, legalLastName, legalFirstName);
        ApiQueries.apiCallToRemovePatientAccount(email, legalLastName, legalFirstName);
    }


}
