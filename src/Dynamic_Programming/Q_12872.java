package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_12872 {
    static final long MOD = 1000000007;
    static int n, m, p;
    static long[][][] dp = new long[101][101][101]; // d[p][x][y] p 번쨰 곡을 선택할 때 x 와 y집합의 크기
    // x : 이미 추가한 노래 집합 y : 아직 추가하지 않은 노래 집합

    public static void main(String[] args) throws Exception {

        getInput();

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(solve(0, 0, n));
    }

    private static long solve(int position, int x, int y) {

        if (position == p) { // 현재 위치가 플레이리스트 길이 도달
            if (y == 0) { // 남은 곡이 없다면
                return 1;
            } else {
                return 0; // 남은 곡이 있다면(모든 노래를 플레이리스트에 추가해야 되기 때문에
            }
        }

        long ans = dp[position][x][y];
        if (ans != -1) {
            return ans;
        }

        ans = 0;
        if (y > 0) { // 아직 추가한 적이 없는 노래를 추가 할 경우
            ans += solve(position + 1, x + 1, y - 1) * y;
        }
        if (x - m > 0) { // 이미 추가된 노래를 또 추가할 경우
            ans += solve(position + 1, x, y) * (x - m);
        }

        ans %= MOD;
        dp[position][x][y] = ans;

        return ans;
    }

    private static void getInput() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputData = br.readLine().split(" ");
        n = Integer.parseInt(inputData[0]); // 모든 노래 갯수
        m = Integer.parseInt(inputData[1]); // 같은 곡 사이에 있어야할 각기 다른 노래 갯수
        p = Integer.parseInt(inputData[2]); // 듣고자 하는 플레이리스트 길이
    }

}
