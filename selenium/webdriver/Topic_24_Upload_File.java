package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Topic_24_Upload_File {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Single_File(){
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        //Nếu mà để file như này thì chỉ có thể chạy trên chính máy này.
        String filePath1 = "C:\\Users\\tunga\\Downloads\\image (73).png";
        //Nên đưa file vào trong chính project này luôn để ai cũng có thể sử dụng được. uploadFiles
        String filePath = "C:\\Users\\tunga\\Downloads\\automation\\software\\selenium webdriver\\selenium-java-testng\\uploadFiles\\image2.jpg";
        //Nếu máy khác dùng hệ điều hành khác dùng được không ?
        //Lấy được đường dẫn tương đối của file đó

        String character = File.separator; // phân biệt windows và mac để dùng  \\ và /

        String projectPath = System.getProperty("user.dir"); // lấy ra path của project

        String fileName = "image2.jpg";

        String fileNamePath = projectPath + character +"uploadFiles"+ character + fileName;


        //
        driver.findElement(By.xpath("//input [@type='file']")).sendKeys(fileNamePath);

    }

    @Test
    public void TC_02_Multiple_Files(){

    }

    public void sleepInSecond (long timeSleep){
        try{
            Thread.sleep( timeSleep * 1000 );
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
