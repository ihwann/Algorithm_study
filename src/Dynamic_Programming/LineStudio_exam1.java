package Dynamic_Programming;


import java.io.IOException;

public class LineStudio_exam1 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static int[][] dp;
    static int n;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        // 답 13
        // 측정값 전후 2분이내 모두 3도 이상 차이날 경우 error
        // 유효한 측정값으 평균 구하기
        int[] data = {10};

        int ans = 0;
        int start = 0;
        int end = 0;
        int cnt = 0;

        for (int i = 0; i < data.length; i++) {
            if (i - 2 < 0) {
                start = 0;
            } else {
                start = i - 2;
            }

            if (i + 2 >= data.length) {
                end = data.length - 1;
            } else {
                end = i + 2;
            }

            for (int n = start; n <= end; n++) {
                if (i == n) continue;
                if (Math.abs(data[i] - data[n]) >= 3) continue;
                ans += data[i];
                cnt++;
                break;
            }
        }
        if(ans == 0){
            System.out.println("ERROR");
        }else{
            System.out.println(ans / cnt);
        }
    }
}
