package javaTester.javaOOP;

public class Student {
    public static void main(String[] args){
        StudentManagement x =
                new StudentManagement();
        StudentManagement y =
                new StudentManagement("Teo", "Hai duong",
                        "22/12/2002", 3.5);
        x.infor();
        y.infor();
    }
}
