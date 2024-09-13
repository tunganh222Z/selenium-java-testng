package javaTester;

public class Topic_04_Casting_Type {
    public static void main(String[] args) {
        // có 2 cách ép kiểu Primitive, Reference
        //Trong ép kiểu Primitive gồm 2 loại
        // Ngầm định implicit : kiểu dữ liệu nhỏ lên dữ liệu lớn, kiểu này không làm mất dữ liệu byte > short ...widening
        // Tường minh explicit : Từ kiểu lớn về kiểu nhỏ, kiểu này làm mất dữ liệu

        //implicit
        byte bNumber = 25;
        short sNumber = bNumber;
        int iNumber = sNumber;
        long lNumber = iNumber;
        //explicit
        double dNumber = 928392.0290293;
        float fNumber = (float) dNumber;
        System.out.println(fNumber);
        int iNumber1 = (int) dNumber;
        System.out.println(iNumber1);
    }
}
