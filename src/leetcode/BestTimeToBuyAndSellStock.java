package leetcode;


public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;

        int buyPrice = Integer.MAX_VALUE;
        int sellPrice = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length - 1; i++) {
            buyPrice = Math.min(buyPrice, prices[i]);
            sellPrice = Math.max(prices[i + 1], buyPrice);
            profit = Math.max(profit, sellPrice - buyPrice);
        }

        System.out.println(buyPrice);
        System.out.println(sellPrice);
        return profit;
    }
}
