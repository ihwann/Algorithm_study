package leetcode;

import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {

        List<List<Integer>> triangle = List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7),
            List.of(4, 1, 8, 3));

        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            int idx = 0;

            for (int j = idx - 1; j <= idx + 1; j++) {
                if (j <= 0) {
                    j = 0;
                }
                if (j >= triangle.get(i).size()) {
                    j = triangle.get(i).size() - 1;
                }
                if (dp[i - 1] + triangle.get(i).get(j) <= dp[i]) {
                    dp[i] = dp[i - 1] + triangle.get(i).get(j);
                    idx = j;
                }
            }

        }

        return dp[triangle.size() - 1];
    }

}
