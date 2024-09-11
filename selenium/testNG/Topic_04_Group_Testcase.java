package testNG;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Group_Testcase {

    WebDriver driver;

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
        // Nó bị fail ở Before thì TC và AfterClass không chạy
    }



    @Test
    public void TC_01_(){

    }

    @Test
    public void TC_02_(){

    }

    @AfterClass
    public void afterClass(){
    driver.quit();
    }
}