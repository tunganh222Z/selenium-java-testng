package javaTester.javaOOP.Java28Exercise.Bai1;

public class QuanLySv {
    //Attribute
    private String hoTen;
    private String ngaySinh;
    private double diem1;
    private double diem2;
    private double diem3;
    private double tongdiem;

    public double getTongdiem(double diem1, double diem2, double diem3){
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
        return this.tongdiem = (diem1 + diem2 + diem3)/3;
    }

    public void setTongdiem(){
        System.out.println(tongdiem);
    }
}
