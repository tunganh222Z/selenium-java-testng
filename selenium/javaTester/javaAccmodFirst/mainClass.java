package javaTester.javaAccmodFirst;

public class mainClass {
    public static void main(String[] args){
        student std = new student();
        std.setAge(15);
        //happy path case
        System.out.println(std.getAge());

        //Unhappy path case
        std.setAge(-10);
        System.out.println(std.getAge());
    }
}
