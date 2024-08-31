package webdriver;

import org.bouncycastle.util.encoders.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Headers;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Topic_14_Alert {
    WebDriver driver;
    By resultText = By.xpath("//p[@id='result']");
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Alert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button [@onclick = 'jsAlert()']")).click();



        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.accept();
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(resultText).getText(), "You clicked an alert successfully");


    }

    @Test
    public void TC_02_Confirm_Alert(){

    }

    @Test
    public void TC_03_Prompt_Alert(){

    }

    @Test
    public void TC_04_Authentication_Alert_BypassUrl(){
        String username = "admin", password = "admin";
        driver.get("https://the-internet.herokuapp.com/");
        String authLink =  driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
        System.out.println(authLink);
        driver.get(authLink);
        String[] authenArray = authLink.split("//");
        System.out.println(authenArray[1]);
        System.out.println(authenArray[0] + "//" + username + ":" + password + "@" +authenArray[1]);
        driver.get(authenArray[0] + "//" + username + ":" + password + "@" +authenArray[1]);



        // cach 2 : run only on windows (AutoIT)
        // cach 3 : selenium v4

    }

    @Test
    public void TC_05_Authenticator_alert_Selenium4x(){
        // get devtool object
        DevTools devTools = ((HasDevTools)driver).getDevTools();
        // Start new session
        devTools.createSession();
        //Enable the Network domain of devtools
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        //Encode username/password
        Map<String,Object> headers = new HashMap<String, Object>();
        String basicAuthen = "Basic " + new String(new Base64().encode(String.format("%s:%s","admin","admin").getBytes()));
        headers.put("Authorization", basicAuthen );

        //Set to header
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));


    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    public void sleepInSecond( long timeSleepSecond ){
        try {
            Thread.sleep( timeSleepSecond * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
