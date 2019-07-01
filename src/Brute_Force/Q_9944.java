package Brute_Force;

import java.util.Scanner;

public class Q_9944 {
    static int n;
    static int m;
    static char[][] map;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfTestCase = 1;

        while (sc.hasNextInt()) {
            n = sc.nextInt();
            m = sc.nextInt();

            map = new char[n][m];
            int cnt = 0; // 빈 칸의 수
            for (int i = 0; i < n; i++) {
                map[i] = sc.next().toCharArray();
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == '.') {
                        cnt += 1; // 순회 해야할 빈 칸의 수 카운트
                    }
                }
            }

            int ans = -1; // 정답을 구하지 않은 상태
            // 모든 빈칸에 대하여 bruteforce 실행
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == '.') {
                        map[i][j] = '*';
                        int temp = solve(i, j, cnt-1);
                        if (temp != -1) {
                            if (ans == -1 || ans > temp) {
                                ans = temp;
                            }
                        }
                        map[i][j] = '.';
                    }
                }
            }
            System.out.println("Case " + numOfTestCase + ": " + ans);
            numOfTestCase += 1;
        }
    }

    private static int solve(int x, int y, int cnt) {

        int ans = -1;
        // 순회해야할 빈 칸이 없다면 종료
        if (cnt == 0) {
            return 0;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 다음 칸이 범위내에 있으며 빈 칸일 경우 계속 이동
            while (chk_direction(nx, ny) && map[nx][ny] == '.') {
                map[nx][ny] = '*'; // 벽 으로 바꾸고
                cnt -= 1; // 순회 해야할 칸의 수를 1 줄인다
                nx += dx[i]; // 다음 칸 계속 이동
                ny += dy[i]; // 다음 칸 계속 이동
            }
            // 위에서 모든 이동이 끝났다면, 허용 범위를 벗어났기 떼문에, 다시 한 칸 뒤로
            nx -= dx[i];
            ny -= dy[i];

            // 다음 칸이 시작 칸과 다를 경우에만 다음 칸 부터 다시 순회
            if (!(x == nx && y == ny)) {
                int temp = solve(nx, ny, cnt);
                if (temp != -1) {
                    if (ans == -1 || ans > temp+1) {
                        ans = temp+1; // 순회 횟수가 한번 늘었기 때문에
                    }
                }
            }

            // 위에서 탐색이 한번 끝났기 때문에 복구 시키기
            while (!(x == nx && y == ny)) {
                map[nx][ny] = '.';
                cnt += 1;
                nx -= dx[i];
                ny -= dy[i];
            }
        }
        return ans;
    }

    private static boolean chk_direction(int x, int y) {
        boolean result = false;
        if (x >= 0 && x < n && y >= 0 && y < m) {
            result = true;
        }
        return result;
    }
}
