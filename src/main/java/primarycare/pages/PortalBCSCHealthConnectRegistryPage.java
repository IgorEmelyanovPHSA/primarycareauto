package primarycare.pages;

import static primarycare.pages.Utils.getEnvConfigProperty;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PortalBCSCHealthConnectRegistryPage extends BasePage{

    /*---------Properties-------*/
    @FindBy(xpath = ".//button[text() = 'BCSC Login']")
    private WebElement bcsc_login_button;

    @FindBy(xpath = ".//h2[text() = 'Test with username and password']")
    private WebElement test_with_username_password_button;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement input_username_bcsc_citizen_registration;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement input_password_bcsc_citizen_registration;

    @FindBy(xpath = ".//button[text() = 'Continue']")
    private WebElement login_continue_button_bcsc_citizen_registration_portal;

    @FindBy(xpath = "//div/h1[text()='Register yourself to get a family doctor or nurse practitioner']")
    private static WebElement register_yourself_to_get_doctor_page_validation;

    @FindBy(xpath = ".//span[text() = 'Next']")
    private WebElement next_button;

    @FindBy(xpath = "//div/h1[text()='Who is registering?']")
    private static WebElement who_is_registering_page_validation;

    /*---------Constructor-------*/
    public PortalBCSCHealthConnectRegistryPage(WebDriver driver) {
        super(driver);
    }




    /*-------------Methods--------------*/
    public void clickBCSCLoginButton() throws InterruptedException {
        waitForElementToBeVisible(driver, bcsc_login_button, 10);
        bcsc_login_button.click();
    }

    public void clickTestWithUsernameAndPasswordButton() throws InterruptedException {
        waitForElementToBeVisible(driver, test_with_username_password_button, 10);
        test_with_username_password_button.click();
    }

    public void loginAsBCSC() throws Exception {
        waitForElementToBeVisible(driver, input_username_bcsc_citizen_registration, 10);
        Thread.sleep(1000);
        input_username_bcsc_citizen_registration.sendKeys(getEnvConfigProperty("user_BCSC_card"));
        Thread.sleep(1000);
        input_password_bcsc_citizen_registration.sendKeys(getEnvConfigProperty("password_BCSC_card"));
        Thread.sleep(1000);
        login_continue_button_bcsc_citizen_registration_portal.click();
    }

    public static boolean validateRegisterYourselfToGetDoctorPageDisplayed() throws InterruptedException {
        try {
            waitForElementToBeVisible(driver, register_yourself_to_get_doctor_page_validation, 10);
            log("/*---Home Register to get a doctor/nurse page - shown up");
        } catch (Exception e) {
            log("/*---Home Register to get a doctor/nurse page has NOT show up");
            throw e;
        }
        return false;
    }

    public void clickNextButton() throws InterruptedException {
        waitForElementToBeVisible(driver, next_button, 10);
        Thread.sleep(1000);
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

}
