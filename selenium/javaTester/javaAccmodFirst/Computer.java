package javaTester.javaAccmodFirst;

public class Computer {
    // Property
    private int ssdSize;
    String ramProductName = "Samsung";
    protected String cpuProductName;
    protected void setcpuProductName(String cpuProduct){
        cpuProductName = cpuProduct;
    }

    //method
    private void setSsdSize(int ssdSize){
        this.ssdSize = ssdSize;
    }

    public static void main(String[] args){
        Computer comp = new Computer();
        comp.ssdSize = 500;
        System.out.println(comp.ssdSize);
    }

}
