package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_16_PopUp_02 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Random_PopUp_inDOM(){
        driver.get("https://www.kmplayer.com/home");
        sleepInSecond(5);
        By popUprand = By.xpath("//div[@class='pop-container']");
        if (driver.findElement(popUprand).isDisplayed()){
            System.out.println("Pop up is displayed");
            driver.findElement(By.xpath("//div[@class='pop-container']//div[@class='close']")).click();
            System.out.println("Pop up is closed");
        } else {
            System.out.println("popUp is not displayed");
        }
        System.out.println(
                "khong xuat hien"
        );

        if (driver.findElements(By.xpath("xpathPopupRand")).size() >0
                && driver.findElements(By.xpath("xpathPopupRand")).get(0).isDisplayed() ){

        }
    }

    @Test
    public void TC_02_Random_PopUp_Not_inDOM(){

    }

    public void sleepInSecond (long sleepTime){
        try {
            Thread.sleep(sleepTime  * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public WebElement findElement(By locator){
        if (driver.findElement(By.xpath("randPopup")).isDisplayed()){
            // do something when pop up is displayed
        }
        return driver.findElement(locator);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
