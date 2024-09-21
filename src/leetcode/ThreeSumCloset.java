package leetcode;

import java.util.Arrays;

public class ThreeSumCloset {

    public static void main(String[] args) {
        //System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        //System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
        //System.out.println(threeSumClosest(new int[]{0, 1, 2}, 3));
        System.out.println(threeSumClosest(new int[]{1, 1, 1, 0}, -100));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum == target) {
                    return sum;
                }
                if (sum > target) {
                    result = Math.min(sum, Math.abs(target - result));
                    end--;
                }
                if (sum < target) {
                    result = Math.min(sum, Math.abs(target - result));
                    start++;
                }
            }
        }
        return result;
    }

}
