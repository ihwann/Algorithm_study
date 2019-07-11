package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Q_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] timeLine = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            /*
            i 번째 회의 0번 인덱스는 시작시간
            i 번째 회의 1번 인덱스는 종료시간
             */
            timeLine[i][0] = Integer.parseInt(st.nextToken());
            timeLine[i][1] = Integer.parseInt(st.nextToken());
        }

        // 종료시간 기준 정렬
        Arrays.sort(timeLine, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] < b[1]) {
                    return -1;
                } else if (a[1] == b[1]) {
                    if (a[0] < b[0]) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
                return 1;
            }
        });


        int ans = 1;
        int endTime = timeLine[0][1];
        for (int i = 1; i < n; i++) {
            if (endTime <= timeLine[i][0]) {
                endTime = timeLine[i][1];
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}
