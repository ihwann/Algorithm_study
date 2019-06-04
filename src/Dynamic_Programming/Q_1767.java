package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class Q_1767 {
//	d[n][m][k] : n * m 체스판에 룩 k 개를 놓는 경우의 수 (모든 룩은 최대 1개까지 룩에게 공격 받을 수 있다.)
//	1. n 행에 룩을 0개만 놓는 경우 d[n][m][k] = d[n-1][m][k]
//	2. n 행에 룩을 1개만 놓는 경우(같은 열에 룩이 없음) d[n][m][k] = d[n-1][m-1][k-1] * m
//						   (같은 열에 룩이 있음) d[n][m][k] = d[n-2][m-1][k-2] * m(n-1)
//	3. n 행에 룩을 2개만 놓는 경우 d[n][m][k] = d[n-1][m-2][k-2] * m(m-1)/2
//	4. n 행에 룩을 3개 놓는 경우(룩은 한개까지만 공격 받으므로 3개 놓을 수 없음)

    static final int MOD = 1000001;
    static long[][][] chess = new long[101][101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        sc.close();

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(chess[i][j], -1);
            }
        }

        System.out.println(solve(n, m, k));
    }

    private static long solve(int n, int m, int k) {
        if (k == 0) { // 놓을 룩의 갯수가 없는 경우
            return 1;
        }

        if (n <= 0 || m <= 0 || k < 0) {
            return 0;
        }

        if (chess[n][m][k] != -1) {
            return chess[n][m][k] % MOD;
        }

        chess[n][m][k] = solve(n - 1, m, k)
                + solve(n - 1, m - 1, k - 1) * m
                + solve(n - 2, m - 1, k - 2) * (m * (n - 1))
                + solve(n - 1, m - 2, k - 2) * (m * (m - 1)) / 2;

        chess[n][m][k] %= MOD;

        return chess[n][m][k];

    }
}
