package brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class Q_15655 {
    static int[] ans = new int[10]; // 정답 저장
    static boolean[] check = new boolean[10]; // 방문했는지 판단

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // 배열크기
        int[] N = new int[a]; // N가지수 배열
        int M = sc.nextInt(); // M가지 수
        for (int i = 0; i < a; i++) {
            N[i] = sc.nextInt(); // 저장
        }
        sc.close();
        Arrays.sort(N); // 배열 N 정렬
        solve(N, M, 0, 0);
    }

    static void solve(int[] n, int m, int index, int start) {
        if (index == m) { // index가 M에 도달하면 출력
            for (int i = 0; i < m; i++) {
                System.out.print(ans[i]);
                if (i != m - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            return;
        }
        for (int i = start; i < n.length; i++) {
            if (check[i])
                continue;
            check[i] = true;
            ans[index] = n[i];
            solve(n, m, index + 1, i + 1);
            check[i] = false;
        }
    }
}
