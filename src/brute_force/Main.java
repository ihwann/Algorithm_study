package brute_force;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int ironStick = 0;
        int total = 0;
        Scanner scan = new Scanner(System.in);
        String test = scan.nextLine();
        char[] testArray = test.toCharArray();
        for (int i = 0; i < testArray.length; i++) {
            if (testArray[i] == '(') {
                ironStick += 1;
            } else {
                if (testArray[i - 1] == '(') {
                    ironStick -= 1;
                    total += ironStick;
                    System.out.print(total + " ");
                } else {
                    total += 1;
                    System.out.print(total + " ");
                    ironStick -= 1;
                }
            }
        }
        System.out.println();
        System.out.println(total);
    }
}