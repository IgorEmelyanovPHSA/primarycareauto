package primarycare.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import primarycare.pages.BasePage;

public class HealthCloudConsolePage extends BasePage {

    /*---------Properties-------*/
    @FindBy(xpath = ".//a[text() = 'Related']")
    private WebElement patient_account_Related_tab;
    private By patient_account_Related_tab_1 = By.xpath(".//a[text() = 'Related']");

    @FindBy(xpath = "(.//a[text() = 'Related'])[2]")
    private WebElement case_Related_tab;
    private By case_Related_tab_1 = By.xpath("(.//a[text() = 'Related'])[2]");


    @FindBy(xpath = ".//a[@title='Individual Attachment Request']")
    private WebElement case_record;
    private By case_record_1 = By.xpath(".//a[@title='Individual Attachment Request']");

    @FindBy(xpath = ".//flexipage-field[@data-field-id='RecordOriginField']//slot[1]//slot[1]/lightning-formatted-text")
    private WebElement case_origin_actual_field_value;
    private By case_origin_actual_field_value_1 = By.xpath(".//flexipage-field[@data-field-id='RecordOriginField']//slot[1]//slot[1]/lightning-formatted-text");

    @FindBy(xpath = ".//flexipage-field[@data-field-id='RecordPriorityField']//slot[1]//slot[1]/lightning-formatted-text")
    private WebElement priority_actual_field_value;
    private By priority_actual_field_value_1 = By.xpath(".//flexipage-field[@data-field-id='RecordPriorityField']//slot[1]//slot[1]/lightning-formatted-text");

    @FindBy(xpath = ".//flexipage-field[@data-field-id='RecordStatusField']//slot[1]//slot[1]/lightning-formatted-text")
    private WebElement status_actual_field_value;
    private By status_actual_field_value_1 = By.xpath(".//flexipage-field[@data-field-id='RecordStatusField']//slot[1]//slot[1]/lightning-formatted-text");

    @FindBy(xpath = ".//flexipage-field[@data-field-id='RecordAccountIdField']//slot[1]//slot[1]//slot[1]//span[text()]")
    private WebElement account_name_actual_field_value;
    private By account_name_actual_field_value_1 = By.xpath(".//flexipage-field[@data-field-id='RecordAccountIdField']//slot[1]//slot[1]//slot[1]//span[text()]");

    @FindBy(xpath = ".//flexipage-field[@data-field-id='RecordReasonField']//slot[1]//slot[1]/lightning-formatted-text")
    private WebElement case_reason_actual_field_value;
    private By case_reason_actual_field_value_1 = By.xpath(".//flexipage-field[@data-field-id='RecordReasonField']//slot[1]//slot[1]/lightning-formatted-text");

    @FindBy(xpath = "(//span[text() ='Sandy Prior'])[3]")
    private WebElement contact_name_actual_field_value;
    private By contact_name_actual_field_value_1 = By.xpath("(//span[text() ='Sandy Prior'])[3]");

    @FindBy(xpath = "(//span[text() ='Kenton Troup'])[3]")
    private WebElement contact_name_Attached_actual_field_value;
    private By contact_name_Attached_actual_field_value_1 = By.xpath("(//span[text() ='Kenton Troup'])[3]");

    @FindBy(xpath = "(.//lightning-formatted-text[text() ='Less than 5 km'])")
    private WebElement distance_able_to_travel_Attached_actual_value;
    private By distance_able_to_travel_Attached_actual_value_1 = By.xpath("(.//lightning-formatted-text[text() ='Less than 5 km'])");

    @FindBy(xpath = "//span[text() ='Richmond - East']")
    private WebElement primary_care_network_actual_field_value;
    private By primary_care_network_actual_field_value_1 = By.xpath("//span[text() ='Richmond - East']");

    @FindBy(xpath = "//span[text() ='A person in my care']")
    private WebElement person_in_my_care_radiobutton;
    private By person_in_my_care_radiobutton_1 = By.xpath("//span[text() ='A person in my care']");

    @FindBy(xpath = "(//span[text()='Continue'])[1]")
    private WebElement continue_button;
    private By continue_button_1 = By.xpath("(//span[text()='Continue'])[1]");

    @FindBy(xpath = "//span[contains(text(),'The caller is registering on the patient')]")
    private WebElement caller_registering_patients_behalf_checkbox;
    private By caller_registering_patients_behalf_checkbox_1 = By.xpath("//span[contains(text(),'The caller is registering on the patient')]");

    @FindBy(xpath = "(//input[@class = 'slds-input slds-listbox__option-text_entity'])[1]")
    private WebElement caller_relationship_dropdown;
    private By caller_relationship_dropdown_1 = By.xpath("(//input[@class = 'slds-input slds-listbox__option-text_entity'])[1]");

    @FindBy(xpath = "//span[text() ='Social worker']")
    private WebElement select_caller_relationship;
    private By select_caller_relationship_1 = By.xpath("//span[text() ='Social worker']");

    @FindBy(xpath = "(//span[@class = 'slds-checkbox_faux'])[1]")
    private WebElement caller_obtained_consent_checkbox;
    private By caller_obtained_consent_checkbox_1 = By.xpath("(//span[@class = 'slds-checkbox_faux'])[1]");

    @FindBy(xpath = "//input[@placeholder = 'First and last name']")
    private WebElement caller_name;
    private By caller_name_1 = By.xpath("//input[@placeholder = 'First and last name']");

    @FindBy(xpath = "(//input[@placeholder = 'Must match provincial health records'])[1]")
    private WebElement patient_first_name;
    private By patient_first_name_1 = By.xpath("(//input[@placeholder = 'Must match provincial health records'])[1]");

    @FindBy(xpath = "(//input[@placeholder = 'Must match provincial health records'])[2]")
    private WebElement patient_last_name;
    private By patient_last_name_1 = By.xpath("(//input[@placeholder = 'Must match provincial health records'])[2]");

    @FindBy(xpath = "(//input[@omnistudio-maskedinput_maskedinput_slds])[1]")
    private WebElement patient_phn;
    private By patient_phn_1 = By.xpath("(//input[@omnistudio-maskedinput_maskedinput_slds])[1]");

    @FindBy(xpath = "//input[@placeholder = 'MM']")
    private WebElement patient_date_of_birth_MM;
    private By patient_date_of_birth_MM_1 = By.xpath("//input[@placeholder = 'MM']");

    @FindBy(xpath = "//input[@placeholder = 'DD']")
    private WebElement patient_date_of_birth_DD;
    private By patient_date_of_birth_DD_1 = By.xpath("//input[@placeholder = 'DD']");

    @FindBy(xpath = "//input[@placeholder = 'YYYY']")
    private WebElement patient_date_of_birth_YYYY;
    private By patient_date_of_birth_YYYY_1 = By.xpath("//input[@placeholder = 'YYYY']");

    @FindBy(xpath = "//span[text() ='Verify EMPI']")
    private WebElement verify_EMPI_button;
    private By verify_EMPI_button_1 = By.xpath("//span[text() ='Verify EMPI']");

    @FindBy(xpath = "(//omnistudio-omniscript-messaging//p[text()])[2]")
    private WebElement empi_actual_verification_status;
    private By empi_actual_verification_status_1 = By.xpath("(//omnistudio-omniscript-messaging//p[text()])[2]");

    @FindBy(xpath = "(//span[text() ='Male'])[1]")
    private WebElement sex_male_button;
    private By sex_male_button_1 = By.xpath("(//span[text() ='Male'])[1]");

    @FindBy(xpath = ".//c-patient-reg-type-ahead[@data-omni-key='streetAddress']//input[@class='slds-input']")
    private WebElement street_address;
    private By street_address_1 = By.xpath(".//c-patient-reg-type-ahead[@data-omni-key='streetAddress']//input[@class='slds-input']");

    @FindBy(xpath = "//button[@class = 'vlocity-btn slds-button slds-button_icon']")
    private WebElement info_icon;
    private By info_icon_1 = By.xpath("//button[@class = 'vlocity-btn slds-button slds-button_icon']");


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

    @FindBy(xpath = "//input[@placeholder = 'Enter first and last name']")
    private WebElement primary_contact_name;
    private By primary_contact_name_1 = By.xpath("//input[@placeholder = 'Enter first and last name']");

    @FindBy(xpath = "(.//input[@type='email'])[1]")
    private WebElement enter_email_address;
    private By enter_email_address_1 = By.xpath("(.//input[@type='email'])[1]");

    @FindBy(xpath = "(.//input[@type='email'])[2]")
    private WebElement enter_confirm_email_address;
    private By enter_confirm_email_address_1 = By.xpath("(.//input[@type='email'])[2]");

    @FindBy(xpath = "(.//input[@type='tel'])[1]")
    private WebElement mobile_phone;
    private By mobile_phone_1 = By.xpath("(.//input[@type='tel'])[1]");

    @FindBy(xpath = "//span[text() ='Email']")
    private WebElement communicarion_preference_Email_button;
    private By communicarion_preference_Email_button_1 = By.xpath("//span[text() ='Email']");

    @FindBy(xpath = "(//span[text() ='Yes'])[1]")
    private WebElement currently_Yes_family_doctor_button;
    private By currently_Yes_family_doctor_button_1 = By.xpath("(//span[text() ='Yes'])[1]");

    //@FindBy(xpath = "//omnistudio-omniscript-typeahead[@data-omni-key = 'searchPractitioner']")
    //private WebElement current_family_doctor_search_component;
    //private By current_family_doctor_search_component_1 = By.xpath("//omnistudio-omniscript-typeahead[@data-omni-key = 'searchPractitioner']");

    //@FindBy(xpath = "//span[text() ='Lori-Ann May Bus']")
    //private WebElement select_from_current_family_doctors_dropdown_list;
    //private By select_from_current_family_doctors_dropdown_list_1 = By.xpath("//span[text() ='Lori-Ann May Bus']");

    @FindBy(xpath = "(.//input[@placeholder =''])[5]")
    private WebElement current_family_doctor_name;
    private By current_family_doctor_name_1 = By.xpath("(.//input[@placeholder =''])[5]");

    @FindBy(xpath = ".//input[@placeholder ='Enter city or town']")
    private WebElement practitioner_location;
    private By practitioner_location_1 = By.xpath(".//input[@placeholder ='Enter city or town']");

    @FindBy(xpath = ".//span[text() ='Family doctor or nurse practitioner is not accepting additional family members']")
    private WebElement doctor_is_not_accepting_additional_family_members_radiobutton;
    private By doctor_is_not_accepting_additional_family_members_radiobutton_1 = By.xpath(".//span[text() ='Family doctor or nurse practitioner is not accepting additional family members']");

    @FindBy(xpath = "//span[text() ='Less than 5 km']")
    private WebElement less_than_5km_radiobutton;
    private By less_than_5km_radiobutton_1 = By.xpath("//span[text() ='Less than 5 km']");


    @FindBy(xpath = "(//span[text() ='Female'])[1]")
    private WebElement gender_of_family_doctor_button;
    private By gender_of_family_doctor_button_1 = By.xpath("(//span[text() ='Female'])[1]");

    @FindBy(xpath = "(//span[text() ='Yes'])[2]")
    private WebElement need_translator_button;
    private By need_translator_button_1 = By.xpath("(//span[text() ='Yes'])[2]");

    @FindBy(xpath = "(//div[@class = 'slds-combobox_container']//input[@class = 'slds-input'])[2]")
    private WebElement language_dropdown_component;
    private By language_dropdown_component_1 = By.xpath("(//div[@class = 'slds-combobox_container']//input[@class = 'slds-input'])[2]");

    @FindBy(xpath = "//span[text() ='French']")
    private WebElement select_from_language_dropdown_list;
    private By select_from_language_dropdown_list_1 = By.xpath("//span[text() ='French']");

    @FindBy(xpath = "(//span[text() ='Finish registration'])[1]")
    private WebElement finish_registration_button;
    private By finish_registration_button_1 = By.xpath("(//span[text() ='Finish registration'])[1]");

    @FindBy(xpath = ".//div/p[text() = 'Successfully registered!']")
    private static WebElement successfully_registered_page_validation;

    @FindBy(xpath = "//span[text() ='SELENIUM Social']")
    private WebElement caller_name_actual_field_value;
    private By caller_name_actual_field_value_1 = By.xpath("//span[text() ='SELENIUM Social']");

    @FindBy(xpath = "(//span[text() ='SELENIUM Social'])[2]")
    private WebElement case_caller_name_actual_field_value;
    private By case_caller_name_actual_field_value_1 = By.xpath("(//span[text() ='SELENIUM Social'])[2]");


    @FindBy(xpath = "//span[text() ='Igor PrimaryContactName']")
    private WebElement primary_contact_name_actual_field_value;
    private By primary_contact_name_actual_field_value_1 = By.xpath("//span[text() ='Igor PrimaryContactName']");

    @FindBy(xpath = "//span[text() ='Lori-Ann May Bus']")
    private WebElement case_practitioner_contact_name_actual_field_value;
    private By case_practitioner_contact_name_actual_field_value_1 = By.xpath("//span[text() ='Lori-Ann May Bus']");

    @FindBy(xpath = ".//a[@title = 'Social Worker']")
    private WebElement caller_related_role_actual_field_value;
    private By caller_related_role_actual_field_value_1 = By.xpath(".//a[@title = 'Social Worker']");

    @FindBy(xpath = "//span[@title='Submitted By']")
    private WebElement case_caller_role_actual_field_value;
    private By case_caller_role_actual_field_value_1 = By.xpath("//span[@title='Submitted By']");

    @FindBy(xpath = ".//a[@title ='Primary Contact']")
    private WebElement primary_contact_related_role_actual_field_value;
    private By primary_contact_related_role_actual_field_value_1 = By.xpath(".//a[@title ='Primary Contact']");

    @FindBy(xpath = ".//lst-formatted-text[text() ='Current Practitioner']")
    private WebElement case_contact_practitioner_role_actual_field_value;
    private By case_contact_practitioner_role_actual_field_value_1 = By.xpath(".//lst-formatted-text[text() ='Current Practitioner']");

    @FindBy(xpath = "//span[text() ='Current Practitioner Location: Richmond']")
    private WebElement case_comment_actual_field_value;
    private By case_comment_actual_field_value_1 = By.xpath("//span[text() ='Current Practitioner Location: Richmond']");

    //@FindBy(xpath = "(//span[text() ='Sandy Prior'])[2]")
    @FindBy(xpath = "//span[text() ='Sandy Prior']")
    private WebElement caller_name_Sandy_Prior_2_actual_field_value;
    private By caller_name_Sandy_Prior_2_actual_field_value_1 = By.xpath("//span[text() ='Sandy Prior']");

    @FindBy(xpath = ".//a[@title = 'Child']")
    private WebElement caller_related_role_Child_actual_field_value;
    private By caller_related_role_Child_actual_field_value_1 = By.xpath(".//a[@title = 'Child']");

    @FindBy(xpath = "(//span[text() ='Sandy Prior'])[1]")
    private WebElement primary_contact_name_Sandy_Prior_1_actual_field_value;
    private By primary_contact_name_Sandy_Prior_1_actual_field_value_1 = By.xpath("(//span[text() ='Sandy Prior'])[1]");

    @FindBy(xpath = "(//span[text() ='Hollis Violette'])[3]")
    private WebElement contact_name_Attached_Hollis_Violette_actual_field_value;
    private By contact_name_Attached_actual_Hollis_Violette_field_value_1 = By.xpath("(//span[text() ='Hollis Violette'])[3]");

    @FindBy(xpath = ".//span[text() ='Pregnancy or recent birth']")
    private WebElement pregnancy_or_recent_birth_radiobutton;
    private By pregnancy_or_recent_birth_radiobutton_1 = By.xpath(".//span[text() ='Pregnancy or recent birth']");

    @FindBy(xpath = ".//span[text() ='Irregular heartbeat']")
    private WebElement irregular_heartbeat_radiobutton;
    private By irregular_heartbeat_radiobutton_1 = By.xpath(".//span[text() ='Irregular heartbeat']");


    /*---------Constructor-------*/
    public HealthCloudConsolePage(WebDriver driver) {
        super(driver);
    }



    /*-------------Methods--------------*/
    public void clickOnRelatedTab() throws InterruptedException {
        WebElement element = driver.findElement(patient_account_Related_tab_1);
        Thread.sleep(2000);
        isDisplayed(patient_account_Related_tab_1);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clickOnCaseRelatedTab() throws InterruptedException {
        WebElement element = driver.findElement(case_Related_tab_1);
        Thread.sleep(2000);
        isDisplayed(case_Related_tab_1);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void clickOnCaseRecord() throws InterruptedException {
        waitForElementToBeLocated(driver, case_record_1, 10);
        Thread.sleep(2000);
        case_record.click();
    }

    public String getCaseOriginActualForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, case_origin_actual_field_value_1, 10);
        Thread.sleep(2000);
        case_origin_actual_field_value.isDisplayed();
        return (case_origin_actual_field_value.getText());
    }

    public String getPriorityActualForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, priority_actual_field_value_1, 10);
        Thread.sleep(2000);
        priority_actual_field_value.isDisplayed();
        return (priority_actual_field_value.getText());
    }

    public String getStatusActualForValidation() throws InterruptedException {
        //case_origin_actual_field_value.click();//let's change the focused on actual Case Detail window frame
        //Thread.sleep(2000);
        log("/*----scroll down to Status field --*/");
        //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
        //Thread.sleep(2000);
        WebElement element1 = driver.findElement(primary_care_network_actual_field_value_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element1);
        Thread.sleep(1000);
        WebElement element2 = driver.findElement(contact_name_actual_field_value_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element2);
        Thread.sleep(1000);
        WebElement element4 = driver.findElement(status_actual_field_value_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element4);
        Thread.sleep(1000);
        waitForElementToBeLocated(driver, status_actual_field_value_1, 10);
        Thread.sleep(1000);
        priority_actual_field_value.isDisplayed();
        return (status_actual_field_value.getText());
    }

    public String getStatusActualAttachedForValidation() throws InterruptedException {
        //case_origin_actual_field_value.click();//let's change the focused on actual Case Detail window frame
        //Thread.sleep(2000);
        log("/*----scroll down to Status field --*/");
        //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
        //Thread.sleep(2000);
        WebElement element1 = driver.findElement(primary_care_network_actual_field_value_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element1);
        Thread.sleep(1000);
        WebElement element2 = driver.findElement(contact_name_Attached_actual_field_value_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element2);
        Thread.sleep(1000);
        WebElement element3 = driver.findElement(distance_able_to_travel_Attached_actual_value_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element3);
        Thread.sleep(1000);
        WebElement element4 = driver.findElement(status_actual_field_value_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element4);
        Thread.sleep(1000);
        waitForElementToBeLocated(driver, status_actual_field_value_1, 10);
        Thread.sleep(1000);
        priority_actual_field_value.isDisplayed();
        return (status_actual_field_value.getText());
    }


    public String getAccountNameActualForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, account_name_actual_field_value_1, 10);
        Thread.sleep(2000);
        account_name_actual_field_value.isDisplayed();
        return (account_name_actual_field_value.getText());
    }

    public String getPrimaryCareNetworkActualForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, primary_care_network_actual_field_value_1, 10);
        Thread.sleep(2000);
        primary_care_network_actual_field_value.isDisplayed();
        return (primary_care_network_actual_field_value.getText());
    }

    public String getCaseReasonActualForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, case_reason_actual_field_value_1, 10);
        Thread.sleep(2000);
        case_reason_actual_field_value.isDisplayed();
        return (case_reason_actual_field_value.getText());
    }

    public void selectRegistrationType() throws InterruptedException {
        waitForElementToBeLocated(driver, person_in_my_care_radiobutton_1, 10);
        Thread.sleep(2000);
        log("/*----scroll down a bit --*/");
        //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        WebElement element = driver.findElement(person_in_my_care_radiobutton_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        person_in_my_care_radiobutton.click();
    }

    public void clickObtainedConsent() throws InterruptedException {
        waitForElementToBeLocated(driver, caller_obtained_consent_checkbox_1, 10);
        Thread.sleep(1000);
        log("/*----scroll down --*/");
        //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        WebElement element = driver.findElement(caller_obtained_consent_checkbox_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        caller_obtained_consent_checkbox.click();
    }

    public void clickContinue() throws InterruptedException {
        waitForElementToBeLocated(driver, continue_button_1, 10);
        Thread.sleep(1000);
        continue_button.click();
    }

    public void selectCallerOnThePatientBehalf() throws InterruptedException {
        waitForElementToBeLocated(driver, caller_registering_patients_behalf_checkbox_1, 10);
        Thread.sleep(1000);
        log("/*----scroll up a bit --*/");
        WebElement element = driver.findElement(caller_registering_patients_behalf_checkbox_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        caller_registering_patients_behalf_checkbox.click();
    }

    public void selectCallerRelationshipWithPatient(String relationship) throws InterruptedException {
        waitForElementToBeLocated(driver, caller_relationship_dropdown_1, 10);
        Thread.sleep(1000);
        log("/*----scroll up a bit --*/");
        WebElement element_1 = driver.findElement(caller_relationship_dropdown_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element_1);
        Thread.sleep(2000);
        caller_relationship_dropdown.click();
        Thread.sleep(1000);
        waitForElementToBeVisible(driver, select_caller_relationship, 10);
        Thread.sleep(1000);
        log("/*----scroll a bit --*/");
        WebElement element = driver.findElement(select_caller_relationship_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(1000);
        select_caller_relationship.click();
        Thread.sleep(1000);
    }

    public void enterNameOfCaller(String nameOfCaller) throws InterruptedException {
        waitForElementToBeLocated(driver, caller_name_1, 10);
        Thread.sleep(1000);
        caller_name.sendKeys(nameOfCaller);
    }
    public void enterPatientFirstName(String patientFirstName) throws InterruptedException {
        waitForElementToBeLocated(driver, patient_first_name_1, 10);
        Thread.sleep(1000);
        patient_first_name.sendKeys(patientFirstName);
    }

    public void enterPatientLastName(String patientLastName) throws InterruptedException {
        waitForElementToBeLocated(driver, patient_last_name_1, 10);
        Thread.sleep(1000);
        patient_last_name.sendKeys(patientLastName);
    }

    public void enterPatientPHN(String patientPHN) throws InterruptedException {
        waitForElementToBeLocated(driver, patient_phn_1, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(patient_phn_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(1000);
        patient_phn.click();
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.sendKeys(patientPHN).build().perform();
        //patient_phn.sendKeys(patientPHN);
        Thread.sleep(1000);
    }

    public void enterMonth(String dateOfBirth_mm) throws InterruptedException {
        waitForElementToBeLocated(driver, patient_date_of_birth_MM_1, 10);
        Thread.sleep(1000);
        patient_date_of_birth_MM.sendKeys(dateOfBirth_mm);
    }
    public void enterDay(String dateOfBirth_dd) throws InterruptedException {
        waitForElementToBeLocated(driver, patient_date_of_birth_DD_1, 10);
        Thread.sleep(1000);
        patient_date_of_birth_DD.sendKeys(dateOfBirth_dd);
    }
    public void enterYear(String dateOfBirth_yy) throws InterruptedException {
        waitForElementToBeLocated(driver, patient_date_of_birth_YYYY_1, 10);
        Thread.sleep(1000);
        patient_date_of_birth_YYYY.sendKeys(dateOfBirth_yy);
        Thread.sleep(1000);
        ////DHSOPR-7560
        patient_date_of_birth_DD.click(); //1click.just temporary to not clicking on EMPI buttons two times.
        Thread.sleep(1000);
        patient_date_of_birth_YYYY.click(); //2click. again to not clicking on EMPI buttons two times.
        Thread.sleep(1000);
        patient_phn.click(); //3click. again to not clicking on EMPI buttons two times.
        Thread.sleep(1000);
    }

    public void clickVerifyPHN() throws InterruptedException {
        waitForElementToBeLocated(driver, verify_EMPI_button_1, 10);
        Thread.sleep(3000);
        verify_EMPI_button.click();
    }

    public String getEMPIStatusActualForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, empi_actual_verification_status_1, 10);
        Thread.sleep(2000);
        empi_actual_verification_status.isDisplayed();
        return (empi_actual_verification_status.getText());
    }

    public void clickSexMale() throws InterruptedException {
        waitForElementToBeLocated(driver, sex_male_button_1, 10);
        Thread.sleep(1000);
        log("/*----scroll down --*/");
        WebElement element = driver.findElement(sex_male_button_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        sex_male_button.click();
    }

    public void enterStreetAddress(String streetAddress) throws InterruptedException {
        waitForElementToBeLocated(driver, street_address_1, 10);
        street_address.sendKeys(streetAddress);
        Thread.sleep(2000);
    }

    public void clickOnInfoIcon() throws InterruptedException {
        waitForElementToBeLocated(driver, info_icon_1, 10);
        info_icon.click();
        Thread.sleep(2000);
    }

    public void enterCity(String City) throws InterruptedException {
        waitForElementToBeLocated(driver, city_1, 10);
        city.click();
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.sendKeys(City).build().perform();
        Thread.sleep(1000);
    }

    public void enterProvince(String Province) throws InterruptedException {
        waitForElementToBeLocated(driver, province_dropdown_component_1, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(province_dropdown_component_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(1000);
        province_dropdown_component.click();
        Thread.sleep(1000);
        province_optin_selection.click();
        Thread.sleep(1000);
    }

    public void enterPostalCode(String postalCode) throws InterruptedException {
        waitForElementToBeLocated(driver, postal_code_1, 10);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(postal_code_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(1000);
        postal_code.click();
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].value  = 'V6Y 1A3';", postal_code);
        //postal_code.sendKeys(postalCode);
        Actions actions = new Actions(driver);
        actions.sendKeys(postalCode).build().perform();
        //actions.sendKeys(Keys.ENTER).build().perform();
        //Thread.sleep(1000);
    }

    public void enterPrimaryContactName(String primaryContactName) throws InterruptedException {
        waitForElementToBeLocated(driver, primary_contact_name_1, 10);
        primary_contact_name.sendKeys(primaryContactName);
    }

    public void enterEmailAddress(String email) throws InterruptedException {
        waitForElementToBeLocated(driver, enter_email_address_1, 10);
        enter_email_address.sendKeys(email);
    }

    public void enterConfirmEmailAddress(String email) throws InterruptedException {
        waitForElementToBeLocated(driver, enter_confirm_email_address_1, 10);
        enter_confirm_email_address.sendKeys(email);
    }

    public void enterMobilePhoneNumber(String mobile) throws InterruptedException {
        waitForElementToBeLocated(driver, mobile_phone_1, 10);
        mobile_phone.click();
        //mobile_phone.sendKeys(mobile);
        Actions actions = new Actions(driver);
        actions.sendKeys(mobile).build().perform();
        //Thread.sleep(1000);
    }

    public void clickEmailCommunicationPreference() throws InterruptedException {
        waitForElementToBeLocated(driver, communicarion_preference_Email_button_1, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(communicarion_preference_Email_button_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        communicarion_preference_Email_button.click();
    }

    public void clickYesFamilyDoctor() throws InterruptedException {
        waitForElementToBeLocated(driver, currently_Yes_family_doctor_button_1, 10);
        Thread.sleep(1000);
        log("/*----scroll down --*/");
        WebElement element = driver.findElement(currently_Yes_family_doctor_button_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        currently_Yes_family_doctor_button.click();
    }

    //public void selectCurrentFamilyDoctor(String currentPractitioner) throws InterruptedException {
        //waitForElementToBeLocated(driver, current_family_doctor_search_component_1, 10);
        //Thread.sleep(1000);
        //current_family_doctor_search_component.sendKeys(currentPractitioner);
        //Thread.sleep(5000);
        //select_from_current_family_doctors_dropdown_list.click();
        //Thread.sleep(1000);
    //}

    public void enterCurrentFamilyDoctor(String currentPractitioner) throws InterruptedException {
        waitForElementToBeLocated(driver, current_family_doctor_name_1, 10);
        Thread.sleep(1000);
        current_family_doctor_name.sendKeys(currentPractitioner);
    }

    public void enterDoctorsCityOrTown(String cityOrTown) throws InterruptedException {
        waitForElementToBeLocated(driver, practitioner_location_1, 10);
        Thread.sleep(1000);
        practitioner_location.sendKeys(cityOrTown);
    }

    public void choseWhyLookingForDoctor() throws InterruptedException {
        waitForElementToBeLocated(driver, doctor_is_not_accepting_additional_family_members_radiobutton_1, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(doctor_is_not_accepting_additional_family_members_radiobutton_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        doctor_is_not_accepting_additional_family_members_radiobutton.click();
    }

    public void choseHowFarDoctorFromTheirHome() throws InterruptedException {
        waitForElementToBeLocated(driver, less_than_5km_radiobutton_1, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(less_than_5km_radiobutton_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        less_than_5km_radiobutton.click();
    }

    public void clickWhatGenderOfFamilyDoctor() throws InterruptedException {
        waitForElementToBeLocated(driver, gender_of_family_doctor_button_1, 10);
        Thread.sleep(1000);
        gender_of_family_doctor_button.click();
    }

    public void clickYesNeedTranslator() throws InterruptedException {
        waitForElementToBeLocated(driver, need_translator_button_1, 10);
        Thread.sleep(1000);
        need_translator_button.click();
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

    public void clickFinishRegistration() throws InterruptedException {
        waitForElementToBeLocated(driver, finish_registration_button_1, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(finish_registration_button_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        finish_registration_button.click();
    }

    public static boolean validateSuccessfullyRegisteredPageDisplayed() throws InterruptedException {
        try {
            waitForElementToBeVisible(driver, successfully_registered_page_validation, 10);
            System.out.println("/*---Successfully registered page - shown up");
        } catch (NoSuchElementException e) {
            System.out.println("/*---Successfully registered page page has NOT show up");
            throw e;
        }
        return false;
    }

    public String getContactNameActualForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, caller_name_actual_field_value_1, 10);
        Thread.sleep(2000);
        caller_name_actual_field_value.isDisplayed();
        return (caller_name_actual_field_value.getText());
    }

    public String getCaseContactNameActualForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, case_caller_name_actual_field_value_1, 10);
        Thread.sleep(2000);
        case_caller_name_actual_field_value.isDisplayed();
        return (case_caller_name_actual_field_value.getText());
    }

    public String getPrimaryContactNameActualForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, primary_contact_name_actual_field_value_1, 10);
        Thread.sleep(2000);
        primary_contact_name_actual_field_value.isDisplayed();
        return (primary_contact_name_actual_field_value.getText());
    }

    public String getCasePractitionerContactNameActualForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, case_practitioner_contact_name_actual_field_value_1, 10);
        Thread.sleep(2000);
        case_practitioner_contact_name_actual_field_value.isDisplayed();
        return (case_practitioner_contact_name_actual_field_value.getText());
    }

    public String getCallerRelatedRoleActualForValidation() throws InterruptedException {
        WebElement element = driver.findElement(caller_related_role_actual_field_value_1);
        Thread.sleep(2000);
        caller_related_role_actual_field_value.isDisplayed();
        Thread.sleep(2000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String textReturn = (String) executor.executeScript("return arguments[0].textContent;", element);
        return textReturn;
    }

    public String getCaseCallerRoleActualForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, case_caller_role_actual_field_value_1, 10);
        Thread.sleep(2000);
        case_caller_role_actual_field_value.isDisplayed();
        Thread.sleep(2000);
        return (case_caller_role_actual_field_value.getText());

        //WebElement element = driver.findElement(case_caller_role_actual_field_value_1);
        //Thread.sleep(2000);
        //case_caller_role_actual_field_value.isDisplayed();
        //Thread.sleep(2000);
        //JavascriptExecutor executor = (JavascriptExecutor) driver;
        //String textReturn = (String) executor.executeScript("return arguments[0].textContent;", element);
        //return textReturn;
    }

    public String getPrimaryContactRelatedRoleActualForValidation() throws InterruptedException {
        WebElement element = driver.findElement(primary_contact_related_role_actual_field_value_1);
        Thread.sleep(2000);
        primary_contact_related_role_actual_field_value.isDisplayed();
        Thread.sleep(2000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String textReturn = (String) executor.executeScript("return arguments[0].textContent;", element);
        return textReturn;
    }
    public String getCaseContactPractitionerRoleActualForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, case_contact_practitioner_role_actual_field_value_1, 10);
        Thread.sleep(2000);
        case_contact_practitioner_role_actual_field_value.isDisplayed();
        Thread.sleep(2000);
        return (case_contact_practitioner_role_actual_field_value.getText());

        //WebElement element = driver.findElement(case_contact_practitioner_role_actual_field_value_1);
        //Thread.sleep(2000);
        //case_contact_practitioner_role_actual_field_value.isDisplayed();
        //Thread.sleep(2000);
        //JavascriptExecutor executor = (JavascriptExecutor) driver;
        //String textReturn = (String) executor.executeScript("return arguments[0].textContent;", element);
        //return textReturn;
    }

    public String getCaseCommentActualForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, case_comment_actual_field_value_1, 10);
        Thread.sleep(2000);
        case_comment_actual_field_value.isDisplayed();
        return (case_comment_actual_field_value.getText());
    }

    public String getContactNameSandyPriorActualForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, caller_name_Sandy_Prior_2_actual_field_value_1, 10);
        Thread.sleep(2000);
        caller_name_Sandy_Prior_2_actual_field_value.isDisplayed();
        return (caller_name_Sandy_Prior_2_actual_field_value.getText());
    }

    public String getCallerRelatedRoleChildActualForValidation() throws InterruptedException {
        WebElement element = driver.findElement(caller_related_role_Child_actual_field_value_1);
        Thread.sleep(2000);
        caller_related_role_Child_actual_field_value.isDisplayed();
        Thread.sleep(2000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String textReturn = (String) executor.executeScript("return arguments[0].textContent;", element);
        return textReturn;
    }

    public String getPrimaryContactNameSandyPriorActualForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, primary_contact_name_Sandy_Prior_1_actual_field_value_1, 10);
        Thread.sleep(2000);
        primary_contact_name_Sandy_Prior_1_actual_field_value.isDisplayed();
        return (primary_contact_name_Sandy_Prior_1_actual_field_value.getText());
    }

    public String getStatusActualHillisVioletteAttachedForValidation() throws InterruptedException {
        log("/*----scroll down to Status field --*/");
        WebElement element1 = driver.findElement(primary_care_network_actual_field_value_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element1);
        Thread.sleep(1000);
        WebElement element2 = driver.findElement(contact_name_Attached_actual_Hollis_Violette_field_value_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element2);
        Thread.sleep(1000);
        WebElement element3 = driver.findElement(distance_able_to_travel_Attached_actual_value_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element3);
        Thread.sleep(1000);
        WebElement element4 = driver.findElement(status_actual_field_value_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element4);
        Thread.sleep(1000);
        waitForElementToBeLocated(driver, status_actual_field_value_1, 10);
        Thread.sleep(1000);
        priority_actual_field_value.isDisplayed();
        return (status_actual_field_value.getText());
    }

    public void choseHealthChangesIn3Months() throws InterruptedException {
        waitForElementToBeLocated(driver, pregnancy_or_recent_birth_radiobutton_1, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(pregnancy_or_recent_birth_radiobutton_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        pregnancy_or_recent_birth_radiobutton.click();
    }

    public void choseNewDiagnosisIn3Months() throws InterruptedException {
        waitForElementToBeLocated(driver, irregular_heartbeat_radiobutton_1, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(irregular_heartbeat_radiobutton_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        irregular_heartbeat_radiobutton.click();
    }










}
