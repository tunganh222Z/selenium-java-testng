package javaTester.javaOOP;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Topice_05_This_Super extends BaseOOP {
    private int firstNumber;
    private int secondNumber;
    WebDriver driver;
    private long ShortTimeout ;
    private long longTimeout;

    public void setImplicitWait() {
        driver.manage().timeouts().implicitlyWait(super.longTimeout, TimeUnit.SECONDS);
    }



    public Topice_05_This_Super (int firstNumber, int secondNumber ){
        super();
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public void sNumber() {
        System.out.println(firstNumber + secondNumber);
    }

    public void showNumber(){
        this.sNumber();
    }




    public static void main(String[] args) {
        Topice_05_This_Super topic = new Topice_05_This_Super(15,7);
        topic.sNumber();
    }
}
