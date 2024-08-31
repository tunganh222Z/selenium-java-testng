package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_11_TC02_Handle_Textbox_TextArea {
    WebDriver driver;
    WebDriverWait explicitWait;
    String firstName ="Tung Anh", lastName = "Dep Try", middleName = "Khoai To";
    String userName = "tunganhusername", password = "tunganhpassword123@!!Q";
    String employeeID ="";
    String passPortID = randPassportID();
    String commentTextarea = "";

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test
    public void TC_01_Login(){
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin" );
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleepInSecond(5);
    }

    @Test
    public void TC_02_Add_Employees(){
        driver.findElement(By.xpath("//ul[@class='oxd-main-menu']//span[text()='PIM']")).click();
        sleepInSecond(5);
        driver.findElement(By.xpath("//nav[@class='oxd-topbar-body-nav']//a[text()='Add Employee']")).click();
        sleepInSecond(5);

        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys(middleName);
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);

        WebElement employeeID = driver.findElement(By.xpath("//label[text()='Employee Id']//parent::div//following-sibling::div//input"));
        String employeeIDString = employeeID.getAttribute("value");
        this.employeeID = employeeIDString;
        System.out.println(employeeID.getAttribute("value"));
        System.out.println(this.employeeID);

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='oxd-form-loader']")));
        sleepInSecond(5);
        By switchbutton = By.xpath("//div[@class='oxd-switch-wrapper']");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", driver.findElement(switchbutton));

        driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input']")).sendKeys(userName);
        driver.findElement(By.xpath("//label[text()='Password']/parent::div//following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div//following-sibling::div/input")).sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleepInSecond(5);
    }
    @Test
    public void TC_03_Verify_Infor(){
        Assert.assertEquals(
                driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"),
                firstName
        );

        Assert.assertEquals(
                driver.findElement(By.xpath("//input[@name='middleName']")).getAttribute("value"),
                middleName
        );

        Assert.assertEquals(
                driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"),
                lastName
        );

        Assert.assertEquals(
                driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"),
                employeeID
        );

        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        sleepInSecond(5);
    }

    @Test
    public void TC_03_Assigned_Immigration_Records(){
        driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button")).click();
        sleepInSecond(5);

       WebElement passPortID = driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input"));
       passPortID.sendKeys(this.passPortID);

       String textCommentArea = "comment dong 1 \n xuong dong \n xuong dong tiep ne";
       this.commentTextarea = textCommentArea;
       WebElement textArea = driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea"));
       textArea.sendKeys(textCommentArea);

       driver.findElement(By.xpath("//h6[text()='Personal Details']/parent::div//button[@type='submit']")).click();
        sleepInSecond(5);

    }

    @Test
    public void TC_04_Verify_edit_Infor(){
        driver.findElement(By.xpath("//i [@class='oxd-icon bi-pencil-fill']/parent::button")).click();
        sleepInSecond(5);

        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"),
                passPortID);

        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"),
                commentTextarea);

    }

    @Test
    public void TC_05_LogOut(){
        driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();
        sleepInSecond(5);
        if (driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']")).isDisplayed()) {
            driver.findElement(By.xpath("//li/a[text()='Logout']")).click();
        } else {
            System.out.println("drop down chua duoc mo ra");
        }
    }

    @Test
    public void TC_06_Login_with_newUsername(){
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName );
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleepInSecond(5);
        driver.findElement(By.xpath("//span[text()='My Info']/parent::a")).click();
        sleepInSecond(5);
    }

    @Test
    public void TC_07_Verify_newUser(){
        Assert.assertEquals(
                driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"),
                firstName
        );

        Assert.assertEquals(
                driver.findElement(By.xpath("//input[@name='middleName']")).getAttribute("value"),
                middleName
        );

        Assert.assertEquals(
                driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"),
                lastName
        );

        Assert.assertEquals(
                driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"),
                employeeID
        );

        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        sleepInSecond(5);

        driver.findElement(By.xpath("//i [@class='oxd-icon bi-pencil-fill']/parent::button")).click();
        sleepInSecond(5);

        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"),
                passPortID);

        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"),
                commentTextarea);
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    public void sleepInSecond (long sleepTime){
        try {
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public String randPassportID (){
        Random rand = new Random();
        return rand.nextInt(1000,9999) + "-" + rand.nextInt(1000,9999) + "-" + rand.nextInt(1000,9999);
    }
}
