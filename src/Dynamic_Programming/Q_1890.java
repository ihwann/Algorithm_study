package Dynamic_Programming;

import java.util.Scanner;

public class Q_1890 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        sc.close();
        long[][] d = new long[n][n];
        d[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                for (int k = 0; k < i; k++) {
                    if (k + map[k][j] == i) {
                        d[i][j] += d[k][j];
                    }
                }

                for (int k = 0; k < j; k++) {
                    if (k + map[i][k] == j) {
                        d[i][j] += d[i][k];
                    }
                }
            }
        }
        System.out.println(d[n - 1][n - 1]);

    }

}
