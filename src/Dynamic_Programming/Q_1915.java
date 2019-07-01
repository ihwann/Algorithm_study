package Dynamic_Programming;

import java.util.Scanner;

public class Q_1915 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1]; // (n,m)을 오른쪽 끝으로 하는 가장 큰 정사각형 한 변의 길이

        for (int i = 1; i <= n; i++) {
            String s = sc.next();
            for (int j = 1; j <= m; j++) {
                map[i][j] = s.charAt(j - 1) - '0';
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 0) continue;
                dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;

                if(ans < dp[i][j]){
                    ans = dp[i][j];
                }
            }
        }

        System.out.println(ans * ans);
    }
}
