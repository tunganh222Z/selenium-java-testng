package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_06_Exercise_XpathAndCss {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {


        driver = new

                FirefoxDriver();
        driver.manage().

                timeouts().

                implicitlyWait(30, TimeUnit.SECONDS);


    }



    @Test
    public void TC_01_RegisterWithEmptyData(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //Click button dang ky
        driver.findElement(
                By.xpath("//div[@class='field_btn']/button"))
                .click();
        // kiem tra error messages
            //Ho va ten
        String Hovaten = driver.findElement(By.xpath("//label[@id='txtFirstname-error']")).getText();
        Assert.assertTrue(Hovaten.equals("Vui lòng nhập họ tên"));
            //Email
        String NhapEmail = driver.findElement(By.xpath("//label[@id='txtEmail-error']")).getText();
        Assert.assertEquals(NhapEmail,"Vui lòng nhập email");
            //NhaplaiEmail
        String NhaplaiEmail = driver.findElement(By.xpath("//label[@id='txtCEmail-error']")).getText();
        Assert.assertEquals(NhaplaiEmail,"Vui lòng nhập lại địa chỉ email");
            // nhapmatkhau
        String NhapPassword = driver.findElement(By.xpath("//label[@id='txtPassword-error']")).getText();
        Assert.assertEquals(NhapPassword,"Vui lòng nhập mật khẩu");
            // nhaplaimatkahu
        String NhaplaiPassword = driver.findElement(By.xpath("//label[@id='txtCPassword-error']")).getText();
        Assert.assertEquals(NhaplaiPassword,"Vui lòng nhập lại mật khẩu");
            // nhapsodienthoai
        String NhapSDT  = driver.findElement(By.xpath("//label[@id='txtPhone-error']")).getText();
        Assert.assertEquals(NhapSDT,"Vui lòng nhập số điện thoại.");
    }

    @Test
    public void TC_02_RegisterWithInvalidEmail(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //ho va ten textbox
        driver.findElement(
                By.xpath("//input [@id='txtFirstname']"))
                .sendKeys("Ma Doan Tung Anh");
        //Dia chi email textbox
        driver.findElement(
                By.xpath("//input [@id='txtEmail']"))
                .sendKeys("123@4123$#");
        // nhap lai email textbox
        driver.findElement(
                By.xpath("//input [@id='txtCEmail']"))
                .sendKeys("123@4123$#");
        // mat khau textbox
        driver.findElement(
                By.xpath("//input [@id='txtPassword']"))
                .sendKeys("Makhaumoi123@");
        // nhap lai mat khau texbox
        driver.findElement(
                By.xpath("//input [@id='txtCPassword']"))
                .sendKeys("Makhaumoi123@");
        // nhap sdt texbox
        driver.findElement(
                By.xpath("//input [@id='txtPhone']"))
                .sendKeys("0376636682");
        //Email
        String NhapEmail = driver.findElement(
                By.xpath("//label[@id='txtEmail-error']"))
                .getText();
        Assert.assertEquals(NhapEmail,"Vui lòng nhập email hợp lệ");

        //NhaplaiEmail
        String NhaplaiEmail = driver.findElement(
                By.xpath("//label[@id='txtCEmail-error']"))
                .getText();
        Assert.assertEquals(NhaplaiEmail,"Email nhập lại không đúng");
        //Click button dang ky
        driver.findElement(
                        By.xpath("//div[@class='field_btn']/button"))
                .click();

    }
    @Test
    public void TC_03_RegisterWithIncorrectConfirmEmail(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //ho va ten textbox
        driver.findElement(
                        By.xpath("//input [@id='txtFirstname']"))
                .sendKeys("Ma Doan Tung Anh");
        //Dia chi email textbox
        driver.findElement(
                        By.xpath("//input [@id='txtEmail']"))
                .sendKeys("tunganh97tuaf@gmail.com");
        // nhap lai email textbox
        driver.findElement(
                        By.xpath("//input [@id='txtCEmail']"))
                .sendKeys("tunganh97tuaf@gmail.net");
        // mat khau textbox
        driver.findElement(
                        By.xpath("//input [@id='txtPassword']"))
                .sendKeys("Makhaumoi123@");
        // nhap lai mat khau texbox
        driver.findElement(
                        By.xpath("//input [@id='txtCPassword']"))
                .sendKeys("Makhaumoi123@");
        // nhap sdt texbox
        driver.findElement(
                        By.xpath("//input [@id='txtPhone']"))
                .sendKeys("0376636682");

        //NhaplaiEmail
        String NhaplaiEmail = driver.findElement(
                        By.xpath("//label[@id='txtCEmail-error']"))
                .getText();
        Assert.assertEquals(NhaplaiEmail,"Email nhập lại không đúng");
        //Click button dang ky
        driver.findElement(
                        By.xpath("//div[@class='field_btn']/button"))
                .click();

    }
    @Test
    public void TC_04_RegisterWithPassword_lessThan6Chars(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //ho va ten textbox
        driver.findElement(
                        By.xpath("//input [@id='txtFirstname']"))
                .sendKeys("Ma Doan Tung Anh");
        //Dia chi email textbox
        driver.findElement(
                        By.xpath("//input [@id='txtEmail']"))
                .sendKeys("tunganh97tuaf@gmail.com");
        // nhap lai email textbox
        driver.findElement(
                        By.xpath("//input [@id='txtCEmail']"))
                .sendKeys("tunganh97tuaf@gmail.com");
        // mat khau textbox
        driver.findElement(
                        By.xpath("//input [@id='txtPassword']"))
                .sendKeys("Pword");
        // nhap lai mat khau texbox
        driver.findElement(
                        By.xpath("//input [@id='txtCPassword']"))
                .sendKeys("Pword");
        // nhap sdt texbox
        driver.findElement(
                        By.xpath("//input [@id='txtPhone']"))
                .sendKeys("0376636682");
        //Passwordlength less than 6
        String Passwordlenght = driver.findElement(
                        By.xpath("//label[@id='txtPassword-error']"))
                .getText();
        Assert.assertEquals(Passwordlenght,"Mật khẩu phải có ít nhất 6 ký tự");

        //RePasswordlength less than 6
        String RePasswordlength = driver.findElement(
                        By.xpath("//label[@id='txtCPassword-error']"))
                .getText();
        Assert.assertEquals(RePasswordlength,"Mật khẩu phải có ít nhất 6 ký tự");
        //Click button dang ky
        driver.findElement(
                        By.xpath("//div[@class='field_btn']/button"))
                .click();

    }
    @Test
    public void TC_05_RegisterWithIncorrectConfirmPassword(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //ho va ten textbox
        driver.findElement(
                        By.xpath("//input [@id='txtFirstname']"))
                .sendKeys("Ma Doan Tung Anh");
        //Dia chi email textbox
        driver.findElement(
                        By.xpath("//input [@id='txtEmail']"))
                .sendKeys("tunganh97tuaf@gmail.com");
        // nhap lai email textbox
        driver.findElement(
                        By.xpath("//input [@id='txtCEmail']"))
                .sendKeys("tunganh97tuaf@gmail.com");
        // mat khau textbox
        driver.findElement(
                        By.xpath("//input [@id='txtPassword']"))
                .sendKeys("Pword123@");
        // nhap lai mat khau texbox
        driver.findElement(
                        By.xpath("//input [@id='txtCPassword']"))
                .sendKeys("Pword123");
        // nhap sdt texbox
        driver.findElement(
                        By.xpath("//input [@id='txtPhone']"))
                .sendKeys("0376636682");

        //Passwordlength less than 6
        String Passwordlenght = driver.findElement(
                        By.xpath("//label[@id='txtCPassword-error']"))
                .getText();
        Assert.assertEquals(Passwordlenght,"Mật khẩu bạn nhập không khớp");
        //Click button dang ky
        driver.findElement(
                        By.xpath("//div[@class='field_btn']/button"))
                .click();
    }
    @Test
    public void TC_06_RegisterWithInvalidPhoneNumber(){
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        //Verify it hon 10 ky tu
        //ho va ten textbox
        driver.findElement(
                        By.xpath("//input [@id='txtFirstname']"))
                .sendKeys("Ma Doan Tung Anh");
        //Dia chi email textbox
        driver.findElement(
                        By.xpath("//input [@id='txtEmail']"))
                .sendKeys("tunganh97tuaf@gmail.com");
        // nhap lai email textbox
        driver.findElement(
                        By.xpath("//input [@id='txtCEmail']"))
                .sendKeys("tunganh97tuaf@gmail.com");
        // mat khau textbox
        driver.findElement(
                        By.xpath("//input [@id='txtPassword']"))
                .sendKeys("Pword123@");
        // nhap lai mat khau texbox
        driver.findElement(
                        By.xpath("//input [@id='txtCPassword']"))
                .sendKeys("Pword123@");
        // nhap sdt texbox
        driver.findElement(
                        By.xpath("//input [@id='txtPhone']"))
                .sendKeys("03766366");
        //Click button dang ky
        driver.findElement(
                        By.xpath("//div[@class='field_btn']/button"))
                .click();
        //Sdt less than 10 char
        String Phonenumber9char = driver.findElement(
                        By.xpath("//label[@id='txtPhone-error']"))
                .getText();
        Assert.assertEquals(Phonenumber9char,"Số điện thoại phải từ 10-11 số.");

        //Verify lon hon 11 ky tu
        //clear textbox
        driver.findElement(
                By.xpath("//input [@id='txtPhone']"))
                .clear();
        // nhap sdt texbox
        driver.findElement(
                        By.xpath("//input [@id='txtPhone']"))
                .sendKeys("0376636668235");
        //Click button dang ky
        driver.findElement(
                        By.xpath("//div[@class='field_btn']/button"))
                .click();

        //Sdt less than 10 char
        String Phonenumber12char = driver.findElement(
                        By.xpath("//label[@id='txtPhone-error']"))
                .getText();
        Assert.assertEquals(Phonenumber12char,"Số điện thoại phải từ 10-11 số.");

        // verify sdt # center phone
        //clear textbox
        driver.findElement(
                        By.xpath("//input [@id='txtPhone']"))
                .clear();
        // nhap sdt texbox
        driver.findElement(
                        By.xpath("//input [@id='txtPhone']"))
                .sendKeys("12345678910");
        //Click button dang ky
        driver.findElement(
                        By.xpath("//div[@class='field_btn']/button"))
                .click();

        //centerphone
        String phonecenterdiff = driver.findElement(
                        By.xpath("//label[@id='txtPhone-error']"))
                .getText();
        Assert.assertEquals(phonecenterdiff,"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");

    }

    @AfterClass
    public void afterClass(){
        //driver.quit();
    }
}