package Simulation;

import java.util.Scanner;

public class Q_14503 {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 지도 크기
        int m = sc.nextInt(); // 지도 크기
        int r = sc.nextInt(); // 로봇청소기 위치
        int c = sc.nextInt(); // 로봇청소기 위치
        int dir = sc.nextInt(); // 현재 로봇청소기 방향
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        sc.close();
        // 빈칸 0 벽 1 청소 2
        while (true) {
            // 현재 위치 청소
            if (map[r][c] == 0) {
                map[r][c] = 2;
            }
            // 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
            if (map[r - 1][c] != 0 && map[r][c + 1] != 0 && map[r + 1][c] != 0 && map[r][c - 1] != 0) {
                // 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
                if (map[r - dx[dir]][c - dy[dir]] == 1) {
                    break;
                } else {
                    r = r - dx[dir];
                    c = c - dy[dir];
                }
            } else {
                // 왼쪽으로 방향전환
                dir = (dir + 3) % 4;
                // 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
                if (map[r + dx[dir]][c + dy[dir]] == 0) {
                    r = r + dx[dir];
                    c = c + dy[dir];
                }
            }

        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    ans += 1;
                }
            }
        }

        System.out.println(ans);
    }

}
