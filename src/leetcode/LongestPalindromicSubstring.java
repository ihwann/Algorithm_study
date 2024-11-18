package leetcode;

public class LongestPalindromicSubstring {

    private static int maxStart = 0;
    private static int maxEnd = 0;

    public static void main(String[] args) {

        //System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {

        if (s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            checkPalindrome(s, i, i);
            checkPalindrome(s, i, i + 1);
        }

        return s.substring(maxStart, maxEnd + 1);
    }

    public static void checkPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            if (maxEnd - maxStart < end - start) {
                maxEnd = end;
                maxStart = start;
            }
            start--;
            end++;
        }
    }
}
