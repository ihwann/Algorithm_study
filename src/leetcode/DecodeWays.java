package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public static void main(String[] args) {

        numDecodings("12");
    }

    public static int numDecodings(String s) {
        int result  = 0;

        initMap();
        return result;
    }



    private static Map<Integer, String> initMap() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            map.put(i, String.valueOf((char) (i + 64)));
        }
        return map;
    }

}
