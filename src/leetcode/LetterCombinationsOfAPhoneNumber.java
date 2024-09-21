package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    private static Map<String, String> digitMap;

    public static void main(String[] args) {
        StringBuffer sa = new StringBuffer("abc");
        sa.setLength(sa.length()-1);
        System.out.println(sa);
    }


    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        digitMap = init();

        dfs(result, new StringBuffer(), 0, digits);

        return result;

    }

    private static void dfs(List<String> result, StringBuffer curResult, int depth, String digits) {
        if (depth == digits.length()) {
            result.add(curResult.toString());
            return;
        }

        String digit = String.valueOf(digits.charAt(depth));
        String strings = digitMap.get(digit);

        for (int i = 0; i < strings.length(); i++) {
            curResult.append(strings.charAt(i));
            dfs(result, curResult, depth + 1, digits);
            curResult.setLength(curResult.length() - 1);
        }
    }

    private static Map<String, String> init() {
        Map<String, String> numMap = new HashMap<>();

        numMap.put("2", "abc");
        numMap.put("3", "def");
        numMap.put("4", "ghi");
        numMap.put("5", "jkl");
        numMap.put("6", "mno");
        numMap.put("7", "pqrs");
        numMap.put("8", "tuv");
        numMap.put("9", "wxyz");

        return numMap;
    }

}
