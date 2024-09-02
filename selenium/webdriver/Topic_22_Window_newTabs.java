package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_22_Window_newTabs {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window();
    }

    @Test
    public void TC_01_Basic_Form(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();

        String parrentID = driver.getWindowHandle();
        System.out.println(parrentID);

        Set<String> allTabGUI = driver.getWindowHandles();


        for (String id : allTabGUI ) {
            if ( !id.equals(parrentID)){
                driver.switchTo().window(id);
                break;
            }
        }
        driver.findElement(By.cssSelector("textarea#APjFqb")).sendKeys("auto testing 123");

        String googleTabID = driver.getWindowHandle();

        driver.switchTo().window(parrentID);

        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();

    }

    @Test
    public void TC_02_Kyna_Enlgish(){
        driver.get("");
    }

    public void switchToWindowByTitle ( String expectedTitle ){
        //Laấy ra hết tất cả ID của các window/tab
        Set<String> allIDs = driver.getWindowHandles();

        //DÙng vòng lặp duyệt qua SET ID ở trên
        for ( String id : allIDs){
            driver.switchTo().window(id);

            //LaẤy ra title của tab/window hiện tại và so sánh với expected
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)){
                break;
            }
        }
    }





    public void sleepInSecond ( long timeSleep ){
        try {
            Thread.sleep( timeSleep * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
