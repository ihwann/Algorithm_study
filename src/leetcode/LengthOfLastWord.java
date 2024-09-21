package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LengthOfLastWord {

    public static void main(String[] args) {

        //System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }

    public static int lengthOfLastWord (String s) {
        String[] split = s.split(" ");

        Object[] array = Arrays.stream(split).filter(str -> !str.isEmpty()).toArray();

        return array[array.length-1].toString().length();
    }

}
