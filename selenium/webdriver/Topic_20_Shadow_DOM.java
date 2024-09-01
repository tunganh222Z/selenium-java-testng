package webdriver;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_Shadow_DOM {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Shadow_DOM(){
        driver.get("https://automationfc.github.io/shadow-dom/");
        //WebElement shadowHostElement = driver.findElement(By.xpath("//div[@id='shadow_host']"));
        //SearchContext shadowrootContext = shadowHostElement.getShadowRoot();

        //String getText = shadowrootContext.findElement(By.cssSelector("span#shadow_content>span")).getText();
        //System.out.println(getText);

        //WebElement ShadowChild = shadowrootContext.findElement(By.cssSelector("div#nested_shadow_host")).getShadowRoot();
        Assert.assertTrue(shadowContext(By.xpath("//div[@id='shadow_host']"), By.cssSelector("span#shadow_content>span")).isDisplayed());

        WebElement shadowParent = shadowContext(By.xpath("//div[@id='shadow_host']"), By.cssSelector("div#nested_shadow_host"));

        SearchContext shadowChild = shadowParent.getShadowRoot();
        System.out.println(shadowChild.findElement(By.cssSelector("div#nested_shadow_content")).getText());


    }

    @Test
    public void TC_02_ShadowDOM_Shopee(){
        driver.get("https://shopee.vn/");
        shadowContext(By.xpath("div.home-page"),By.cssSelector("div.shopee-popup__close-btn")).click();
    }


    public WebElement shadowContext (By locator, By elementShadowLocator) {
        WebElement shadowHost = driver.findElement(locator);
        SearchContext shadowRootContext = shadowHost.getShadowRoot();
        return shadowRootContext.findElement(elementShadowLocator);
    }

    @AfterClass
    public void afterClass(){
        //driver.quit();
    }
}
