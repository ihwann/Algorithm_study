package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString344 {
    public static void main(String[] args) {
        char[] s = {'h', 'a', 'n', 'n', 'a', 'H'};

        int begin = 0;
        int end = s.length - 1;

        while (begin < end) {
            char tmp = s[begin];
            s[begin] = s[end];
            s[end] = tmp;
            begin++;
            end--;
        }

        System.out.println(Arrays.toString(s));
    }
}
