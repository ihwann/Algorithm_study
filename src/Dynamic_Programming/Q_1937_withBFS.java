package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1937_withBFS {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] check;

    public static void main(String[] agrs) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = 1;
                q.add(i);
                q.add(j);
                q.add(temp);
                check[i][j] = true;

                while (!q.isEmpty()) {
                    int x = q.poll();
                    int y = q.poll();
                    temp = q.poll();
                    if (ans < temp) ans = temp;
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        if (map[x][y] < map[nx][ny] && check[nx][ny] == false) {
                            q.add(nx);
                            q.add(ny);
                            q.add(temp + 1);
                            check[nx][ny] = true;
                        }
                    }
                }
                check(n);
            }
        }

        System.out.println(ans);
    }

    private static void check(int n) {

        for(int i=0; i<n; i++){
            Arrays.fill(check[i], false);
        }
    }
}
