package Dynamic_Programming;

import java.util.Scanner;

public class Q_9095 {
    public static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n + 1];
        System.out.println(go(n));

    }

    public static int go(int x) {
        if (x == 1) return 1;
        if (x == 2) return 2;
        if (x == 3) return 4;

        return d[x] = go(x - 1) + go(x - 2) + go(x - 3);
    }

}
