package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1206 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int testCase = 1; testCase <= 10; testCase++) {

            int n = Integer.parseInt(br.readLine());

            int[] apt = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < apt.length; i++) {
                apt[i] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;
            for (int i = 2; i < apt.length - 2; i++) {
                int leftMaxHeight = Math.max(apt[i - 2], apt[i - 1]);
                int rightMaxHeight = Math.max(apt[i + 1], apt[i + 2]);
                int maxHeight = Math.max(leftMaxHeight, rightMaxHeight);
                if (apt[i] <= maxHeight) continue;
                ans += apt[i] - maxHeight;
            }

            StringBuilder output = new StringBuilder();

            output.append("#").append(testCase).append(" ").append(ans);
            System.out.println(output);
        }
    }
}
