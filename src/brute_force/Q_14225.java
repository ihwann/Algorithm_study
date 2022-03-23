package brute_force;

import java.util.Scanner;

public class Q_14225 {
    static boolean[] part_sum = new boolean[2000010]; // i가 부분순열의 합으로 가능한지 체크
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 수열의 크기
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        //Arrays.sort(arr);

        solve(0, 0, arr);

        for (int i = 1; ; i++) {
            if (!part_sum[i]) {
                System.out.println(i);
                break;
            }
        }
    }

    private static void solve(int i, int sum, int[] arr) {
        if (i == n) {
            part_sum[sum] = true;
            return;
        }
        solve(i + 1, sum + arr[i], arr);
        solve(i + 1, sum, arr);
    }
}
