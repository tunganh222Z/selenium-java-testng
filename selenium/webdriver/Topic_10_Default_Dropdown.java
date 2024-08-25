package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_10_Default_Dropdown {
    WebDriver driver;
    String firstName = "Tung Anh", lastName = "Dep Try", eMail = randomEmail(), companyName = "Cong Ty TNHH 99 thanh vien", password = "tunganhdeptryQ123!!!###";
    String daySelected = randomDoB();
    String yearSelected = randomYob();

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void sleepInSecond (long sleeptime){
        try {
            Thread.sleep( sleeptime * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public String randomEmail(){
        Random rand = new Random();
        return "tuganh" + rand.nextInt(0,9999) + "@gmail.com";
    }

    public String randomDoB(){
        Random rand = new Random();
        int i = rand.nextInt(1,28);
        return Integer.toString(i);
    }

    public String randomYob(){
        Random rand = new Random();
        int i = rand.nextInt(1900,2024);
        return Integer.toString(i);
    }

    @Test
    public void TC_01_Register(){
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.xpath("//div [@class='header']//a[@class='ico-register']")).click();
        sleepInSecond(2);

        driver.findElement(By.xpath("//input [@id='gender-male']")).click();
        driver.findElement(By.xpath("//input [@id='FirstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input [@id='LastName']")).sendKeys(lastName);

        //Handle default dropdown
        Select day = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        day.selectByVisibleText(daySelected);

        //Verify so luong item trong dropdown la 32 items
        List<WebElement> dayOptions = day.getOptions();
        Assert.assertEquals(dayOptions.size(), 32); // size() tra ve so luong element bang bao nhieu

        //verify dropdown nay la single khong phai multiple
        Assert.assertFalse(day.isMultiple());

        Select month = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        month.selectByVisibleText("September");

        Select year = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        year.selectByVisibleText(yearSelected);

        driver.findElement(By.xpath("//input [@id='Email']")).sendKeys(eMail);
        driver.findElement(By.xpath("//input [@id='Company']")).sendKeys(companyName);
        driver.findElement(By.xpath("//input [@id='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input [@id='ConfirmPassword']")).sendKeys(password);




        driver.findElement(By.xpath("// div [@class='buttons']")).click();
        sleepInSecond(2);
    }

    public void TC_02_login(){
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.xpath("//div[@class='header']//a[@class='ico-login']")).click();
        sleepInSecond(2);

        driver.findElement(By.xpath("//div [@class='form-fields']//input [@id='Email']")).sendKeys(eMail);
        driver.findElement(By.xpath("//div [@class='form-fields']//input [@id='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//div [@class='buttons']//button[@type='submit']")).click();
        sleepInSecond(2);







    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
