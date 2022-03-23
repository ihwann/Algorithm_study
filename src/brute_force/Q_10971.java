package brute_force;

import java.util.Scanner;

public class Q_10971 {

    public static boolean next_permutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i] <= a[i - 1]) {
            i -= 1;
        }
        if (i <= 0)
            return false;

        int j = a.length - 1;
        while (a[j] <= a[i - 1]) {
            j -= 1;
        }
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] W = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                W[i][j] = sc.nextInt();
            }
        }
        int ans = Integer.MAX_VALUE;
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = i;
        }
        do {
            boolean ok = true;
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                if (W[d[i]][d[i + 1]] == 0) {
                    ok = false;
                } else {
                    sum += W[d[i]][d[i + 1]];
                }
            }
            if (ok && W[d[n - 1]][d[0]] != 0) {
                sum += W[d[n - 1]][d[0]];
                if (ans > sum) {
                    ans = sum;
                }
            }
        } while (next_permutation(d));

        System.out.println(ans);
    }
}
