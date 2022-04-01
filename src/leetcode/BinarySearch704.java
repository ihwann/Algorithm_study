package leetcode;

import java.util.Arrays;

public class BinarySearch704 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int k = 9;
        System.out.println(solution(nums, k));
    }

    private static int solution(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int pivot = (left + right) / 2;

        int answer = 0;
        while (left <= right) {
            pivot = (left + right) / 2;
            if (nums[pivot] == k) return pivot;
            if (nums[pivot] < k) {
                left = pivot + 1;
            } else if (nums[pivot] > k) {
                right = pivot - 1;
            }
        }
        return -1;
    }
}
