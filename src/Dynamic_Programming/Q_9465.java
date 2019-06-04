package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_9465 {
    //문제해결 실패 다시 풀어보기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.valueOf(br.readLine());
            long[][] a = new long[2][n + 1];
            String[] data1 = br.readLine().split(" ");
            String[] data2 = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                a[0][i] = Long.parseLong(data1[i]);
                a[1][i] = Long.parseLong(data2[i]);
            }

            long[][] d = new long[3][n + 1];
            for (int i = 1; i <= n; i++) {
                /*
                 * 0 = 위 아래 뜯지 않았을 때
                 * 1 = 위 뜯었을 때
                 * 2 = 아래 뜯었을때
                 */
                d[0][i] = Math.max(d[0][i - 1], Math.max(d[1][i - 1], d[2][i - 1]));
                d[1][i] = Math.max(d[0][i - 1], d[2][i - 1]) + a[0][i - 1];
                d[2][i] = Math.max(d[0][i - 1], d[1][i - 1]) + a[1][i - 1];
            }
            long ans = 0;
            ans = Math.max(d[0][n], Math.max(d[1][n], d[2][n]));
            System.out.println(ans);
        }
    }
}
