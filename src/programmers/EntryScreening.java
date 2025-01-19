package programmers;

import java.util.Arrays;

public class EntryScreening {

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    public static long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long minTime = 0;
        long maxTime = (long) times[times.length - 1] * n;

        while (minTime <= maxTime) {
            long midTime = (minTime + maxTime) / 2;

            long completeCount = 0;
            for (int time : times) {
                completeCount += (midTime / time);
            }

            if (completeCount < n) {
                minTime = midTime + 1;
            } else {
                maxTime = midTime - 1;
                answer = midTime;
            }
        }
        return answer;
    }

}
