package Brute_Force;

import java.util.Scanner;

public class Q_9095 {
    // 문제실패 다시풀어보기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            System.out.println(go(0, c));
        }
        sc.close();
    }

    public static int go(int sum, int goal) {
        if (sum > goal)
            return 0;
        if (sum == goal)
            return 1;

        int now = 0;
        for (int i = 1; i <= 3; i++) {
            now += go(sum + i, goal);
        }
        return now;
    }
}
