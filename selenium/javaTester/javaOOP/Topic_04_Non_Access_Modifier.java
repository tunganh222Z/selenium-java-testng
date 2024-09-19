package javaTester.javaOOP;

public class Topic_04_Non_Access_Modifier {
    // Static : Variable / Method
    // Dùng cho tất cả các instance/object
    //phạm vi cho toàn bộ system sử dụng nó
    // có thể override được
    static String browserName = "Chrome";

    //Non-static
    String severName = "Chrome";

    public static void main(String[] args) {
        // Create Object
        Topic_04_Non_Access_Modifier nonStatic = new Topic_04_Non_Access_Modifier();
        System.out.println(nonStatic.severName);
        browserName = "firefox";
        System.out.println(browserName);
        // Static variable
        System.out.println(browserName);

        nonStatic.clickToElement("nonStatic method");
    }

    public static class NestedTesting {

    }

    public void clickToElement(String elementName){
        System.out.println(elementName);
    }

    public static void sendkeyToElement(String elementName){
        System.out.println(elementName);
    }
}
