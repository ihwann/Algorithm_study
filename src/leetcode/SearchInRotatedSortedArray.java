package leetcode;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {

        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low += 1;
                }
            } else {
                if (nums[low] <= target && target > nums[mid]) {
                    high = mid - 1;
                } else {
                    low += 1;
                }
            }
        }

        return -1;
    }

//    private static int findPivot(int[] nums) {
//        int low = 0;
//        int high = nums[nums.length - 1];
//
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//
//            if(mid )
//        }
//        return 0;
//    }

}
