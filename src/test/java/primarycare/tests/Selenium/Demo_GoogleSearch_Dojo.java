package primarycare.tests.Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import primarycare.pages.LoginPage;

public class Demo_GoogleSearch_Dojo {
    @Test
    //public static void main(String[] args) throws InterruptedException
    public void Can_Search_In_Google () throws Exception{
        // Set the system property for the Chrome driver

        //for Windows
        System.out.println("/*1.---Let's try to run in Windows Chrome");
        System.setProperty("webdriver.chrome.driver", "/Users/igor.emelyanov/Downloads/primarycareauto/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        // Create a new instance of the Chrome driver
        ChromeDriver driver = new ChromeDriver(ops);
        //WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();

        // Navigate to Google.com
        System.out.println("/*2.---Navigate to Google.com");
        driver.get("https://www.google.com");

        // Find the search box element and enter "Dojo computer"
        System.out.println("/*3.---Find the search box element and enter 'Dojo computer'");
        WebElement searchBox = driver.findElement(By.name("q"));
        Thread.sleep(3000);
        searchBox.sendKeys("Dojo computer");
        Thread.sleep(3000);

        // Press the Enter key to perform the search
        System.out.println("/*4.---Press the Enter key to perform the search");
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(10000);

        // Wait for the search results to load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the title of the first search result
        System.out.println("/*5.---Print the title of the first search result");
        WebElement firstResult = driver.findElement(By.cssSelector("h3.LC20lb.DKV0Md"));
        System.out.println(firstResult.getText());

        // Close the browser
        driver.quit();
    }
}
