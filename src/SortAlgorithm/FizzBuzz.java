package SortAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    static List<String> result;

    public static void main(String[] args) {
        runFizzBuzz(3000);

        System.out.println(result.toString());
    }

    private static List<String> runFizzBuzz(int n) {
        result = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            String word = toWord(i, 3, "Fizz") + toWord(i, 5, "Buzz");

            if (isEmpty(word)) {
                result.add(String.valueOf(i));
            } else {
                result.add(word);
            }
        }
        return result;
    }

    private static String toWord(int value, int divisor, String word) {
        return value % divisor == 0 ? word : "";
    }

    private static boolean isEmpty(String word) {
        if (word == null || word == "") {
            return true;
        } else {
            return false;
        }
    }
}
