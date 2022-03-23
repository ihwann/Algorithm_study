package brute_force;

import java.util.Arrays;
import java.util.Scanner;

//문제 실패 다시풀어보기
public class Q_15663 {
    static int[] num = new int[10]; // 배열크기
    static int[] ans = new int[10]; // 정답 저장
    static int[] cnt = new int[10]; // 각 집합 원소의 중복 갯수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = sc.nextInt();
        }
        Arrays.sort(temp);
        sc.close();
        int k = 0;
        int x = temp[0];
        int c = 1;

        for (int i = 1; i < N; i++) {
            if (x == temp[i])
                c += 1;
            else {
                num[k] = x;
                cnt[k] = c;
                k += 1;
                x = temp[i];
                c = 1;
            }
        }
        num[k] = x;
        cnt[k] = c;
        N = k + 1;
        solve(N, M, 0);
    }

    static void solve(int n, int m, int index) {
        if (index == m) { // index가 M에 도달하면 출력
            for (int i = 0; i < m; i++) {
                System.out.print(num[ans[i]]);
                if (i != m - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (cnt[i] > 0) {
                cnt[i] -= 1;
                ans[index] = i;
                solve(n, m, index + 1);
                cnt[i] += 1;
            }
        }
    }
}
