package math;

import java.util.Scanner;

public class Q_1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        int t = sc.nextInt();
        int[] a = new int[t];
        for (int i = 0; i < t; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < t; i++) {
            if (prime(a[i])) {
                cnt++;
            }
        }
        sc.close();
        System.out.println(cnt);
    }

    public static boolean prime(int a) {
        if (a < 2)
            return false;
        else {
            for (int j = 2; j * j <= a; j++) {
                if (a % j == 0)
                    return false;
            }
        }
        return true;
    }
}
