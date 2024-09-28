package javaTester.JavaForTester.phoneFactory;

public class Samsung extends PhoneFactory{

    @Override
    protected void setPhoneName(String phoneName) {
        super.phoneName = phoneName;
    }

    @Override
    protected String getPhoneName() {
        return super.phoneName;
    }
}
