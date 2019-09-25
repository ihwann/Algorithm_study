package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class STUnitas_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int n = 0; n < testCase; n++) {


            Stack<String> stack = new Stack<>();
            String croissant = br.readLine();
            String answer = "Yes";

            for (int i = 0; i < croissant.length(); i++) {
                if (croissant.charAt(0) == ')') {
                    answer = "No";
                    break;
                } else {

                    String str = String.valueOf(croissant.charAt(i));

                    if (str.equals("(")) {
                        stack.push(str);
                    } else {
                        if (stack.size() > 0) {
                            stack.pop();
                        } else {
                            answer = "No";
                            break;
                        }
                    }
                }
            }
            if (stack.size() > 0) {
                answer = "No";
            }

            System.out.println(answer);
        }
    }
}
