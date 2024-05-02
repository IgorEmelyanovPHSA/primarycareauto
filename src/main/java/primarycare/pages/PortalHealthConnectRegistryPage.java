package primarycare.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PortalHealthConnectRegistryPage extends BasePage{

    /*---------Properties-------*/
    @FindBy(xpath = "//div/h1[text()='Register to get a family doctor or nurse practitioner']")
    private static WebElement register_to_get_doctor_page_validation;

    @FindBy(xpath = ".//span[text() = 'Next']")
    private WebElement next_button;
    private By next_button_1 = By.xpath(".//span[text() = 'Next']");

    @FindBy(xpath = "//div/h1[text()='Who is registering?']")
    private static WebElement who_is_registering_page_validation;

    @FindBy(xpath = ".//span[text() = 'Register myself or my family']")
    private WebElement register_my_household_button;
    private By register_my_household_button_1 = By.xpath(".//span[text() = 'Register myself or my family']");

    @FindBy(xpath = ".//omnistudio-omniscript-text[@data-omni-key='firstName']//input")
    private WebElement first_name;
    private By first_name1 = By.xpath("//omnistudio-omniscript-text[@data-omni-key='firstName']//input");

    @FindBy(xpath = ".//omnistudio-omniscript-text[@data-omni-key='lastName']//input")
    private WebElement last_name;
    private By last_name1 = By.xpath("//omnistudio-omniscript-text[@data-omni-key='lastName']//input");

    @FindBy(xpath = ".//omnistudio-omniscript-text[@data-omni-key='phn']//input")
    private WebElement phn;
    private By phn1 = By.xpath("//omnistudio-omniscript-text[@data-omni-key='phn']//input");

    @FindBy(xpath = ".//omnistudio-omniscript-text[@data-omni-key='Month']//input")
    private WebElement date_of_birth_MM;
    private By date_of_birth_MM1 = By.xpath("//omnistudio-omniscript-text[@data-omni-key='Month']//input");

    @FindBy(xpath = ".//omnistudio-omniscript-text[@data-omni-key='Day']//input")
    private WebElement date_of_birth_DD;
    private By date_of_birth_DD1 = By.xpath("//omnistudio-omniscript-text[@data-omni-key='Day']//input");

    @FindBy(xpath = ".//omnistudio-omniscript-text[@data-omni-key='Year']//input")
    private WebElement date_of_birth_YY;
    private By date_of_birth_YY1 = By.xpath("//omnistudio-omniscript-text[@data-omni-key='Year']//input");

    @FindBy(xpath = "(.//button[@aria-label='Continue'])[1]")
    private WebElement continue_button;
    private By continue_button_1 = By.xpath("(.//button[@aria-label='Continue'])[1]");

    @FindBy(xpath = ".//c-patient-reg-type-ahead[@data-omni-key='StreetAddress']//input[@class='slds-input']")
    private WebElement street_address;
    private By street_address_1 = By.xpath(".//c-patient-reg-type-ahead[@data-omni-key='StreetAddress']//input[@class='slds-input']");

    @FindBy(xpath = ".//omnistudio-omniscript-text[@data-omni-key='city']//input[@class='vlocity-input slds-input']")
    private WebElement city;
    private By city_1 = By.xpath(".//omnistudio-omniscript-text[@data-omni-key='city']//input[@class='vlocity-input slds-input']");

    @FindBy(xpath = ".//omnistudio-omniscript-select[@data-omni-key='province']//input")
    private WebElement province_dropdown_component;
    private By province_dropdown_component_1 = By.xpath(".//omnistudio-omniscript-select[@data-omni-key='province']//input");

    @FindBy(xpath = ".//span[text()='BC']")
    private WebElement province_optin_selection;
    private By province_option_selection_1 = By.xpath(".//span[text()='BC']");


    @FindBy(xpath = ".//omnistudio-omniscript-text[@data-omni-key='postalCodeForPatient']//input[@class='vlocity-input slds-input']")
    private WebElement postal_code;
    private By postal_code_1 = By.xpath(".//omnistudio-omniscript-text[@data-omni-key='postalCodeForPatient']//input[@class='vlocity-input slds-input']");

    @FindBy(xpath = "(.//input[@role='combobox'])[1]")
    private WebElement sex_dropdown;
    private By sex_dropdown_1 = By.xpath("(.//input[@role='combobox'])[2]");

    @FindBy(xpath = "(.//span[text() = 'Female'])[1]")
    private WebElement select_sex;
    private By select_sex_1 = By.xpath("(.//span[text() = 'Female'])[1]");

    @FindBy(xpath = "(.//input[@type='email'])[2]")
    private WebElement enter_email_address;
    private By enter_email_address_1 = By.xpath("(.//input[@type='email'])[2]");

    @FindBy(xpath = "(.//input[@type='email'])[4]")
    private WebElement re_enter_email_address;
    private By re_enter_email_address_1 = By.xpath("(.//input[@type='email'])[4]");

    @FindBy(xpath = "(.//input[@type='tel'])[1]")
    private WebElement mobile_phone;
    private By mobile_phone_1 = By.xpath("(.//input[@type='tel'])[1]");

    @FindBy(xpath = "(.//input[@role='combobox'])[1]")
    private WebElement communication_preference_dropdown;
    private By communication_preference_dropdown_1 = By.xpath("(.//input[@role='combobox'])[1]");

    @FindBy(xpath = "(.//span[text() = 'Email'])[1]")
    private WebElement select_communication_preference;
    private By select_communication_preference_1 = By.xpath("(.//span[text() = 'Email'])[1]");

    @FindBy(xpath = "(.//span[text() = 'No'])[1]")
    private WebElement no_family_doctor_radio;
    private By no_family_doctor_radio_1 = By.xpath("(.//span[text() = 'No'])[1]");

    @FindBy(xpath = "(.//span[text() = 'No'])[2]")
    private WebElement no_need_translator_radio;
    private By no_need_translator_radio_1 = By.xpath("(.//span[text() = 'No'])[2]");

    @FindBy(xpath = "(.//button[@aria-label = 'Submit registration'])[1]")
    private WebElement submit_registration_button;
    private By submit_registration_button_1 = By.xpath("(.//button[@aria-label = 'Submit registration'])[1]");

    @FindBy(xpath = "//h1[text()='Successfully registered!']") //Registration successful!
    private static WebElement registration_successful_page_validation;

    @FindBy(xpath = ".//span[text()='Add a family member']")
    private WebElement add_family_member_button;
    private By add_family_member_button_1 = By.xpath(".//span[text()='Add a family member']");

    @FindBy(xpath = ".//omnistudio-omniscript-select[@data-omni-key='relativeRole']//input")
    private WebElement relationships_to_me_dropdown_component;
    private By relationships_to_me_dropdown_component_1 = By.xpath(".//omnistudio-omniscript-select[@data-omni-key='relativeRole']//input");

    @FindBy(xpath = ".//span[text()='My parent']")
    private WebElement relationships_to_me_option_selection;
    private By relationships_to_me_option_selection_1 = By.xpath(".//span[text()='My parent']");

    @FindBy(xpath = "(.//span[text() = 'Yes'])[1]")
    private WebElement yes_family_doctor_radio;
    private By yes_family_doctor_radio_1 = By.xpath("(.//span[text() = 'Yes'])[1]");

    //@FindBy(xpath = "//omnistudio-omniscript-typeahead[@data-omni-key = 'searchPractitioner']")
    //private WebElement current_family_doctor_search_component;
    //private By current_family_doctor_search_component_1 = By.xpath("//omnistudio-omniscript-typeahead[@data-omni-key = 'searchPractitioner']");

    //@FindBy(xpath = "//span[text() ='Lori-Ann May Bus']")
    //private WebElement select_from_current_family_doctors_dropdown_list;
    //private By select_from_current_family_doctors_dropdown_list_1 = By.xpath("//span[text() ='Lori-Ann May Bus']");

    @FindBy(xpath = "(.//input[@placeholder])[1]")
    private WebElement family_doctor_name;
    private By family_doctor_name_1 = By.xpath("(.//input[@placeholder])[1]");

    @FindBy(xpath = "(.//input[@placeholder])[3]")
    private WebElement practitioner_location;
    private By practitioner_location_1 = By.xpath("(.//input[@placeholder])[3]");

    @FindBy(xpath = ".//span[text() ='Family doctor or nurse practitioner is not accepting additional family members']")
    private WebElement doctor_is_not_accepting_additional_family_members_radiobutton;
    private By doctor_is_not_accepting_additional_family_members_radiobutton_1 = By.xpath(".//span[text() ='Family doctor or nurse practitioner is not accepting additional family members']");

    @FindBy(xpath = "(.//input[@data-value = 'No preference'])[1]")
    private WebElement how_far_doctor_from_home_search_component;
    private By how_far_doctor_from_home_search_component_1 = By.xpath("(.//input[@data-value = 'No preference'])[1]");

    @FindBy(xpath = "//span[text()='Less than 5 km']")
    private WebElement select_les_than_5_km_dropdown_list_option;
    private By select_les_than_5_km_dropdown_list_option_1 = By.xpath("//span[text()='Less than 5 km']");

    @FindBy(xpath = "(.//input[@data-value = 'No preference'])[1]")
    private WebElement what_family_doctor_gender_search_component;
    private By what_family_doctor_gender_search_component_1 = By.xpath("(.//input[@data-value = 'No preference'])[1]");

    @FindBy(xpath = "//span[text()='Female']")
    private WebElement select_doctor_gender_dropdown_list_option;
    private By select_doctor_gender_dropdown_list_option_1 = By.xpath("//span[text()='Female']");

    @FindBy(xpath = "(.//span[text() = 'Yes'])[2]")
    private WebElement yes_need_translator_radio;
    private By yes_need_translator_radio_1 = By.xpath("(.//span[text() = 'Yes'])[2]");

    @FindBy(xpath = "(//div[@class = 'slds-combobox_container']//input[@class = 'slds-input'])[1]")
    private WebElement language_dropdown_component;
    private By language_dropdown_component_1 = By.xpath("(//div[@class = 'slds-combobox_container']//input[@class = 'slds-input'])[1]");

    @FindBy(xpath = "//span[text() ='Portuguese']")
    private WebElement select_from_language_dropdown_list;
    private By select_from_language_dropdown_list_1 = By.xpath("//span[text() ='Portuguese']");

    @FindBy(xpath = "(.//input[@type='email'])[3]")
    private WebElement enter_family_member_email_address;
    private By enter_family_member_email_address_1 = By.xpath("(.//input[@type='email'])[3]");

    @FindBy(xpath = "(.//input[@type='email'])[4]")
    private WebElement re_enter_family_member_email_address;
    private By re_enter_family_member_email_address_1 = By.xpath("(.//input[@type='email'])[4]");

    @FindBy(xpath = "(.//input[@type='tel'])[2]")
    private WebElement mobile_family_member_phone;
    private By mobile_family_member_phone_1 = By.xpath("(.//input[@type='tel'])[2]");

    @FindBy(xpath = "(.//input[@role='combobox'])[2]")
    private WebElement family_member_communication_preference_dropdown;
    private By family_member_communication_preference_dropdown_1 = By.xpath("(.//input[@role='combobox'])[2]");

    @FindBy(xpath = "(.//span[text() = 'Email'])[2]")
    private WebElement family_member_select_communication_preference;
    private By family_member_select_communication_preference_1 = By.xpath("(.//span[text() = 'Email'])[2]");

    @FindBy(xpath = ".//span[text() ='I am pregnant or have recently given birth']")
    private WebElement pregnancy_or_recent_birth_radiobutton;
    private By pregnancy_or_recent_birth_radiobutton_1 = By.xpath(".//span[text() ='I am pregnant or have recently given birth']");

    @FindBy(xpath = ".//span[text() ='Seizures or Epilepsy']")
    private WebElement seizures_or_epilepsy_radiobutton;
    private By seizures_or_epilepsy_radiobutton_1 = By.xpath(".//span[text() ='Seizures or Epilepsy']");

    @FindBy(xpath = "//h1[contains(text(),'You are registering')]")
    private WebElement click_some_where;
    private By click_some_where_1 = By.xpath("//h1[contains(text(),'You are registering')]");


    /*---------Constructor-------*/
    public PortalHealthConnectRegistryPage(WebDriver driver) {
        super(driver);
    }



    /*-------------Methods--------------*/
    public static boolean validateRegisterToGetDoctorPageDisplayed() throws InterruptedException {
        try {
            waitForElementToBeVisible(driver, register_to_get_doctor_page_validation, 10);
            log("/*---Home Register to get a doctor/nurse page - shown up");
        } catch (Exception e) {
            log("/*---Home Register to get a doctor/nurse page has NOT show up");
            throw e;
        }
        return false;
    }

    public void clickNextButton() throws InterruptedException {
        waitForElementToBeVisible(driver, next_button, 10);
        WebElement element = driver.findElement(next_button_1);
        next_button.click();
    }

    public static boolean validateWhoIsRegisteringPageDisplayed() throws InterruptedException {
        try {
            waitForElementToBeVisible(driver, who_is_registering_page_validation, 10);
            System.out.println("/*---Who is Registering page - shown up");
        } catch (NoSuchElementException e) {
            System.out.println("/*---Who is Registering page page has NOT show up");
            throw e;
        }
        return false;
    }

    public void clickRegisterMyHouseholdButton() throws InterruptedException {
        waitForElementToBeVisible(driver, register_my_household_button, 10);
        WebElement element = driver.findElement(register_my_household_button_1);
        register_my_household_button.click();
    }

    public void enterFirstName(String firstname) throws InterruptedException {
        waitForElementToBeLocated(driver, first_name1, 10);
        first_name.sendKeys(firstname);
    }

    public void enterLastName(String lastname) throws InterruptedException {
        waitForElementToBeLocated(driver, last_name1, 10);
        last_name.sendKeys(lastname);
    }

    public void enterPHN(String personalHealthNumber) throws InterruptedException {
        waitForElementToBeLocated(driver, phn1, 10);
        phn.sendKeys(personalHealthNumber);
    }

    public void enterMonth(String month) throws InterruptedException {
        waitForElementToBeLocated(driver, date_of_birth_MM1, 10);
        date_of_birth_MM.sendKeys(month);
    }

    public void enterDay(String day) throws InterruptedException {
        waitForElementToBeLocated(driver, date_of_birth_DD1, 10);
        date_of_birth_DD.sendKeys(day);
    }

    public void enterYear(String year) throws InterruptedException {
        waitForElementToBeLocated(driver, date_of_birth_YY1, 10);
        date_of_birth_YY.sendKeys(year);
        Thread.sleep(1000);
        date_of_birth_DD.click(); //just temporary to not clicking on Continue buttons two times.
        Thread.sleep(1000);
    }

    public void clickContinueButton() throws InterruptedException {
        waitForElementToBeVisible(driver, continue_button, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(continue_button_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(3000);
        continue_button.click();
    }

    public void enterStreetAddress(String streetAddress) throws InterruptedException {
        waitForElementToBeLocated(driver, street_address_1, 10);
        Thread.sleep(1000);
        street_address.sendKeys(streetAddress);
        Thread.sleep(2000);
        street_address.click();
        Thread.sleep(2000);
        //just click somewhere
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(click_some_where_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        waitForElementToBeLocated(driver, click_some_where_1, 10);// just to click somewhere
        click_some_where.click();
        waitForElementToBeLocated(driver, postal_code_1, 10);// just to click somewhere
        postal_code.click();
        Thread.sleep(2000);
    }

    public void enterCity(String City) throws InterruptedException {
        waitForElementToBeLocated(driver, city_1, 10);
        //city.sendKeys(City);
        city.click();
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.sendKeys(City).build().perform();
        Thread.sleep(1000);
    }

    public void enterProvince(String Province) throws InterruptedException {
        waitForElementToBeLocated(driver, province_dropdown_component_1, 10);
        Thread.sleep(1000);
        province_dropdown_component.click();
        Thread.sleep(1000);
        province_optin_selection.click();
        Thread.sleep(1000);
    }

    public void enterPostalCode(String postalCode) throws InterruptedException {
        waitForElementToBeLocated(driver, postal_code_1, 10);
        postal_code.click();
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].value  = 'V6Y 1A3';", postal_code);
        //postal_code.sendKeys(postalCode);
        Actions actions = new Actions(driver);
        actions.sendKeys(postalCode).build().perform();
        //actions.sendKeys(Keys.ENTER).build().perform();
        //Thread.sleep(1000);
    }

    public void selectSex() throws InterruptedException {
        waitForElementToBeLocated(driver, sex_dropdown_1, 10);
        sex_dropdown.click();
        waitForElementToBeVisible(driver, select_sex, 10);
        select_sex.click();
        Thread.sleep(1000);
    }

    public void enterEmailAddress(String email) throws InterruptedException {
        waitForElementToBeLocated(driver, enter_email_address_1, 10);
        enter_email_address.sendKeys(email);
    }
    public void re_enterEmailAddress(String email) throws InterruptedException {
        waitForElementToBeLocated(driver, re_enter_email_address_1, 10);
        re_enter_email_address.sendKeys(email);
    }

    public void enterMobilePhoneNumber(String mobile) throws InterruptedException {
        waitForElementToBeLocated(driver, mobile_phone_1, 10);
        mobile_phone.click();
        //mobile_phone.sendKeys(mobile);
        Actions actions = new Actions(driver);
        actions.sendKeys(mobile).build().perform();
        //Thread.sleep(1000);
    }

    public void selectCommunicationPreference() throws InterruptedException {
        waitForElementToBeLocated(driver, communication_preference_dropdown_1, 10);
        communication_preference_dropdown.click();
        waitForElementToBeVisible(driver, select_communication_preference, 10);
        select_communication_preference.click();
        Thread.sleep(1000);
    }

    public void clickNoFamilyDoctorRadiobutton() throws InterruptedException {
        waitForElementToBeVisible(driver, no_family_doctor_radio, 10);
        WebElement element = driver.findElement(no_family_doctor_radio_1);
        no_family_doctor_radio.click();
    }

    public void clickNoNeedTranslatorRadiobutton() throws InterruptedException {
        waitForElementToBeVisible(driver, no_need_translator_radio, 10);
        WebElement element = driver.findElement(no_need_translator_radio_1);
        no_need_translator_radio.click();
    }

    public void clickSubmitRegistrationButton() throws InterruptedException {
        waitForElementToBeVisible(driver, submit_registration_button, 10);
        WebElement element = driver.findElement(submit_registration_button_1);
        submit_registration_button.click();
    }

    public static boolean validateRegisterSuccessfulPageDisplayed() throws InterruptedException {
        try {
            waitForElementToBeVisible(driver, registration_successful_page_validation, 10);
            System.out.println("/*---Registration successful page - shown up");
        } catch (NoSuchElementException e) {
            System.out.println("/*---Registration successful page page has NOT show up");
            throw e;
        }
        return false;
    }

    public void clickAddFamilyMemberButton() throws InterruptedException {
        waitForElementToBeVisible(driver, add_family_member_button, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(add_family_member_button_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(3000);
        add_family_member_button.click();
    }

    public void selectPersonsRelationShip(String Province) throws InterruptedException {
        waitForElementToBeLocated(driver, relationships_to_me_dropdown_component_1, 10);
        Thread.sleep(1000);
        log("/*----scroll down a bit --*/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);
        relationships_to_me_dropdown_component.click();
        Thread.sleep(2000);
        //log("/*----jump to component --*/");
        //WebElement element = driver.findElement(relationships_to_me_option_selection_1);
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        //Thread.sleep(2000);
        relationships_to_me_option_selection.click();
        Thread.sleep(1000);
    }

    public void clickYesFamilyDoctorRadiobutton() throws InterruptedException {
        waitForElementToBeVisible(driver, yes_family_doctor_radio, 10);
        yes_family_doctor_radio.click();
    }

    //public void selectCurrentFamilyDoctor(String currentPractitioner) throws InterruptedException {
        //waitForElementToBeLocated(driver, current_family_doctor_search_component_1, 10);
        //Thread.sleep(1000);
        //log("/*----scroll down a bit --*/");
        //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
        //Thread.sleep(2000);
        //current_family_doctor_search_component.sendKeys(currentPractitioner);
        //Thread.sleep(5000);
        //select_from_current_family_doctors_dropdown_list.click();
        //Thread.sleep(1000);
    //}

    public void enterFamilyDoctorName(String cityOrTown) throws InterruptedException {
        waitForElementToBeLocated(driver, family_doctor_name_1, 10);
        Thread.sleep(1000);
        log("/*----scroll down a bit --*/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
        Thread.sleep(2000);
        family_doctor_name.sendKeys(cityOrTown);
    }

    public void enterDoctorsCityOrTown(String cityOrTown) throws InterruptedException {
        waitForElementToBeLocated(driver, practitioner_location_1, 10);
        Thread.sleep(1000);
        log("/*----scroll down a bit --*/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);
        practitioner_location.sendKeys(cityOrTown);
    }

    public void choseWhyLookingForDoctor() throws InterruptedException {
        waitForElementToBeLocated(driver, doctor_is_not_accepting_additional_family_members_radiobutton_1, 10);
        Thread.sleep(1000);
        doctor_is_not_accepting_additional_family_members_radiobutton.click();
    }

    public void selectHowFarDoctorFromTheirHome() throws InterruptedException {
        waitForElementToBeLocated(driver, how_far_doctor_from_home_search_component_1, 10);
        Thread.sleep(1000);
        log("/*----scroll down a bit --*/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,350)");
        Thread.sleep(2000);
        how_far_doctor_from_home_search_component.click();
        Thread.sleep(5000);
        select_les_than_5_km_dropdown_list_option.click();
        Thread.sleep(1000);
    }

    public void selectWhatGenderOfFamilyDoctor() throws InterruptedException {
        waitForElementToBeLocated(driver, how_far_doctor_from_home_search_component_1, 10);
        Thread.sleep(1000);
        how_far_doctor_from_home_search_component.click();
        Thread.sleep(5000);
        select_doctor_gender_dropdown_list_option.click();
        Thread.sleep(1000);
    }

    public void clickYesNeedTranslatorRadiobutton() throws InterruptedException {
        waitForElementToBeVisible(driver, yes_need_translator_radio, 10);
        yes_need_translator_radio.click();
    }

    public void enterLanguage(String Language) throws InterruptedException {
        waitForElementToBeLocated(driver, language_dropdown_component_1, 10);
        language_dropdown_component.click();
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Language).build().perform();
        Thread.sleep(5000);
        select_from_language_dropdown_list.isDisplayed();
        Thread.sleep(5000);
        //JavascriptExecutor executor = (JavascriptExecutor) driver;
        //executor.executeScript("arguments[0].click();", element);
        select_from_language_dropdown_list.click();
        Thread.sleep(1000);
    }

    public void enterFamilyMemberEmailAddress(String email) throws InterruptedException {
        waitForElementToBeLocated(driver, enter_family_member_email_address_1, 10);
        enter_family_member_email_address.sendKeys(email);
    }

    public void re_enterFamilyMemberEmailAddress(String email) throws InterruptedException {
        waitForElementToBeLocated(driver, re_enter_family_member_email_address_1, 10);
        re_enter_family_member_email_address.sendKeys(email);
    }

    public void enterFamilyMemberMobilePhoneNumber(String mobile) throws InterruptedException {
        waitForElementToBeLocated(driver, mobile_family_member_phone_1, 10);
        mobile_family_member_phone.click();
        //mobile_phone.sendKeys(mobile);
        Actions actions = new Actions(driver);
        actions.sendKeys(mobile).build().perform();
        //Thread.sleep(1000);
    }

    public void selectFamilyMemberCommunicationPreference() throws InterruptedException {
        waitForElementToBeLocated(driver, family_member_communication_preference_dropdown_1, 10);
        family_member_communication_preference_dropdown.click();
        waitForElementToBeVisible(driver, family_member_select_communication_preference, 10);
        family_member_select_communication_preference.click();
        Thread.sleep(1000);
    }

    public void choseHealthChangesIn3Months() throws InterruptedException {
        waitForElementToBeLocated(driver, pregnancy_or_recent_birth_radiobutton_1, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(pregnancy_or_recent_birth_radiobutton_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        log("/*----scroll up a bit --*/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)");
        Thread.sleep(2000);
        pregnancy_or_recent_birth_radiobutton.click();
    }

    public void choseNewDiagnosisIn3Months() throws InterruptedException {
        waitForElementToBeLocated(driver, seizures_or_epilepsy_radiobutton_1, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(seizures_or_epilepsy_radiobutton_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        seizures_or_epilepsy_radiobutton.click();
    }

}
