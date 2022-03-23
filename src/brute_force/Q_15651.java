package brute_force;

import java.util.Scanner;

public class Q_15651 {
    static int[] ans = new int[10];
    static boolean[] check = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.close();
        solve(N, M, 0);
    }

    static void solve(int n, int m, int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(ans[i]);
                if (i != m - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            return;
        }
        if (index > m) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            /*
             * if (check[i] == true) { continue; }
             */
            check[i] = true;
            ans[index] = i;
            solve(n, m, index + 1);
            check[i] = false;
        }
    }
}
