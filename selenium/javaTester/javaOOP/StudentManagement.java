package javaTester.javaOOP;

public class StudentManagement {
    //Attribute
    private String name;
    private String address;
    private String birth;
    private double gpa;

    //methods
    // Constructor - hàm tạo không tham số kiểu trả về void
    StudentManagement(){
        System.out.println("Constructor !");
    }

    // Constructor - hàm tạo có tham số
    StudentManagement(String ten, String diachi, String ngaysinh, double diem){
        name = ten;
        address = diachi;
        birth = ngaysinh;
        gpa = diem;
    }

    public void infor(){
        System.out.println(name + " " + address + " " + birth +" " + gpa);
    }

}
