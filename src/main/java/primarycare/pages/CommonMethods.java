package primarycare.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class CommonMethods extends BasePage {
    /*---------Properties-------*/
    private static By appsLauncher = By.xpath("//div[@class='slds-icon-waffle']");
    private By healthCloudConsoleTitle = By.xpath(".//span[@title='Health Cloud Console']");
    private By appsHealthCloudConsole = By.xpath("//p[text()='Health Cloud Console']");

//    @FindBy(xpath = "//div[@class= 'slds-icon-waffle']")
//    private WebElement is_waffle_icon_displayed;
//    private static By is_waffle_icon_displayed_1 = By.xpath("//div[@class= 'slds-icon-waffle']");

    @FindBy(xpath = "//button[@title = 'Show Navigation Menu']")
    private WebElement navigator_menu_dropdown;
    private By navigator_menu_dropdown_1 = By.xpath("//button[@title = 'Show Navigation Menu']");

    @FindBy(xpath = "//span/span[text() = 'Home']")
    private WebElement select_Home_from_dropdown;
    private By select_Home_from_dropdown_1 = By.xpath("//span/span[text() = 'Home']");

    @FindBy(xpath = "//span/span[text() = 'Create New Registration']")
    private WebElement select_CreateNewRgistration_from_dropdown;
    private By select_CreateNewRgistration_from_dropdown_1 = By.xpath("//span/span[text() = 'Create New Registration']");

    @FindBy(xpath = "//button[@aria-label = 'Search']")
    private WebElement searchAssistant;

    //@FindBy(xpath = "//input[@placeholder = 'Search Accounts and more...']")
    //private WebElement searchInput;
    @FindBy(xpath = "//input[@placeholder = 'Search...']")
    private WebElement searchInput;


    @FindBy(xpath = "(//a[@title='Sandy Prior'])[2]")
    private WebElement patient_founded;
    private By patient_Sandy_Prior_founded_1 = By.xpath("(//a[@title='Sandy Prior'])[2]");

    @FindBy(xpath = "(//a[@title='Kenton Troup'])[2]")
    private WebElement patient_Kenton_founded;
    private By patient_Kenton_founded_1 = By.xpath("(//a[@title='Kenton Troup'])[2]");

    @FindBy(xpath = ".//button[@aria-label = 'Search']")
    private WebElement search_assistant;
    private By search_assistant1 = By.xpath(".//button[@aria-label = 'Search']");

    @FindBy(xpath = ".//input[@placeholder = 'Search...']")
    private WebElement search_input;
    private By search_input1 = By.xpath(".//input[@placeholder = 'Search...']");

    @FindBy(xpath = "(.//lightning-formatted-rich-text[@class = 'primary slds-truncate slds-rich-text-editor__output'])[1]")
    private WebElement profile_in_search_dropdown;
    private By profile_in_search_dropdown_ = By.xpath("(.//lightning-formatted-rich-text[@class = 'primary slds-truncate slds-rich-text-editor__output'])[1]");

    @FindBy(xpath = "(//a[@title='Hollis Violette'])[2]")
    private WebElement family_member_Hollis_Violette_founded;
    private By family_member_Hollis_Violette_founded_1 = By.xpath("(//a[@title='Hollis Violette'])[2]");


    /*---------Constructor-------*/
    public CommonMethods(WebDriver driver) {
        super(driver);
    }


    /*-------------Methods--------------*/
    public void goToHealthCloudConsolePageIfNeededAndConfirmPageIsDisplayed() throws InterruptedException {
        //log("/*-- Close all open tabs --*/");
        //closeAllHealthCloudConsoleTabs();
        //Thread.sleep(5000);
        if (isDisplayed(healthCloudConsoleTitle)) {
            log("/*-- User already on Health Cloud Console Page --*/");
        } else {
            log("/*-- Navigate to Health Cloud Console Page --*/");
            selectHealthCloudConsoleApp();
            Thread.sleep(2000);
        }
        // Thread.sleep(2000);
        // log("/*-- Close all open tabs --*/");
        // closeAllHealthCloudConsoleTabs();
        //if (isDisplayed(supplyLocation)) {
        //    log("/*-- User is already on Supply loc--*/");
        // } else {
        //    log("/*-- Click Dropdown Menu --*/");
        //   click(dropdownMenu);
        //    Thread.sleep(5000);
        //    log("/*-- Navigate and Select Supply Locations --*/");
        //    click(supplyLocationInDropdown);
        //    Thread.sleep(2000);
        //}
        //log("/*-- Close all open tabs --*/");
        //closeAllHealthCloudConsoleTabs();
        //Thread.sleep(2000);
    }

    public static boolean isWaffleIconDisplayed() throws InterruptedException {
        boolean WaffleIconDisplayed = false;
        for(int i = 1; i <= 40; i++ ) {
            if (!isDisplayed(appsLauncher)) {
                log(i +"-try to see the 'Waffle Icon' SF Title Page: "  +  " the 'Waffle Icon' is not showing up yet, re-try!");
                log( "wait for 10 sec");
                Thread.sleep(10000);
                //log( "Refresh the browser");
                //refreshBrowser();
                //Thread.sleep(5000);
            } else {
                log("/*---The 'Waffle Icon' SF Title Page Page "  + "has shown up " + " --*/");
                WaffleIconDisplayed = true;
                Thread.sleep(5000);
                break;
            }
        }
        return WaffleIconDisplayed;
    }

    public void closeAllHealthCloudConsoleTabs() throws InterruptedException {
        do {
            try {
                WebElement closetab = driver.findElement(By.xpath("(.//button[@class = 'slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container'])"));
                click(closetab);
                Thread.sleep(2000);
            } catch (NoSuchElementException e) {
                log("/*---there are no Tab's to close anymore");
            }
        } while (isDisplayed(By.xpath("(.//button[@class = 'slds-button slds-button_icon slds-button_icon-x-small slds-button_icon-container'])")));
    }

    public void selectHomeFromNavigationMenuDropdown() throws InterruptedException {
        waitForElementToBeVisible(driver, navigator_menu_dropdown, 10);
        Thread.sleep(5000);
        navigator_menu_dropdown.click();
        Thread.sleep(5000);
        waitForElementToBeVisible(driver, select_Home_from_dropdown, 10);
        Thread.sleep(5000);
        select_Home_from_dropdown.click();
        Thread.sleep(2000);
    }

    public void selectCreateNewRegistrationFromNavigationMenuDropdown() throws InterruptedException {
        waitForElementToBeVisible(driver, navigator_menu_dropdown, 10);
        navigator_menu_dropdown.click();
        Thread.sleep(2000);
        waitForElementToBeVisible(driver, select_CreateNewRgistration_from_dropdown, 10);
        Thread.sleep(2000);
        select_CreateNewRgistration_from_dropdown.click();
        Thread.sleep(2000);
    }

    public void selectHealthCloudConsoleApp() throws InterruptedException {
        waitForElementToBeLocated(driver, appsLauncher, 10);
        WebElement element = driver.findElement(appsLauncher);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        Thread.sleep(10000);
        waitForElementToBeLocated(driver, appsHealthCloudConsole, 10);
        WebElement element1 = driver.findElement(appsHealthCloudConsole);
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", element1);
        Thread.sleep(2000);
    }

    public void globalSearch(String textToSearch) throws InterruptedException {
        waitForElementToBeVisible(driver, searchAssistant, 10);
        searchAssistant.click();
        Thread.sleep(3000);
        waitForElementToBeVisible(driver, searchInput, 10);
        Thread.sleep(3000);
        searchInput.clear();
        Thread.sleep(3000);
        searchInput.sendKeys(textToSearch);
        Thread.sleep(2000);
        searchInput.sendKeys(Keys.RETURN);
        Thread.sleep(2000);
    }

    public void SearchForCitizen(String citizen) throws InterruptedException {
        waitForElementToBeVisible(driver, search_assistant, 10);
        Thread.sleep(2000);
        WebElement search_navigator = driver.findElement(search_assistant1);
        Thread.sleep(3000);
        search_navigator.click();
        Thread.sleep(3000);
        waitForElementToBeVisible(driver, search_input, 10);
        Thread.sleep(2000);
        WebElement search_input = driver.findElement(search_input1);
        search_input.sendKeys(citizen);
        Thread.sleep(2000);
        search_input.sendKeys(Keys.RETURN);
        Thread.sleep(5000);
    }

    public void SearchForCitizenAlternativeWay(String citizen) throws InterruptedException {
        waitForElementToBeVisible(driver, search_assistant, 10);
        Thread.sleep(2000);
        WebElement search_navigator = driver.findElement(search_assistant1);
        Thread.sleep(3000);
        search_navigator.click();
        Thread.sleep(3000);
        waitForElementToBeVisible(driver, search_input, 10);
        Thread.sleep(2000);
        WebElement search_input = driver.findElement(search_input1);
        search_input.sendKeys(citizen);
        Thread.sleep(2000);
        waitForElementToBeVisible(driver, profile_in_search_dropdown, 10);
        Thread.sleep(2000);
        profile_in_search_dropdown.click();
    }


    public void clickOnFondedPatient(String legalFirstName, String legalLastName) throws InterruptedException {
        waitForElementToBeLocated(driver, patient_Sandy_Prior_founded_1, 10);
        Thread.sleep(2000);
        patient_founded.click();
    }

    public void clickOnFondedKentonPatient(String legalFirstName, String legalLastName) throws InterruptedException {
        waitForElementToBeLocated(driver, patient_Kenton_founded_1, 10);
        Thread.sleep(2000);
        patient_Kenton_founded.click();
    }

    public static void refreshBrowser() throws InterruptedException {
        driver.navigate().refresh();
    }

    public void clickOnFondedHollisVioletteFamilyMember(String legalFirstName, String legalLastName) throws InterruptedException {
        waitForElementToBeLocated(driver, family_member_Hollis_Violette_founded_1, 10);
        Thread.sleep(2000);
        family_member_Hollis_Violette_founded.click();
    }

    public boolean isPatientFoundValidation(String legalFirstName, String legalLastName) throws InterruptedException {
        boolean isPatientFound = false;
        By patientFoundWithParameter = By.xpath("//a[@title='" + legalFirstName + " " + legalLastName + "']");
        for(int i = 1; i <= 40; i++ ) {
            if (!isDisplayed(patientFoundWithParameter)) {
                log(i +"-try to find Patient in list: " + legalFirstName + " " + legalLastName + " not found, re-try!");
                log("wait for 10 sec");
                Thread.sleep(10000);
                refreshBrowser();
                Thread.sleep(5000);
            } else {
                log("/*---Patient --> " + legalFirstName + " " + legalLastName + " present on the page--*/");
                isPatientFound = true;
                Thread.sleep(5000);
                break;
            }
        }
        return isPatientFound;
    }

}
