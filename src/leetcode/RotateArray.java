package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RotateArray {

    public static void main(String[] args) {

        int[] nums = {1,2};
        int k = 3;

        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {

        if (k % nums.length == 0) {
            return;
        }
        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
