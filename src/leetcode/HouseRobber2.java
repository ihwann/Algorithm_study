package leetcode;

public class HouseRobber2 {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }

    public static int rob(int[] nums) {
        int[][] maxRob = new int[2][nums.length];

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                // 첫번째 집을 턴 경우
                maxRob[0][i] = nums[i];
                continue;
            }

            if (i == 1) {
                maxRob[0][i] = maxRob[0][0];
                maxRob[1][i] = nums[i];
                continue;
            }

            maxRob[0][i] = Math.max(maxRob[0][i - 1], maxRob[0][i - 2] + nums[i]);
            maxRob[1][i] = Math.max(maxRob[1][i - 1], maxRob[1][i - 2] + nums[i]);
        }

        return Math.max(maxRob[0][nums.length - 2], maxRob[1][nums.length - 1]);
    }

}
