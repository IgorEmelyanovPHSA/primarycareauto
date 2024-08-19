package rbauction.tests;

import rbauction.pages.LoginPage;
import rbauction.pages.TestRailManager;
import rbauction.pages.Utils;
import org.apache.commons.io.output.TeeOutputStream;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class BaseTest_RBAuction {
    public final static SimpleDateFormat LOG_TIMESTAMP_FORMAT = new SimpleDateFormat("HH:mm:ss.SSS");
    protected DecimalFormat df = new DecimalFormat("0.00");
    protected String TestcaseID;
    public WebDriver driver;
    private ByteArrayOutputStream logOutputSteps;
    protected LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        log("Environment: "+ Utils.getTargetEnvironment());
        captureBothStreams();
        ///// for Mac local
        //System.setProperty("webdriver.chrome.driver", "/Users/enya/immsauto/chromedriver");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
        //driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        //loginPage = new LoginPage(getDriver());
        ////
        ///// for Ubuntu GitHub Actions
        //System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox");
        //options.addArguments("--disable-dev-shm-usage");
        //options.addArguments("--headless");
        //driver = new ChromeDriver(options);
        //driver.manage().window().maximize();
        //loginPage = new LoginPage(getDriver());
        ////
        ///// for Windows local and Jenkins
        //ChromeOptions options = new ChromeOptions();
        //log("DEBUG: SetUp  --headless");
        //options.addArguments("--headless");
        //log("DEBUG: SetUp  --disable-gpu");
        //options.addArguments("--disable-gpu");//disable the use of GPU hardware acceleration
        //log("DEBUG: SetUp before --no-sandbox");
        //options.addArguments("--no-sandbox"); //this flag killing 100% CPU//https://github.com/SeleniumHQ/selenium/issues/13872


        //options.addArguments("--disable-extensions");
        //options.addArguments("--disable-web-security");

        //log("DEBUG: SetUp remote-allow-origins");
        //options.addArguments("--remote-allow-origins=*");

        //log("DEBUG: SetUp new Chrome (Options)");
        //driver = new ChromeDriver(options);

        try {
            log("DEBUG: SetUp 'System.setProperty'");
            System.setProperty("webdriver.chrome.driver", "/Users/igor.emelyanov/Downloads/primarycareauto/chromedriver.exe");
            log("DEBUG: SetUp 'new ChromeDriver()'");
            driver = new ChromeDriver();
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize FUCKING Webdriver", e);
        }
        log("DEBUG: SetUp maximize ");
        driver.manage().window().maximize();
        log("DEBUG: SetUp LoginPage(getDriver)");
        loginPage = new LoginPage(getDriver());
    }

    /////////////////After///////////////////

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result){
        log("DEBUG: tearDown very beginning");
        try {
            if(Utils.shoudIUpdateTestRail()){
                if (result.getStatus() == ITestResult.SUCCESS) {
                    TestRailManager.addResultsForTestCase(TestcaseID, TestRailManager.TEST_CASE_PASSED_STATUS, "", logOutputSteps.toString());
                } else if (result.getStatus() == ITestResult.FAILURE) {
                    TestRailManager.addResultsForTestCase(TestcaseID, TestRailManager.TEST_CASE_FAILED_STATUS, result.getThrowable().toString(), logOutputSteps.toString());
                }
            } else {
                log("Test Rail will not be updated.");
            }
        } catch (Exception e) {
            log("Test Rail was not updated: "+e);
        }
        if (driver!=null) {
            log("DEBUG: tearDown deleteCookies");
            driver.manage().deleteAllCookies();
            log("DEBUG: tearDown driver.quit - start");
            driver.quit();
            log("DEBUG: tearDown  driver.quit -successful");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    private void captureBothStreams() {
        logOutputSteps = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(logOutputSteps);
        TeeOutputStream bothStreams = new TeeOutputStream(ps, System.out);
        PrintStream both = new PrintStream(bothStreams);
        System.setOut(both);
    }

    public ByteArrayOutputStream getLogOutputSteps() {
        return logOutputSteps;
    }

    public static String getLogTime() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return LOG_TIMESTAMP_FORMAT.format(timestamp);
    }

    public static void log(String msg) {
        System.out.println(getLogTime() + " " + msg);
    }

}