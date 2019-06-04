package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_15486 {

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(bf.readLine());
            int[] t = new int[n + 1];
            int[] p = new int[n + 1];
            int[] d = new int[n + 50];

            for (int i = 1; i <= n; i++) {
                String[] temp = bf.readLine().split(" ");
                t[i] = Integer.parseInt(temp[0]); // 시간
                p[i] = Integer.parseInt(temp[1]); // 소득
            }

            for (int i = 1; i <= n; i++) {
                d[i + t[i]] = Math.max(d[i] + p[i], d[i + t[i]]); // i일에 상담 한다면
                d[i + 1] = Math.max(d[i], d[i + 1]); // i 일에 상담하지 않는다면
            }

            System.out.println(d[n + 1]);

        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
