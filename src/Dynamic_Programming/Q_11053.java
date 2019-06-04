package Dynamic_Programming;

import java.util.Scanner;

public class Q_11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
        }
        int MAX = d[0];
        for (int i = 0; i < n; i++) {
            if (MAX < d[i])
                MAX = d[i];
        }
        System.out.println(MAX);

    }

}
