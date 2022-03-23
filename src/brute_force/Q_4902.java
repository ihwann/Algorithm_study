package brute_force;

import java.util.Scanner;

public class Q_4902 {
    private static int[][] triangle;
    private static int[][] partSum_triangle;
    private static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int testCase = 1; ; testCase++) {
            int n = sc.nextInt();
            if (n == 0) break;

            // 삼각형 배열 선언(위에서부터 i번째 줄은 2*i-1 개의 작은 삼각형이 있음)
            triangle = new int[n + 1][2 * n];

            // 삼각형 각 줄마다의 부분 합(dynamic programming 개념) 배열
            partSum_triangle = new int[n + 1][2 * n];

            ans = Integer.MIN_VALUE;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= (2 * i) - 1; j++) {
                    triangle[i][j] = sc.nextInt();

                    // 삼각형 각 줄마다 있는 단위삼각형에 부분합 채우기
                    partSum_triangle[i][j] = partSum_triangle[i][j - 1] + triangle[i][j];
                }
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= (2 * i) - 1; j++) {
                    solve(i, j, j, 0, n);
                }
            }

            System.out.printf("%d. %d\n", testCase, ans);
        }

    }

    private static void solve(int row, int col_leftPoint, int col_rightPoint, int sum, int n) {
        if (row < 1 || row > n) return;
        if (col_leftPoint < 1 || col_rightPoint > 2 * row - 1) return;

        sum += partSum_triangle[row][col_rightPoint] - partSum_triangle[row][col_leftPoint - 1];
        if (ans < sum) ans = sum;

        // 짝수 번째 줄 인 경우 역삼각형 모양으로 계산
        if (col_leftPoint % 2 == 0) {
            solve(row - 1, col_leftPoint - 2, col_rightPoint, sum, n);

            // 홀수 번째 줄 인 경우 정삼각형 모양으로 계산
        } else {
            solve(row + 1, col_leftPoint, col_rightPoint + 2, sum, n);
        }
    }
}
