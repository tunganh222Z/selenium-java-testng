package webdriver;


import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_06_Register {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    private String UserID;
    private String Password;

    @BeforeClass
    public void beforeClass() {


        driver = new

                ChromeDriver();
        driver.manage().

                timeouts().

                implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.guru99.com/v4/");
    }



    @Test
    public void TC_01_Click_VisitHere(){
        //Click ads
        /*
        driver.findElement(By.xpath("//a[text()='here']")).click();
        driver.findElement(
                By.xpath("//div[@id='ad_position_box']//div[@id='dismiss-button']"))
                .click();

         */

        // Click here
        driver.findElement(By.xpath("//a[text()='here']")).click();

        // click ads

    }
    @Test
    public void TC_02_Input_Random_Email(){
        // Generate random email


        // input random email
        driver.findElement(
                        By.xpath("//input[@name='emailid']"))
                .sendKeys("tunganh@gmail.com");

        // click submit
        driver.findElement(
                        By.xpath("//input[@name='btnLogin']"))
                .click();
    }
    @Test
    public void TC_03_get_UserID_Password(){
        // wait until UserID appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // get UserID
        UserID = driver.findElement(
                By.xpath("//td[text()='User ID :']/following-sibling::td"))
                .getText();
        System.out.println("User ID la :" + UserID);
        // get Password
        Password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td"))
                .getText();
        System.out.println("Password la :" + Password);

    }
    @Test
    public void TC_04_Login(){
        // truy cap man hinh login
        driver.get("https://demo.guru99.com/v4/");
        // input ID textbox
        driver.findElement(
                        By.xpath("//td[text()='UserID']/following-sibling::td/input"))
                .sendKeys(UserID);

        //input Password textbox
        driver.findElement(By.xpath("//td[text()='Password']/following-sibling::td/input"))
                .sendKeys(Password);

        // click btn login
        driver.findElement(
                By.xpath("//input[@name='btnLogin']"))
                .click();

    }

    @AfterClass
    public void afterClass(){

        //driver.quit();
    }
}