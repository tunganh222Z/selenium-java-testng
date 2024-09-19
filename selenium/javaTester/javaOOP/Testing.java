package javaTester.javaOOP;

import static javaTester.javaOOP.Topic_04_Non_Access_Modifier.browserName;


public class Testing extends Topic_04_Non_Access_Modifier{
    public static void main(String[] args){
        Topic_02_Variable_Property testingObj = new Topic_02_Variable_Property();
        Topic_04_Non_Access_Modifier testingOBJ = new Topic_04_Non_Access_Modifier();
        // có thể import hoặc gọi bằng Topic_04_Non_Access_Modifier.browserName
        System.out.println(Topic_04_Non_Access_Modifier.browserName);
        System.out.println(testingOBJ.severName);
        testingObj.studentAddress = "123";
        Topic_03_Method.showCarColor();
    }

    @Override
    public void clickToElement(String elementName){

    }

}
