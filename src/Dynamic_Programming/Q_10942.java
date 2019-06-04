package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class Q_10942 {
    static int[] a; // 문자열
    static int[][] d; // 팰린드롬 판정

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n + 1];
        d = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            Arrays.fill(d[i], -1);
        }
        int m = sc.nextInt();
        StringBuilder ans = new StringBuilder();
        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ans.append(chkPalin(x, y));
            ans.append("\n");
        }
        System.out.println(ans);
    }

    public static int chkPalin(int x, int y) {
        if (x == y) {
            return 1;
        } else if (y == x + 1) {
            if (a[x] == a[y]) {
                return 1;
            } else {
                return 0;
            }
        }
        if (d[x][y] != -1) {
            return d[x][y];
        }
        if (a[x] != a[y]) {
            return d[x][y] = 0;
        } else {
            return d[x][y] = chkPalin(x + 1, y - 1);
        }
    }

}
