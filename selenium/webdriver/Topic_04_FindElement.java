package webdriver;


import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_FindElement {

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
        driver.get("https://automationfc.github.io/basic-form/");
    }



    @Test
    public void TC_01_Text_isDisplayed_getText(){
        // 1 - truyen text vao trong locator de check hien thi displayed
            // nen su dung vi no tuyet do
        driver.findElement(By.xpath("//h1[text()='Selenium WebDriver API']")).isDisplayed();
            // han che vi no tuong doi
        driver.findElement(By.xpath("//p[contains(text(),'Mail Personal or Business Check')]")).isDisplayed();
        // 2 - get text roi verify sau
        String textcheck = driver.findElement(By.xpath("//h5[@id='nine']/p[1]")).getText();
        Assert.assertTrue(textcheck.contains("Mail Personal or Business Check"));
        //3 verify nested text
        String nestedText = driver.findElement(By.xpath("//h5[@id='nested']")).getText();
        System.out.println(nestedText);
        Assert.assertTrue(nestedText.equals("Hello World! (Ignore Me) @04:45 PM"));
    }

    @Test
    public void TC_02_concatMethod(){
        // vua chua dau ky tu '' + "" thi dung concat
        /*
        Hello "John", What's happened?
        <span class="concat">Hello "John", What's happened?</span>
        'Hello "John", What'+"'s happened?"
        //span[text()=concat('Hello "John", What',"'s happened?","'s happened?")]
         */
        // 1- su dung concat : code xau + kho doc
        String getTextconcat = driver.findElement(By.xpath("//span[text()=concat('Hello \"John\", What',\"'s happened?\")]")).getText();
        System.out.println(getTextconcat);
        Assert.assertTrue(getTextconcat.equals("Hello \"John\", What's happened?"));
        // 2 -  su dung get text //span[@class='concat'] : Locator ngan gon + verify de hieu
        String getTextspanConcat = driver.findElement(By.xpath("//span[@class='concat']")).getText();
        System.out.println(getTextspanConcat);
        Assert.assertTrue(getTextspanConcat.equals("Hello \"John\", What's happened?"));
    }

    @AfterClass
    public void afterClass(){

        //driver.quit();
    }
}