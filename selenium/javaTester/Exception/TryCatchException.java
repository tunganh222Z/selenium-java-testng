package javaTester.Exception;

import org.openqa.selenium.WebDriver;

public class TryCatchException {
    public static void main(String[] args) {
        int number = 10;

        try {
            // Đúng : chạy code block trong Try và không qua catch
            // Sai : Gặp exception thì nhảy qua Catch

            number = number / 0 ;
        } catch (ArithmeticException e){
            e.printStackTrace();
        }

        System.out.println(number);

        String[] browserName = {"Chrome", "Firefox", "Safari"};
        try {
            browserName[0] = "Edge Chromium";
            browserName[3] = "Fail out of bounds";
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            // Dù pass hay fail thì cũng phải chạy code trong này
        }

        for (String browser : browserName){
            System.out.println(browser);
        }

    }

    public static void sleepInSecond (long timeout) {
        try {
            Thread.sleep(timeout * 1000);

        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void sendkeyToAlert(WebDriver driver, String keysToSend) {
        driver.switchTo().alert().sendKeys(keysToSend);
    }
}
