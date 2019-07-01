package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1946 {
    private static int[] rank;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfTestCase = Integer.parseInt(br.readLine());

        while (numOfTestCase-- > 0) {
            int num = Integer.parseInt(br.readLine());

            rank = new int[num + 1];

            for (int i = 1; i <= num; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int rankOfDocument = Integer.parseInt(st.nextToken()); // 서류심사 석차
                int rankOfMeeting = Integer.parseInt(st.nextToken()); // 면접심사 석차
                rank[rankOfDocument] = rankOfMeeting; // 서류심사 석차 index에 면접심사 석차 값 대입
            }

            // 서류심사 석차 1 번째 인덱스 신입사원은 이미 서류심사 점수가 가장 높기 때문에 무조건 선발
            // 서류심사 석차 2 번째 인덱스 신입사원 부터 이미 서류심사는 점수가 낮기 때문에 면접심사 점수가 다른 인원보다 무조건 높아야 선발
            int numOfRecruit = 1;
            int cutLine = rank[1];
            for (int i = 2; i <= num; i++) {
                if (rank[i] < cutLine) {
                    numOfRecruit += 1;
                    cutLine = rank[i];
                }
            }

            System.out.println(numOfRecruit);
        }
    }
}
