package Dynamic_Programming;

import java.util.Scanner;

public class Q_11048 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] miro = new int[n + 1][m + 1];
        int[][] d = new int[n + 1][m + 1]; // (1,1)에서 (n,m)까지 이동하면서 얻은 사탕의 최대 값
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                miro[i][j] = sc.nextInt();
            }
        }
        sc.close();
        d[1][1] = miro[1][1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                d[i][j] = Math.max(Math.max(d[i - 1][j], d[i - 1][j - 1]), d[i][j - 1]) + miro[i][j];
            }
        }
        System.out.println(d[n][m]);
    }

}
