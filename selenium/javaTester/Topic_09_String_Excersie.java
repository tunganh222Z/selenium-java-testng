package javaTester;

import org.testng.annotations.Test;

public class Topic_09_String_Excersie {
    String courseName = "Automation Testing Advanced";

    @Test
    public void TC_01(){
        // Tách từng ký tự
        String[] courseNameArray = courseName.split("");
        int countUpperCase = 0;
        for (String charCourse : courseNameArray){
            if (charCourse.charAt(0) <= 'Z' && charCourse.charAt(0) >= 'A'){
                countUpperCase++;
            }

        }
        System.out.println(countUpperCase);
    }
}
