package Dynamic_Programming;

import java.util.Scanner;

public class Q_11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] d = new int[n + 1];
        d[1] = 1;
        d[2] = 2;

        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
            d[i] %= 10007;
        }

        System.out.println(d[n]);
    }
}