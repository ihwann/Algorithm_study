package Graph_and_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q_15661 {

    static int[][] stats;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        stats = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideTeam(0, 0, n);

        System.out.println(ans);
    }

    private static void divideTeam(int dept, int select, int n) {

        if (dept == n / 2) {
            getScore();
        } else {
            for (int i = select; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    divideTeam(dept + 1, select, n);
                    visited[i] = false;
                }
            }
        }
    }

    private static void getScore() {

        ArrayList<Integer> start_team = new ArrayList<>();
        ArrayList<Integer> link_team = new ArrayList<>();

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                start_team.add(i);
            } else {
                link_team.add(i);
            }
        }

        int start_score = 0;
        int link_score = 0;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                if (i == j) continue;
                start_score += stats[start_team.get(i)][start_team.get(j)];
                link_score += stats[link_team.get(i)][link_team.get(j)];
            }
        }

        int tempans = Math.abs(start_score - link_score);

        ans = Math.min(ans, tempans);
    }
}
