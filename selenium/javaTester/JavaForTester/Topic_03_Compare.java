package javaTester.JavaForTester;

public class Topic_03_Compare {
    int number = 8;
    public static void main(String[] args){
        int x = 5;
        int y = x;
        System.out.println("x = " +x);
        System.out.println("y = "+y); // y = 5 vì y đang gán cho x
        y = 10;
        System.out.println("x = " +x);
        System.out.println("y = "+y); // y = 10 vì đây là kiểu nguyên thủy, dữ liệu khai báo kiểu gì, gán gì thì nó chứa dữ liệu đó luôn
        Topic_03_Compare firstVariable = new Topic_03_Compare();
        Topic_03_Compare secondVariable = firstVariable;
        System.out.println("number = "+firstVariable.number );
        System.out.println("number = "+ secondVariable.number);
        firstVariable.number = 15; // tạo ra vùng nhớ có giá trị 15
        // kiểu tham chiếu khi thay đổi sẽ thay đổi toàn bộ
        System.out.println("number = "+firstVariable.number );
        System.out.println("number = "+ secondVariable.number);
        // 2 thằng này tham chiếu đến number đã có vùng nhớ mới nên trả ra là 15

    }
}
