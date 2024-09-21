package javaTester.JavaForTester;

import org.testng.annotations.Test;

import java.util.Scanner;

public class Topic_08_Array {
    Scanner sc = new Scanner(System.in);

    @Test
    public void TC_01_Array() {
        int[] number = new int[5];
        for (int i = 0; i < 5; i++) {
            number[i] = sc.nextInt();
        }
    }

}
