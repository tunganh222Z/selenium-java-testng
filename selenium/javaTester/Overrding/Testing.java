package javaTester.Overrding;

public class Testing {

    public static void main(String[] args) {
        PersonOverriding p = new PersonOverriding(){
            @Override
            public void sleep(){

            }
        };
        p.eat();
        StudentOverriding s = new StudentOverriding();
        s.eat();
        s.sleep();
    }
}
