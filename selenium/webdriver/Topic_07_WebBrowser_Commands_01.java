package webdriver;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_07_WebBrowser_Commands_01 {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    String tunganh;

    @BeforeClass
    public void beforeClass() {


        driver = new

                FirefoxDriver();
        driver.manage().

                timeouts().

                implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().

                window().

                maximize();

    }



    @Test
    public void TC_01_(){
        // set truc tiep
        driver.get("https://facebook.com"); //*
        // khai bao bien roi gan vao sau
        String facebookurl = "https://facebook.com";
        driver.get(facebookurl);
        // driver.get(); mo ra mot URL bat ky
        // dong browser
        driver.quit();
        //dong 1 tab
        driver.close(); //*
        //
        WebElement textboxelement = driver.findElement(By.xpath("//div[@class='textbox']")); //*
        textboxelement.getText();
        // assert equals là tuyệt đối
        Assert.assertEquals(facebookurl,textboxelement.getText());
        // get nam trong nhom de lay du lieu trong driver
        driver.get(this.tunganh);
        // lấy ra current url dang su dung
        driver.getCurrentUrl(); //*
        // lay ra page source html cua page : dùng để verify một cách tương đối
        driver.getPageSource();
            //verify tuong doi
        Assert.assertTrue(driver.getCurrentUrl().contains("xyz"));
        // lay ra title cua page hien tai
        driver.getTitle();
        // lay ra ID cua cua so / tab hien tai
        driver.getWindowHandle(); //*
        driver.getWindowHandles();//*
        // cookie framework
        driver.manage().getCookieNamed(tunganh);

        //get ra nhung log o dev tool
        driver.manage().logs().get(LogType.DRIVER);

        // apply cho viec tim element ( findElement)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //* dung 1 lan
       // cho page duoc load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        // set truoc khi dung voi thu vien JavascriptExecutor
        // Inject 1 doan code JS vao trong Browser/ Element d
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        driver.manage().window().fullscreen();
        driver.manage().window().maximize(); //* dung 1 lan
        driver.manage().window().minimize();

        // kieu nay dung de test UI Responsive
            // setSize dung new Dimension chung ta dung cua selenium
        driver.manage().window().setSize(new Dimension(1366, 768));
            // set cho browser o vi tri nao so voi do phan giai man hinh
        driver.manage().window().setPosition(new Point(200,300));
        driver.manage().window().getPosition();
        // navigate tra ve kieu interface, navigate dung de chuyen huong
        driver.navigate();
        driver.navigate().back();
        // driver.navigate().to = driver.get(), driver.navigate.to tot hon, thao tacs với history của web page (back / foward )
        driver.navigate().to("https://facebook.com");
        // new URL la dung url cua Java

        driver.navigate().forward();
        driver.navigate().refresh();

        // thao tac voi Alert/Window /Tab / Frame / iFrame
            // alert se tra ve interface
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("123123123");
            // lay ra id cua cua so hien tai su dung handle window
            String homePageWindowID = driver.getWindowHandle();
            driver.getWindowHandles();
        driver.switchTo().window(homePageWindowID);
        // co 3 cach dung switch/ handle frame (iFrame)
        // switch = Index/ID (name) / Element
        driver.switchTo().frame(0);
        driver.switchTo().frame("aklsdjkalsjd23e123");
        driver.switchTo().frame(driver.findElement(By.xpath("")));
        // switch ve HTML chua frame truoc do
        driver.switchTo().defaultContent();
        // tu frame trong di ra frame ngoai chua no
        driver.switchTo().parentFrame();




    }

    @Test
    public void TC_02_(){

    }

    @AfterClass
    public void afterClass(){
    driver.quit();
    }
}