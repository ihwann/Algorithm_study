package CodingTest;

import java.util.Stack;

public class KakaoBank03 {
    public static void main(String[] args) {
        String s = "(()()()";

        int[] bracketArr = new int[3];
        // 사라진 괄호
        String goneBracket = "";
        for (int i = 0; i < s.length(); i++) {
            String bracket = String.valueOf(s.charAt(i));
            if ("(".equals(bracket)) {
                bracketArr[0] += 1;
            } else if (")".equals(bracket)) {
                bracketArr[0] -= 1;
            } else if ("{".equals(bracket)) {
                bracketArr[1] += 1;
            } else if ("}".equals(bracket)) {
                bracketArr[1] -= 1;
            } else if ("[".equals(bracket)) {
                bracketArr[2] += 1;
            } else if ("]".equals(bracket)) {
                bracketArr[2] -= 1;
            }
        }
        // 없어진 문자열 세팅
        for (int i = 0; i < bracketArr.length; i++) {
            if (bracketArr[i] != 0) {
                goneBracket = setGoneBracket(i, bracketArr);
            }
        }

        int answer = 0;
        for (int i = 0; i <= s.length(); i++) {
            StringBuffer sb = new StringBuffer(s);
            sb.insert(i, goneBracket);

            if (isValidBracket(sb.toString())) {
                answer += 1;
            }
        }

        System.out.println(answer);
    }

    private static String setGoneBracket(int i, int[] bracketArr) {
        if (i == 0) {
            if (bracketArr[i] > 0) {
                return ")";
            } else {
                return "(";
            }
        } else if (i == 1) {
            if (bracketArr[i] > 0) {
                return "}";
            } else {
                return "{";
            }
        } else {
            if (bracketArr[i] > 0) {
                return "]";
            } else {
                return "[";
            }
        }
    }

    private static boolean isValidBracket(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                //닫힌것은 비교하여 뺀다
                case ')':
                    if (stack.empty()) return false;
                    if (stack.peek() == '(') stack.pop();
                    break;
                case '}':
                    if (stack.empty()) return false;
                    if (stack.peek() == '{') stack.pop();
                    break;
                case ']':
                    if (stack.empty()) return false;
                    if (stack.peek() == '[') stack.pop();
                    break;
                //열린것은 담고
                default:
                    stack.push(s.charAt(i));
                    break;
            }
        }
        return stack.empty();
    }
}
