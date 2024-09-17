package javaTester.javaOOP;

public class CarOOP {
    //Body

    // Nested class // inner class
    public class Pupil {
        String test = "abc";
    }
    public static void main(String[] args){
        CarOOP car = new CarOOP();
        // CarrOOP là một Class
        // car là một instance / biến kiểu Class / object
        CarOOP.Pupil puppil = car.new Pupil();
        System.out.println(puppil.test);

    }
}
