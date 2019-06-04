package Dynamic_Programming;

import java.util.Scanner;

public class Q_12996 {
    static final long mod = 1000000007;
    static long[][][][] d = new long[51][51][51][51];

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= a; j++) {
                for (int k = 0; k <= b; k++) {
                    for (int l = 0; l <= c; l++) {
                        d[i][j][k][l] = -1;
                    }
                }
            }
        }


        sc.close();
        System.out.println(solve(n, a, b, c));
    }

    private static long solve(int n, int a, int b, int c) {
        // TODO Auto-generated method stub
        if (n == 0) {
            if (a == 0 && b == 0 && c == 0)
                return 1;
            else
                return 0;
        }
        if (a < 0 || b < 0 || c < 0)
            return 0;

        long ans = d[n][a][b][c];

        if (ans != -1)
            return ans;

        ans = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    if (i + j + k == 0)
                        continue;
                    ans += solve(n - 1, a - i, b - j, c - k);
                }
            }
        }
        ans %= mod;
        d[n][a][b][c] = ans;

        return d[n][a][b][c];
    }
}
