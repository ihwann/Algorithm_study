package programmers;

/**
 * url : https://programmers.co.kr/learn/courses/30/lessons/12980
 */

public class JumpAndTeleport {
    public static void main(String[] args) {

        int answer = 0;
        int n = 6;

        while (n >= 1) {
            if (n % 2 != 0) answer +=1;
            n /= 2;
        }
        System.out.println("n = " + n);
        System.out.println("answer = " + answer);
    }
}
