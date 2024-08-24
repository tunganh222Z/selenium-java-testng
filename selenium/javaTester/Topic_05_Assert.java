package javaTester;

import graphql.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Topic_05_Assert {
    WebDriver driver;
    @Test
    public void verifyTestNG(){
        // Trong java co rat nhieu thu vien de verify du lieu
        // testing framework (unit / intergration / UI automation test)
        // JUnit 4 / TestNG / JUnit 5 /  AssertJ / ....
        // cac ham tra ve kieu du lieu boolean
        // quy tac bat dau voi tien to la isXXX
        driver.findElement(By.xpath("")).isDisplayed();
        driver.findElement(By.xpath("")).isEnabled();
        driver.findElement(By.xpath("")).isSelected();


        //Unit test
        Object name = null;
        Assert.assertNull(name);

    }
}
