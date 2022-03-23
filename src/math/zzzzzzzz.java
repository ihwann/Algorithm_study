package math;

public class zzzzzzzz {

    public static void main(String[] args) {
        int N = 5;
        int number = 12;

        System.out.println(solution(N, number));
    }

    private static int solution(int N, int number) {
        int answer = 0;
        int[] dp = new int[N * number+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            if (i - number >= 0) {
                dp[i] = Math.min(dp[i], dp[i - number] + 1);
            }
            if (i + number <= number+N) {
                dp[i] = Math.min(dp[i], dp[i + number] + 1);
            }
            if (i / number >= 0) {
                dp[i] = Math.min(dp[i], dp[i / number] + 1);
            }
            if (i * number <= number*N) {
                dp[i] = Math.min(dp[i], dp[i * number] + 1);
            }
        }
        answer = dp[number];
        return answer;
    }
}
