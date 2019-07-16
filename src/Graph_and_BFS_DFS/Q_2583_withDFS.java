package Graph_and_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Q_2583_withDFS {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visit;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]); // 모눈종이 세로
        m = Integer.parseInt(input[1]); // 모눈종이 가로
        int k = Integer.parseInt(input[2]); // 사각형 갯수

        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            String[] point = br.readLine().split(" ");
            int x1 = Integer.parseInt(point[0]);
            int y1 = Integer.parseInt(point[1]);
            int x2 = Integer.parseInt(point[2]);
            int y2 = Integer.parseInt(point[3]);

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        int cnt = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && visit[i][j] == false) {
                    cnt += 1; // 영역의 갯수
                    int area = dfs(i, j); // 각 영역의 크기
                    ans.add(area);
                }
            }
        }
        Collections.sort(ans);
        System.out.println(cnt);
        for (int item : ans) {
            System.out.print(item + " ");
        }
    }

    private static int dfs(int i, int j) {
        visit[i][j] = true;
        int result = 1;
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (map[nx][ny] == 0 && visit[nx][ny] == false) {
                    result += dfs(nx, ny);
                }
            }
        }
        return result;
    }
}
