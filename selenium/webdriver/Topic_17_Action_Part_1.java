package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.WebElementToJsonConverter;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_17_Action_Part_1 {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void beforeClass(){
        driver =  new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        action = new Actions(driver);
    }

    @Test
    public void TC_01_Hover_mouse(){
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        WebElement toolTips = driver.findElement(By.xpath("//a [@href='#']"));
        WebElement themeRoller = driver.findElement(By.xpath("//a[@href='http://jqueryui.com/themeroller/']"));
        WebElement yourAgeTxtBox = driver.findElement(By.xpath("//input[@id='age']"));
        action.moveToElement(yourAgeTxtBox).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='ui-tooltip-content']")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ui-tooltip-content']")).getText(), "We ask for your age only for statistical purposes.");
    }

    @Test
    public void TC_02_(){
        driver.get("http://www.myntra.com/");
        action.moveToElement(driver.findElement(By.xpath("//div[@data-reactid='334']"))).perform();
        sleepInsecond(3);

        driver.findElement(By.xpath("//a [@class='desktop-categoryName' and text()='Home & Bath']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Kids Home Bath']")).getText(), "Kids Home Bath");

    }

    @Test
    public void TC_03_(){
        driver.get("https://www.fahasa.com/");

        action.moveToElement(driver.findElement(By.xpath("//span[@class='icon_menu']"))).perform();
        sleepInsecond(2);
        driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//ul[@class='nav-links']//a[text()='Tiểu Thuyết']")).click();
        System.out.println(driver.findElement(By.xpath("//ol[@class='breadcrumb']//li[contains(@class,'category')]/strong[text()='Tiểu thuyết']")).getText().toUpperCase());

        Assert.assertEquals(driver.findElement(By.xpath("//ol[@class='breadcrumb']//li[contains(@class,'category')]/strong[text()='Tiểu thuyết']")).getText().toUpperCase(),"TIỂU THUYẾT");

    }

    public void  sleepInsecond (long sleepTime){
        try {
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
