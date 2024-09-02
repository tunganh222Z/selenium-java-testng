package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Topic_21_Frame_iFrame {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        action = new Actions(driver);
    }

    @Test
    public void TC_01_(){
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        driver.findElement(By.cssSelector("div#imageTemplateContainer")).click();
        sleepInSecond(3);

        WebElement iFrameB = driver.findElement(By.cssSelector("div#formTemplateContainer>iframe"));

        Assert.assertTrue(iFrameB.isDisplayed());

        //switch by index
        //driver.switchTo().frame(0);
        //switch by ID,NAME
        //driver.switchTo().frame("frame-one85593366");
        //switch by webElement
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer>iframe")));
        Select qualityRating = new Select(driver.findElement(By.xpath("//select[@id = 'RESULT_RadioButton-8']")));
        qualityRating.selectByVisibleText("Neutral");
        Assert.assertEquals(qualityRating.getFirstSelectedOption().getText(), "Neutral");

        driver.switchTo().defaultContent();
    }

    @Test
    public void TC_02_iFrame_KynaEnglish(){
        String userName = "Ma Doãn Tùng Anh", phoneNumber = "0376636693";
        String textMessage = " Test auto \n happy 02.09 national day \n test hihi";
        driver.get("https://skills.kynaenglish.vn/");
        sleepInSecond(2);
        action.keyDown(Keys.ESCAPE).perform();
        action.keyUp(Keys.ESCAPE).perform();

        driver.switchTo().frame(driver.findElement(By.cssSelector("div#cs-live-chat>iframe")));
        driver.findElement(By.cssSelector("div.button_bar")).click();
        sleepInSecond(1);



        driver.findElement(By.cssSelector("input.input_name")).sendKeys(userName);
        driver.findElement(By.cssSelector("input.input_phone")).sendKeys(phoneNumber);
        driver.findElement(By.cssSelector("textarea.input")).sendKeys(textMessage);
        sleepInSecond(1);

        String expectedOption = "TƯ VẤN TUYỂN SINH";
        Select dropdownService = new Select(driver.findElement(By.cssSelector("select#serviceSelect")));
        dropdownService.selectByVisibleText(expectedOption);

        Assert.assertEquals(dropdownService.getFirstSelectedOption().getText(), expectedOption);

        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("a.register-btn")).click();

    }


    public void sleepInSecond (long timeSleep){
        try {
            Thread.sleep(timeSleep * 1000);
        } catch ( InterruptedException e ){
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
