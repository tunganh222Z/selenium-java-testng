package javaTester.javaOOP;

public class Topic_02_Variable_Property {
    int studentNumber;
    String studentCountry;

    /*Access modifier : public private protected defaul
    Data type String
    Variable name studentName
    Variable value AutomantionFC
    Global variable*/
    private String studentName = "AutomationFC";

    // Static variable
    // dùng trong một hàm Static để gán lại
    public static String studentAddress = "Bac Kan";

    //Dùng trong phạm vi Class này (cho tất cả instance / object dùng)
    private static String studentPhone = "0909090990";

    //Final variable
    //không được phép override lại -Dữ liệu không thay đôi trong quá trình chạy
    final String country = "Vietnam";

    // Final Static variable
    // là một hằng số
    // không được override
    // có thể truy cập rộng rãi cho tất cả các instance / thread
    // TÊN BIẾN PHẢI VIẾT HOA HẾT
    static final float PI_NUMBER = 3.14f;

    // method static
    public static void main(String[] args){
        // Biến variable không phải static thì phải new object lên
        Topic_02_Variable_Property sc = new Topic_02_Variable_Property();

        //Country không phải static nên phải gọi thông qua object
        sc.country.getBytes();

        // Local variable
        String studentName ="";
        // gán cho một biến static ngoài hàm main
        studentName = studentPhone;
        if (studentName.isBlank()){
            // Block code
        }

        System.out.println(sc.studentNumber);

    }
    // Constructor
    Topic_02_Variable_Property(){
        // Local variable - Constructor
        String studentName = "Automation FC";
    }

    public void display(){
        // local variable - Ham` method non static
        String studentName = "AutomationFC";
        studentName = this.studentName;
    }
}
