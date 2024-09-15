package javaTester.javaAccmodFirst;

public class student {
    private int age;
    // chỉ có thể sử dụng age trong class này
    // gán cho biến age thông qua một cái hàm
    // chứ không truy cập trực tiếp biến age
    public void setAge(int enterAge){
        if(enterAge > 0){
            this.age = enterAge;
        } else {
            System.out.println("Enter age is invalid");
        }
    }

    public int getAge(){
        return age;
    }
}
