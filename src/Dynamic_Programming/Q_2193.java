package Dynamic_Programming;

import java.util.Scanner;

public class Q_2193 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        long[][] d = new long[n + 1][2];
        long ans = 0;
        d[1][1] = 1;
        d[1][0] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j >= 0; j--) {
                if (j == 1)
                    d[i][j] = d[i - 1][0];
                if (j == 0)
                    d[i][j] = d[i - 1][0] + d[i - 1][1];
            }
        }
        ans = d[n][0] + d[n][1];
        System.out.println(ans);

    }
}
