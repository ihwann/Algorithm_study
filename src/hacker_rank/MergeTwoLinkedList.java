package hacker_rank;


import java.util.*;

public class MergeTwoLinkedList {
    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int j = 0;

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            while(set.contains(c)) {
                set.remove(s.charAt(j));
                j++;
            }


            set.add(c);
            answer = Math.max(set.size(), j);
        }

        return answer;
    }
}
