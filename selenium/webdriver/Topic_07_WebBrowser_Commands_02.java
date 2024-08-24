import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;


public class Topic_07_WebBrowser_Commands_02 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        // khi click xong thi cau lenh impicitlyWait nay khong dc apply
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_Url(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepinSecond(3);
        String LoginPageUrl = driver.getCurrentUrl();
        Assert.assertTrue(LoginPageUrl.contains("http://live.techpanda.org/index.php/customer/account/login/"));
        driver.findElement(By.xpath("//a[@title='Create an Account' and @class='button']")).click();
        sleepinSecond(3);
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
    }

    @Test
    public void TC_02_PageTitle(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepinSecond(2);
        Assert.assertTrue(driver.getTitle().contains("Customer Login"));
        driver.findElement(By.xpath("//a[@title='Create an Account' and @class='button']")).click();
        sleepinSecond(2);
        Assert.assertTrue(driver.getTitle().contains("Create New Customer Account"));

    }

    @Test
    public void TC_03_PageNavigation(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepinSecond(1);
        driver.findElement(By.xpath("//a[@title='Create an Account' and @class='button']")).click();
        sleepinSecond(1);
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
        driver.navigate().back();
        sleepinSecond(1);
        Assert.assertTrue(driver.getCurrentUrl().contains("http://live.techpanda.org/index.php/customer/account/login/"));
        driver.navigate().forward();
        sleepinSecond(1);
        Assert.assertTrue(driver.getTitle().contains("Create New Customer Account"));
    }

    @Test
    public void TC_04_PageSource(){
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepinSecond(1);
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));
        driver.findElement(By.xpath("//a[@title='Create an Account' and @class='button']")).click();
        sleepinSecond(1);
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));


    }

    public void sleepinSecond(long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}