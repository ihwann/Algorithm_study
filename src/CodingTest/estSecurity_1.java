package CodingTest;

import java.util.Stack;

public class estSecurity_1 {

    public static void main(String[] args) {
        String s = "aaab";

        System.out.println(Solution(s));
    }

    private static int Solution(String s) {

        int answer = 0;
        Stack<String> stack = new Stack<>();
        if (s.length() == 1) {
            return 1;
        } else {
            if (s.length() == 2) {
                return 2;
            }
        }
        stack.push(String.valueOf(s.charAt(0)));
        stack.push(String.valueOf(s.charAt(1)));

        for (int i = 2; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            String str1 = stack.pop();
            String str2 = stack.pop();

            if(str.equals(str1) && str1.equals(str2)){
                answer = Math.max(answer, stack.size());
                stack.clear();
                stack.push(str1);
                stack.push(str);
            }else{
                stack.push(str2);
                stack.push(str1);
                stack.push(str);
                answer = Math.max(answer, stack.size());
            }
        }
        return answer;
    }

}
