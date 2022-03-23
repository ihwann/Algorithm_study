package programmers;

import java.util.*;

/**
 * url : https://programmers.co.kr/learn/courses/30/lessons/76502
 */
public class BracketRotation {
    public static void main(String[] args) {
        String s = "[](){}";
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isValidRotation(i, s)) answer += 1;
        }
        System.out.println(answer);
    }

    private static boolean isValidRotation(int i, String s) {
        String str = rotation(i, s);
        return validBracket(str);
    }

    private static String rotation(int cnt, String str) {
        Queue<String> q = new LinkedList<>(Arrays.asList(str.split("")));
        for (int i = 0; i < cnt; i++) {
            String s = q.poll();
            q.offer(s);
        }
        return q.toString();
    }

    private static boolean validBracket(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(str.charAt(i));
            } else {
                if (str.charAt(i) == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(i));
                    }
                } else if (str.charAt(i) == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(i));
                    }
                } else if (str.charAt(i) == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(i));
                    }
                } else {
                    stack.push(str.charAt(i));
                }
            }
        }
        return stack.isEmpty();
    }
}
