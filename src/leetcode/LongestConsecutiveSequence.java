package leetcode;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {

        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        int result = Integer.MIN_VALUE;

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (Integer i : set) {
            if (set.contains(i - 1)) {
                continue;
            }
            int consecutiveCount = 1;

            while (set.contains(i + 1)) {
                consecutiveCount += 1;
                i = i + 1;
            }
            result = Math.max(result, consecutiveCount);
        }

        return result;
    }

}
