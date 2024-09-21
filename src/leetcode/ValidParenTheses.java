package leetcode;

import java.util.Stack;

public class ValidParenTheses {

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (c == ')') {
                    if (pop != '(') {
                        return false;
                    }
                }
                if (c == '}') {
                    if (pop != '{') {
                        return false;
                    }
                }
                if (c == ']') {
                    if (pop != '[') {
                        return false;
                    }
                }

            }
        }

        return stack.isEmpty();
    }
}
