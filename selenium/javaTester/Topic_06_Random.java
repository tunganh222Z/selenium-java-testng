package javaTester;

import java.util.Random;

public class Topic_06_Random {
    //Java built in : cung cấp sẵn chỉ việc lấy ra sử dụng

    // java Libraries do một cá nhân hay tổ chức viết mình sử dụng lại,
    // những nơi yêu cầu bảo mật cao thì không được dùng thư viện ngoài
    public static void main(String[] agrs){
        Random rand = new Random();
        rand.nextInt(0,9999);
    }
}
