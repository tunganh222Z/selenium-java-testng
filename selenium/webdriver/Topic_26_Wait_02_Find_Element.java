package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_26_Wait_02_Find_Element {
    WebDriver driver;
    WebDriverWait explicitWait;
    FluentWait<WebDriver> fluentWait;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        fluentWait = new FluentWait<>(driver);
        //v4
        //explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //fluentWait.withTimeout(Duration.ofSeconds(10));

        //v3
        //explicitWait = new WebDriverWait(driver, 10);
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //fluentWait.withTimeout(10,TimeUnit.SECONDS);

        driver.manage().window().maximize();
    }

    @Test
    public void TC_01_FindElement(){
        //case1 Element được tìm thấy chỉ có 1
        // Nếu element được tìm thấy thì không cần chờ hết timeouts,
        // tìm thấy se trả về 1 WebElement,
        // qua step tiếp theo
        System.out.println("Start step: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input#email"));
        System.out.println("End step: " + getDateTimeNow());


        //case 2 - Element được tìm thấy nhưng có nhiều hơn 1
        //sẽ không cần chờ hết time out,
        // nó sẽ lấy cái element đầu tiên dù tìm được cả N node
        // qua step tiếp theo
        System.out.println("Start step: " + getDateTimeNow());
        driver.findElement(By.cssSelector("input [type='text'], [type='password']")).sendKeys("tunganh@gmail.com");
        System.out.println("End step: " + getDateTimeNow());

        //case 3 - Element không được tìm thấy
        //Chờ hết timeout là 10s, cứ mỗi nửa giây tìm lại một lần,
        // nếu tìm lại mà thấy thì cũng trả về element rồi qua step tiếp theo
        //Nếu tìm lại mà không thấy hết timeout thì
        // đánh fail testcase này luôn và throw exception : No Such element
        System.out.println("Start step: " + getDateTimeNow());
        driver.findElements(By.cssSelector("input[name='reg_email__']"));
        System.out.println("End step: " + getDateTimeNow());


    }

    @Test
    public void TC_02_FindElements(){
        List<WebElement> elementList;
        //case1 Element được tìm thấy chỉ có 1
        // Không cần chờ hết timeouts 10s,
        // trả về một list elements chứa đúng 1 element
        System.out.println("Start step: " + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector(""));
        System.out.println("List have :" + elementList.size());
        System.out.println("End step: " + getDateTimeNow());

        //case 2 - Element được tìm thấy nhưng có nhiều hơn 1
        System.out.println("Start step: " + getDateTimeNow());
        driver.findElements(By.cssSelector(""));
        System.out.println("End step: " + getDateTimeNow());

        //case 3 - Element không được tìm thấy
        //Chờ hết timeout là 10s, cứ mỗi nửa giây tìm lại một lần,
        // nếu tìm lại mà thấy thì cũng trả về list elements rồi qua step tiếp theo
        //Nếu tìm lại mà không thấy hết timeout thì
        // trả về list rỗng và chạy qua step tiếp theo
        System.out.println("Start step: " + getDateTimeNow());
        driver.findElements(By.cssSelector(""));
        System.out.println("End step: " + getDateTimeNow());
    }

    public String getDateTimeNow(){
        Date date = new Date();
        return date.toString();
    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}
