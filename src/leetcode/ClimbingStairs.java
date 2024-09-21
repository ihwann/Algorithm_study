package leetcode;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        int[] stairs = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == 2) {
                stairs[i] = i;
                continue;
            }

            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }

        return stairs[n];
    }

}
