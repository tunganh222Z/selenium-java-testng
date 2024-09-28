package javaTester.JavaForTester.phoneWithoutFactory;

public class EndUser {
    public static void main(String[] args) {
        // Quận 3 - iPhone
        Iphone iPhone = new Iphone();
        iPhone.setPhoneName("Iphone 14 proMax");
        System.out.println(iPhone.getPhoneName());
        // Quận 5 - Samsung
        Samsung samsung = new Samsung();
        samsung.setPhoneName("Samsung galaxy s22");
        System.out.println(samsung.getPhoneName());
        // Quận 8 - Oppo
        Oppo oppo = new Oppo();
        oppo.setPhoneName("OppoRenoX8");
        System.out.println(oppo.getPhoneName());
    }
}
