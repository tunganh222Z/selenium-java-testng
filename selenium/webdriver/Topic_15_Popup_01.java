package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_15_Popup_01 {
    WebDriver driver;

    String userName = "tunganhDeptry", password = "passWord123!!@#";

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Fixed_PopUp_inDom_01(){
        driver.get("https://ngoaingu24h.vn/");
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@role='dialog']")).isDisplayed());

        driver.findElement(By.xpath("//div[@role='dialog']//input[@autocomplete='username']")).sendKeys(userName);
        driver.findElement(By.xpath("//div[@role='dialog']//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//div[@role='dialog']//button[text()='Đăng nhập']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='notistack-snackbar']")).getText(), "Bạn đã nhập sai tài khoản hoặc mật khẩu!");
        driver.findElement(By.xpath("//div[@role='dialog']/h2/button")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//div[@role='dialog']")).isDisplayed());
    }

    @Test
    public void TC_02_Fixed_PopUp_inDom_02(){
        driver.get("https://skills.kynaenglish.vn/dang-nhap");
        WebElement loginPopUp = driver.findElement(By.xpath("//div[@class='right']"));

        Assert.assertTrue(loginPopUp.isDisplayed());

        driver.findElement(By.xpath("//div[@class='right']//input[@id='user-login']")).sendKeys(userName);
        driver.findElement(By.xpath("//div[@class='right']//input[@id='user-password']")).sendKeys(password);

        driver.findElement(By.xpath("//div[@class='right']//button[text()='Đăng nhập']")).click();

    }

    @Test
    public void TC_03_Fixed_PopUp_Not_inDom_01(){
        driver.get("https://tiki.vn/");
        driver.findElement(By.xpath("//span[text()='Tài khoản']/parent::div")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'ReactModal__Content')]")).isDisplayed());

        driver.findElement(By.xpath("//div[contains(@class,'ReactModal__Content')]//p[@class='login-with-email']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'ReactModal__Content')]//button[text()='Đăng nhập']")).click();

        Assert.assertEquals(
                driver.findElement(
                        By.xpath("//div[contains(@class,'ReactModal__Content')]//form/span[1]")).getText(),
                "Email không được để trống");

        driver.findElement(By.xpath("//div[contains(@class,'ReactModal__Content')]//button[@class='btn-close']")).click();

        // Assert.assertFalse(driver.findElement(By.xpath("//div[contains(@class,'ReactModal__Content')]")).isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.findElements(By.xpath("//div[contains(@class,'ReactModal__Content')]")).size(), 0);
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
