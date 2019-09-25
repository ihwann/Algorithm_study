package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class STUnitas_3 {
    static int n;
    static int[][] city;
    static int[][] costDP;
    static boolean[] visitChk;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        city = new int[n][n];
        costDP = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (city[i][j] == 0) continue;
                visitChk = new boolean[n];
                dfs(i, j, i, 1);
            }
        }
    }

    private static int dfs(int i, int j, int originStart, int numOfCity) {

        // i가 출발지 j가 목적지
        int result = city[i][j];
        costDP[i][j] = city[i][j];
        visitChk[i] = true; // 방문함

        if (numOfCity == 4) {
            result += city[i][originStart];
            return result;
        } else {

            // 다음목적지로
            for (int x = 0; x < n; x++) {
                if (visitChk[x]) continue;
                if (x == i) continue;
            }
        }

        return result;
    }
}
