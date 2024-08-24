package webdriver;


import graphql.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_08_webElement_Commands {

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
    }



    @Test
    public void TC_01_Element(){
        // tim va tra ve 1 element
        driver.findElement(By.xpath(""));
        // tim va luu vao 1 bien webElement. Khai bao bien khi dung bien nay it nhat 2 lan >
        // cac ham nam trong WebDriver de tuong tac voi browser. WebElement la de tuong tac voi element
        WebElement tunganh = driver.findElement(By.xpath(""));
        // xoa du lieu trong 1 field input
        tunganh.clear(); // clear thuong duoc dung truoc sendkeys de dam bao tinh toan dien cua du lieu
        // input vao 1 field
        tunganh.sendKeys("sendkey");
        // click vao element do Button , duong link , check box, Radio
        tunganh.click();
        //find element roi lai find element tiep ???
        // tim tu node parent > node child
        tunganh.findElement(By.xpath("")); // viet kieu nay phuc tap lang nhang
            // find element khong nen su ung cho non-present element
            // non-present element thi su dung find elements
        // list webelement
        List<WebElement> textboxes = driver.findElements(By.xpath(""));
        // dung verify xem checkbox,... da dc chon chua
        tunganh.isSelected();
            //verify bang cach : true da chon, false chua chon
        Assert.assertTrue(tunganh.isSelected());
        Assert.assertFalse(tunganh.isSelected());
        // dung de verify xem element co hien thi hay k
        tunganh.isDisplayed();
        Assert.assertTrue(tunganh.isDisplayed());
        Assert.assertFalse(tunganh.isDisplayed());
        // Dropdown co mot thu vien rieng de handle
        // no gom 2 loai default va custom
        Select select = new Select(driver.findElement(By.xpath(""))); // default dropdown moi dung dc

        // dung de verify 1 element co thao tac len duoc khong ( khong phai la read-only )
        tunganh.isEnabled();

        //HTML Element vi du 1 HTML o duoi
        //<input type="text" name="uid" maxlength="10" onkeyup="validateuserid();" onblur="validateuserid();">
        tunganh.getAttribute("type"); // se tra ve value cua attribute truyen vao, return string de verify
        //nhuwng cai nay lien quan den accessibility va properties trong devtool
        tunganh.getAccessibleName();
        tunganh.getDomAttribute("checked");
            // lay ra properties trong dev tool
        tunganh.getDomProperty("");
        //
        tunganh.getAriaRole(); // it khi dung`
        // lay value trong tab style
        tunganh.getCssValue("background-color");
        //element nay se nam o vi tri nao so voi do phan giai man hinh // de test giao dien
        // giong getPosition()
        tunganh.getLocation();
        // ket hop giua Location + size
        tunganh.getRect();
        //Location
        Point namePoint = tunganh.getRect().getPoint();
        namePoint.getX();
        namePoint.getY();
        // size
        Dimension nameSize = tunganh.getRect().getDimension();
        nameSize.getHeight();
        nameSize.getWidth();
        // handle cac loai element duoi dang shadow element, mot so element nam trong #shadow-root
        // getshadowroot lay ra cai element do
        tunganh.getShadowRoot();
        //trong truong hop thao tac voi 1 element ma khong biet tagname la cua no la gi
        // tu 1 cai id, name, css, class co the truy ra nguoc lai tag name html
        // tai sao can lay tag name ? trong truong hop biet locator cua 1 element ma k biet ten the cua no
        // Element A => dau ra cua no la tagname cua element A
        // Dau vao Element B se nhan tagname cua Element A la tham so truyen vao
        tunganh.getTagName();
        // de chup mot cai hinh bi loi va luu duoi dang nao`
        // byte , file, base64
        // lu duoi dang PNG, JPG o local
        // base 64 luu duoi dang text
        // tunganh.getScreenshotAs("");
        // Form element nao nam trong the form, hanh vi giong phim enter
        tunganh.submit();
    }

    @Test
    public void TC_02_(){

    }

    @AfterClass
    public void afterClass(){
    driver.quit();
    }
}