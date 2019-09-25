package CodingTest;

public class ZoomInternet_4 {

    public static void main(String[] args) {

        int[] num = {9,4,2,10};

        int result = solution(num);

        System.out.println(result);
    }

    private static int solution(int[] num) {

        int answer = 1;
        int temp = 1;

        if (num.length == 1) {
            return 1;
        } else {

            int lastSig = 0;

            for (int i = 1; i < num.length; i++) {

                int diff = num[i] - num[i - 1];

                int sig = Integer.signum(diff);

                if (diff != 0 && lastSig != sig) {
                    lastSig = sig;
                    temp += 1;
                    answer = Math.max(answer, temp);
                } else if (diff != 0 && lastSig == sig) {
                    temp = 2;
                    lastSig = sig;
                } else if (diff == 0) {
                    lastSig = 0;
                    temp = 1;
                }
            }
        }
        return answer;
    }
}
