package Brute_Force;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] dp = new int[n + 50]; // n 일 까지 상담을 했을 때 최대 소득

        for (int i = 1; i <= n; i++) {
            String[] temp = br.readLine().split(" ");
            t[i] = Integer.parseInt(temp[0]);
            p[i] = Integer.parseInt(temp[1]);
        }

        for (int i = 1; i <= n; i++) {
            // i 일에 상담을 했을 경우
            dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);

            // i 일에 상담을 하지 않았을 경우
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }

        System.out.println(dp[n + 1]);

    }
}