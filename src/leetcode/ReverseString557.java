package leetcode;

import java.util.Arrays;

public class ReverseString557 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        String[] strArr = s.split(" ");
        for (int i = 0; i < strArr.length; i++) {
           strArr[i] = reverse(strArr[i]);
        }

        System.out.println("strArr = " + String.join(" ", strArr));
    }

    private static String reverse(String s) {
        char[] chars = s.toCharArray();
        int begin = 0;
        int end = chars.length - 1;

        while (begin < end) {
            char tmp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = tmp;
            begin++;
            end--;
        }
        return new String(chars);
    }
}
