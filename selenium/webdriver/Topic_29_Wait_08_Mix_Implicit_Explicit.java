package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Topic_29_Wait_08_Mix_Implicit_Explicit {
    WebDriverWait explicitWait;
    WebDriver driver;

    public String getDateTime(){
        Date date = new Date();
        return date.toString();
    }

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        //explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Only_Implicit_Found(){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get("https://www.facebook.com/");
            // Khi vào tìm thì nó tìm thấy luôn, không cần chờ hết timeout

            driver.findElement(By.cssSelector("input#email"));
    }

    @Test
    public void TC_02_Only_Implicit_notFound(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.facebook.com/");
        // Khi vào element không tìm thấy và sẽ polling 0.5s đến
        // hết Timeout thì fail throw no such element exception

        driver.findElement(By.cssSelector("input#abc1234"));
    }

    @Test
    public void TC_03_Only_Explicit_Found(){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.facebook.com/");


        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));

    }

    @Test
    public void TC_04_Only_Explicit_notFound(){
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.facebook.com/");

        //TimeoutException: Expected condition failed:
        // waiting for visibility of element located by By.cssSelector: input#abc1234
        // (tried for 5 second(s) with 500 milliseconds interval)
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#abc1234")));

    }

    @Test
    public void TC_05_Mixing_Implicit_Explicit_Found(){
        driver.get("https://www.facebook.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        System.out.println("Start Time : " + getDateTime());
        try {
            explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#automation")));
        } catch (Exception e) {
            System.out.println("End Time : " + getDateTime());
            throw new RuntimeException(e);
        }

    }

    @Test
    public void TC_06_Only_Explicit_notFound_Param_webElement() {
        driver.get("https://www.facebook.com/");

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        System.out.println("Start Time : " + getDateTime());
        try {
            explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#email"))));
        } catch (Exception e) {
            System.out.println("End Time : " + getDateTime());
            throw new RuntimeException(e);

        }
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
