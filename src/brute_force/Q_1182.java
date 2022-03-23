package brute_force;

import java.util.Scanner;

public class Q_1182 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
        int ans = go(a, S, 0, 0);
        if (S == 0) {
            ans -= 1;
        }
        System.out.println(ans);
    }

    public static int go(int[] a, int S, int index, int sum) {
        if (index == a.length) {
            if (sum == S) {
                return 1;
            } else
                return 0;
        }
        return go(a, S, index + 1, a[index] + sum) + go(a, S, index + 1, sum);
    }

}
