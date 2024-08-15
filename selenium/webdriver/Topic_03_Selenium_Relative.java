package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_03_Selenium_Relative {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {


        driver = new

                FirefoxDriver();
        driver.manage().

                timeouts().

                implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://testfoxifygen2.myshopify.com/pages/test4411");
    }



    @Test
    public void TC_01_Password_ageVerify(){
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//button[@class='x-btn x-button x-gs-primary-button x-age-verifier__confirm']")).click();
        driver.get("https://testfoxifygen2.myshopify.com/pages/test4411");

    }

    @Test
    public void TC_02_Relative(){
        // submit button button.x-button-submit
        By SubmitButton = By.cssSelector("button.x-button-submit");
        // check box
        By CheckBox = By.cssSelector("span.x-checkbox__checkmark");
        WebElement CheckBoxElement = driver.findElement(By.xpath("//span[@class='x-checkbox__checkmark']"));
        // define thanh mot element //
        WebElement CheckBoxLabel = driver.
                findElement(RelativeLocator.with(By.xpath("//span[@class='x-form-label']"))
                .above(SubmitButton)
                .toRightOf(CheckBoxElement));
        System.out.println(CheckBoxLabel.getText());
    }

    @AfterClass
    public void afterClass(){

        //driver.quit();
    }
}