package javaTester;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_09_String {
    public static void main(String[] args){

        WebDriver driver = new FirefoxDriver();
        // kiểu nguyên thủy gán trực tiếp
        String s1 = "Cat";
        String s2 =s1;

        // kiểu theo đối tượng
        String s3 = new String("Cat");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
        System.out.println(s1.equals(s3));

        String schoolName = "Automation testing school";
        String schoolName2 ="automation testing school";
        String chuoi2 = "2024 tung anh";


        // độ dài
        schoolName.length();

        // lấy ra 1 ký tự
        System.out.println(schoolName.charAt(0));

        //nối chuỗi
        System.out.println(schoolName.concat(chuoi2));
        System.out.println(schoolName + chuoi2);

        // kiểm tra tuyệt đối
        System.out.println(schoolName.equals(chuoi2));

        // kiểm tra tương đối không phân biệt hoa thường
        System.out.println(schoolName.equalsIgnoreCase(schoolName2));

        // startsWith / endsWith / contains
        System.out.println(schoolName.startsWith("A"));
        System.out.println(schoolName.startsWith("Automation"));

        // Khi tạo .toLowerCase uppercase sẽ tạo ra vùng nhớ mới
        // vị trí của 1 ký tự / chuỗi ký tự trong chuỗi
        // đếm index từ ký tự đầu tiên trong khai báo
        schoolName.indexOf("Automation");
        schoolName.indexOf("A");
        schoolName.indexOf("testing");

        // tách ký tự / chuỗi trong chuỗi
        //.substring(startIndex, endIndex)
        schoolName.substring(11,15);


        // Split tách chuỗi thành 1 mảng dựa vào ký tự / chuỗi ký tự
        // Split (" ")
        // tách bằng khoảng trắng sẽ tạo ra các mảng là
        // String[] result ={"Automation","testing","school"};
        String[] result = schoolName.split(" ");

        // replace thay thế ký tự/ chuỗi ký tự khác
        String productPrice ="$100.00";
        productPrice = productPrice.replace("$","");

        // convert String sang float, Integer ,. . .
        float productPriceF = Float.parseFloat(productPrice);
        int productPriceI = Integer.parseInt(productPrice);
        // convert float > String
        productPrice = String.valueOf(productPriceF);

        // get osName
        String osName = System.getProperty("os.name");
        System.out.println(osName);

        String driverInstanceName = driver.toString();
        System.out.println(driverInstanceName);


        if (osName.toLowerCase().contains("windows")){
            Keys key = Keys.CONTROL;
        } else {
            Keys key = Keys.COMMAND;
        }
        // close browser / driver

        //trim
        String helloWorld = "   \n \t  helloWord       ";
        System.out.println(helloWorld.trim());

        // Dynamic locator format
        String dynamicButtonXpath = "//button[@id=%s]";
        System.out.println("Click button login" + String.format(dynamicButtonXpath, "login"));


    }
}
