package Dynamic_Programming;

import java.util.Scanner;

public class Q_2156 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        int[][] d = new int[n + 1][3];
        d[1][0] = 0;
        d[1][1] = a[1];
        if (n >= 2) {
            d[2][2] = a[1] + a[2];
            for (int k = 2; k <= n; k++) {
                d[k][0] = Math.max(d[k - 1][0], Math.max(d[k - 1][1], d[k - 1][2]));
                d[k][1] = d[k - 1][0] + a[k];
                d[k][2] = d[k - 1][1] + a[k];
            }
        }
        int ans = Math.max(d[n][0], Math.max(d[n][1], d[n][2]));
        System.out.println(ans);
    }

}
