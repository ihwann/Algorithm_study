package CodingTest;

public class SendBird {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("CABABD");


        //34

        String s = sb.substring(0, 2) + sb.subSequence(4,sb.length());
        System.out.println(sb.substring(0, 2) + sb.subSequence(4,sb.length()));

        sb = new StringBuffer(s);
    }
}
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String solution(String S) {
        // write your code in Java SE 8
        //String S = "CABABD";
        StringBuffer sb = new StringBuffer(S);
        while(sb.length() >= 0) {
            if(sb.length() == 1) break;
            if(sb.length() == 0) break;

            for(int i=0; i<S.length() - 1; i++) {
                int curCharNum = S.charAt(i) - '0';
                int nextCharNum = S.charAt(i+1) - '0';

                if(!isNextStr(curCharNum, nextCharNum)) continue;

                int cursor = i+1;
                while(true) {
                    if(cursor + 1 >= sb.length()) break;

                    curCharNum = sb.charAt(cursor) - '0';
                    nextCharNum = sb.charAt(cursor + 1) - '0';
                    if(isNextStr(curCharNum, nextCharNum)) {
                        cursor += 1;
                    } else {
                        break;
                    }
                }

                String subStr = sb.substring(0, i-1) + sb.subSequence(cursor, sb.length());
                sb = new StringBuffer(subStr);
            }
        }

        return sb.toString();
    }

    private static boolean isNextStr(int curNum, int nextNum) {
        return nextNum == curNum + 1;
    }
}
