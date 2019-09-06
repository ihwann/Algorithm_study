package Math;


public class ZoomInternet_4 {

    public static void main(String[] args) {

        int[] zigzag = {4, 8, 12, 16};

        int result = solution(zigzag);

        System.out.println(result);
    }

    private static int solution(int[] zigzag) {

        int answer = 1;
        int temp = 1;

        if (zigzag.length == 1) {
            return 1;
        } else {

            int lastSig = 0;

            for (int i = 0; i < zigzag.length - 1; i++) {

                int diff = zigzag[i] - zigzag[i + 1];

                int sig = Integer.signum(diff);

                if (diff != 0 && lastSig != sig) {
                    lastSig = sig;
                    temp += 1;
                    answer = Math.max(answer, temp);
                } else {
                    temp = 2;
                    lastSig = 0;
                }
            }
        }
        return answer;
    }
}
