package Brute_Force;

import java.util.Scanner;

public class Q_1476 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();
        sc.close();
        int e = 1, s = 1, m = 1;

        for (int i = 1; ; i++) {
            if (E == e && S == s && M == m) {
                System.out.print(i);
                break;
            }
            e += 1;
            s += 1;
            m += 1;
            if (e == 16) {
                e = 1;
            }
            if (s == 29) {
                s = 1;
            }
            if (m == 20) {
                m = 1;
            }
        }
    }
}
