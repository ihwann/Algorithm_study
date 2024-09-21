package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        //System.out.println(romanToInt("MCDLXXVI"));
    }

    public static int romanToInt(String s) {
        int result = 0;

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        String[] split = s.split("");

        String prev = split[0];
        for (int i = 0; i < split.length; i++) {
            String current = split[i];

            if (map.get(current) > map.get(prev)) {
                int sub = map.get(current) - map.get(prev);
                result -=  map.get(prev);
                result += sub;
            } else {
                result += map.get(current);
            }
            prev = current;
        }

        return result;
    }

}
