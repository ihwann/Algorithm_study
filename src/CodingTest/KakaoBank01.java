package CodingTest;

public class KakaoBank01 {
    public static void main(String[] args) {

        int[] black_caps = {1,1,1};
        int[] answer = new int[black_caps.length];

        for (int i = 0; i < black_caps.length; i++) {
            if (black_caps[i] == 2) {
                answer[i - 1] = 1;
                answer[i + 1] = 1;
                continue;
            }
            if (black_caps[i] == 0) {
                if (i == 0) {
                    answer[1] = 2;
                    continue;
                }
                if (i == black_caps.length - 1) {
                    answer[i - 1] = 2;
                    continue;
                }
                answer[i - 1] = 2;
                answer[i + 1] = 2;
            }

        }

        for (int i = 0; i < black_caps.length; i++) {
            if (black_caps[i] == 1) {
                if (i == 0) {
                    answer[1] = 1;
                    continue;
                }
                if (i == black_caps.length - 1) {
                    answer[i - 1] = 1;
                    continue;
                }
                if (answer[i + 1] == 2) {
                    answer[i - 1] = 1;
                    continue;
                }
                if (answer[i - 1] == 2) {
                    answer[i + 1] = 1;
                    continue;
                }
                if (answer[i + 1] == 1) {
                    answer[i - 1] = 2;
                    continue;
                }
                if (answer[i - 1] == 1) {
                    answer[i + 1] = 2;
                    continue;
                }
                if (answer[i + 1] == 0) {
                    if (answer[i - 1] == 2) answer[i + 1] = 1;
                    if (answer[i - 1] == 1) answer[i + 1] = 2;
                    continue;
                }
                if (answer[i - 1] == 0) {
                    if (answer[i + 1] == 2) answer[i - 1] = 1;
                    if (answer[i + 1] == 1) answer[i - 1] = 2;
                    continue;
                }
//                if (answer[i - 1] == 2) {
//                    answer[i + 1] = 1;
//                    continue;
//                }
//                if (answer[i + 1] == 2) {
//                    answer[i - 1] = 1;
//                    continue;
//                }
            }
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
