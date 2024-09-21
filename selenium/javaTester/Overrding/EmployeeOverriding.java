package javaTester.Overrding;

public class EmployeeOverriding extends PersonOverriding {
    @Override
    public void sleep(){
        System.out.println( "4 tieng" );
    }
    public void eat(){
        System.out.println("com ga 10k");
    }
}
