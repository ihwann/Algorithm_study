package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q_15686 {

    static ArrayList<Point> homes = new ArrayList<>();
    static ArrayList<Point> chickens = new ArrayList<>();
    static boolean[] visited;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]); // 치킨집 최대 갯수

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) homes.add(new Point(i, j));
                if (map[i][j] == 2) chickens.add(new Point(i, j));
            }
        }

        visited = new boolean[chickens.size()];

        dfs(0, 0, m);

        System.out.println(ans);
    }

    private static void dfs(int index, int select, int m) {

        if (select == m) {
            int tmpAns = 0;

            for (int i = 0; i < homes.size(); i++) {

                Point h = homes.get(i);
                int minDist = Integer.MAX_VALUE;

                for (int j = 0; j < chickens.size(); j++) {
                    if (visited[j]) {
                        Point c = chickens.get(j);
                        int dist = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);

                        minDist = Math.min(minDist, dist);
                    }
                }
                tmpAns += minDist;
            }

            if (ans > tmpAns) {
                ans = tmpAns;
                return;
            }
        }

        if (index == chickens.size()) return;

        // 치킨 배달집으로 선택
        visited[index] = true;
        dfs(index + 1, select + 1, m);

        // 치킨 배달집으로 선택되지 않음
        visited[index] = false;
        dfs(index + 1, select, m);
    }
}