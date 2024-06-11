package primarycare.tests.Selenium.Patient_Attachments_Registry_Portal;

import primarycare.pages.CommonMethods;
import primarycare.pages.HealthCloudConsolePage;
import primarycare.tests.Utilities.ApiQueries;
import primarycare.tests.Utilities.TestListener;
import primarycare.pages.Utils;
import primarycare.tests.BaseTest_PrimaryCare;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import primarycare.pages.PortalHealthConnectRegistryPage;

import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class Portal_Family_Registration_Attached_Flow extends BaseTest_PrimaryCare{
    //for Self Registration Sandy Prior - Unattached
    private String legalFirstName = "Sandy";
    private String legalLastName = "Prior";
    private String personalHealthNumber = "9873010063";
    private String dateOfBirth_MM = "03";//March
    private String dateOfBirth_DD = "01";
    private String dateOfBirth_YYYY = "1975";
    private String streetAddress = "15409 92 Ave";//"11265 86 Ave";
    private String City = "Fleetwood";//""Delta";
    private String province = "BC";
    private String postalCode = "V3R 5V9";//"V4C 2W8";
    private String email = "igor.emelyanov@phsa.ca";//"accountToDelete@phsa.ca";
    private String email_search_API = "";//"accountToDelete@phsa.ca";
    private String mobilePhone = "7788797898";
    private String communicationPreference = "Email";

    //for registering Family member Hollis Violette - Attached
    private String familyMemberPersonsRelationShip = "My parent";
    private String familyMemberFirstName = "Hollis";
    private String familyMemberLastName = "Violette";
    private String familyMemberPHN = "9873009789";
    private String familyMemberDateOfBirth_MM = "04";//March
    private String familyMemberDateOfBirth_DD = "12";
    private String familyMemberDateOfBirth_YYYY = "1947";
    private String familyMemberStreetAddress = "15409 92 Ave";//"11265 86 Ave";
    private String familyMemberCity = "Fleetwood";//"Delta";
    private String familyMemberProvince = "BC";
    private String familyMembePpostalCode = "V3R 5V9";//"V4C 2W8";
    private String familyMemberEmail = "igor.emelyanov@phsa.ca";//"accountToDelete@phsa.ca";
    private String email_search_API_familyMemberEmail = "";//"accountToDelete@phsa.ca";
    private String familyMemberMobilePhone = "7788797898";
    private String familyMemberCommunicationPreference = "Email";
    private String caseOriginExpectedValue = "Web";
    private String priorityExpectedValue = "None";
    private String statusExpected = "Active";
    private String accountNameExpected = "2336 Fleetwood";//"2321 North Delta";
    private String primaryCareNetworkExpected = "Fleetwood";//"North Delta and West Newton";
    private String caseReasonExpected = "Family doctor or nurse practitioner is not accepting additional family members";
    private String caseCommentExpected = "Current Practitioner Location: Richmond";
    private String language = "Portuguese";
    //Contact-Contact Relations
    private String primaryContactName = "Sandy Prior";
    private String primaryContactRelationshipsRole = "Child"; //Sandy is the child of Hollis Violette
    private String familyMemberContactName = "Sandy Prior";
    //Case Contact Role - Current Practitioner
    private String currentFamilyDoctor = "Lori-Ann May Bus";
    private String currentFamilyDoctorCityOrTown = "Richmond";

    @Test(priority = 1)
    public void Can_do_Family_Member_Registration_Attached_in_Portal () throws Exception {
        TestcaseID = "267921"; //C267921
        log("/////////////////////////////////////////////////////////");
        log("First let's do Myself Registration Unattached as Sandy Prior.");
        log("/////////////////////////////////////////////////////////");

        log("Target Environment: "+ Utils.getTargetEnvironment());

        log("/*01.---Pre-conditioning API call to remove duplicate Patient account (Sandy Prior) if found--*/");
        ApiQueries.apiCallToRemovePatientAccount(email_search_API, legalLastName, legalFirstName);

        log("/*02.---Pre-conditioning API call to remove duplicate Family Member (Hollis Violette) account if found--*/");
        ApiQueries.apiCallToRemovePatientAccount(email_search_API_familyMemberEmail, familyMemberLastName, familyMemberFirstName);

        log("/*1.---Open Patient Registry Portal (Health Connect Registry site)--*/");
        PortalHealthConnectRegistryPage portalHealthConnectRegistryPage= loginPage.openPortalHealthConnectRegistryPage();
        Thread.sleep(15000);

        log("/*2.---- Validate that the Register to get doctor page has displayed --*/");
        PortalHealthConnectRegistryPage.validateRegisterToGetDoctorPageDisplayed();
        Thread.sleep(1000);

        log("/*3.---Click Next button--*/");
        portalHealthConnectRegistryPage.clickNextButton();
        Thread.sleep(1000);

        log("/*4.--- Validate that the Who is Registering page has displayed --*/");
        PortalHealthConnectRegistryPage.validateWhoIsRegisteringPageDisplayed();
        Thread.sleep(1000);

        log("/*5.---Click Register my household button--*/");
        portalHealthConnectRegistryPage.clickRegisterMyHouseholdButton();
        Thread.sleep(20000);

        log("/*6.---Enter First Name: " + legalFirstName +"--*/");
        portalHealthConnectRegistryPage.enterFirstName(legalFirstName);
        Thread.sleep(1000);

        log("/*7.---Enter Last Name: " + legalLastName +"--*/");
        portalHealthConnectRegistryPage.enterLastName(legalLastName);
        Thread.sleep(1000);

        log("/*8.---Enter PHN: " + personalHealthNumber +"--*/");
        portalHealthConnectRegistryPage.enterPHN(personalHealthNumber);
        Thread.sleep(1000);

        log("/*9.---Enter Date of Birth - Month: " + dateOfBirth_MM +"--*/");
        portalHealthConnectRegistryPage.enterMonth(dateOfBirth_MM);
        Thread.sleep(1000);

        log("/*10.---Enter Date of Birth - Day: " + dateOfBirth_DD +"--*/");
        portalHealthConnectRegistryPage.enterDay(dateOfBirth_DD);
        Thread.sleep(1000);

        log("/*11.---Enter Date of Birth - Year: " + dateOfBirth_YYYY +"--*/");
        portalHealthConnectRegistryPage.enterYear(dateOfBirth_YYYY);
        Thread.sleep(1000);

        log("/*12.---Click Continue--*/");
        portalHealthConnectRegistryPage.clickContinueButton();
        Thread.sleep(5000);

        log("/*13.---Enter Street address: " + streetAddress +"----*/");
        portalHealthConnectRegistryPage.enterStreetAddress(streetAddress);
        //Thread.sleep(1000);

        log("/*14.---Enter City: " + City +"----*/");
        portalHealthConnectRegistryPage.enterCity(City);
        Thread.sleep(1000);

        log("/*14_1.---Select Province option from dropdown: " + province +"----*/");
        portalHealthConnectRegistryPage.enterProvince(province);
        Thread.sleep(1000);

        log("/*15.---Enter Postal Code: " + postalCode +"----*/");
        portalHealthConnectRegistryPage.enterPostalCode(postalCode);
        Thread.sleep(1000);

        log("/*16.---Click Continue--*/");
        portalHealthConnectRegistryPage.clickContinueButton();
        Thread.sleep(1000);

        log("/*17.---Enter email: " + email +"----*/");
        portalHealthConnectRegistryPage.enterEmailAddress(email);
        Thread.sleep(1000);

        log("/*18.---Enter email: " + email +"----*/");
        portalHealthConnectRegistryPage.re_enterEmailAddress(email);
        Thread.sleep(1000);

        log("/*19.---Enter mobile: " + mobilePhone +"----*/");
        portalHealthConnectRegistryPage.enterMobilePhoneNumber(mobilePhone);
        Thread.sleep(1000);

        log("/*20.---Select Communication Preference - Email----*/");
        portalHealthConnectRegistryPage.selectCommunicationPreference();
        Thread.sleep(1000);

        log("/*21.---Click Continue--*/");
        portalHealthConnectRegistryPage.clickContinueButton();
        Thread.sleep(1000);

        log("/*22.---Click 'No' currently having family doctor--*/");
        portalHealthConnectRegistryPage.clickNoFamilyDoctorRadiobutton();
        Thread.sleep(1000);

        log("/*23.---Click 'No' need a translator--*/");
        portalHealthConnectRegistryPage.clickNoNeedTranslatorRadiobutton();
        Thread.sleep(1000);

        log("/*24---Click Continue--*/");
        portalHealthConnectRegistryPage.clickContinueButton();
        Thread.sleep(1000);

        //Health screen
        log("/*24.1---chose radiobutton 'Have you experienced any of the following new changes in your health in the last 3 months?'----*/");
        log("/*---chose 'I am pregnant or have recently given birth'----*/");
        portalHealthConnectRegistryPage.choseHealthChangesIn3Months();
        Thread.sleep(2000);

        log("/*24.2---chose radiobutton 'Have you had a new diagnosis of any of the following in the last 3 months?'----*/");
        log("/*---chose 'Seizures or Epilepsy'----*/");
        portalHealthConnectRegistryPage.choseNewDiagnosisIn3Months();
        Thread.sleep(2000);

        log("/*24.3---Click Continue--*/");
        portalHealthConnectRegistryPage.clickContinueButton();
        Thread.sleep(1000);

        log("/*25.---Click Submit registration --*/");
        portalHealthConnectRegistryPage.clickSubmitRegistrationButton();
        Thread.sleep(15000);

        log("/*26.--- Validate is 'Successfully registered!' page displayed? --*/");
        PortalHealthConnectRegistryPage.validateRegisterSuccessfulPageDisplayed();
        Thread.sleep(5000);

        log("/////////////////////////////////////////////////////////");
        log("The Actual Family Registration Attached for Hollis Violette.");
        log("/////////////////////////////////////////////////////////");

        log("/*27.---Click 'Add a family member' button --*/");
        portalHealthConnectRegistryPage.clickAddFamilyMemberButton();
        Thread.sleep(10000);

        log("/*28.---Select 'person's relationships to me' from dropdown: " + familyMemberPersonsRelationShip +"----*/");
        portalHealthConnectRegistryPage.selectPersonsRelationShip(familyMemberPersonsRelationShip);
        Thread.sleep(1000);

        log("/*29.---Enter Family Member First Name: " + familyMemberFirstName +"--*/");
        portalHealthConnectRegistryPage.enterFirstName(familyMemberFirstName);
        Thread.sleep(1000);

        log("/*30.---Enter Family Member Last Name: " + familyMemberLastName +"--*/");
        portalHealthConnectRegistryPage.enterLastName(familyMemberLastName);
        Thread.sleep(1000);

        log("/*31.---Enter Family Member PHN: " + familyMemberPHN +"--*/");
        portalHealthConnectRegistryPage.enterPHN(familyMemberPHN);
        Thread.sleep(1000);

        log("/*32.---Enter Family Member Date of Birth - Month: " + familyMemberDateOfBirth_MM +"--*/");
        portalHealthConnectRegistryPage.enterMonth(familyMemberDateOfBirth_MM);
        Thread.sleep(1000);

        log("/*33.---Enter Family Member Date of Birth - Day: " + familyMemberDateOfBirth_DD +"--*/");
        portalHealthConnectRegistryPage.enterDay(familyMemberDateOfBirth_DD);
        Thread.sleep(1000);

        log("/*34.---Enter Family Member Date of Birth - Year: " + familyMemberDateOfBirth_YYYY +"--*/");
        portalHealthConnectRegistryPage.enterYear(familyMemberDateOfBirth_YYYY);
        Thread.sleep(1000);

        log("/*35.---Click Continue on 'Add a Family member' screen--*/");
        portalHealthConnectRegistryPage.clickContinueButton();
        Thread.sleep(5000);

        log("/*36.---Click Continue on 'You are registering: Hollis Violette' screen--*/");
        portalHealthConnectRegistryPage.clickContinueButton();
        Thread.sleep(1000);

        //log("/*37.1---Enter email" +email +"----*/");
        //portalHealthConnectRegistryPage.enterFamilyMemberEmailAddress(familyMemberEmail);
        //Thread.sleep(1000);

        //log("/*37.2---Enter email" +email +"----*/");
        //portalHealthConnectRegistryPage.re_enterFamilyMemberEmailAddress(familyMemberEmail);
        //Thread.sleep(1000);

        log("/*37.3.---Enter mobile: " + familyMemberMobilePhone +"----*/");
        portalHealthConnectRegistryPage.enterFamilyMemberMobilePhoneNumber(familyMemberMobilePhone);
        Thread.sleep(1000);

        log("/*37.4.---Select Communication Preference - Email----*/");
        portalHealthConnectRegistryPage.selectFamilyMemberCommunicationPreference();
        Thread.sleep(1000);

        log("/*37.5---Click Continue on 'Primary Contact Information' screen--*/");
        portalHealthConnectRegistryPage.clickContinueButton();
        Thread.sleep(1000);

        log("/*38.---Click 'Yes' currently having family doctor--*/");
        portalHealthConnectRegistryPage.clickYesFamilyDoctorRadiobutton();
        Thread.sleep(1000);

        log("/*39.---Select current Family doctor'" + currentFamilyDoctor +"----*/");
        //portalHealthConnectRegistryPage.selectCurrentFamilyDoctor(currentFamilyDoctor);
        portalHealthConnectRegistryPage.enterFamilyDoctorName(currentFamilyDoctor);
        Thread.sleep(2000);

        log("/*40.---Enter Doctor's location 'city or town': " + currentFamilyDoctorCityOrTown +"----*/");
        portalHealthConnectRegistryPage.enterDoctorsCityOrTown(currentFamilyDoctorCityOrTown);
        Thread.sleep(2000);

        log("/*41.---chose radiobutton 'Why looking for doctor?'----*/");
        portalHealthConnectRegistryPage.choseWhyLookingForDoctor();
        Thread.sleep(2000);

        log("/*42.---Select 'How far Doctor from their home?' dropdown option----*/");
        portalHealthConnectRegistryPage.selectHowFarDoctorFromTheirHome();
        Thread.sleep(2000);

        log("/*43.---Select 'What gender of family doctor? dropdown option'----*/");
        portalHealthConnectRegistryPage.selectWhatGenderOfFamilyDoctor();
        Thread.sleep(2000);

        log("/*44.---Click 'Yes' need a translator--*/");
        portalHealthConnectRegistryPage.clickYesNeedTranslatorRadiobutton();
        Thread.sleep(1000);

        log("/*45---select language 'What language?' dropdown" + language +"----*/");
        portalHealthConnectRegistryPage.enterLanguage(language);
        Thread.sleep(2000);

        log("/*46---Click Continue--*/");
        portalHealthConnectRegistryPage.clickContinueButton();
        Thread.sleep(1000);

        //Health screen
        log("/*46.1---chose radiobutton 'Have you experienced any of the following new changes in your health in the last 3 months?'----*/");
        log("/*---chose 'I am pregnant or have recently given birth'----*/");
        portalHealthConnectRegistryPage.choseHealthChangesIn3Months();
        Thread.sleep(2000);

        log("/*46.2---chose radiobutton 'Have you had a new diagnosis of any of the following in the last 3 months?'----*/");
        log("/*---chose 'Seizures or Epilepsy'----*/");
        portalHealthConnectRegistryPage.choseNewDiagnosisIn3Months();
        Thread.sleep(2000);

        log("/*46.3---Click Continue--*/");
        portalHealthConnectRegistryPage.clickContinueButton();
        Thread.sleep(1000);

        log("/*47.---Click Family Member Submit registration --*/");
        portalHealthConnectRegistryPage.clickSubmitRegistrationButton();
        Thread.sleep(15000);

        log("/*48.--- Validate is Family Member 'Successfully registered!' page displayed? --*/");
        PortalHealthConnectRegistryPage.validateRegisterSuccessfulPageDisplayed();
        Thread.sleep(5000);

        log("/////////////////////////////////////////////////////////");
        log("Go to SF to find and Validate the Family Member - Hollis Violette.");
        log("/////////////////////////////////////////////////////////");

        log("/*49.--- Login as an SysAdmin to Health Cloud Console of SF Admin side --*/");
        HealthCloudConsolePage healthCloudConsolePage = loginPage.loginAsSysAdmin();
        Thread.sleep(15000);// wait for sf loading

        log("/*50.----Validate if Health Cloud Console Page displayed --*/");
        CommonMethods common = new CommonMethods(getDriver());
        common.goToHealthCloudConsolePageIfNeededAndConfirmPageIsDisplayed();
        Thread.sleep(5000);

        log("/*51.----Close All previously opened Tab's --*/");
        common.closeAllHealthCloudConsoleTabs();
        Thread.sleep(5000);

        log("/*52.----Select Home from Navigation Menu Dropdown --*/");
        common.selectHomeFromNavigationMenuDropdown();
        Thread.sleep(5000);

        //log("/* ----Wait for 30 sec before Searching the family member Hillis Violette --*/");
        //Thread.sleep(30000);

        //log("/* ----Refresh page --*/");
        //common.refreshBrowser();
        //Thread.sleep(5000);

        log("/*53.---Search for Patient by PHN " + familyMemberFirstName + " "+ familyMemberLastName +"--*/");
        common.globalSearch(familyMemberPHN);
        Thread.sleep(2000);

        log("/*54.---Click on founded Family Member Patient 'Hollis Violette'--*/");
        ///////////////////
        log("/*54.1--- first make sure that Hollis Violette is showing up in the Tab   ---*/");
        boolean isPatientFound =  common.isPatientFoundValidation(familyMemberFirstName, familyMemberLastName);
        if (!isPatientFound){
            throw new RuntimeException("Exception: Patient " + familyMemberFirstName + " " + familyMemberLastName + " not found!!!");
        }
        /////////////////////
        log("/*54.2--- now we can Click on searched Patient   ---*/");
        common.clickOnFondedHollisVioletteFamilyMember(familyMemberFirstName, familyMemberLastName);
        Thread.sleep(5000);

        log("/*55.---Go to Patient Account Related Tab--*/");
        healthCloudConsolePage.clickOnRelatedTab();
        Thread.sleep(5000);

        log("---- Validation of Contact-Contact Relations(Related Contact)  ---*/");

        log("/*56.---- Validate the Caller's Contact Name: 'Sandy Prior'  ---*/");
        String contactActualValue = healthCloudConsolePage.getContactNameSandyPriorActualForValidation();
        log("/*---- Contact(Caller's) Name the actual value is: " + contactActualValue + " --*/");
        assertEquals(contactActualValue, primaryContactName);
        Thread.sleep(5000);

        log("/*57.---- Validate the Caller's Related Role: 'Child' ---*/");
        String callerRelatedRoleActualValue = healthCloudConsolePage.getCallerRelatedRoleChildActualForValidation();
        log("/*---- Contact(Caller's) Related Role the actual value is: " + callerRelatedRoleActualValue + " --*/");
        assertEquals(callerRelatedRoleActualValue, primaryContactRelationshipsRole);
        Thread.sleep(5000);

        log("/*58.---- Validate the Primary Contact Name: 'Sandy Prior'  ---*/");
        String primaryContactNameActualValue = healthCloudConsolePage.getPrimaryContactNameSandyPriorActualForValidation();
        log("/*---- Primary Contact Name the actual value is: " + primaryContactNameActualValue + " --*/");
        assertEquals(primaryContactNameActualValue, primaryContactName);
        Thread.sleep(5000);

        log("/*59.---- Validate the Primary Related Role: 'Primary Contact'  ---*/");
        String primaryContactRelatedRoleActualValue = healthCloudConsolePage.getPrimaryContactRelatedRoleActualForValidation();
        log("/*---- Primary Contact Related Role the actual value is: " + primaryContactRelatedRoleActualValue + " --*/");
        assertEquals(primaryContactRelatedRoleActualValue, "Primary Contact");
        Thread.sleep(5000);

        log("/*60.---Click on Case record link--*/");
        healthCloudConsolePage.clickOnCaseRecord();
        Thread.sleep(5000);

        log("/*61.---- Validate field Case origin - 'Web'  ---*/");
        String caseOriginActualValue = healthCloudConsolePage.getCaseOriginActualForValidation();
        log("/*---- Case Origin actual value is: " + caseOriginActualValue + " --*/");
        assertEquals(caseOriginActualValue, caseOriginExpectedValue);
        Thread.sleep(5000);

        log("/*62.---- Validate Priority  - 'None'  ---*/");
        String priorityActualValue = healthCloudConsolePage.getPriorityActualForValidation();
        log("/*---- Priority actual value is: " + priorityActualValue + " --*/");
        assertEquals(priorityActualValue, priorityExpectedValue);
        Thread.sleep(5000);

        log("/*63.---- Validate Account name - '2336 Fleetwood'  ---*/");
        String accountNameActual = healthCloudConsolePage.getAccountNameActualForValidation();
        log("/*---- Account Name actual is: " + accountNameActual + " --*/");
        assertEquals(accountNameActual, accountNameExpected);
        Thread.sleep(5000);

        log("/*64.---- Validate Primary Care Network - 'Fleetwood'  ---*/");
        String primaryCareNetworkActual = healthCloudConsolePage.getPrimaryCareNetworkActualForValidation();
        log("/*----Primary Care Network actual is: " + primaryCareNetworkActual + " --*/");
        assertEquals(primaryCareNetworkActual, primaryCareNetworkExpected);
        Thread.sleep(5000);

        log("/*65.---- Validate Case Reason - 'Doctor_is_not_accepting_additional_family_members_radiobutton'  ---*/");
        String caseReasonActual = healthCloudConsolePage.getCaseReasonActualForValidation();
        log("/*---Case Reason actual is: " + caseReasonActual + " --*/");
        assertEquals(caseReasonActual, caseReasonExpected);
        Thread.sleep(5000);

        log("/*66.---- Validate Status - 'Active'  ---*/");
        String statusActual = healthCloudConsolePage.getStatusActualHillisVioletteAttachedForValidation();
        log("/*---- Status actual is: " + statusActual + " --*/");
        assertEquals(statusActual, statusExpected);
        Thread.sleep(5000);

        log("/*67.---Go to the Case Related Tab--*/");
        healthCloudConsolePage.clickOnCaseRelatedTab();
        Thread.sleep(5000);

        log("/*68.----all broken with DHSOPR-4795 - Validate Case Comments - 'Current Practitioner Location: Richmond'  ---*/");
        //String caseCommentActual = healthCloudConsolePage.getCaseCommentActualForValidation();
        //log("/*---Case Comment actual is: " + caseCommentActual + " --*/");
        //assertEquals(caseCommentActual, caseCommentExpected);
        //Thread.sleep(5000);

        log("----all  broken with DHSOPR-4795 - Validation of Case -> Related -> Contact Roles  ---*/");

        //log("/*69.---- Validate the Case Practitioner Contact Name: 'Lori-Ann May Bus'  ---*/");
        //String casePractitionerContactNameActualValue = healthCloudConsolePage.getCasePractitionerContactNameActualForValidation();
        //log("/*---- Case Practitioner Name the actual value is: " + casePractitionerContactNameActualValue + " --*/");
        //assertEquals(casePractitionerContactNameActualValue, currentFamilyDoctor);
        //Thread.sleep(5000);

        //log("/*70.---- Validate the Case Practitioner Role: 'Current Practitioner'  ---*/");
        //String casePractitionerRoleActualValue = healthCloudConsolePage.getCaseContactPractitionerRoleActualForValidation();
        //log("/*---- Case Practitioner Role the actual value is: " + casePractitionerRoleActualValue + " --*/");
        //assertEquals(casePractitionerRoleActualValue, "Current Practitioner");
        //Thread.sleep(2000);

    }

}
