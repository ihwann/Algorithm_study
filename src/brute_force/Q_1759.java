package brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class Q_1759 {
    //문제 실패 다시 풀어보기
    public static void go(int n, String[] alpha, String password, int i) {
        if (password.length() == n) {
            if (check(password)) {
                System.out.println(password);
            }
            return;
        }
        if (i < alpha.length) {
            go(n, alpha, password + alpha[i], i + 1);
            go(n, alpha, password, i + 1);
        }
    }

    public static boolean check(String password) {
        int ja = 0; // 자음
        int mo = 0; // 모음
        for (char i : password.toCharArray()) {
            if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u')
                mo += 1;
            else
                ja += 1;
        }
        if (ja >= 2 && mo >= 1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt(); // 만들어야하는 암호 길이
        int C = sc.nextInt(); // 사용가능한 알파벳 수
        String alpha[] = new String[C];
        for (int i = 0; i < C; i++) {
            alpha[i] = sc.next();
        }
        Arrays.sort(alpha);
        sc.close();
        go(L, alpha, "", 0);
    }
}
