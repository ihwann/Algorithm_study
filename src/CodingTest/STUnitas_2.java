package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class STUnitas_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            if (sb.length() == 0) {
                sb.append(i);
            } else {
                sb.insert(sb.length() - num[i], i);
            }
        }
        StringBuffer answer = new StringBuffer();
        for (int i = 0; i < sb.length(); i++) {
            answer.append(sb.charAt(i)).append(" ");
        }
        //String answer2 = answer.substring(0, answer.length() - 1);
        System.out.println(sb.toString());
    }
}
