package Brute_Force;

import java.util.Scanner;

public class Q_1748 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = 0;

        for (int start = 1, len = 1; start <= n; start *= 10, len++) {
            int end = (start * 10) - 1;
            if (end > n)
                end = n;
            ans += (end - start + 1) * len;
        }
        sc.close();
        System.out.println(ans);

    }

}
