package Math;

import java.util.Scanner;

public class zzzzzzzz {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[][] a = new int[2][5];
        for (int i = 0; i < 5; i++) {
            a[1][i] = s.charAt(i);
        }

        System.out.println(a[1][0]);
        System.out.println(a[1][1]);
        System.out.println(a[1][2]);
        System.out.println(a[1][3]);
        System.out.println(a[1][4]);
    }
}
