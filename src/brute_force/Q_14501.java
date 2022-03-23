package brute_force;

import java.util.Scanner;

public class Q_14501 {
    static int[] T;
    static int[] P;
    static int N;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = new int[N + 1];
        P = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        solve(1, 0);
        System.out.println(answer);
    }

    static void solve(int day, int sum) {
        if (day == N + 1) {
            if (answer < sum) {
                answer = sum;
            }
            return;
        }
        if (day > N + 1) {
            return;
        }
        solve(day + 1, sum);
        solve(day + T[day], sum + P[day]);
    }
}
