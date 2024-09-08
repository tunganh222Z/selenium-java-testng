package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class Topic_30_Wait_09_Fluent {
    WebDriver driver;
    WebDriverWait explicitWait;

    FluentWait<WebDriver> fluentDriver;

    FluentWait<WebElement> fluentElement; // khong khoi tao trong beforeClass

    FluentWait<String> stringFluentWait;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        fluentDriver = new FluentWait<WebDriver>(driver);

    }

    @Test
    public void TC_01_(){
        fluentDriver = new FluentWait<WebDriver>(driver);

        fluentElement = new FluentWait<WebElement>(driver.findElement(By.cssSelector("")));

        stringFluentWait = new FluentWait<String>("abc");

        //Set timeout
        fluentDriver.withTimeout(Duration.ofSeconds(10));

        //Set polling time every 0.3s
        fluentDriver.pollingEvery(Duration.ofMillis(300));

        //ignore exception
        fluentDriver.ignoring(NoSuchElementException.class);

        //ignore excetion timeout
        fluentDriver.ignoring(TimeoutException.class);

        // CONDITION
        //fluentDriver.until(new Function<T, V>() {
        // });
        //
        // type 1 WebDriver , Type 2 Kieu tra ve
        fluentDriver.until(new Function<WebDriver, Object>() {
            @Override
            public Object apply(WebDriver webDriver){
                return null;
            }
        });

        fluentDriver.until(new Function<WebDriver, String>() {

            @Override
            public String apply(WebDriver webDriver) {
                return webDriver.findElement(By.cssSelector("")).getText();
            }
        });
        //Chaining
        fluentDriver.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(400))
                .ignoring(NoSuchElementException.class, TimeoutException.class)
                .until(new Function<WebDriver, Boolean>() {
                    @Override
                    public Boolean apply(WebDriver webDriver){
                        return webDriver.findElement(By.cssSelector("")).isDisplayed();
                    }
                });

    }

    @Test
    public void TC_02_(){
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        

        //Setting
        fluentDriver.withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class, TimeoutException.class);
        // Waiting for Hello world text Within 10s
        // Condition Boolean isDisplayed
        fluentDriver
                .until(new Function<WebDriver, Boolean>() {
                    @Override
                    public Boolean apply (WebDriver webDriver){
                        return webDriver.findElement(By.xpath("//div[@id='finish']//h4[text()='Hello World!']")).isDisplayed();
                    }
                });

        //Condition String getText
        String getHelloText = fluentDriver
                .until(new Function<WebDriver, String>() {
                   @Override
                   public String apply(WebDriver webDriver){
                       String text = driver.findElement(By.xpath("//div[@id='finish']//h4")).getText();
                       System.out.println(" Text la :" + text);
                       return text;
                   }
                });
        Assert.assertEquals(getHelloText, "Hello World!");
    }

    @Test
    public void TC_03_(){
        driver.get("https://automationfc.github.io/fluent-wait/");

        WebElement countDownTime = driver.findElement(By.xpath("//div[@id='javascript_countdown_time']"));

        fluentElement = new FluentWait<WebElement>(countDownTime);
        //settings
        fluentElement.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class, TimeoutException.class);

        fluentElement.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement webElement){
                String text = webElement.getText();
                System.out.println(text);
                return webElement.getText().endsWith("00");
            }
        });

    }

    public WebElement waitAndFindElement(By locator){
        fluentDriver = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);
        return fluentDriver.until(new Function<WebDriver, WebElement >() {
            @Override
            public WebElement apply(WebDriver webDriver){
                return webDriver.findElement(locator);
            }
        });
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
