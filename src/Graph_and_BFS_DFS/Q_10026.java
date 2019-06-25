package Graph_and_BFS_DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair_10026 {
    int x;
    int y;

    Pair_10026(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q_10026 {
    private static int n;
    private static char[][] map;
    private static boolean[][] checkMap;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        map = new char[n][n];
        checkMap = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }
        // 적록색약이 아닌 사람들이 보는 구역의 수
        int notBlind = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!checkMap[i][j]) {
                    notBlind++;
                    bfs_notBlind(i, j);
                }
            }
        }

        // 방문 체크 배열 초기화
        for(int i=0; i<n; i++){
            Arrays.fill(checkMap[i], false);
        }

        // 적록색약인 사람들이 보는 구역의 수
        int Blind = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!checkMap[i][j]) {
                    Blind++;
                    bfs_Blind(i, j);
                }
            }
        }

        System.out.println(notBlind + " " + Blind);
    }

    // 적록색약이 아닌 사람
    private static void bfs_notBlind(int i, int j) {

        Queue<Pair_10026> q = new LinkedList<>();
        q.offer(new Pair_10026(i, j));
        checkMap[i][j] = true;

        while (!q.isEmpty()) {
            Pair_10026 p = q.remove();
            int x = p.x;
            int y = p.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (!checkMap[nx][ny] && map[nx][ny] == map[x][y]) {
                        checkMap[nx][ny] = true;
                        q.offer(new Pair_10026(nx, ny));
                    }
                }
            }
        }
    }

    // 적록색약인 사람
    private static void bfs_Blind(int i, int j) {

        Queue<Pair_10026> q = new LinkedList<>();
        q.offer(new Pair_10026(i, j));
        checkMap[i][j] = true;

        while (!q.isEmpty()) {
            Pair_10026 p = q.remove();
            int x = p.x;
            int y = p.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {

                    // 같은 색상일 때
                    if (!checkMap[nx][ny] && map[nx][ny] == map[x][y]) {
                        checkMap[nx][ny] = true;
                        q.offer(new Pair_10026(nx, ny));
                    }
                    // G 색에서 R 색으로 변경 될 때
                    if(!checkMap[nx][ny] && map[nx][ny] == 'R' && map[x][y] == 'G'){
                        checkMap[nx][ny] = true;
                        q.offer(new Pair_10026(nx, ny));
                    }
                    // R 색에서 G 색으로 변경 될 때
                    if(!checkMap[nx][ny] && map[nx][ny] == 'G' && map[x][y] == 'R'){
                        checkMap[nx][ny] = true;
                        q.offer(new Pair_10026(nx, ny));
                    }
                }
            }
        }
    }
}
