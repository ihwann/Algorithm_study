package leetcode;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;

        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        dp[0] = 0;

        int coinLength = coins.length;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }

}
