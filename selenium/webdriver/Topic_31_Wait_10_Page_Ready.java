package webdriver;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_31_Wait_10_Page_Ready {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));


    }

    @Test
    public void TC_01_Ajax_Loading(){
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
        List<WebElement> days = driver.findElements(By.xpath("//tr[@class='rcRow']//a"));

        String expectedDays = "15";

        for (WebElement day : days){
            if (day.getText().equals(expectedDays)){
                day.click();
                break;
            }
        }


        //Wait cho page Ready
        Assert.assertTrue(isPageLoadedSuccess());
        System.out.println("selected loaded");

    }

    //Điều kiện 1
    public boolean isPageLoadedSuccess() {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        });
    }

    @AfterClass
    public void afterClass(){
       // driver.quit();
    }

}
