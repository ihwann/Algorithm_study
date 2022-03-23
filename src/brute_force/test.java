package brute_force;

import java.util.*;

public class test {
    public static void main(String args[]) {
        String input = "apple";

        Solution(input);
    }

    private static void Solution(String input) {

        char[] data = input.toCharArray();
        Arrays.sort(data);
        int len = data.length;
        HashMap<Character, Integer> hash = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (hash.containsKey(data[i])) continue;
            int cnt = 0;
            for (int j = 0; j < len; j++) {
                if (data[i] == data[j]) cnt++;
            }
            hash.put(data[i], cnt);
        }
        
        for (char name : hash.keySet()) {
            int value = hash.get(name);
            System.out.println(name + " : " + value);
        }
    }
}