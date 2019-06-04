package Dynamic_Programming;

import java.util.Scanner;

public class Q_2293 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coin = new int[n];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        sc.close();

        dp[0] = 1;

        for (int i = 0; i < coin.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (j - coin[i] >= 0) {
                    dp[j] += dp[j - coin[i]];
                }
            }
        }

        System.out.println(dp[k]);
    }

}
