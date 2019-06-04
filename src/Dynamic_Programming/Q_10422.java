package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class Q_10422 {
    static final long MOD = 1000000007;
    static long[][] dp = new long[2501][2501]; // 여는 괄호 i개 닫는 괄호 j 개 있는 문자열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < 2501; i++) {
            Arrays.fill(dp[i], -1);
        }

        while (T-- > 0) {
            int n = sc.nextInt();

            if (n % 2 == 0) {
                System.out.println(solve(n / 2, n / 2)); // 문자열 길이가 짝수면
            } else {
                System.out.println(0); // 문자열 길이가 홀수면
            }
        }
        sc.close();

    }

    private static long solve(int i, int j) {
        // i : 여는 괄호 갯수 j : 닫는 괄호 갯수
        if (i < j) {
            return 0;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }

        long ans = dp[i][j];
        if (ans != -1) { // 메모이제이션 1
            return ans %= MOD;
        }

        ans = 0;
        dp[i][j] = solve(i - 1, j) + solve(i, j - 1); // 메모이제이션 2
        ans = dp[i][j] % MOD;

        return ans;
    }
}
