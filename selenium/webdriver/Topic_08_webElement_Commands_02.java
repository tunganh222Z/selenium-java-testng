import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_08_webElement_Commands_02 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_isDisplayed(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement inputMail =  driver.findElement(By.xpath("//input[@id='mail']"));
        if (inputMail.isDisplayed()){
            inputMail.sendKeys("Automation Testing");
            System.out.println("Email textbox is displayed");
        } else {
            System.out.println("Email textbox is not displayed");
        }

        WebElement radioUnder18 = driver.findElement(By.xpath("//input[@id='under_18']"));
        if (radioUnder18.isDisplayed()){
            radioUnder18.click();
            System.out.println("Radio button is displayed");
        } else {
            System.out.println("Radio button is not displayed");
        }

        WebElement educationTextbox = driver.findElement(By.xpath("//textarea[@id='edu']"));
        if (educationTextbox.isDisplayed()){
            educationTextbox.sendKeys("Automation Testing");
            System.out.println("Education textbox is displayed");
        } else {
            System.out.println("Education textbox is not displayed");
        }

        WebElement user5 = driver.findElement(By.xpath("//div[@class='figcaption']/h5[contains(text(),'User5')]"));
        if (user5.isDisplayed()){
            System.out.println("user 5 is displayed");
        } else {
            System.out.println("user 5 is not displayed");
        }
    }

    @Test
    public void TC_02_isEnabled(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement inputMail =  driver.findElement(By.xpath("//input[@id='mail']"));
        if (inputMail.isEnabled()){
            System.out.println("input mail textbox is enabled");
        } else {
            System.out.println("input mail textbox is disabled");
        }

        WebElement radioUnder18 = driver.findElement(By.xpath("//input[@id='under_18']"));
        if (radioUnder18.isDisplayed()){
            System.out.println("Radio button under 18 is enabled");
        } else {
            System.out.println("radio button under 18 is disabled");
        }

        WebElement educationTextbox = driver.findElement(By.xpath("//textarea[@id='edu']"));
        if (educationTextbox.isDisplayed()) {
            System.out.println("education textbox is enabled");
        } else {
            System.out.println("education textbox is disabled");
        }

        WebElement job1 = driver.findElement(By.xpath("//select[@id='job1']"));
        if (job1.isEnabled()){
            System.out.println("Job 1 is enabled");
        } else {
            System.out.println("Job 1 is disabled");
        }

        WebElement job2 = driver.findElement(By.xpath("//select[@id='job2']"));
        if (job2.isEnabled()){
            System.out.println("Job 2 is enabled");
        } else {
            System.out.println("Job 2 is disabled");
        }

        WebElement DevCheckbox = driver.findElement(By.xpath("//input[@id='development'] "));
        if (DevCheckbox.isEnabled()){
            DevCheckbox.click();
            System.out.println("Development checkbox is enabled");
        } else {
            System.out.println("Development checkbox is disabled");
        }

        WebElement slider2 = driver.findElement(By.xpath("//input[@id='slider-2']"));
        if (slider2.isEnabled()){
            System.out.println("Slider 2 is enabled");
        } else {
            System.out.println("Slider 2 is disabled");
        }
    }

    @Test
    public void TC_03_isSelected(){
        driver.get("https://automationfc.github.io/basic-form/index.html");

        WebElement radioUnder18 = driver.findElement(By.xpath("//input[@id='under_18']"));
        radioUnder18.click();
        radioUnder18.click();
        if (radioUnder18.isSelected()){
            System.out.println("Radio button under 18 is selected");
        } else {
            System.out.println("Radio button under 18 is de-selected");
        }

        WebElement Langjavacheckbox = driver.findElement(By.xpath("//input [@id='java']"));
        Langjavacheckbox.click();
        if (Langjavacheckbox.isSelected()){
            System.out.println("Java check box is selected");
        } else {
            System.out.println("Java check box is de-selected");
        }

        Langjavacheckbox.click();
        if (Langjavacheckbox.isSelected()){
            System.out.println("Java check box is selected");
        } else {
            System.out.println("Java check box is de-selected");
        }
    }

    @Test
    public void TC_04_registerFunctionAt_MailChimp(){
        driver.get("https://login.mailchimp.com/signup/");

        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement userName = driver.findElement(By.xpath("//input[@id='new_username']"));
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='new_password']"));

        inputEmail.sendKeys("tunganh97tuaf@gmail.com");

        inputPassword.sendKeys("1");
        if (driver.findElement(By.xpath("//li [@class='number-char completed']")).isDisplayed()) {
            System.out.println("Verified one number");
        } else {
            System.out.println("Not verified ");
        }

        inputPassword.clear();
        inputPassword.sendKeys("A");
        if (driver.findElement(By.xpath("//li [@class='uppercase-char completed']")).isDisplayed()) {
            System.out.println("Verified Upper case");
        } else {
            System.out.println("Not verified ");
        }

        inputPassword.clear();
        inputPassword.sendKeys("a");
        if (driver.findElement(By.xpath("//li [@class='lowercase-char completed']")).isDisplayed()) {
            System.out.println("Verified lower case");
        } else {
            System.out.println("Not verified ");
        }

        inputPassword.clear();
        inputPassword.sendKeys("#");
        if (driver.findElement(By.xpath("//li [@class='special-char completed']")).isDisplayed()) {
            System.out.println("Verified Special char");
        } else {
            System.out.println("Not verified ");
        }

        inputPassword.clear();
        inputPassword.sendKeys("12345tunganh12345");
        if (driver.findElement(By.xpath("//li [@class='8-char completed']")).isDisplayed()) {
            System.out.println("Verified Greater than 8 chars");
        } else {
            System.out.println("Not verified ");
        }
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    public void sleepInSecond(long timesleep){
        try {
            Thread.sleep(timesleep * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }
}