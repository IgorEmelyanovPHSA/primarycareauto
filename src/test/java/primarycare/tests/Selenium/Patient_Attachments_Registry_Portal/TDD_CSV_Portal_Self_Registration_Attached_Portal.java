package primarycare.tests.Selenium.Patient_Attachments_Registry_Portal;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import primarycare.pages.CommonMethods;
import primarycare.pages.HealthCloudConsolePage;
import primarycare.tests.Utilities.ApiQueries;
import primarycare.tests.Utilities.TestListener;
import primarycare.pages.Utils;
import primarycare.tests.BaseTest_PrimaryCare;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import primarycare.pages.PortalHealthConnectRegistryPage;

import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

@Listeners({TestListener.class})
public class TDD_CSV_Portal_Self_Registration_Attached_Portal extends BaseTest_PrimaryCare{
    //for Self Registration Sandy Prior - Attached for 268 Languages

    private String legalFirstName = "Sandy";
    private String legalLastName = "Prior";
    private String personalHealthNumber = "9873010063";
    private String dateOfBirth_MM = "03";//March
    private String dateOfBirth_DD = "01";
    private String dateOfBirth_YYYY = "1975";
    private String streetAddress = "307-7631 Francis Rd";
    private String City = "Richmond";
    private String province = "BC";
    private String postalCode = "V6Y 1A3";
    private String email = "accountToDelete@phsa.ca";
    private String email_search_API = "accountToDelete@phsa.ca";
    private String mobilePhone = "7788797898";
    private String communicationPreference = "Email";

    //private String translationLanguageExpected = "Azerbaijani (Azeri - Torki)";

    @Test(priority = 1)
    public void Can_do_TDD_CSV_Self_Registration_Attached_in_Portal () throws Exception {
        //TestcaseID = "267921";
        log("/////////////////////////////////////////////////////////");
        log("TDD_CSV 268 Translate Languages do Myself Registration Unattached as Sandy Prior.");
        log("/////////////////////////////////////////////////////////");
        String DEFAULT_FOLDER_PATH = Paths.get(System.getProperty("user.dir"), "resources", "upload").toString();
        String[] csvCell;
        String csvFileName = "Languages.csv";

        CSVReader csvReader = new CSVReaderBuilder(new FileReader(DEFAULT_FOLDER_PATH + "/" + csvFileName)).withSkipLines(0).build();
        ArrayList<String> languagesListTotal = new ArrayList<String>();
        ArrayList<String> languagesListPass = new ArrayList<String>();
        ArrayList<String> languagesListFailed = new ArrayList<String>();

        while ((csvCell = csvReader.readNext()) != null) {
            String name = csvCell[0];
            languagesListTotal.add(name);
        }

        log("Total number of Languages to be processed in languageListTotal: " + languagesListTotal.size());

        int countFailed = 0;
        int countPass = 0;
        int totalCountArray = 0;

        for (int i = 0; i < languagesListTotal.size(); i++) {
            totalCountArray += 1;
            log("Language will be selected in Translation Language Drop Down testCase = " + languagesListTotal.get(i));
            try {
                Can_Do_Self_Registration_Attached_in_Portal(languagesListTotal.get(i));
                countPass += 1;
                languagesListPass.add(languagesListTotal.get(i));
            } catch (Exception ex) {
                countFailed += 1;
                languagesListFailed.add(languagesListTotal.get(i));
            }
            //Close Chrome window after each test
            driver.close();
            //Restart a clean Chrome window
            setUp();
        }

        log("Total number of names in TC: " + totalCountArray);
        log("Number of pass TC: " + countPass);
        log("Number of failed TC: " + countFailed);

        if (languagesListFailed.size() > 0) {
            log("List of Translation Languages when TC failed: ");
            for (int i = 0; i < languagesListFailed.size(); i++) {
                log("TC failed with name = " + languagesListFailed.get(i));
            }
        }
    }


    public void Can_Do_Self_Registration_Attached_in_Portal(String translationLanguageExpected) throws Exception{
        log("Target Environment: "+ Utils.getTargetEnvironment());

        log("/*01.---Pre-conditioning API call to remove duplicate Patient account (Sandy Prior) if found--*/");
        ApiQueries.apiCallToRemovePatientAccount(email_search_API, legalLastName, legalFirstName);

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

        log("/*23.---Click 'Yes' need a translator--*/");
        portalHealthConnectRegistryPage.clickYesNeedTranslatorRadiobutton();
        Thread.sleep(1000);

        log("/*23_1---select language 'What language?' dropdown" + translationLanguageExpected +"----*/");
        portalHealthConnectRegistryPage.enterTranslateLanguage(translationLanguageExpected);
        Thread.sleep(2000);

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
        log("TDD _csv Go to SF to find and Validate the Family Member - Sandy Prior.");
        log("/////////////////////////////////////////////////////////");

        log("/*27.--- Login as an SysAdmin to Health Cloud Console of SF Admin side --*/");
        HealthCloudConsolePage healthCloudConsolePage = loginPage.loginAsSysAdmin();
        Thread.sleep(15000);// wait for sf loading

        log("/*28.----Validate if Health Cloud Console Page displayed --*/");
        CommonMethods common = new CommonMethods(getDriver());
        common.goToHealthCloudConsolePageIfNeededAndConfirmPageIsDisplayed();
        Thread.sleep(5000);

        log("/*29.----Close All previously opened Tab's --*/");
        common.closeAllHealthCloudConsoleTabs();
        Thread.sleep(2000);

        log("/*30.----Select Home from Navigation Menu Dropdown --*/");
        common.selectHomeFromNavigationMenuDropdown();
        Thread.sleep(2000);

        log("/*31.---Search for Patient by PHN " + legalFirstName + " "+ legalLastName +"--*/");
        common.globalSearch(personalHealthNumber);
        Thread.sleep(2000);

        log("/*32.---Click on founded Patient--*/");
        ///////////////////
        log("/*33.1--- first make sure that Sandy Prior is showing up in the Tab   ---*/");
        boolean isPatientFound =  common.isPatientFoundValidation(legalFirstName, legalLastName);
        if (!isPatientFound){
            throw new RuntimeException("Exception: Patient " + legalFirstName + " " + legalLastName + " not found!!!");
        }
        /////////////////////
        log("/*33.2--- now we can Click on searched Patient   ---*/");
        common.clickOnFondedPatient(legalFirstName, legalLastName);
        Thread.sleep(5000);

        log("/*34.---Go to Related Tab--*/");
        healthCloudConsolePage.clickOnRelatedTab();
        Thread.sleep(5000);

        log("/*35.---Click on Case record link--*/");
        healthCloudConsolePage.clickOnCaseRecord();
        Thread.sleep(5000);

        log("/*38.---- Validate Language - 'Portuguese'  ---*/");
        String translationLanguageActual = healthCloudConsolePage.getTranslationLanguageForValidation();
        log("/*---- Translation Language actual is: " + translationLanguageActual + " --*/");
        assertEquals(translationLanguageActual, translationLanguageExpected);
        Thread.sleep(5000);
    }
}
