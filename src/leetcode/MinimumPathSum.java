package leetcode;

import java.util.Arrays;

public class MinimumPathSum {

    public static void main(String[] args) {

    }

    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        return findPathSum(grid.length - 1, grid[0].length - 1, grid, dp);
    }

    private static int findPathSum(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) {
            return grid[i][j];
        } else if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        } else if (dp[i][j] != 0) {
            return dp[i][j];
        }

        dp[i][j] = grid[i][j] + Math.min(
            findPathSum(i - 1, j, grid, dp),
            findPathSum(i, j - 1, grid, dp)
        );

        return dp[i][j];
    }

}
