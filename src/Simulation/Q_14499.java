package Simulation;

import java.util.Scanner;

public class Q_14499 {
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 맵의 가로
        int m = sc.nextInt(); // 맵의 세로
        int x = sc.nextInt(); // 주사위 놓인 좌표
        int y = sc.nextInt(); // 주사위 높인 좌표
        int t = sc.nextInt(); // 굴린 횟수
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int[] dice = new int[7];
        while (t-- > 0) {
            int d = sc.nextInt();
            int nx = x + dx[d - 1];
            int ny = y + dy[d - 1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;
            if (d == 1) { // 동
                int temp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
            } else if (d == 2) { // 서
                int temp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
            } else if (d == 3) { // 북
                int temp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
            } else { // 북
                int temp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
            }
            x = nx; // 주사위 위치 업데이트
            y = ny; // 주사위 위치 업데이트
            if (map[x][y] == 0) {
                map[x][y] = dice[6];
            } else {
                dice[6] = map[x][y];
                map[x][y] = 0;
            }
            //System.out.println("t" + t);
            System.out.println(dice[1]);
        }
    }
}
