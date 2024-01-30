package primarycare.pages;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import primarycare.pages.Tables;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProviderPortalHomePage extends BasePage{
    /*---------Properties-------*/
    @FindBy(xpath = ".//span/div[text()='My Clinics & Panels']")
    private WebElement is_provider_portal_home_page_displayed;
    private By is_provider_portal_home_page_displayed_1 = By.xpath(".//span/div[text()='My Clinics & Panels']");

    @FindBy(xpath = ".//span[text()='Address']")
    private WebElement is_provider_portal_home_page_displayed_MoA;
    private By is_provider_portal_home_page_displayed_MoA_1 = By.xpath(".//span[text()='Address']");

    @FindBy(xpath = ".//h1[text()='My Clinics & Panels']")
    private WebElement is_provider_portal_home_page_displayed_TIER1;
    private By is_provider_portal_home_page_displayed_TIER1_1 = By.xpath(".//h1[text()='My Clinics & Panels']");

    @FindBy(xpath = "//a[text() = 'Home']")
    private WebElement home_link;
    private By home_link_1 = By.xpath("//a[text() = 'Home']");

    @FindBy(xpath = "(//span[text()='View'])[2]")
    private WebElement view_link;
    private By view_link_1 = By.xpath("(//span[text()='View'])[2]");

    @FindBy(xpath = "(//span[text()='My Panel'])[1]")
    private WebElement rostering_link;
    private By rostering_link_1 = By.xpath("(//span[text()='My Panel'])[1]");

    @FindBy(xpath = "(//span[text()='Current Staff'])[1]")
    private WebElement current_staff_link;
    private By current_staff_link_1 = By.xpath("(//span[text()='Current Staff'])[1]");

    @FindBy(xpath = "(//span[text()='CASTLEGAR MED FAMILY CLINIC'])[1]")
    private WebElement facility_link;
    private By facility_link_1 = By.xpath("(//span[text()='CASTLEGAR MED FAMILY CLINIC'])[1]");

    @FindBy(xpath = "//span[text()='Edit']")
    private WebElement edit_button;
    private By edit_button_1 = By.xpath("//span[text()='Edit']");

    @FindBy(xpath = "(//input[@data-interactive-lib-uid])[1]")
    private WebElement desired_panel_size_component;
    private By desired_panel_size_component_1 = By.xpath("(//input[@data-interactive-lib-uid])[1]");

    @FindBy(xpath = "//input[@class='slds-input slds-listbox__option-text_entity']")
    private WebElement accepting_new_patient_dropdown;
    private By accepting_new_patient_dropdown_1 = By.xpath("//input[@class='slds-input slds-listbox__option-text_entity']");

    @FindBy(xpath = "//span[@class][text()='Yes']")
    private WebElement select_yes_from_accepting_new_patient_options;
    private By select_yes_from_accepting_new_patient_options_1 = By.xpath("//span[@class][text()='Yes']");


    @FindBy(xpath = "//input[@omnistudio-maskedinput_maskedinput_slds]")
    private WebElement max_new_requests_component;
    private By max_new_requests_component_1 = By.xpath("//input[@omnistudio-maskedinput_maskedinput_slds]");

    @FindBy(xpath = "(//span[text()='Save'])[1]")
    private WebElement save_button;
    private By save_button_1 = By.xpath("(//span[text()='Save'])[1]");

    @FindBy(xpath = "(//span[@class='uiOutputNumber'])[1]")
    private WebElement desired_panel_size_actual_field_value;
    private By desired_panel_size_actual_field_value_1 = By.xpath("(//span[@class='uiOutputNumber'])[1]");

    @FindBy(xpath = "//div[@class='slds-col max-new-req-text-value pannel-label-value slds-size_12-of-12']//span")
    private WebElement max_new_requests_actual_field_value;
    private By max_new_requests_actual_field_value_1 = By.xpath("//div[@class='slds-col max-new-req-text-value pannel-label-value slds-size_12-of-12']//span");

    @FindBy(xpath = "//div[@class='slds-col acc-new-pts-text-value pannel-label-value slds-size_12-of-12']//span")
    private WebElement isAccepting_actual_field_value;
    private By isAccepting_actual_field_value_1 = By.xpath("//div[@class='slds-col acc-new-pts-text-value pannel-label-value slds-size_12-of-12']//span");

    @FindBy(xpath = "//button[text() = 'Add']")
    private WebElement add_staff_button;
    private By add_staff_button_1 = By.xpath("//button[text() = 'Add']");

    @FindBy(xpath = "//button[@aria-label='System Role, --None--']")
    private WebElement role_dropdown;
    private By role_dropdown_1 = By.xpath("//button[@aria-label='System Role, --None--']");

    @FindBy(xpath = "//div/lightning-base-combobox-item//span[text()='Provider']")
    private WebElement select_provider_from_roles_options;
    private By select_provider_from_roles_options_1 = By.xpath("//div/lightning-base-combobox-item//span[text()='Provider']");

    @FindBy(xpath = "//input[@placeholder ='Search Contacts...']")
    private WebElement practitioner_search_component_search_component;
    private By practitioner_search_component_1 = By.xpath("//input[@placeholder ='Search Contacts...']");

    @FindBy(xpath = "//div/ul/li//span/lightning-base-combobox-formatted-text[@title = 'Kristine Hnatyshyn Fisher']")
    private WebElement select_from_practitioners_dropdown_list;
    private By select_from_practitioners_dropdown_list_1 = By.xpath("//div/ul/li//span/lightning-base-combobox-formatted-text[@title = 'Kristine Hnatyshyn Fisher']");

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement save_new_staff_member_button;
    private By save_new_staff_member_button_1 = By.xpath("//button[text()='Save']");

    @FindBy(xpath = "//a[contains(text(),'Kristine Fisher')]")
    private WebElement practitioner_facility_name_actual_field_value;
    private By practitioner_facility_name_actual_field_value_1 = By.xpath("//a[contains(text(),'Kristine Fisher')]");

    @FindBy(xpath = "//a[contains(text(),'Kristine Fisher')]")
    private WebElement practitioner_facility_name_link;
    private By practitioner_facility_name_link_1 = By.xpath("//a[contains(text(),'Kristine Fisher')]");

    @FindBy(xpath = "//div[@title='Edit']")
    private WebElement edit_practitioner_facility_button;
    private By edit_practitioner_facility_button_1 = By.xpath("//div[@title='Edit']");

    @FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.HealthcarePractitionerFacility.EffectiveFrom']//input[@class=' input']")
    private WebElement effective_from_input;
    private By effective_from_input_1 = By.xpath("//div[@data-target-selection-name='sfdc:RecordField.HealthcarePractitionerFacility.EffectiveFrom']//input[@class=' input']");

    @FindBy(xpath = "(//span[text()='Save'])[2]")
    private WebElement save_effective_from_modal_button;
    private By save_effective_from_modal_button_1 = By.xpath("(//span[text()='Save'])[2]");

    @FindBy(xpath = ".//div[@class='slds-table_header-fixed_container slds-scrollable_x']")
    private WebElement practitioner_facility_current_staff_tab_table;
    private By practitioner_facility_current_staff_tab_table_1 = By.xpath(".//div[@class='slds-table_header-fixed_container slds-scrollable_x']");

    @FindBy(xpath = "//span[text()='Inactive']")
    private WebElement previous_staff_tab;
    private By previous_staff_tab_1 = By.xpath("//span[text()='Inactive']");

    @FindBy(xpath = "//span[text()='Providers & Other PAS Users']")
    private WebElement current_staff_tab;
    private By current_staff_tab_1 = By.xpath("Providers & Other PAS Users");

    @FindBy(xpath = "(.//div[@class='slds-table_header-fixed_container slds-scrollable_x'])[2]")
    private WebElement practitioner_facility_previous_staff_tab_table;
    private By practitioner_facility_previous_staff_tab_table_1 = By.xpath("(.//div[@class='slds-table_header-fixed_container slds-scrollable_x'])[2]");

    @FindBy(xpath = "//button[text()='Add Patient']")
    private WebElement add_patient_button;
    private By add_patient_button_1 = By.xpath("//button[text()='Add Patient']");

    @FindBy(xpath = "//input[@placeholder='Enter PHN number']")
    private WebElement patient_phn_input_component;
    private By patient_phn_input_component_1 = By.xpath("//input[@placeholder='Enter PHN number']");

    @FindBy(xpath = "//button[text()='Search']")
    private WebElement search_patient_button;
    private By search_patient_button_1 = By.xpath("//button[text()='Search']");

    @FindBy(xpath = "(//button[text()='Add Patient'])[2]")
    private WebElement add_founded_patient_button;
    private By add_founded_patient_button_1 = By.xpath("(//button[text()='Add Patient'])[2]");

    @FindBy(xpath = "//div[@class='slds-modal__container']//button[@title='Close']")
    private WebElement close_modal_form_button;
    private By close_modal_form_button_1 = By.xpath("//div[@class='slds-modal__container']//button[@title='Close']");

    @FindBy(xpath = "//td[@data-col-key-value]//lightning-base-formatted-text[text()='Garth']")
    private WebElement empaneled_patient_first_name_actual_field_value;
    private By empaneled_patient_first_name_actual_field_value_1 = By.xpath("//td[@data-col-key-value]//lightning-base-formatted-text[text()='Garth']");

    @FindBy(xpath = ".//div[@class='slds-table_header-fixed_container slds-scrollable_x']")
    private WebElement empaneled_patients_current_panel_tab_table;
    private By empaneled_patients_current_panel_tab_table_1 = By.xpath(".//div[@class='slds-table_header-fixed_container slds-scrollable_x']");

    @FindBy(xpath = "//button[@name='Yes']")
    private WebElement yes_on_modal_remove_patients_form_button;
    private By yes_on_modal_remove_patients_form_button_1 = By.xpath("//button[@name='Yes']");

    @FindBy(xpath = "(//div[@class='slds-tile__detail slds-text-body_small']//span[text()='Active'])[1]")
    private WebElement panels_filter_dropdown_component;
    private By panels_filter_dropdown_component_1 = By.xpath("(//div[@class='slds-tile__detail slds-text-body_small']//span[text()='Active'])[1]");

    @FindBy(xpath = "//div[@data-filter='Removed']")
    private WebElement select_removed_option_for_dropdown_component;
    private By select_removed_option_for_dropdown_component_1 = By.xpath("//div[@data-filter='Removed']");

    @FindBy(xpath = "//button[@aria-label='Select Panel Status, Select...']")
    private WebElement empaneled_patient_status_dropdown;
    private By empaneled_patient_status_dropdown_1 = By.xpath("//button[@aria-label='Select Panel Status, Select...']");

    @FindBy(xpath = "(.//span[@title='Active'])[2]")
    private WebElement select_active_from_panel_status_options;
    private By select_active_from_panel_status_options_1 = By.xpath("(.//span[@title='Active'])[2]");

    @FindBy(xpath = "//button[@name='Proceed']")
    private WebElement proceed_on_modal_update_panel_status_form_button;
    private By proceed_on_modal_update_panel_status_form_button_1 = By.xpath("//button[@name='Proceed']");

    @FindBy(xpath = "//button[@name='Yes']")
    private WebElement yes_on_modal_update_panel_status_form_button;
    private By yes_on_modal_update_panel_status_form_button_1 = By.xpath("//button[@name='Yes']");

    @FindBy(xpath = "//button[@aria-label='Select clinics, Select an Option']")
    private WebElement empaneled_patient_change_clinic_options_dropdown;
    private By empaneled_patient_change_clinic_options_dropdown_1 = By.xpath("//button[@aria-label='Select clinics, Select an Option']");

    @FindBy(xpath = "(.//div[@class='slds-form-element__control']/lightning-base-combobox//span[@title])[1]")
    private WebElement select_Capri_Center_from_options;
    private By select_Capri_Center_from_options_1 = By.xpath("(.//div[@class='slds-form-element__control']/lightning-base-combobox//span[@title])[1]");

    @FindBy(xpath = "//button[text()='Proceed']")
    private WebElement proceed_on_modal_change_clinic_form_button;
    private By proceed_on_modal_change_clinic_form_button_1 = By.xpath("//button[text()='Proceed']");

    @FindBy(xpath = "(//span[text()='My Panel'])[2]")
    private WebElement rostering_second_clinic_link;
    private By rostering_second_clinic_link_1 = By.xpath("(//span[text()='My Panel'])[2]");

    @FindBy(xpath = "//a[contains(text(),'Agnes Phillip')]")
    private WebElement moa_practitioner_facility_name_link;
    private By moa_practitioner_facility_name_link_1 = By.xpath("//a[contains(text(),'Agnes Phillip')]");

    @FindBy(xpath = "//span[text()='Details']")
    private WebElement details_tab;
    private By details_tab_1 = By.xpath("//span[text()='Details']");

    @FindBy(xpath = "//div[@data-target-selection-name='sfdc:RecordField.HealthcarePractitionerFacility.Manage_Facility__c']//span[@data-aura-class='uiImage uiOutputCheckbox']")
    private WebElement manage_facility_checkbox;
    private By manage_facility_checkbox_1 = By.xpath("//div[@data-target-selection-name='sfdc:RecordField.HealthcarePractitionerFacility.Manage_Facility__c']//span[@data-aura-class='uiImage uiOutputCheckbox']");

    @FindBy(xpath = "//button[@title='Edit Manage Facility']")
    private WebElement pencil_edit_button;
    private By pencil_edit_button_1 = By.xpath("//button[@title='Edit Manage Facility']");

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement click_manage_facility_checkbox;
    private By click_manage_facility_checkbox_1 = By.xpath("//input[@type='checkbox']");

    @FindBy(xpath = "//div/lightning-base-combobox-item//span[text()='Medical Office Assistant']")
    private WebElement select_MoA_from_roles_options;
    private By select_MoA_from_roles_options_1 = By.xpath("//div/lightning-base-combobox-item//span[text()='Medical Office Assistant']");

    @FindBy(xpath = "//div/ul/li//span/lightning-base-combobox-formatted-text[@title = 'Agnes Phillip']")
    private WebElement select_MoA_Agnes_Phillip_from_practitioners_dropdown_list;
    private By select_MoA_Agnes_Phillip_from_practitioners_dropdown_list_1 = By.xpath("//div/ul/li//span/lightning-base-combobox-formatted-text[@title = 'Agnes Phillip']");

    @FindBy(xpath = "//a[contains(text(),'Agnes Phillip')]")
    private WebElement practitioner_MoA_facility_name_actual_field_value;
    private By practitioner_MoA_facility_name_actual_field_value_1 = By.xpath("//a[contains(text(),'Agnes Phillip')]");

    @FindBy(xpath = "(//span[text()='Panel Sharing'])[2]")
    private WebElement panel_sharing_link;
    private By panel_sharing_link_1 = By.xpath("(//span[text()='Panel Sharing'])[2]");

    @FindBy(xpath = "//span[text()='Give Access To']")
    private WebElement give_access_to_tab;
    private By give_access_to_tab_1 = By.xpath("//span[text()='Give Access To']");

    @FindBy(xpath = "(.//div[@class='slds-table_header-fixed_container slds-scrollable_x'])[2]")
    private WebElement panel_sharing_give_access_to_tab_table;
    private By panel_sharing_give_access_to_tab_table_1 = By.xpath("(.//div[@class='slds-table_header-fixed_container slds-scrollable_x'])[2]");

    @FindBy(xpath = "//a[contains(text(),'Agnes Phillip')]")
    private WebElement practitioner_moa_name_link;
    private By practitioner_moa_name_link_1 = By.xpath("//a[contains(text(),'Agnes Phillip')]");

    @FindBy(xpath = ".//label/span[text()='Manage My Panel & Profile']")
    private WebElement click_manage_manage_my_panel_profile_checkbox;
    private By click_manage_manage_my_panel_profile_checkbox_1 = By.xpath(".//label/span[text()='Manage My Panel & Profile']");

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement save_give_access_to_button;
    private By save_give_access_to_button_1 = By.xpath("//button[text()='Save']");

    @FindBy(xpath = ".//omnistudio-omniscript-custom-lwc")
    private WebElement basecard;

    @FindBy(xpath = ".//div[@class='slds-table_header-fixed_container slds-scrollable_x']")
    private WebElement practitioner_granted_access_by_tab_table;
    private By practitioner_granted_access_by_tab_table_1 = By.xpath(".//div[@class='slds-table_header-fixed_container slds-scrollable_x']");

    @FindBy(xpath = ".//a[text()='Lori-Ann May Bus Panel']")
    private WebElement practitioner_panel_name_link;
    private By practitioner_panel_name_link_1 = By.xpath(".//a[text()='Lori-Ann May Bus Panel']");

    @FindBy(xpath = "(.//span[text()='Clinic Details'])[1]")
    private WebElement current_details_link;
    private By current_details_link_1 = By.xpath("(.//span[text()='Clinic Details'])[1]");

    @FindBy(xpath = "//span[text()='CASTLEGAR MED FAMILY CLINIC']")
    private WebElement riverview_med_family_facility_link;
    private By riverview_med_family_facility_link_1 = By.xpath("//span[text()='CASTLEGAR MED FAMILY CLINIC']");

    @FindBy(xpath = ".//h1[text()='Account Details']")
    private WebElement edit_clinic_page_displayed_validation;

    @FindBy(xpath = ".//a[text()='Clinic & Provider Registry']")
    private WebElement clinic_and_provider_registry_link;
    private By clinic_and_provider_registry_link_1 = By.xpath(".//a[text()='Clinic & Provider Registry']");

    @FindBy(xpath = ".//span[text()='Search all clinics in BC']")
    private WebElement search_all_clinics_in_BC_link;
    private By search_all_clinics_in_BC_link_1 = By.xpath(".//span[text()='Search all clinics in BC']");

    @FindBy(xpath = ".//input[@placeholder='Enter Clinic Name']")
    private WebElement clinic_name_search_box_component;
    private By clinic_name_search_box_component_1 = By.xpath(".//input[@placeholder='Enter Clinic Name']");

    @FindBy(xpath = "//button[text()='Search']")
    private WebElement search_clinics_button;
    private By search_clinics_button_1 = By.xpath("//button[text()='Search']");

    //////////////////////////////////////////////////////////////////////////////////
    Tables tables;
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*---------Constructor-------*/
    public ProviderPortalHomePage(WebDriver driver) {
        super(driver);
        tables = new primarycare.pages.Tables(driver);
    }


    /*-------------Methods--------------*/
    public boolean isPortalProviderHomePageDisplayed() throws InterruptedException {
        boolean isPortalProviderHomePageDisplayed = false;
        for(int i = 1; i <= 40; i++ ) {
            if (!isDisplayed(is_provider_portal_home_page_displayed_1)) {
                log(i +"-try to see Provider Home Page: "  +  " Home Page not showing up yet, re-try!");
                log( "wait for 10 sec");
                Thread.sleep(10000);
                log( "Refresh the browser");
                refreshBrowser();
                Thread.sleep(5000);
            } else {
                log("/*---Provider Home Page "  + "has shown up " + " --*/");
                isPortalProviderHomePageDisplayed = true;
                break;
            }
        }
        return isPortalProviderHomePageDisplayed;
    }

    public boolean isPortalProviderHomePageDisplayed_MoA() throws InterruptedException {
        boolean isPortalProviderHomePageDisplayed = false;
        for(int i = 1; i <= 40; i++ ) {
            if (!isDisplayed(is_provider_portal_home_page_displayed_MoA_1)) {
                log(i +"-try to see Provider Home Page: "  +  " Home Page not showing up yet, re-try!");
                log( "wait for 10 sec");
                Thread.sleep(10000);
                log( "Refresh the browser");
                refreshBrowser();
                Thread.sleep(5000);
            } else {
                log("/*---Provider Home Page "  + "has shown up " + " --*/");
                isPortalProviderHomePageDisplayed = true;
                break;
            }
        }
        return isPortalProviderHomePageDisplayed;
    }

    public boolean isPortalProviderHomePageDisplayed_TIER1() throws InterruptedException {
        boolean isPortalProviderHomePageDisplayed = false;
        for(int i = 1; i <= 40; i++ ) {
            if (!isDisplayed(is_provider_portal_home_page_displayed_TIER1_1)) {
                log(i +"-try to see Provider Home Page: "  +  " Home Page not showing up yet, re-try!");
                log( "wait for 10 sec");
                Thread.sleep(10000);
                log( "Refresh the browser");
                refreshBrowser();
                Thread.sleep(5000);
            } else {
                log("/*---Provider Home Page "  + "has shown up " + " --*/");
                isPortalProviderHomePageDisplayed = true;
                break;
            }
        }
        return isPortalProviderHomePageDisplayed;
    }

    public void clickHomeLink() throws InterruptedException {
        waitForElementToBeVisible(driver, home_link, 10);
        Thread.sleep(5000);
        WebElement element = driver.findElement(home_link_1);
        Thread.sleep(5000);
        home_link.click();
    }

    public void clickView() throws InterruptedException {
        waitForElementToBeVisible(driver, view_link, 10);
        Thread.sleep(1000);
        view_link.click();
    }

    public void clickRostering() throws InterruptedException {
        waitForElementToBeVisible(driver, rostering_link, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(rostering_link_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        rostering_link.click();
    }

    public void clickEdit() throws InterruptedException {
        waitForElementToBeVisible(driver, edit_button, 10);
        Thread.sleep(1000);
        edit_button.click();
    }

    public void enterDesiredPanelSize(int desiredPanelSize) throws InterruptedException {
        waitForElementToBeLocated(driver, desired_panel_size_component_1, 10);
        Thread.sleep(1000);
        desired_panel_size_component.click();
        Thread.sleep(1000);
        desired_panel_size_component.clear();
        Thread.sleep(1000);
        //String size ="" + String desiredPanelSize;
        String size = Integer.toString(desiredPanelSize);
        desired_panel_size_component.sendKeys(size);
        Thread.sleep(1000);
    }

    public void selectAcceptingNewPatientsOption(String isAcceptingNewPatients) throws InterruptedException {
        waitForElementToBeLocated(driver, accepting_new_patient_dropdown_1, 10);
        Thread.sleep(1000);
        accepting_new_patient_dropdown.click();
        Thread.sleep(1000);
        waitForElementToBeLocated(driver, select_yes_from_accepting_new_patient_options_1, 10);
        Thread.sleep(2000);
        select_yes_from_accepting_new_patient_options.click();
        Thread.sleep(2000);
    }

    public void enterMaxNewRequests(String maxNewRequests) throws InterruptedException {
        waitForElementToBeLocated(driver, max_new_requests_component_1, 10);
        Thread.sleep(1000);
        max_new_requests_component.click();
        Thread.sleep(1000);
        max_new_requests_component.clear();
        Thread.sleep(1000);
        max_new_requests_component.sendKeys(maxNewRequests);
        Thread.sleep(1000);
    }

    public void clickSave() throws InterruptedException {
        waitForElementToBeVisible(driver, save_button, 10);
        Thread.sleep(1000);
        save_button.click();
    }

    public String getActualDesiredPanelSizeForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, desired_panel_size_actual_field_value_1, 10);
        Thread.sleep(2000);
        desired_panel_size_actual_field_value.isDisplayed();
        return (desired_panel_size_actual_field_value.getText());
    }

    public String getActualMaxNewRequestsForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, max_new_requests_actual_field_value_1, 10);
        Thread.sleep(2000);
        max_new_requests_actual_field_value.isDisplayed();
        return (max_new_requests_actual_field_value.getText());
    }

    public String getActualIsAcceptingNewPatientsForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, isAccepting_actual_field_value_1, 10);
        Thread.sleep(5000);
        isAccepting_actual_field_value.isDisplayed();
        return (isAccepting_actual_field_value.getText());
    }

    public void clickOnFacility() throws InterruptedException {
        waitForElementToBeVisible(driver, facility_link, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(facility_link_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        facility_link.click();
    }

    public void clickCurrentStaff() throws InterruptedException {
        waitForElementToBeVisible(driver, current_staff_link, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(current_staff_link_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        current_staff_link.click();
    }

    public void clickAddStaff() throws InterruptedException {
        waitForElementToBeVisible(driver, add_staff_button, 10);
        Thread.sleep(1000);
        add_staff_button.click();
    }

    public void selectRoleOption(String role) throws InterruptedException {
        waitForElementToBeLocated(driver, role_dropdown_1, 10);
        Thread.sleep(1000);
        role_dropdown.click();
        Thread.sleep(1000);
        waitForElementToBeLocated(driver, select_provider_from_roles_options_1, 10);
        Thread.sleep(2000);
        select_provider_from_roles_options.click();
        Thread.sleep(2000);
    }

    public void selectPractitioner(String practitioner) throws InterruptedException {
        waitForElementToBeLocated(driver, practitioner_search_component_1, 10);
        Thread.sleep(1000);
        practitioner_search_component_search_component.sendKeys(practitioner);
        Thread.sleep(5000);
        select_from_practitioners_dropdown_list.click();
        Thread.sleep(1000);
    }

    public void clickSaveNewStaffMember() throws InterruptedException {
        waitForElementToBeVisible(driver, save_new_staff_member_button, 10);
        Thread.sleep(1000);
        save_new_staff_member_button.click();
    }

    public String getActualPractitionerFacilityNameForValidation() throws InterruptedException {
        log("/*----scroll down a bit --*/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
        Thread.sleep(2000);
        waitForElementToBeLocated(driver, practitioner_facility_name_actual_field_value_1, 10);
        Thread.sleep(2000);
        practitioner_facility_name_actual_field_value.isDisplayed();
        return (practitioner_facility_name_actual_field_value.getText());
    }

    public void clickOnPractitionerFacilityNameLink() throws InterruptedException {
        waitForElementToBeVisible(driver, practitioner_facility_name_link, 10);
        Thread.sleep(2000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(practitioner_facility_name_link_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        practitioner_facility_name_link.click();
    }

    public void clickEditPractitionerFacility() throws InterruptedException {
        waitForElementToBeVisible(driver, edit_practitioner_facility_button, 10);
        Thread.sleep(2000);
        edit_practitioner_facility_button.click();
    }

    public void inputYesterdayDayInEffectiveFrom() throws InterruptedException {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date yesterday = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        waitForElementToBeVisible(driver, effective_from_input, 10);
        Thread.sleep(2000);
        String todayAsString = dateFormat.format(yesterday);
        effective_from_input.click();
        Thread.sleep(2000);
        effective_from_input.clear();
        Thread.sleep(2000);
        effective_from_input.sendKeys(todayAsString);
        Thread.sleep(2000);
        effective_from_input.sendKeys(Keys.ENTER);
    }

    public void clickSaveEffectiveFrom() throws InterruptedException {
        waitForElementToBeVisible(driver, save_effective_from_modal_button, 10);
        Thread.sleep(1000);
        save_effective_from_modal_button.click();
    }

    public void clickOnPractitionerFacilityCurrentStaffTabDropDownMenu(String practitionerFacilityName, String role) throws InterruptedException {
        waitForElementToBeVisible(driver, practitioner_facility_current_staff_tab_table, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(practitioner_facility_name_link_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        Map<String,String> practitionerFacility = ImmutableMap.of("Practitioner Facility Name", practitionerFacilityName, "System Role", role);
        tables.getPractitionerFacilityCurrentStaffProviderActions(practitionerFacility);
    }

    //@Step
    public void selectRemoveFromDropDownMenu() throws InterruptedException {
        selectActionFromDropDown("Remove");
    }
    public void selectEditFromDropDownMenu() throws InterruptedException {
        selectActionFromDropDown("Edit");
    }
    public void selectChangeClinicFromDropDownMenu() throws InterruptedException {
        selectActionFromDropDown("Change Clinic");
    }

    public void selectActionFromDropDown(String action) throws InterruptedException {
        Thread.sleep(1000);
        By remove_dropdown_item = By.xpath("//a/span[text() = '" + action + "']");
        waitForElementToBeEnabled(driver, remove_dropdown_item, 10);
        Thread.sleep(1000);
        WebElement transfer_item = driver.findElement(remove_dropdown_item);
        Thread.sleep(1000);
        scrollTop(transfer_item);
        Thread.sleep(1000);
        transfer_item.click();
        Thread.sleep(1000);
    }

    public void clickPreviousStaffTab() throws InterruptedException {
        waitForElementToBeVisible(driver, previous_staff_tab, 10);
        Thread.sleep(2000);
        previous_staff_tab.click();
    }

    public void clickOnPractitionerFacilityPreviousTabDropDownMenu(String practitionerFacilityName, String role) throws InterruptedException {
        waitForElementToBeVisible(driver, practitioner_facility_previous_staff_tab_table, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(practitioner_facility_name_link_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        //String practitionerFacilityName11 ="Gabrielle Marie Cunningham | PONDEROSA PRIMARY CARE CENTRE";
        Map<String,String> practitionerFacility = ImmutableMap.of("Practitioner Facility Name", practitionerFacilityName, "System Role", role);
        tables.getPractitionerFacilityPreviousStaffActions(practitionerFacility);
    }

    public void selectReAddFromDropDownMenu() throws InterruptedException {
        selectActionFromDropDown("Re-add");
    }

    public void clickCurrentStaffTab() throws InterruptedException {
        waitForElementToBeVisible(driver, current_staff_tab, 10);
        Thread.sleep(2000);
        current_staff_tab.click();
    }

    public void refreshBrowser() throws InterruptedException {
        driver.navigate().refresh();
    }

    public void clickAddPatient() throws InterruptedException {
        waitForElementToBeVisible(driver, add_patient_button, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(add_patient_button_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        add_patient_button.click();
    }

    public void enterPatientPHN(String patientPHN) throws InterruptedException {
        waitForElementToBeLocated(driver, patient_phn_input_component_1, 10);
        Thread.sleep(1000);
        patient_phn_input_component.click();
        Thread.sleep(1000);
        patient_phn_input_component.clear();
        Thread.sleep(1000);
        patient_phn_input_component.sendKeys(patientPHN);
        Thread.sleep(1000);
    }

    public void clickSearchForPatientPHNButton() throws InterruptedException {
        waitForElementToBeVisible(driver, search_patient_button, 10);
        Thread.sleep(1000);
        search_patient_button.click();
    }

    public void clickAddFoundedPatient() throws InterruptedException {
        waitForElementToBeVisible(driver, add_founded_patient_button, 10);
        Thread.sleep(1000);
        add_founded_patient_button.click();
    }

    public void clickCloseModalForm() throws InterruptedException {
        waitForElementToBeVisible(driver, close_modal_form_button, 10);
        Thread.sleep(1000);
        close_modal_form_button.click();
    }

    public String getActualEmpaneledPatientFirstNameForValidation() throws InterruptedException {
        //log("/*----scroll down a bit --*/");
        //((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
        //Thread.sleep(2000);
        waitForElementToBeLocated(driver, empaneled_patient_first_name_actual_field_value_1, 10);
        Thread.sleep(2000);
        empaneled_patient_first_name_actual_field_value.isDisplayed();
        return (empaneled_patient_first_name_actual_field_value.getText());
    }

    public void clickOnEmpaneledPatientCurrentPanelTabDropDownMenu(String empaneledPatientFirstName, String empaneledPatientLastName) throws InterruptedException {
        waitForElementToBeVisible(driver, empaneled_patients_current_panel_tab_table, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(empaneled_patient_first_name_actual_field_value_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        Map<String,String> empaneledPatient = ImmutableMap.of("Last Name", empaneledPatientLastName, "First Name", empaneledPatientFirstName);
        tables.getEmpaneledPatientCurrentPanelActions(empaneledPatient);
    }

    public void clickYesOnModalRemovePatientsForm() throws InterruptedException {
        waitForElementToBeVisible(driver, yes_on_modal_remove_patients_form_button, 10);
        Thread.sleep(1000);
        yes_on_modal_remove_patients_form_button.click();
    }

    public void selectRemovedPanel() throws InterruptedException {
        waitForElementToBeVisible(driver, panels_filter_dropdown_component, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element1 = driver.findElement(panels_filter_dropdown_component_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element1);
        Thread.sleep(2000);
        panels_filter_dropdown_component.click();
        Thread.sleep(2000);
        waitForElementToBeVisible(driver, select_removed_option_for_dropdown_component, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(select_removed_option_for_dropdown_component_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        select_removed_option_for_dropdown_component.click();
    }

    public void selectPanelStatusActiveOption() throws InterruptedException {
        waitForElementToBeLocated(driver, empaneled_patient_status_dropdown_1, 10);
        Thread.sleep(1000);
        empaneled_patient_status_dropdown.click();
        Thread.sleep(1000);
        waitForElementToBeLocated(driver, select_active_from_panel_status_options_1, 10);
        Thread.sleep(2000);
        select_active_from_panel_status_options.click();
        Thread.sleep(2000);
    }

    public void clickProceedOnModalUpdatePanelStatusForm() throws InterruptedException {
        waitForElementToBeVisible(driver, proceed_on_modal_update_panel_status_form_button, 10);
        Thread.sleep(1000);
        proceed_on_modal_update_panel_status_form_button.click();
    }

    public void clickYesOnModalUpdatePanelStatusForm() throws InterruptedException {
        waitForElementToBeVisible(driver, yes_on_modal_update_panel_status_form_button, 10);
        Thread.sleep(1000);
        yes_on_modal_update_panel_status_form_button.click();
    }

    public void selectChangeClinicFirstAvailableOption() throws InterruptedException {
        waitForElementToBeLocated(driver, empaneled_patient_change_clinic_options_dropdown_1, 10);
        Thread.sleep(2000);
        empaneled_patient_change_clinic_options_dropdown.click();
        Thread.sleep(2000);
        waitForElementToBeLocated(driver, select_Capri_Center_from_options_1, 10);
        Thread.sleep(2000);
        select_Capri_Center_from_options.click();
        Thread.sleep(2000);
    }

    public void clickProceedOnModalChangeClinicForm() throws InterruptedException {
        waitForElementToBeVisible(driver, proceed_on_modal_change_clinic_form_button, 10);
        Thread.sleep(1000);
        proceed_on_modal_change_clinic_form_button.click();
    }

    public void clickOnSecondClinicRosteringLink() throws InterruptedException {
        waitForElementToBeVisible(driver, rostering_second_clinic_link, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(rostering_second_clinic_link_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        rostering_second_clinic_link.click();
    }

    public void clickOnMoAPractitionerFacilityCurrentStaffTableRow(String practitionerMoAFacilityName, String role) throws InterruptedException {
        waitForElementToBeVisible(driver, practitioner_facility_current_staff_tab_table, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(moa_practitioner_facility_name_link_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(3000);
        Map<String,String> moa_practitionerFacility = ImmutableMap.of("Practitioner Facility Name", practitionerMoAFacilityName, "System Role", role);
        tables.clickOnPractitionerFacilityTableRowMoA(moa_practitionerFacility);
    }

    public void clickDetailsTab() throws InterruptedException {
        waitForElementToBeVisible(driver, details_tab, 10);
        Thread.sleep(2000);
        details_tab.click();
    }

    public void checkedManageFacilityCheckBox() throws InterruptedException {
        waitForElementToBeVisible(driver, manage_facility_checkbox, 10);
        Thread.sleep(2000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(manage_facility_checkbox_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        //verify that it is Checked, if not -> change to checked.
        int count = 0;
        while(count < 1) {
            try {
                driver.findElement(By.xpath("//img[@alt='True']"));
                log("checkbox status is already 'Checked'");
                log("do nothing");
                break;
            } catch (Exception ex) {
                log("checkbox status is - 'UnChecked'");
                log("Change status to -> Checked");
                pencil_edit_button.click();
                Thread.sleep(2000);
                click_manage_facility_checkbox.click();
                Thread.sleep(2000);
                log("/*----scroll down a bit --*/");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,70)", "");
                Thread.sleep(2000);
                save_button.click();
                count = count + 1;
            }
        }
    }

    public void selectMOARoleOption(String role) throws InterruptedException {
        waitForElementToBeLocated(driver, role_dropdown_1, 10);
        Thread.sleep(1000);
        role_dropdown.click();
        Thread.sleep(1000);
        waitForElementToBeLocated(driver, select_MoA_from_roles_options_1, 10);
        Thread.sleep(2000);
        select_MoA_from_roles_options.click();
        Thread.sleep(2000);
    }

    public void selectMoAAgnesPhillipPractitioner(String practitioner) throws InterruptedException {
        waitForElementToBeLocated(driver, practitioner_search_component_1, 10);
        Thread.sleep(2000);
        practitioner_search_component_search_component.sendKeys(practitioner);
        Thread.sleep(5000);
        select_MoA_Agnes_Phillip_from_practitioners_dropdown_list.click();
        Thread.sleep(1000);
    }

    public String getActualMoAPractitionerFacilityNameForValidation() throws InterruptedException {
        waitForElementToBeLocated(driver, practitioner_MoA_facility_name_actual_field_value_1, 10);
        Thread.sleep(2000);
        practitioner_MoA_facility_name_actual_field_value.isDisplayed();
        return (practitioner_MoA_facility_name_actual_field_value.getText());
    }

    public void clickPanelSharing() throws InterruptedException {
        waitForElementToBeVisible(driver, panel_sharing_link, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(panel_sharing_link_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        panel_sharing_link.click();
    }

    public void clickGiveAccessToTab() throws InterruptedException {
        waitForElementToBeVisible(driver, give_access_to_tab, 10);
        Thread.sleep(2000);
        give_access_to_tab.click();
    }

    public void setToTrueDelegationCheckBox(String practitionerFacilityName, String role) throws InterruptedException {
        waitForElementToBeVisible(driver, practitioner_facility_previous_staff_tab_table, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(practitioner_moa_name_link_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        Map<String,String> practitionerRecord = ImmutableMap.of("Name", practitionerFacilityName, "Role", role);
        WebElement cellDelegationCheckElement= tables.getDelegationCheckedStatusInTableCell(practitionerRecord);
        //check status and Set to True if it is not.
        String statusText = cellDelegationCheckElement.getText();
        log("Status of delegation checkbox is: " + statusText);
        if (Objects.equals(statusText, "True\nEdit Manage My Panel & Profile"))
        {
            log("checkbox status is already 'Checked'");
            log("do nothing");
        } else if (Objects.equals(statusText, "False\nEdit Manage My Panel & Profile"))
        {
            log("checkbox status is - 'UnChecked'");
            log("Change status to -> Checked");
            cellDelegationCheckElement.click();
            click_manage_manage_my_panel_profile_checkbox.click();
            Thread.sleep(2000);
            log("/*6.----Click somewhere else --*/");
            clickGiveAccessToTab();
            Thread.sleep(5000);
            log("/*7.----Click 'Save' button --*/");
            clickSaveGiveAccessToButton();
        }
    }

    public void clickSaveGiveAccessToButton() throws InterruptedException {
        waitForElementToBeVisible(driver, save_give_access_to_button, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(save_give_access_to_button_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        save_give_access_to_button.click();
    }

    public void clickMoAPanelSharing() throws InterruptedException {
        waitForElementToBeVisible(driver, basecard, 10);
        Thread.sleep(2000);
        WebElement baseCard = driver.findElement(By.xpath(".//omnistudio-omniscript-custom-lwc"));
        //String baseCardText = baseCard.getText();
        List<WebElement> flexCardsRows = baseCard.findElements(By.xpath(".//omnistudio-flex-card-state"));
        int numberOfRows = flexCardsRows.size();
        //String flexCardRowText = flexCardsRows.get(1).getText();
        //flexCardsRows.get(0).click();
        int h = 0;
        for (int i = 0; i < numberOfRows; i++) {
            String flexCardRowText = flexCardsRows.get(i).getText();
            //log("get Text: " +'\n' + flexCardRowText);
            if (flexCardRowText.contains("CASTLEGAR MED FAMILY CLINIC"))
            {
                log("Related Flex Card has founded: " + '\n' + flexCardRowText);
                h = i;
            }
        }
        log("Click related 'Panel Shared' link");
        log("/*----scroll down a bit --*/");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,900)");
        Thread.sleep(2000);
        WebElement cellPanelSharing = flexCardsRows.get(h).findElement(By.xpath(".//span[text()='Panel Sharing']"));
        log("/*----jump to component --*/");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", cellPanelSharing);
        Thread.sleep(2000);
        //String cellText = cellPanelSharing.getText();
        cellPanelSharing.click();
        Thread.sleep(2000);
    }

    public void clickOnPractitionerGrantedAccessByTableRow(String practitionerGrantedByFacilityPanelName, String role) throws InterruptedException {
        waitForElementToBeVisible(driver, practitioner_granted_access_by_tab_table, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(practitioner_panel_name_link_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        Map<String,String> directors_practitionerPanelName = ImmutableMap.of("Panel", practitionerGrantedByFacilityPanelName, "Role", role);
        Thread.sleep(2000);
        WebElement cell = tables.getOnGrantedAccessByTableCell(directors_practitionerPanelName);
        WebElement panelLink = cell.findElement(practitioner_panel_name_link_1);
        panelLink.click();
    }

    public boolean isEmpaneledPatientFoundValidation(String empaneledPatientFirstName) throws InterruptedException {
        boolean isPatientFound = false;
        for(int i = 1; i <= 40; i++ ) {
            log("/*----scroll down --*/");
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
            Thread.sleep(2000);
            if (!isDisplayed(empaneled_patient_first_name_actual_field_value_1)) {
                log(i +"-try to find Empaneled: " + empaneledPatientFirstName + " " + " not found, re-try!");
                log( "wait for 10 sec");
                Thread.sleep(10000);
                log( "Refresh the browser");
                refreshBrowser();
                Thread.sleep(5000);
            } else {
                log("/*---Empaneled Patient --> " + empaneledPatientFirstName + " " + " present on the page--*/");
                isPatientFound = true;
                break;
            }
        }
        return isPatientFound;
    }

    public void clickOnRiverViewMedFamilyFacility() throws InterruptedException {
        waitForElementToBeVisible(driver, riverview_med_family_facility_link, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(riverview_med_family_facility_link_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        riverview_med_family_facility_link.click();
    }

    public void clickOnClinicDetailsLink() throws InterruptedException {
        waitForElementToBeVisible(driver, current_details_link, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(current_details_link_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        current_details_link.click();
    }

    public void isEditClinicPageDisplayed_MoA() throws InterruptedException {
        if (!isDisplayed(edit_clinic_page_displayed_validation)) {
            log("*/--- Edit Clinic Page has not shown up");
            Thread.sleep(2000);
            throw new RuntimeException("Exception: Validation for Clinic Page show up - failed!!!");
        } else {
            log("*/--- Edit Clinic Page has shown up");
        }
    }

    public void clickClinicAndProviderRegistryLink() throws InterruptedException {
        waitForElementToBeVisible(driver, clinic_and_provider_registry_link, 10);
        Thread.sleep(5000);
        WebElement element = driver.findElement(clinic_and_provider_registry_link_1);
        Thread.sleep(5000);
        clinic_and_provider_registry_link.click();
    }

    public void clickSearchAllClinicsInBCLink() throws InterruptedException {
        waitForElementToBeVisible(driver, search_all_clinics_in_BC_link, 10);
        Thread.sleep(5000);
        WebElement element = driver.findElement(search_all_clinics_in_BC_link_1);
        Thread.sleep(5000);
        clinic_and_provider_registry_link.click();
    }

    public void enterClinicNameInSearchBox(String clinicName) throws InterruptedException {
        waitForElementToBeLocated(driver, clinic_name_search_box_component_1, 10);
        Thread.sleep(1000);
        clinic_name_search_box_component.click();
        Thread.sleep(1000);
        clinic_name_search_box_component.clear();
        Thread.sleep(1000);
        clinic_name_search_box_component.sendKeys(clinicName);
        Thread.sleep(1000);
    }

    public void clickSearchForClinics() throws InterruptedException {
        waitForElementToBeVisible(driver, search_clinics_button, 10);
        Thread.sleep(1000);
        log("/*----jump to component --*/");
        WebElement element = driver.findElement(search_clinics_button_1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(2000);
        search_clinics_button.click();
    }

}
