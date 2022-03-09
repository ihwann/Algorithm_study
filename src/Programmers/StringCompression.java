package Programmers;

import java.util.*;
import java.util.stream.Collectors;

public class StringCompression {
    public static void main(String[] args) {
        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        int n = 5;

        Map<Integer, Integer> person = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            person.put(i, 0);
        }

        int[] answer = new int[2];

        Queue<String> q = new LinkedList<>(Arrays.asList(words));
        Set<String> overlap = new HashSet<>();

        int order = 0;
        String curWord = "";
        String preWord = String.valueOf(words[0].charAt(0));
        while (!q.isEmpty()) {
            if (++order > n) order = 1;
            curWord = q.poll();

            if (!overlap.contains(curWord) && curWord.charAt(0) == preWord.charAt(preWord.length() - 1)) {
                person.put(order, person.get(order) + 1);

                //q.offer(curWord);
                preWord = curWord;
                overlap.add(curWord);
            } else {
                answer[0] = order;
                answer[1] = person.get(order) + 1;
                break;
            }
        }

        //return Arrays.stream(answer).toArray();
    }
}
