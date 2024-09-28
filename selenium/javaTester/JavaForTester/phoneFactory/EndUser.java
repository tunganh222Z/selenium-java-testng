package javaTester.JavaForTester.phoneFactory;

public class EndUser {
    public static void main(String[] args) {
        PhoneFactory phone;
        phone = getPhone("iPhone");
        phone.setPhoneName("iPhone 14 Pro");
        System.out.println(phone.getPhoneName());

    }

    public static PhoneFactory getPhone(String phoneType){
        PhoneFactory phoneFactory;
        if (phoneType.equals("iPhone")){
            phoneFactory = new Iphone();
        } else if ( phoneType.equals("Samsung")){
            phoneFactory = new Samsung();
        } else {
            phoneFactory = new Oppo();
        }
        return phoneFactory;
    }
}
