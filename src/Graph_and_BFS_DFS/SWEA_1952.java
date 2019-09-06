package Graph_and_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952 {
    static int result;
    static int[] pay;
    static int[] month;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= num; tc++) {

            pay = new int[4];
            month = new int[12];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int i = 0; i < 4; i++) {
                pay[i] = Integer.parseInt(st1.nextToken());
            }

            for (int i = 0; i < 12; i++) {
                month[i] = Integer.parseInt(st2.nextToken());
            }

            result = pay[3];

            solve(0, 0);

            StringBuilder ans = new StringBuilder();
            ans.append("#" + tc).append(" ").append(result);
            System.out.println(ans);
        }
    }

    private static void solve(int cur, int sum) {

        if (cur >= 12) {
            result = Math.min(result, sum);
            return;
        }

        if (month[cur] == 0) {
            solve(cur + 1, sum);
        } else {
            solve(cur + 1, sum + month[cur] * pay[0]);
            solve(cur + 1, sum + pay[1]);
            solve(cur + 3, sum + pay[2]);
        }
    }
}
