package javaTester.JavaForTester;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Topic_01_Data_Type {
    FirefoxDriver firefoxDriver = new FirefoxDriver();
    Select select = new Select(firefoxDriver.findElement(By.className("")));
    // interface

    JavascriptException jsExecutor;
    //Object
    Object name = "Automation FC";
    // array
    int[] studentname = {15,20,30,50};
    String[] namestudent = {"tesst","arraystring"};
    //collection
    List<String> studenaddress = new ArrayList<String>();

    //global
    static int number;
    String noneStatic = "tung anh";

    // primitive type / value type : Nguyên thủy
    // byte, short, int, long Số nguyên
    //float, double số thực
    // char character
    // boolean true/false


    // reference type : Tham chiếu
    // Array là kiểu dữ liệu được defined trước, chứa được một tập hợp các kiểu dữ liệu cùng một kiểu
    String[] studentNumber ={"ten 1", noneStatic};
    Integer[] mangSoNguyen = {12345, 444};
    Double[] mangsoThuc= {123.45,444.4,123123.0};

    // String

    // Class, Thằng Topic này là một cái biến đại diện cho thằng Topic_01_Data_Type
    Topic_01_Data_Type Topic;
    // Interface
    WebDriver driver;
    // Object có thể convert qua các kiểu dữ liệu như String, Integer, Float ...
    Object aObject;
    // Collection bao gồm :
    // List / Set/ Queue / Map
    //List lưu trùng , Set không lưu trùng
    List<WebElement> listWebElement = driver.findElements(By.xpath(""));
    Set<String> getWindows = driver.getWindowHandles();

    // Nguyên thủy không có function đi theo
    // Tham chiếu có function đi theo



    public static void main(String[] args){
        System.out.println(number);
        Topic_01_Data_Type name = new Topic_01_Data_Type();
        System.out.println(name.noneStatic);
    }
}
