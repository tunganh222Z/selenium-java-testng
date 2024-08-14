package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Topic_01_Data_Type {
    FirefoxDriver firefoxDriver = new FirefoxDriver();
    Select select = new Select(firefoxDriver.findElement(By.className("")));
    // interface
    WebDriver driver;
    JavascriptException jsExecutor;
    //Object
    Object name = "Automation FC";
    // array
    int[] studentname = {15,20,30,50};
    String[] namestudent = {"tesst","arraystring"};
    //collection
    List<String> studenaddress = new ArrayList<String>();
}
