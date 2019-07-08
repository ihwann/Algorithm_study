package Brute_Force;

import java.util.Scanner;

public class Q_14888 {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int plus = sc.nextInt();
        int minus = sc.nextInt();
        int mul = sc.nextInt();
        int div = sc.nextInt();
        sc.close();
        solve(A, 1, A[0], plus, minus, mul, div);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void solve(int[] a, int index, int cur, int plus, int minus, int mul, int div) {
        if (index == a.length) {
            if (MAX < cur)
                MAX = cur;
            if (MIN > cur)
                MIN = cur;
        }
        if (plus > 0) {
            solve(a, index + 1, cur + a[index], plus - 1, minus, mul, div);
        }
        if (minus > 0) {
            solve(a, index + 1, cur - a[index], plus, minus - 1, mul, div);
        }
        if (mul > 0) {
            solve(a, index + 1, cur * a[index], plus, minus, mul - 1, div);
        }
        if (div > 0) {
            solve(a, index + 1, cur / a[index], plus, minus, mul, div - 1);
        }
    }
}
