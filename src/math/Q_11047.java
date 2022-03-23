package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_11047 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] val = br.readLine().split(" ");

        int n = Integer.parseInt(val[0]);
        int k = Integer.parseInt(val[1]);
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        while (k > 0) {
            int max = coin[0];
            for (int i = 0; i < coin.length; i++) {
                if (k >= coin[i]) {
                    max = coin[i];
                } else {
                    break;
                }
            }

            int mok = k / max;
            ans += mok;
            k = k - (max * mok);
        }

        System.out.println(ans);
    }
}
