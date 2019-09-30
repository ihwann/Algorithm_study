package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");


        int[] a = new int[n];
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] != Integer.MAX_VALUE && a[i] != 0) {
                int jump = a[i];

                for (int j = 1; j <= jump; j++) {
                    if (i + j < n) {
                        dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
                    }
                }
            }
        }

        if (dp[n - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n - 1]);
        }

    }
}
