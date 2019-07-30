package Graph_and_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_2468 {
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];

        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (maxHeight < map[i][j]) maxHeight = map[i][j]; // 최대 지역 높이 구하기
            }
        }

        int ans = 0;
        int temp = 0;
        for (int cut = 0; cut <= maxHeight; cut++) { // 장마의 양
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > cut && visit[i][j] == false) {
                        temp += 1;
                        dfs(i, j, cut);
                    }
                }
            }
            if (ans < temp) ans = temp;
            initializationVisit(); // visit 방문체크 초기화
            temp = 0;
        }

        System.out.println(ans);
    }

    private static void initializationVisit() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], false);
        }
    }

    private static void dfs(int i, int j, int cut) {

        visit[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (map[nx][ny] > cut && visit[nx][ny] == false) {
                dfs(nx, ny, cut);
            }
        }
    }
}
