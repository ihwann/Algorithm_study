package Dynamic_Programming;

import java.util.Scanner;

public class Q_11057 {
    static final int mod = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        long ans = 0;
        long[][] d = new long[n + 1][10];
        for (int i = 0; i <= 9; i++) {
            d[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    d[i][j] += d[i - 1][k];
                    d[i][j] %= mod;
                }
            }
        }
        for (int i = 0; i <= 9; i++) {
            ans += d[n][i];
        }
        ans %= mod;
        System.out.println(ans);

    }

}
