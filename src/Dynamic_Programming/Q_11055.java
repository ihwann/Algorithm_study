package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_11055 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            dp[i] = num[i];
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (num[j] < num[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + num[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
