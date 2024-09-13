package testNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Topic_09_Parameter {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    By emailTextbox = By.xpath("//*[@id='email']");
    By passwordTextbox = By.xpath("//*[@id='pass']");
    By loginButton = By.xpath("//*[@id='send2']");

    @Parameters({"browser","version"})
    @BeforeClass
    public void beforeClass(String browserName, String browserVersion) {
        driver = getBrowserDriver(browserName);


        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @Parameters({"environment"})
    @Test
    public void TC_01_LoginToSystem(String environmentName) {
        driver.get(getEnvironment(environmentName) + "/index.php/customer/account/login/");

        driver.findElement(emailTextbox).sendKeys("selenium_11_01@gmail.com");
        driver.findElement(passwordTextbox).sendKeys("111111");
        driver.findElement(loginButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("selenium_11_01@gmail.com"));

        // ....

        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
    }

    private WebDriver getBrowserDriver(String browserName){
        WebDriver driver;
        if (browserName.equals("firefox")){
            driver = new FirefoxDriver();
        }
        else if (browserName.equals("chrome")){
            driver = new ChromeDriver();
        } else{
            throw new RuntimeException("Browser name is not valid");
        }
        return driver;
    }

    private String getEnvironment(String environmentName){
        WebDriver driver;
        String urlValue;
        if (environmentName.equals("dev")){
            urlValue = "dev.facebook.com";
        } else if (environmentName.equals("testing")){
            urlValue = "testing.facebook.com";
        } else if (environmentName.equals("staging")){
            urlValue = "staging.facebook.com";
        } else {
            throw new RuntimeException("Environment name is not valid");
        }
        return urlValue;
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}