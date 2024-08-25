package webdriver;

import org.openqa.selenium.By;
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
import java.util.List;
import java.util.Random;

public class Topic_11_CustomDropdown {
    WebDriver driver;
    //Wait tường minh : một trạng thái cụ thể cho một element như
    // Visible, Invisible, Present, số lượng elemts, wait element có được click hay không, ...
    WebDriverWait explicitWait;

    public String random(){
        Random rand = new Random();
        return "random" + rand.nextInt();
    }

    public void sleepInSecond (long timeSleep){
        try {
            Thread.sleep(timeSleep * 1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        // Wait ngầm định : không rõ ràng cho một cái trạng thái của một element, chỉ rõ ràng cho việc tìm find element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_Jquery_Custom_Dropdown(){
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        // 1. Click vào dropdown thì show ra danh sách để chọn

        // 2.1 Danh sách sẽ show ra các items cần chọn
        // 2.2 Danh sách sẽ show ra nhưng những items khác bên dưới còn đang load ( nhiều khi có tới cả ngàn/triệu bản ghi trong đó )
            // wait
            // Visible : nhìn thấy được/thao tác được : có trên UI + có trong HTML
            // Present :  Có / không có trên UI hoặc có trong HTML


        // all items dang luu trong allItems


        // 3.1 Nếu như item cần chọn hiển thị thì click vào chọn


        // 3.2 Nếu như item cần chọn nằm bên dưới thì 1 số trường hợp cần phải scroll down xuống để hiển thị lên rồi mới chọn

        // 4. trước khi click cần kiểm tra xem text của item = item cần chọn thì click vào
        String itemtextexpected = "8";
        selectItemDropdown(
                "//span[@id='number-button']",
                "//ul[@id='number-menu']//div",
                itemtextexpected);
        // verify
        WebElement verifyItem =  driver.findElement(By.xpath("//span[@id='number-button']/span [@class='ui-selectmenu-text']"));
        Assert.assertEquals(verifyItem.getText(), itemtextexpected);

    }

    @Test
    public void TC_02_React_Custom_Dropdown(){
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        String itemSelected = "Stevie Feliciano";
        selectItemDropdown("//div[@class='ui fluid selection dropdown']",
                "//div[@role='option']",
                itemSelected);

        WebElement selectedOption = driver.findElement(By.xpath("//div[@class='divider text']"));
        System.out.println("Value selected is :" + selectedOption.getText());
        Assert.assertEquals(selectedOption.getText(), itemSelected);
    }

    @Test
    public void TC_03_VueJS_Custom_Dropdown(){
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        String itemSelected = "Third Option";
        selectItemDropdown("//li [@class='dropdown-toggle']",
                "//ul [@class='dropdown-menu']//a",
                itemSelected);
    }
    @Test
    public void TC_04_Editable_Dropdown(){
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

        String itemSearch = "a";
        String expectedItem = "Bahrain";

        WebElement parrent = driver.findElement(By.xpath("//input[@class='search']"));
        parrent.click();
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));

        parrent.sendKeys(itemSearch);
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));

        List<WebElement> itemsAfterSearch = driver.findElements(By.xpath("//div[@role='option']"));
        for (int i = 0; i < itemsAfterSearch.size(); i++){
            String textItem = itemsAfterSearch.get(i).getText();
            if (textItem.equals(expectedItem)){
                itemsAfterSearch.get(i).click();
                System.out.println(itemsAfterSearch.get(i));
            }
        }
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    public void selectItemDropdown(String parrentXpath, String childItemXpath, String itemTextExpected){
        driver.findElement(By.xpath(parrentXpath)).click();
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemXpath)));
        List<WebElement> allItems = driver.findElements(By.xpath(childItemXpath));
        for ( int i = 0 ; i < allItems.size() ; i++){
            String textItem = allItems.get(i).getText();
            System.out.println(textItem);
            if (textItem.equals(itemTextExpected)){
                allItems.get(i).click();
                break;
            }
        }
    }
}
