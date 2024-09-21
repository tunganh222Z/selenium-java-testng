package javaTester.Overrding;

public class StudentOverriding extends PersonOverriding implements IWork{
    @Override
    public void eat(){
        System.out.println("com ga 15k");
    }

    @Override
    public void sleep(){
        System.out.println("20 tieng");
    }

    @Override
    public void workingTime(){
        System.out.println("15h per week");
    }

}
