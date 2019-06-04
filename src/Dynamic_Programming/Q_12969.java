package Dynamic_Programming;

import java.util.Scanner;

/**
 * dp[i][a][b][k] : 길이가 i이고 A의 개수가 a, B의 개수가 b일 때,
 * S[i] < S[j]를 만족하는 쌍의 개수가 p인 문자열이 존재하는지 검사 여부
 * 1) x번째 원소가 A인 경우 : dp[x+1][a+1][b][p];
 * 2) x번째 원소가 B인 경우 : dp[x+1][a][b+1][p+a];
 * 3) x번째 원소가 C인 경우 : dp[x+1][a][b][p+a+b];
 */


public class Q_12969 {
    static int n, k;
    static boolean[][][][] d = new boolean[31][31][31][436];
    static char[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        ans = new char[n];
        sc.close();

        if (solve(0, 0, 0, 0)) {
            System.out.println(new String(ans));
        } else {
            System.out.println(-1);
        }
    }

    private static boolean solve(int i, int a, int b, int p) {
        // TODO Auto-generated method stub

        // 종료 조건
        if (i == n) {
            if (p == k) {
                return true;
            } else {
                return false;
            }
        }

        // 방문했지만 다시 방문했으면 문자열이 없는 경우이므로 false
        if (d[i][a][b][p])
            return false;

        // 방문했다면 true;
        d[i][a][b][p] = true;

        ans[i] = 'A';
        if (solve(i + 1, a + 1, b, p))
            return true;

        ans[i] = 'B';
        if (solve(i + 1, a, b + 1, p + a))
            return true;

        ans[i] = 'C';
        if (solve(i + 1, a, b, p + a + b))
            return true;

        return false;
    }

}
