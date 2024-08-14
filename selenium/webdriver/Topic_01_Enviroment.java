package webdriver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


/*
8 loaij locator
id, class, name : trung attribute voi html
linktext / partial link text : HTML link ( the a )
tagname : HTML tagname
selenium version 4
    Class - Relative Locator
        above/bellow/near/leftof/rightof
       UI Testing
       FUI : Functional UI
       GUI : Graphic UI
        font/ size / color / position /
Css/XPath
 */
public class Topic_01_Enviroment {
    WebDriver driver;

    @Test
    public void TC_01_Run_On_Firefox() {
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    @Test
    public void TC_02_Run_On_Chrome() {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    @Test
    public void TC_03_Run_On_Edge() {
        driver = new EdgeDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }
}
