package Dynamic_Programming;

import java.util.Scanner;

public class Q_11052 {
    public static int[] d;
    public static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n + 1];
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        sc.close();
        System.out.print(solve(n));
    }

    public static int solve(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= i; j++) {
                d[x] = Math.max(d[x], p[j] + d[x - j]);
            }
        }
        return d[x];
    }
}
