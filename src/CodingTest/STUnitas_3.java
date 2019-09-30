package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class STUnitas_3 {
    static int n;
    static int[][] city;
    static boolean[] visitChk;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        city = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            visitChk = new boolean[n];
            dfs(i, i, 0, 1);
        }

        System.out.println(answer);
    }

    private static void dfs(int i, int originStart, int cost, int numOfCity) {
        if (numOfCity == n) {
            cost += city[i][originStart];
            answer = Math.min(answer, cost);
            return;
        } else {
            visitChk[i] = true; // 방문함

            for (int x = 0; x < n; x++) {
                if (visitChk[x]) continue;
                if (city[i][x] == 0) continue;
                dfs(x, originStart, cost + city[i][x], numOfCity + 1);
            }
        }
    }
}
