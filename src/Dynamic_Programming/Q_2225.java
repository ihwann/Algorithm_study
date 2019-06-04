package Dynamic_Programming;

import java.util.Scanner;

public class Q_2225 {
    static final long MOD = 1000000000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        long[][] d = new long[k + 1][n + 1];
        d[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                for (int L = 0; L <= j; L++) {
                    d[i][j] += (d[i - 1][j - L]);
                    d[i][j] %= MOD;
                }
            }
        }
        System.out.println(d[k][n]);
        String answer = "01033334444";
        String ans = "";
        for (int i = 0; i < answer.length(); i++) {
            if (i < answer.length() - 4) {
                ans += "*";
            } else {
                ans += answer.charAt(i);
            }
        }
        //ans += "*";
        //ans += answer.charAt(5);
        System.out.print(ans);
    }

}
