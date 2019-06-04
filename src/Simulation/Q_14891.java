package Simulation;

import java.util.Scanner;

public class Q_14891 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 4;
        char[][] topni = new char[4][8];

        for (int i = 0; i < n; i++) {
            topni[i] = sc.next().toCharArray();
        }
        int k = sc.nextInt();
        while (k-- > 0) {
            int no = sc.nextInt() - 1; // 회전시킬 톱니바퀴 번호
            int dir = sc.nextInt(); // 회전 방향 1: 시계방향 -1 : 반시계방향
            int[] d = new int[n]; // 톱니바퀴 회전 하기 전 계산 저장
            d[no] = dir;
            // 왼쪽 톱니바퀴
            for (int i = no - 1; i >= 0; i--) {
                if (topni[i][2] != topni[i + 1][6]) {
                    d[i] = -d[i + 1];
                } else {
                    break;
                }
            }

            // 오른쪽 톱니바퀴
            for (int i = no + 1; i < n; i++) {
                if (topni[i - 1][2] != topni[i][6]) {
                    d[i] = -d[i - 1];
                } else {
                    break;
                }
            }
            // 톱니바퀴 회전
            for (int i = 0; i < n; i++) {
                if (d[i] == 0)
                    continue;
                if (d[i] == 1) { // 시계방향
                    char temp = topni[i][7];
                    for (int j = 7; j >= 1; j--) {
                        topni[i][j] = topni[i][j - 1];
                    }
                    topni[i][0] = temp;
                } else if (d[i] == -1) { // 반시계방향
                    char temp = topni[i][0];
                    for (int j = 0; j < 7; j++) {
                        topni[i][j] = topni[i][j + 1];
                    }
                    topni[i][7] = temp;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (topni[i][0] == '1') {
                ans |= (1 << i);
            }
        }
        System.out.println(ans);

    }

}
