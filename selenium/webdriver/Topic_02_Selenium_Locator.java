package webdriver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }


        driver = new

                FirefoxDriver();
        driver.manage().

                timeouts().

                implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("");
    }

    // TestNG order testcase theo alphabet ( 0 - 9 A-Z )
    /*
    HTML code cua First name text box
    <input type="text" data-val="true" data-val-required="First name is required." id="FirstName" name="FirstName">
    HTML Element : <tagname attribute_name1='attribute_value' attribute_name2='attribute_value' attribute_name3='attribute_value'>
    data-val, data-val-required, id, name la attribute
     */

    @Test
    public void TC_01_Id(){
       // driver.findElement(By.)
    }

    @Test
    public void TC_02_Class(){

    }
    @Test
    public void TC_03_Name(){

    }

    @Test
    public void TC_04_Tagname(){

    }

    @Test
    public void TC_05_Link(){

    }

    @Test
    public void TC_06_Partial(){

    }

    @Test
    public void TC_07_Css(){

    }

    @Test
    public void TC_08_XPath(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}