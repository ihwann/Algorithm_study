package Simulation;

import java.util.Scanner;

public class Q_13458 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 시험장 갯수
        int[] room = new int[n + 1]; // 각 시험장 마다 인원 수

        for (int i = 1; i <= n; i++) {
            room[i] = sc.nextInt();
        }

        int b = sc.nextInt(); // 총 감독관이 감독할 수 있는 인원 수
        int c = sc.nextInt(); // 부 감독관이 감독할 수 있는 인원 수

        // 각 시험장 마다 총 감독관이 감독할 수 있는 인원 수 빼기
        for (int i = 1; i <= n; i++) {
            room[i] = room[i] - b;
        }

        long ans = n;
        for (int i = 1; i <= n; i++) {
            // 부 감독관이 필요한 경우만
            if (room[i] >= 1) {
                if (room[i] % c == 0) {
                    room[i] = room[i] / c;
                } else {
                    room[i] = (room[i] / c) + 1;
                }
                ans += room[i];
            }
        }

        System.out.println(ans);
    }
}
