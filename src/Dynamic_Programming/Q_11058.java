package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;


//dp[n] = 버튼을 n번 눌러서  출력되는 최대 A 개수
//n 번째 a 버튼 눌렀을 경우 : dp[n-1] + 1
//n 번째 Ctrl+a, Ctrl+c 눌렀을 경우 : 출력되는 A 개수에 영향을 주지 않음
//n 번째 Ctrl+v 눌렀을 경우 : 누르기 전에  Ctrl+a, Ctrl+c 눌려야 영향이 있음 고로  Ctrl + a  Ctrl + c  Ctrl + v 한 세트로 생각
//마지막  Ctrl+a Ctrl+c 누르고 Ctrl+v를 j번 누를 경우 d[n-(j+2)] * j+1

public class Q_11058 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 1; j <= i - 3; j++) {
                dp[i] = Math.max(dp[i], dp[i - (2 + j)] * (j + 1));
            }
        }

        System.out.println(dp[n]);

    }

}
