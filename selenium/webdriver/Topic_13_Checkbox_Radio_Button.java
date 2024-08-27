package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Topic_13_Checkbox_Radio_Button {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_Default_Telerik(){
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        WebElement checkBox = driver.findElement(By.xpath("//label[text()='Rear side airbags']/preceding-sibling::span/input"));
            if (!checkBox.isSelected()){
                System.out.println("check box is not selected");
            }
            Assert.assertTrue(checkBox.isSelected());


    }

    @Test
    public void TC_02_Default_Telerik_radioBtn(){
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");

        By radiobtn = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");

    }

    @Test
    public void TC_03_Select_All_Checkbox(){
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        By checkBoxItems = By.xpath("//ul[@class='fieldlist']/li/span/input[@type='checkbox']");
        List<WebElement> listItems = driver.findElements(checkBoxItems);
        Assert.assertTrue(listItems.get(2).isEnabled());


        //selectAllCheckbox(checkBoxItems);

    }

    @Test
    public void TC_04_Custom_Checkbox(){
        driver.get("https://login.ubuntu.com/");
        By checkbox = By.xpath("//input[@id='id_new_user']");
        clickJS(checkbox);
    }


    @AfterClass
    public void afterClass(){
        //driver.quit();
    }

    public void selectAllCheckbox(By xpath){
        List<WebElement> listItems = driver.findElements(xpath);
        for (int i = 0; i < listItems.size(); i++){
            if (!listItems.get(i).isSelected() && !listItems.get(i).isEnabled()){
                listItems.get(i).click();
                System.out.println("check box index "+ i + " is selected");
            } else {
                System.out.println("check box index " + i + " is selected before");
            }
        }
    }

    public void checkRadioBtn (By byXpath){
        if (!driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            System.out.println("Radio Btn is selected");
        } else {
            System.out.println("Radio btn has been selected before");
        }
    }

    public void clickJS (By byXpath){
        JavascriptExecutor jsClick = (JavascriptExecutor) driver;
        jsClick.executeScript("arguments[0].click();", driver.findElement(byXpath));
    }
}
