package Dynamic_Programming;

import java.util.Scanner;

public class Q_1495 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 곡의 갯수
        int s = sc.nextInt(); // 시작 볼륨
        int m = sc.nextInt(); // 볼륨 범위

        int[] vol = new int[n + 1];
        boolean[][] dp = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            vol[i] = sc.nextInt();
        }

        sc.close();

        dp[0][s] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i][j] == false)
                    continue;
                if (j - vol[i + 1] >= 0) {
                    dp[i + 1][j - vol[i + 1]] = true;
                }
                if (j + vol[i + 1] <= m) {
                    dp[i + 1][j + vol[i + 1]] = true;
                }
            }
        }

        int ans = -1;
        for (int i = 0; i <= m; i++) {
            if (dp[n][i]) {
                ans = i;
            }
        }

        System.out.println(ans);
    }

}
