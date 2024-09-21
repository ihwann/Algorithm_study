package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        backTracking(0, nums, temp, result);
        return result;
    }

    private static void backTracking(int start, int[] nums, List<Integer> temp,
        List<List<Integer>> result) {
        if (temp.size() > nums.length) {
            return;
        }

        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backTracking(i + 1, nums, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
