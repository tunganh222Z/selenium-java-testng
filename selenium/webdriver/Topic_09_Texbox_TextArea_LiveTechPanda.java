package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Random;

public class Topic_09_Texbox_TextArea_LiveTechPanda {
    WebDriver driver;

    public String getEmailRand (){
        Random emailRand = new Random();

        return "automation" + emailRand.nextInt(0,99999) + "@gmail.com";

    }

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_loginWith_Empty_Email_Password(){
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSecond(3);

        driver.findElement(By.xpath("//button[@title='Login']")).click();
    }

    @Test
    public void TC_02_loginWith_Invalid_Email(){
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSecond(3);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123123123@123123.123");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@title='Login']")).click();

        WebElement validateEmail = driver.findElement(By.xpath("//div[@id='advice-validate-email-email']"));
        if (validateEmail.isDisplayed()){
            Assert.assertEquals(validateEmail.getText(), "Please enter a valid email address. For example johndoe@domain.com.");
            System.out.println("Error message is validated");
        } else {
            System.out.println("Error message is not validated");
        }
    }

    @Test
    public void TC_03_loginWith_Password_lessThan_6Chars(){
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSecond(3);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("tunganh@example.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("12345");
        driver.findElement(By.xpath("//button[@title='Login']")).click();

        WebElement validatePassword = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']"));
        if (validatePassword.isDisplayed()){
            Assert.assertEquals(validatePassword.getText(), "Please enter 6 or more characters without leading or trailing spaces.");
            System.out.println("Password message error is validated");
        } else {
            System.out.println("Password message error is not validated");
        }
    }

    @Test
    public void TC_04_loginWith_Incorrect_Password(){
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSecond(3);

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("tunganh@example.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("tunganhbkvnQ123#*^");
        driver.findElement(By.xpath("//button[@title='Login']")).click();

        WebElement errorMsg = driver.findElement(By.xpath("//li[@class='error-msg']"));
        if (errorMsg.isDisplayed()){
            Assert.assertEquals(errorMsg.getText(), "Invalid login or password.");
            System.out.println("Error message is validated");
        } else {
            System.out.println("Error message is not validated");
        }
    }

    @Test
    public void TC_05_Login_Success(){
        driver.get("http://live.techpanda.org/");

        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        sleepInSecond(2);
        //1 - đăng ký trước bằng tay manual 1 tài khoản email rồi dùng nó để login cho case này
            // Khi hệ thống bị reset dữ liệu là phải đăng ký lại
            // DB bị xóa data
            // Qua 1 môi trường mới Dev / testing / staging /production
        // 2 - Sẽ dùng tính năng Register trước - email đầu vào cố định không thay đổi
            // Email fix cứng chỉ dùng được một lần - HardCode
        // 3 - Sẽ dùng tính năng Register trước - email đầu vào không cố định / random
        driver.findElement(By.xpath("//a[@class='button']")).click();
        sleepInSecond(2);

        // Register
        String firstName = "Tung Anh",middleName = "Dep Try", lastName = "Khoai To", emailAddress = getEmailRand(), password = "Tunganh123Q!#";

        driver.findElement(By.xpath("//input [@id='firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input [@id='middlename']")).sendKeys(middleName);
        driver.findElement(By.xpath("//input [@id='lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input [@id='email_address']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input [@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input [@id='confirmation']")).sendKeys(password);
        driver.findElement(By.xpath("//input [@id='is_subscribed']")).click();
        driver.findElement(By.xpath("//div[@class='buttons-set']//button [@class='button']")).click();
        sleepInSecond(2);

        WebElement successMsg = driver.findElement(By.xpath("//li[@class='success-msg']"));
        if (successMsg.isDisplayed()){
            Assert.assertEquals(successMsg.getText(), "Thank you for registering with Main Website Store.");
            System.out.println("Success message is validate");
        } else {
            System.out.println("Success message is not validate");
        }

        String userName = firstName + " " + middleName + " " + lastName;

        WebElement welcomeUser = driver.findElement(By.xpath("//p [@class='hello']"));
        String verifyWelcomMsg = welcomeUser.getText();
        if (welcomeUser.isDisplayed()) {
            Assert.assertEquals(welcomeUser.getText(), "Hello, " + userName + "!");
            System.out.println("Welcome message is validated");
        } else {
            System.out.println("Welcome message is not validated");
        }

        WebElement userInfor = driver.findElement(By.xpath("//div[@class='col-1']//div[@class='box-content']"));
        String veriyUserInfor = userInfor.getText();
        if (userInfor.isDisplayed()){
            Assert.assertTrue(veriyUserInfor.contains(userName) && veriyUserInfor.contains(emailAddress));
            System.out.println("User Infor message is validated");
        } else {
            System.out.println("User Infor message is not validated");
        }

        driver.findElement(By.xpath("//div [@id='header-nav'] //a [contains(text(),'Mobile')]")).click();
        sleepInSecond(2);

        driver.findElement(By.xpath("//div [@class='product-info']//a [@title='Samsung Galaxy']")).click();
        sleepInSecond(2);

        driver.findElement(By.xpath("//a [contains(text(),'Add Your Review')]")).click();
        sleepInSecond(2);

        driver.findElement(By.xpath("//tr [@class='first last odd']//input [@value='5']")).click();
        driver.findElement(By.xpath("//textarea [@id='review_field']")).sendKeys("Vedy guts phone \n my grandmother love this sooooo guts \n text more for shoppee's coin");
        driver.findElement(By.xpath("//input [@id='summary_field']")).sendKeys("Vedy goooots fone");

        WebElement Nickname = driver.findElement(By.xpath("//input [@id='nickname_field']"));
        if (Nickname.isDisplayed()){
            Assert.assertEquals(Nickname.getAttribute("value"), firstName);
            System.out.println("Nick name = first name");
        } else {
            System.out.println("Nick name != first name");
        }

        driver.findElement(By.xpath("//button [@title = 'Submit Review']")).click();
        sleepInSecond(2);

        WebElement successMsgReview = driver.findElement(By.xpath("//li [@class = 'success-msg']"));
        if (successMsgReview.isDisplayed()){
            Assert.assertEquals(successMsgReview.getText(), "Your review has been accepted for moderation.");
            System.out.println("Success message review is validated");
        } else {
            System.out.println("Success message review is not validated");
        }

        driver.findElement(By.xpath("//a [@class='skip-link skip-account']")).click();
        sleepInSecond(1);

        WebElement modal = driver.findElement(By.xpath("//div[@id='header-account']"));
        if (modal.isDisplayed()){
            driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
            System.out.println("Log out successfully");
        } else {
            System.out.println("Log out fail");
        }
        sleepInSecond(6);

        Assert.assertEquals(driver.getTitle(), "Home page");

    }


    @AfterClass
    public void afterClass(){
        // driver.quit();
    }

    public void sleepInSecond(long sleepTime){
        try {
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
