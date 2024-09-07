package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Topic_28_Wait_07_Explicit_03 {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_AjaxLoading(){
        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        List<WebElement> dayPicker = driver.findElements(By.xpath("//tr[@class='rcRow']//a[@href='#']"));
        System.out.println("Tong so ngay trong thang la :" + dayPicker.size());
        String expectedDay = "15";
        for (int i = 0 ; i < dayPicker.size() ; i++){

            if (dayPicker.get(i).getText().equals(expectedDay)){
                dayPicker.get(i).click();
                break;
            }
        }

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@id,'RadCalendar1')]//div[@class='raDiv']")));
        System.out.println("Selected day " + expectedDay);

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id,'Label1Panel')]")).getText().contains(expectedDay));

    }

    @Test
    public void TC_02_UploadFiles(){

        String character = File.separator; // phân biệt windows và mac để dùng  \\ và /

        String projectPath = System.getProperty("user.dir"); // lấy ra path của project

        String fileName = "image2.jpg";
        String fileName2 = "image (76).png";

        String fileNamePath = projectPath + character +"uploadFiles"+ character + fileName;
        String fileNamePath2 = projectPath + character +"uploadFiles"+ character + fileName2;

        driver.get("https://gofile.io/welcome");

        //Wait + assert spinner loading disappear
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner-border']"))));
        //explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='bi bi-cloud-upload']/parent::button")));
        driver.findElement(By.xpath("//i[@class='bi bi-cloud-upload']/parent::button")).click();

        // Wait + assert all elements loading disappear
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='spinner-border']")))));

        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(fileNamePath + "\n" + fileNamePath2);

        // Wait + assert all elements loading disappear
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("//div[@class='spinner-border']")))));

        //Wait progress bar elements disappear
        Assert.assertTrue(explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.xpath("div.progress-bar")))));

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='row mb-2 mainUploadSuccessLink']//a"))).click();


        //Verify button download
        Assert.assertTrue(explicitWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[text()='"+ fileName + "']/ancestor::div[contains(@class,'contentId')]//span[text()='Download']"))).isDisplayed());

        Assert.assertTrue(explicitWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[text()='"+ fileName2 + "']/ancestor::div[contains(@class,'contentId')]//span[text()='Download']"))).isDisplayed());
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
