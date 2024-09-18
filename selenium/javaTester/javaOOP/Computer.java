package javaTester.javaOOP;

public abstract class Computer {
    //normal method
    public void showComputerPerformance(){
        System.out.println("Over power");
    }

    //Abstract method
    // phần khung để class kế thừa nó phải override lại (implement) lại
    public abstract void showComputerRam();
}
