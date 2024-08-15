package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLInputElement;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {


        driver = new

                ChromeDriver();
        driver.manage().

                timeouts().

                implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://testfoxifygen2.myshopify.com/products/the-archived-snowboard");
    }

    // TestNG order testcase theo alphabet ( 0 - 9 A-Z )
    /*
    HTML code cua First name text box
    <input type="text" data-val="true" data-val-required="First name is required." id="FirstName" name="FirstName">
    HTML Element : <tagname attribute_name1='attribute_value' attribute_name2='attribute_value' attribute_name3='attribute_value'>
    data-val, data-val-required, id, name la attribute
     */
    @Test
    public void TC_00_Password_AgeVerify(){
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//button[@class='x-btn x-button x-gs-primary-button x-age-verifier__confirm']")).click();
    }
    @Test
    public void TC_01_Id(){
       driver.findElement(By.id("NewsletterForm--sections--15975324778557__footer")).sendKeys("Tunganh");
       // by la mot class. tim element co id la FirstName
        System.out.println(driver.findElement(By.id("NewsletterForm--sections--15975324778557__footer")));

    }

    @Test
    public void TC_02_Class(){
        driver.findElement(By.className("announcement-bar"));
    }
    @Test
    public void TC_03_Name(){

    }

    @Test
    public void TC_04_Tagname(){

    }

    @Test
    public void TC_05_Link(){
        driver.findElement(By.linkText("Powered by Shopify"));
    }

    @Test
    public void TC_06_Partial(){
        driver.findElement(By.partialLinkText("by Shopify"));
    }

    @Test
    public void TC_07_Css(){
        //css vs Id
        driver.findElement(By.cssSelector("input[id='NewsletterForm--sections--15975324778557__footer']"));
        driver.findElement(By.cssSelector("input#NewsletterForm--sections--15975324778557__footer"));
        //css vs class
        driver.findElement(By.cssSelector("div[class='announcement-bar']"));
        driver.findElement(By.cssSelector("div.announcement-bar"));
        driver.findElement(By.cssSelector(".announcement-bar"));
        // css vs link
        driver.findElement(By.cssSelector("a[href='/']"));
    }

    @Test
    public void TC_08_XPath(){
        // xpath vs id
        driver.findElement(By.xpath("//input[@id='NewsletterForm--sections--15975324778557__footer']"));
        // xpath vs class
        driver.findElement(By.xpath("//div[@class='announcement-bar']"));
        // xpath vs link
        driver.findElement(By.xpath("//a[text()='testfoxifygen2']"));
        driver.findElement(By.xpath("//a[contains(text(),'testfoxifygen2')]"));
    }

    @AfterClass
    public void afterClass(){

        //driver.quit();
    }
}