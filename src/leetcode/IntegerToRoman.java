package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(3749));
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        Map<Integer, String> map = new HashMap<>() {{
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
            put(90, "XC");
            put(100, "C");
            put(400, "CD");
            put(500, "D");
            put(900, "CM");
            put(1000, "M");
        }};

        List<Integer> keyList = map.keySet()
            .stream()
            .sorted(Comparator.reverseOrder())
            .toList();

        while (num > 0) {
            for (Integer key : keyList) {
                if (num >= key) {
                    String value = map.get(key);
                    sb.append(value);
                    num -= key;
                    break;
                }
            }
        }

        return sb.toString();
    }

}
