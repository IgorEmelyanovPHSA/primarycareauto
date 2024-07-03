package rbauction.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    /*---------Properties-------*/
    @FindBy(id = "username")
    private WebElement textUserName;

    @FindBy(id = "password")
    private WebElement textPassword;

    @FindBy(id = "Login")
    private WebElement login_button;

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement input_username_provider_portal;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement input_password_provider_portal;

    @FindBy(xpath = "//button[@type = 'button']")
    private WebElement login_button_provider_portal;


    /*---------Constructor-------*/
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    /*-------------Methods--------------*/
    public PortalHealthConnectRegistryPage openPortalHealthConnectRegistryPage() throws Exception {
        driver.navigate().to(Utils.getEnvConfigProperty("url_direct_link"));
        return new PortalHealthConnectRegistryPage(driver);
    }

    public ProviderPortalHomePage loginProviderPortalHomePageAsDirector() throws Exception {
        driver.navigate().to(Utils.getEnvConfigProperty("url_direct_link"));
        Thread.sleep(2000);
        waitForElementToBeVisible(driver, input_username_provider_portal, 10);
        //input_username_provider_portal.sendKeys(Utils.getEnvConfigProperty("user_DIRECTOR_Portal"));
        //input_password_provider_portal.sendKeys(Utils.getEnvConfigProperty("password_DIRECTOR_Portal"));
        //login_button_provider_portal.click();
        return new ProviderPortalHomePage(driver);
    }

    public HealthCloudConsolePage loginAsSysAdmin() throws Exception {
        driver.navigate().to(Utils.getEnvConfigProperty("url_sf_admin_side"));
        textUserName.sendKeys(Utils.getEnvConfigProperty("user_SYS_ADMIN"));
        textPassword.sendKeys(Utils.getEnvConfigProperty("password_SYS_ADMIN_PW"));
        click(login_button);
        return new HealthCloudConsolePage(driver);
    }

    public ProviderPortalHomePage loginProviderPortalHomePageAsMoA() throws Exception {
        driver.navigate().to(Utils.getEnvConfigProperty("url_provider_portal_direct_link"));
        Thread.sleep(2000);
        waitForElementToBeVisible(driver, input_username_provider_portal, 10);
        input_username_provider_portal.sendKeys(Utils.getEnvConfigProperty("user_MOA_Portal"));
        input_password_provider_portal.sendKeys(Utils.getEnvConfigProperty("password_MOA_Portal"));
        login_button_provider_portal.click();
        return new ProviderPortalHomePage(driver);
    }

    public PortalBCSCHealthConnectRegistryPage openPortalBCSCHealthConnectRegistryPage() throws Exception {
        driver.navigate().to(Utils.getEnvConfigProperty("url_auth_citizen_registration_BCSC_link"));
        return new PortalBCSCHealthConnectRegistryPage(driver);
    }

    public ProviderPortalHomePage loginProviderPortalHomePageAsTier1() throws Exception {
        driver.navigate().to(Utils.getEnvConfigProperty("url_provider_portal_direct_link"));
        Thread.sleep(2000);
        waitForElementToBeVisible(driver, input_username_provider_portal, 10);
        input_username_provider_portal.sendKeys(Utils.getEnvConfigProperty("user_TIER1_Portal"));
        input_password_provider_portal.sendKeys(Utils.getEnvConfigProperty("password_TIER1_Portal"));
        login_button_provider_portal.click();
        return new ProviderPortalHomePage(driver);
    }



}
