package javaTester.javaOOP;

public class Topic_06_Getter_Setter {
    //Kiểm tra validate dữ liệu được
    private String personName;
    private int personAge;
    private int personPhone;

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public int getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(int personPhone) {
        this.personPhone = personPhone;
    }

    public void setPersonName(String personName){
        if (personName == null || personName.isEmpty()) {
            throw new IllegalArgumentException(" Name invalid ");
        } else {
            this.personName = personName;
        }

    }

    public String getPersonName(){
        return this.personName;
    }


}
