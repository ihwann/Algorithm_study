package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {

        String str = "";
        System.out.println(str.isEmpty());
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            setAnagramMap(anagramMap, str);
        }

        return new ArrayList<>(anagramMap.values());
    }

    private void setAnagramMap(Map<String, List<String>> anagramMap, String str) {
        String key = generateKey(str);

        anagramMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }

    private String generateKey(String str) {
        if (str.length() == 1) {
            return str;
        }
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);

        return String.valueOf(charArray);
    }
}
