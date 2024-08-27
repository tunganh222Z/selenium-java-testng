package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_12_Handle_Button {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Verify_EGOV_Button(){
        driver.get("https://egov.danang.gov.vn/reg");

        WebElement registerButton = driver.findElement(By.xpath("//input [@class= 'egov-button'] "));

        Assert.assertFalse(registerButton.isEnabled());

        driver.findElement(By.xpath("//input [ @id ='chinhSach'] ")).click();
        sleepInSecond(2);

        Assert.assertTrue(registerButton.isEnabled());

        String getBGcolor = registerButton.getCssValue("background-color");

        converColortHexa(getBGcolor);

        Assert.assertEquals(converColortHexa(getBGcolor), "#ef5a00");
    }

    @Test
    public void TC_02_(){
        driver.get("https://www.fahasa.com/customer/account/create");

        driver.findElement(By.xpath("//li [@class = 'popup-login-tab-item popup-login-tab-login']")).click();
        sleepInSecond(2);

        WebElement loginButton = driver.findElement(By.xpath("//button [@class='fhs-btn-login']"));

        Assert.assertFalse(loginButton.isEnabled());


        driver.findElement(By.xpath("//input [@id='login_username']")).sendKeys("mailExample@gmail.com");
        driver.findElement(By.xpath("//input [@id='login_password']")).sendKeys("ExamplePassword123@!@#!@#");

        Assert.assertTrue(loginButton.isEnabled());

        String loginBtnBgcolor = loginButton.getCssValue("background");
        Assert.assertEquals(converColortHexa(loginBtnBgcolor).toUpperCase(), "#C92127");
    }

    @Test
    public void TC_03_(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    public void sleepInSecond (long sleepTime){
        try {
            Thread.sleep(sleepTime*1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public String converColortHexa(String rgbColor){
        Color getBGcolorRGB = Color.fromString(rgbColor);
        String getBGcolorHexa = getBGcolorRGB.asHex();
        return getBGcolorHexa;
    }
}
