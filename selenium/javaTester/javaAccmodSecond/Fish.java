package javaTester.javaAccmodSecond;


import javaTester.javaAccmodFirst.Computer;

public class Fish extends Computer {
    Computer comp = new Computer();
    public void showCPUProductName(){
        cpuProductName = "Intel";
    }


    //Cat cat = new Cat();
   // Cannot be access outside package
}
