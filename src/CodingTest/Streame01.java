package CodingTest;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.util.HashSet;
import java.util.Set;

public class Streame01 {
    private static Set<Integer> strSet = new HashSet<>();

    public static void main(String[] args) {
        int largestPalindrome = Integer.MIN_VALUE;
        String S = "39878";



        stringPermutation("", S);
        for (int strParsedNum : strSet) {
            if (isPalindrome(strParsedNum)) {
                largestPalindrome = Math.max(largestPalindrome, strParsedNum);
            }
        }

        System.out.println(largestPalindrome);
    }


    private static void stringPermutation(String permuStr, String sourceStr) {
        if (!"".equals(permuStr)) {
            strSet.add(Integer.parseInt(permuStr));
        }
        for (int i = 0; i < sourceStr.length(); i++) {
            stringPermutation(permuStr + sourceStr.charAt(i), sourceStr.substring(0, i) + sourceStr.substring(i + 1));
        }
    }

    private static boolean isPalindrome(int num) {
        if (num < 10) return true;
        String reverseStr = new StringBuilder(String.valueOf(num)).reverse().toString();

        return String.valueOf(num).equals(reverseStr);
    }
}
