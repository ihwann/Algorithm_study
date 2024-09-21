package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            int curPoint = nums[i];
            String start = String.valueOf(curPoint);
            String end = null;

            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                int nextPoint = nums[i + 1];
                end = String.valueOf(nextPoint);
                i++;
            }

            if (end != null) {
                result.add(start + "->" + end);
            } else {
                result.add(start);
            }

        }

        return result;
    }
}
