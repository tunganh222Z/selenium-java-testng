package javaTester.javaOOP;

public interface IComputer {
    // không thằng nào đc phép chứa method thường trong interface
    //nếu không gán từ khóa Abstract cho hàm thì interface tự hiểu là abstract
    public void showComputerPerformance();
    //
    public abstract void ShowComputerRam();
}
