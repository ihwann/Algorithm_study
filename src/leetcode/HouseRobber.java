package leetcode;

import java.util.Collection;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }

    public static int rob(int[] nums) {
        int[] money = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                money[i] = nums[i];
                continue;
            }

            if (i == 1) {
                money[i] = Math.max(nums[i], nums[i - 1]);
                continue;
            }

            money[i] = Math.max(money[i - 1], money[i - 2] + nums[i]);
        }

        return money[nums.length - 1];
    }
}
