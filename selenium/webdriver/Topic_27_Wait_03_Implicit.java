package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_27_Wait_03_Implicit {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();

        driver.manage().window();
    }

    @Test
    public void TC_01_Equal_5s(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");

    }

    @Test
    public void TC_02_LessThan_5s(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");

    }

    @Test
    public void TC_03_(){
        driver.get("https://demo.minimog.co/");
        driver.findElement(By.xpath("//button[@class='m-slider-controls__button m-slider-controls__button-prev swiper-button-prev ']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class='m-slider-controls__button m-slider-controls__button-prev swiper-button-prev ']")).isDisplayed());
        String totalPage = driver.findElement(By.xpath("//div[@class='m-collection-list__header-container container-fluid']//span[@class='swiper-pagination-total']")).getText();
        int carouselTotal = Integer.parseInt(totalPage);
        for (int i = 0;  i < carouselTotal ; i++){
            driver.findElement(By.xpath("//button[@class='m-slider-controls__button m-slider-controls__button-prev swiper-button-prev ']")).click();
        }
    }



    @Test
    public void TC_03_GreaterThan_5s(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://automationfc.github.io/dynamic-loading/");

        driver.findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
