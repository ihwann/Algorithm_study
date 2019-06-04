package Brute_Force;

import java.util.Scanner;

public class Q_2309 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 9;
        int sum = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }
        sc.close();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((sum - a[i] - a[j]) == 100) {
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j)
                            continue;
                        System.out.println(a[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }

}
