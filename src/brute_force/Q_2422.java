package brute_force;

import java.util.Scanner;

public class Q_2422 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 아이스크림 종류 갯수
        int m = sc.nextInt(); // 섞어먹으면 안되는 조합의 갯수

        // 섞어 먹으면 안되는 조합
        boolean[][] a = new boolean[n+1][n+1];

        for (int i = 0; i < m; i++) {
            int j = sc.nextInt();
            int k = sc.nextInt();
            a[j][k] = true;
            a[k][j] = true;
        }

        // 아이스크림 3가지를 고르기 때문에 3중 for문 사용
        int result = 0;
        for (int i = 1; i <= n-2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (a[i][j] || a[j][k] || a[i][k]) continue;
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}
