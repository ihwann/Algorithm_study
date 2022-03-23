package brute_force;

import java.util.Scanner;

public class Q_2003 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0; // a[left] ~ a[right] 까지 합
        int sum = a[0];
        int ans = 0;

        while (left <= right && right < n) {
            if (sum < m) {
                right += 1;
                sum += a[right];
            } else if (sum == m) {
                ans += 1;
                right += 1;
                sum += a[right];
            } else if (sum > m) {
                sum -= a[left];
                left++;
                if (left > right && left < n) {
                    right = left;
                    sum = a[left];
                }
            }
        }

        System.out.println(ans);
    }
}
