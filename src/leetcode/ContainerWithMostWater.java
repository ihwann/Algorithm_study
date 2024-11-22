package leetcode;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int result = Integer.MIN_VALUE;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            result = Math.max(result, calculateArea(left, right, height));

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    public static int calculateArea(int left, int right, int[] height) {
        return Math.min(height[left], height[right]) * (right - left);
    }
}
