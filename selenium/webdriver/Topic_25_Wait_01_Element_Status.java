package webdriver;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_25_Wait_01_Element_Status {
    WebDriverWait explicitWait;
    WebDriver driver;
    By reConfirmEmail = By.cssSelector("reConfirmEmail");
    By regBtn = By.cssSelector("loginBtn");
    By inputEmail = By.cssSelector("inputEmail");

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Visible(){

        driver.findElement(regBtn).click();
        driver.findElement(inputEmail).sendKeys("testElementStatus");

        //Tại thời điểm này Element này đang visible kích thước lớn hơn 0x0 và có trong DOM
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(reConfirmEmail));
    }

    @Test
    public void TC_02_Invisible_inDom(){
        driver.findElement(inputEmail).clear();

        //Tại thời điểm này Element này không hiển thị nhưng có trong inDOM - Điều kiện 2
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reConfirmEmail));
        Assert.assertFalse(driver.findElement(reConfirmEmail).isDisplayed());

        // close pop up register
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/parent::div/img")).click();

    }

    @Test
    public void TC_03_Invisible_Not_inDom(){
        // close pop up register
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/parent::div/img")).click();

        // Tại thời điểm này element không hiển thị trên UI và không hiển thị trong DOM - điều kiện 3
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reConfirmEmail));

        // Step này Fail
        Assert.assertFalse(driver.findElement(reConfirmEmail).isDisplayed());

    }

    @Test
    public void TC_04_Presence(){
        driver.findElement(regBtn).click();
        driver.findElement(inputEmail).sendKeys("testElementStatus");

        //Tại thời điểm này Element này đang visible kích thước lớn hơn 0x0 và có trong DOM
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(reConfirmEmail));


        driver.findElement(inputEmail).clear();
        //Tại thời điểm này Element này không hiển thị nhưng có trong inDOM - Điều kiện 2
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(reConfirmEmail));

    }

    @Test
    public void TC_05_Staleness(){
        driver.findElement(regBtn).click();
        //Tại thời điểm này element có trong DOM nhưng chưa có trên UI

        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/parent::div/img")).click();
        // Tại thời điểm này element không hiển thị trên UI và không hiển thị trong DOM - điều kiện 3

        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(reConfirmEmail)));

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
