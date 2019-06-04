package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_15989 {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] num = {1, 2, 3};
        int[] d = new int[10001];

        d[0] = 1;

        for (int j = 0; j < num.length; j++) {
            for (int i = 1; i < d.length; i++) {
                if (i - num[j] >= 0) {
                    d[i] += d[i - num[j]];
                }
            }
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(d[n]);
        }
    }

}
