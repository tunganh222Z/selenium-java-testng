package javaTester.javaOOP;

public class Topic_03_Method {
    void showCarName(){
        System.out.println("Huyndai cerato");
    }

    static void showCarColor(){
        System.out.println("pink");
    }
    public static void main(String[] args) {
        showCarColor();

        Topic_03_Method newObject = new Topic_03_Method();
        newObject.showCarName();
    }
}
