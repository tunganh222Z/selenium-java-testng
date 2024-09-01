package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_18_Action_Part_2 {
    WebDriver driver;
    Actions action;
    String osName = System.getProperty("os.name");
    Keys keys;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        if (osName.startsWith("Windows")){
            keys = Keys.LEFT_CONTROL;
        } else {
            keys = Keys.COMMAND;
        }
    }

    @Test
    public void TC_01_Click_Hold_Block(){
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> listNumber = driver.findElements(By.xpath("//ol/li"));
        action.clickAndHold(listNumber.get(0)).moveToElement(listNumber.get(16)).release().perform();
        sleepInSecond(5);

        List<WebElement> listNumberSelected = driver.findElements(By.xpath("//ol/li[contains(@class,'ui-selected')]"));
        Assert.assertEquals(listNumberSelected.size(), 5);


    }
    @Test

    public void TC_02_Click_Hold_Specific(){
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> listNumber = driver.findElements(By.xpath("//ol/li"));




        for (int i = 0; i< listNumber.size(); i++){
            System.out.println(listNumber.get(i).getText());
            action.keyDown(Keys.LEFT_CONTROL).perform();
            if (i % 2 != 0){
                action.click(listNumber.get(i)).pause(1).perform();

            }
            action.keyUp(Keys.LEFT_CONTROL).perform();
        }
        sleepInSecond(3);

        List<WebElement> listNumberSelected = driver.findElements(By.xpath("//ol/li[contains(@class,'ui-selected')]"));
        Assert.assertEquals(listNumberSelected.size(), 5);
    }

    @Test
    public void TC_03_Double_Click(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        sleepInSecond(1);

        action.doubleClick(driver.findElement(By.xpath("//button [@ondblclick='doubleClickMe()']"))).perform();

        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='demo']")).getText(),"Double click me");
    }

    @Test
    public void TC_04_Right_Click(){
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        action.contextClick(driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"))).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//ul[contains(@class,'context-menu-list')]")).isDisplayed());

        WebElement hoverContextMenu = driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-copy')]"));
        action.moveToElement(hoverContextMenu).perform();
        Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'context-menu-hover') and contains(@class,'context-menu-visible')]")).isDisplayed() );
    }

    public void sleepInSecond(long sleepTime){
        try{
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
