package primarycare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class Tables extends BasePage {
    /*---------Properties-------*/
    @FindBy(xpath = "(.//div[@class='slds-table_header-fixed_container slds-scrollable_x'])[1]")
    private WebElement practitioner_facility_current_staff_Table;

    @FindBy(xpath = "(.//div[@class='slds-table_header-fixed_container slds-scrollable_x'])[2]")
    private WebElement practitioner_facility_previous_staff_Table;

    @FindBy(xpath = "(.//div[@class='slds-table_header-fixed_container slds-scrollable_x'])[1]")
    private WebElement empaneled_patient_current_panel_Table;

    @FindBy(xpath = "(.//div[@class='slds-table_header-fixed_container slds-scrollable_x'])[2]")
    private WebElement panel_sharing_give_access_Table;

    @FindBy(xpath = ".//div[@class='slds-table_header-fixed_container slds-scrollable_x']")
    private WebElement granted_access_by_Table;

    /*---------Constructor-------*/
    public Tables(WebDriver driver) {
        super(driver);
    }

    /*-------------Methods--------------*/
    public GenericTable getPractitionerFacilityCurrentStaffMoATable() {
        waitForTextToBePresent(driver, practitioner_facility_current_staff_Table ,30, "Medical Office Assistant");
        return new GenericTable(practitioner_facility_current_staff_Table);
    }

    public GenericTable getPractitionerFacilityCurrentStaffProviderTable() {
        waitForTextToBePresent(driver, practitioner_facility_current_staff_Table ,30, "Provider");
        return new GenericTable(practitioner_facility_current_staff_Table);
    }

    public GenericTable getPractitionerFacilityPreviousStaffTable() {
        waitForTextToBePresent(driver, practitioner_facility_previous_staff_Table ,30, "Provider");
        return new GenericTable(practitioner_facility_previous_staff_Table);
    }

    public GenericTable getEmpaneledPatientCurrentPanelTable() {
        waitForTextToBePresent(driver, empaneled_patient_current_panel_Table,30, "First Name");
        return new GenericTable(empaneled_patient_current_panel_Table);
    }

    public GenericTable getPanelSharingGiveAccessToTable() {
        waitForTextToBePresent(driver, panel_sharing_give_access_Table ,30, "Manage My Panel & Profile");
        return new GenericTable(panel_sharing_give_access_Table);
    }

    public GenericTable getGrantedAccessByTable() {
        waitForTextToBePresent(driver, granted_access_by_Table ,30, "Panel");
        return new GenericTable(granted_access_by_Table);
    }

    //@Step
    public void getPractitionerFacilityCurrentStaffProviderActions(Map<String, String> searchCriteria) throws InterruptedException {
        WebElement element = getPractitionerFacilityCurrentStaffRowProvider(searchCriteria).get("Actions");
        Thread.sleep(2000);
        moveToElement(element);
        Thread.sleep(2000);
        element.click();
    }

    public void getPractitionerFacilityPreviousStaffActions(Map<String, String> searchCriteria) throws InterruptedException {
        WebElement element = getPractitionerFacilityPreviousStaffRow(searchCriteria).get("Actions");
        Thread.sleep(2000);
        moveToElement(element);
        Thread.sleep(2000);
        element.click();
    }

    public void getEmpaneledPatientCurrentPanelActions(Map<String, String> searchCriteria) throws InterruptedException {
        WebElement element = getEmpaneledPatientCurrentPanelRow(searchCriteria).get("Actions");
        Thread.sleep(2000);
        moveToElement(element);
        Thread.sleep(2000);
        element.click();
    }

    // ------  TABLES -------
    public GenericTable getPractitionerFacilityTable() {
        waitForTextToBePresent(driver, practitioner_facility_current_staff_Table ,30, "Practitioner Facility Name");
        return new GenericTable(practitioner_facility_current_staff_Table);
    }

    // ------  TABLE ROWS -------
    public Map<String, WebElement> getPractitionerFacilityCurrentStaffRowProvider(Map<String, String> searchCriteria) {
        return getTableRow(searchCriteria, getPractitionerFacilityCurrentStaffProviderTable());
    }

    public Map<String, WebElement> getPractitionerFacilityCurrentStaffRowMoA(Map<String, String> searchCriteria) {
        return getTableRow(searchCriteria, getPractitionerFacilityCurrentStaffProviderTable());
    }

    public Map<String, WebElement> getPractitionerFacilityPreviousStaffRow(Map<String, String> searchCriteria) {
        return getTableRow(searchCriteria, getPractitionerFacilityPreviousStaffTable());
    }

    public Map<String, WebElement> getEmpaneledPatientCurrentPanelRow(Map<String, String> searchCriteria) {
        return getTableRow(searchCriteria, getEmpaneledPatientCurrentPanelTable());
    }

    public Map<String, WebElement> getPractitionerPanelSharingGiveAccessToRow(Map<String, String> searchCriteria) {
        return getTableRow(searchCriteria, getPanelSharingGiveAccessToTable());
    }

    public Map<String, WebElement> getGrantedAccessByRow(Map<String, String> searchCriteria) {
        return getTableRow(searchCriteria, getGrantedAccessByTable());
    }


    // ------  TABLE ACTIONS -------
    public void clickOnPractitionerFacilityTableRowMoA(Map<String, String> searchCriteria) throws InterruptedException {
        WebElement element = getPractitionerFacilityCurrentStaffRowMoA(searchCriteria).get("Practitioner Facility Name");
        Thread.sleep(2000);
        moveToElement(element);
        Thread.sleep(2000);
        element.click();
    }

    public WebElement getDelegationCheckedStatusInTableCell(Map<String, String> searchCriteria) throws InterruptedException {
        WebElement cellElement = getPractitionerPanelSharingGiveAccessToRow(searchCriteria).get("Manage My Panel & Profile");
        Thread.sleep(2000);
        moveToElement(cellElement);
        Thread.sleep(2000);
        //element.click();
        //String textStatus = cellElement.getText();
        return cellElement;
    }

    public WebElement getOnGrantedAccessByTableCell(Map<String, String> searchCriteria) throws InterruptedException {
        WebElement cellElement = getGrantedAccessByRow(searchCriteria).get("Panel");
        Thread.sleep(2000);
        moveToElement(cellElement);
        //element.click();
        Thread.sleep(2000);
        return cellElement;
    }

    // ------  PRIVATE -------
    private Map<String, WebElement> getTableRow(Map<String, String> searchCriteria, GenericTable table) {
        return table.getMappedRow(searchCriteria);
    }



}
