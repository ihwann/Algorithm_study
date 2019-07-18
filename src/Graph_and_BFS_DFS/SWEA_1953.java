package Graph_and_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class suspect {
    int x;
    int y;
    int cnt; // 탈주범 이동 시간

    public suspect(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class SWEA_1953 {

    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visit;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder ans = new StringBuilder();

            int n = Integer.parseInt(st.nextToken()); // 지하터널 세로 길이
            int m = Integer.parseInt(st.nextToken()); // 지하터널 가로 길이
            int r = Integer.parseInt(st.nextToken()); // 맨홀뚜껑 세로 좌표
            int l = Integer.parseInt(st.nextToken()); // 맨홀뚜껑 가로 좌표
            int time = Integer.parseInt(st.nextToken()); // 탈출 후 소요시간

            map = new int[n][m];
            visit = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            result = 0;
            bfs(n, m, r, l, time);

            System.out.println(ans.append("#").append(tc).append(" ").append(result));
        }
    }

    private static void bfs(int n, int m, int r, int l, int time) {

        Queue<suspect> q = new LinkedList<>();
        q.add(new suspect(r, l, 1));
        visit[r][l] = true;

        while (!q.isEmpty()) {
            suspect suspect = q.remove();
            int x = suspect.x;
            int y = suspect.y;
            int count = suspect.cnt;
            if (count > time) break;
            result++;

            switch (map[x][y]) {
                case 1:
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (visit[nx][ny] || map[nx][ny] == 0) continue;
                        if (pathChk(nx, ny, i)) {
                            visit[nx][ny] = true;
                            q.add(new suspect(nx, ny, count + 1));
                        }

                    }
                    break;
                case 2:
                    for (int i = 0; i < 2; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (visit[nx][ny] || map[nx][ny] == 0) continue;
                        if (pathChk(nx, ny, i)) {
                            visit[nx][ny] = true;
                            q.add(new suspect(nx, ny, count + 1));
                        }
                    }
                    break;
                case 3:
                    for (int i = 2; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (visit[nx][ny] || map[nx][ny] == 0) continue;
                        if (pathChk(nx, ny, i)) {
                            visit[nx][ny] = true;
                            q.add(new suspect(nx, ny, count + 1));
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < 4; i += 3) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (visit[nx][ny] || map[nx][ny] == 0) continue;
                        if (pathChk(nx, ny, i)) {
                            visit[nx][ny] = true;
                            q.add(new suspect(nx, ny, count + 1));
                        }
                    }
                    break;
                case 5:
                    for (int i = 1; i < 4; i += 2) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (visit[nx][ny] || map[nx][ny] == 0) continue;
                        if (pathChk(nx, ny, i)) {
                            visit[nx][ny] = true;
                            q.add(new suspect(nx, ny, count + 1));
                        }
                    }
                    break;
                case 6:
                    for (int i = 1; i < 3; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (visit[nx][ny] || map[nx][ny] == 0) continue;
                        if (pathChk(nx, ny, i)) {
                            visit[nx][ny] = true;
                            q.add(new suspect(nx, ny, count + 1));
                        }
                    }
                    break;
                case 7:
                    for (int i = 0; i < 3; i += 2) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (visit[nx][ny] || map[nx][ny] == 0) continue;
                        if (pathChk(nx, ny, i)) {
                            visit[nx][ny] = true;
                            q.add(new suspect(nx, ny, count + 1));
                        }
                    }
                    break;
            }
        }
    }

    private static boolean pathChk(int nx, int ny, int dir) {
        int type = map[nx][ny];
        switch (dir) {
            case 0: // 상
                if (type == 3 || type == 4 || type == 7) return false;
                break;
            case 1: // 하
                if (type == 3 || type == 5 || type == 6) return false;
                break;
            case 2: // 좌
                if (type == 2 || type == 6 || type == 7) return false;
                break;
            case 3: // 우
                if (type == 2 || type == 4 || type == 5) return false;
                break;
        }
        return true;
    }
}
