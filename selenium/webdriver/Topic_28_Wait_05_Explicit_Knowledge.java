package webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class Topic_28_Wait_05_Explicit_Knowledge {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();

        //khởi tạo một cái explicitWait có thời gian là 10s
        // - polling mặc định là 0.5s
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //- Custom polling là 0.3s
        //explicitWait = new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofMillis(300));
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_(){
        // Dùng để chờ một cái Alert present trong HTML / DOM trước khi thao tác lên
        // Return alert
        Alert alertDemo = explicitWait.until(ExpectedConditions.alertIsPresent());

        //Chờ cho element không còn ở trong DOM nữa
        explicitWait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(""))));

        //Chờ element có trong DOM có trên UI hay không không quan tâm
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("")));
        // 1 list elements
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")));

        //Chờ cho một element visible hiển thị trên UI
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(""))));

        //Chờ cho một element được phép click : Link / Button / checkbox / ...
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));

        // Chờ page hiện tại có title như mong đợi
        explicitWait.until(ExpectedConditions.titleIs("expectedTitle"));

        //Kết hợp nhiều điều kiện : and / or
        explicitWait.until(ExpectedConditions.and(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("")),
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(""))));

        //Chờ element có attribute chứa value mong đợi
        explicitWait.until(ExpectedConditions.attributeContains(By.cssSelector(""), "expectedAttribute", "expectedValue"));
        //tuyệt đối
        explicitWait.until(ExpectedConditions.attributeToBe(By.cssSelector(""), "attribute", "value"));
        // thực tế từ một attribute từ không có dữ liệu thành có dữ liệu
        explicitWait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.cssSelector("")), "attributeNotNull"));
        //Kiểm tra attribute trong DOM
        explicitWait.until(ExpectedConditions.domAttributeToBe(driver.findElement(By.cssSelector("")),"Attribute","value"));


        explicitWait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("")));
        //Chờ cho một elemeent được selected true, chờ cho một element chưa được selected false
        explicitWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector(""), true));

        // chờ cho frame/iframe chờ cho available để switch được
        // ( index dùng int, id name dùng String, By locator, webElement)
        explicitWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(""));

        //Chờ cho element đó không hiển thị trên UI, việc có trong DOM hay không không quan trọng
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));

        //Chờ một đoạn code Js cần trả về giá trị
        explicitWait.until(ExpectedConditions.jsReturnsValue("JavaScript;"));

        // Mong đợi số lượng elements bằng 5
        // vd đợi xem dropdown load ra được đủ 5 items hay chưa
        explicitWait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(""), 5));
        // Chờ window/tab là bao nhiêu, chờ thôi chứ k chờ load xong
        explicitWait.until(ExpectedConditions.numberOfWindowsToBe(5));

        // Chờ element có một đoạn expected text tren UI , tobe là tuyệt đối
        explicitWait.until(ExpectedConditions.textToBe(By.cssSelector(""), "expectedFixedText"));
        //bắt buộc text này phải có trong HTML
        explicitWait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(""), "expectedText"));

        //Chờ url contains expected
        explicitWait.until(ExpectedConditions.urlContains("facebook.com/cas"));


        explicitWait.until(ExpectedConditions.refreshed(ExpectedConditions.alertIsPresent()));
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
