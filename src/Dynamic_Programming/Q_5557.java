package Dynamic_Programming;

import java.util.Scanner;

public class Q_5557 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        n -= 1;
        int[] a = new int[n];
        long[][] dp = new long[100][21]; // i 까지 수를 사용해서 j를 만드는 방법의 수

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int goal = sc.nextInt();
        sc.close();

        dp[0][a[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 20; j++) {
                if (j - a[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - a[i]];
                }
                if (j + a[i] <= 20) {
                    dp[i][j] += dp[i - 1][j + a[i]];
                }
            }
        }
        long ans = dp[n - 1][goal];
        System.out.println(ans);
    }

}
