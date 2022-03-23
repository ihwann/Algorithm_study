package brute_force;

import java.util.ArrayList;
import java.util.Scanner;

class Pair_15684 { // 놓을 수 있는 가로선 후보들
    int first;
    int second;

    Pair_15684(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Q_15684 {
    static int[][] ladder_game; // 사다리 조작 맵
    static int n;
    static int m;
    static int h;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 세로선 갯수
        m = sc.nextInt(); // 초기 주어지는 가로선 갯수
        h = sc.nextInt(); // 세로선 마다 놓을 수 있는 위치의 가로선 갯수

        ladder_game = new int[h + 1][n + 1];

        while (m-- > 0) {
            int a = sc.nextInt(); // 가로선의 정보
            int b = sc.nextInt(); // 가로선의 정보
            /*
            a,b 에 정보가 주어지면 b번 세로선과 b+1번 세로선을 a번 점선 위치에서 연결했다는 의미.
            가로선의 시작은 1
            가로선의 끝은 2
             */
            ladder_game[a][b] = 1;
            ladder_game[a][b + 1] = 2;
        }

        // h*n 크기의 사다리면 가로선은 h * n-1 개 까지 놓을 수 있다.
        // 예비 가로선들을 ArrayList에 저장
        ArrayList<Pair_15684> temp_garoLine = new ArrayList<>();
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= n - 1; j++) {
                if (ladder_game[i][j] != 0) continue;
                if (ladder_game[i][j + 1] != 0) continue;
                temp_garoLine.add(new Pair_15684(i, j));
            }
        }
        // ArrayList에 담긴 예비 가로선의 크기만큼 배열 지정
        Pair_15684[] arr_temp = temp_garoLine.toArray(new Pair_15684[temp_garoLine.size()]);

        /*
        가로선들을 하나도 추가하지 않았을 때 문제 조건에 참이면
        가로선을 하나도 추가하지 않았기 때문에 0 출력하고 종료
         */
        if (go(n)) {
            System.out.println(0);
            System.exit(0);
        }

        /*
        추가로 필요한 가로선(정답)이 3을 초과하면 -1을 출력하므로 3중(가로선 x,y) for문까지 검사
         */

        int ans = -1;
        int len = arr_temp.length;

        for (int i = 0; i < len; i++) {
            int x1 = arr_temp[i].first;
            int y1 = arr_temp[i].second;
            if (ladder_game[x1][y1] != 0 || ladder_game[x1][y1 + 1] != 0) continue;
            ladder_game[x1][y1] = 1;
            ladder_game[x1][y1 + 1] = 2;
            if (go(n)) {
                if (ans == -1 || ans > 1) {
                    ans = 1;
                }
            }
            for (int j = i + 1; j < len; j++) {
                int x2 = arr_temp[j].first;
                int y2 = arr_temp[j].second;
                if (ladder_game[x2][y2] != 0 || ladder_game[x2][y2 + 1] != 0) continue;
                ladder_game[x2][y2] = 1;
                ladder_game[x2][y2 + 1] = 2;
                if (go(n)) {
                    if (ans == -1 || ans > 2) {
                        ans = 2;
                    }
                }
                for (int k = j + 1; k < len; k++) {
                    int x3 = arr_temp[k].first;
                    int y3 = arr_temp[k].second;
                    if (ladder_game[x3][y3] != 0 || ladder_game[x3][y3 + 1] != 0) continue;
                    ladder_game[x3][y3] = 1;
                    ladder_game[x3][y3 + 1] = 2;
                    if (go(n)) {
                        if (ans == -1 || ans > 3) {
                            ans = 3;
                        }
                    }
                    ladder_game[x3][y3] = 0;
                    ladder_game[x3][y3 + 1] = 0;
                }
                ladder_game[x2][y2] = 0;
                ladder_game[x2][y2 + 1] = 0;
            }
            ladder_game[x1][y1] = 0;
            ladder_game[x1][y1 + 1] = 0;
        }
        System.out.println(ans);
    }

    private static boolean go(int n) {
        for (int start_seroLine = 1; start_seroLine <= n; start_seroLine++) {
            if (start_seroLine != end_seroLine(start_seroLine)) {
                return false;
            }
        }
        return true;
    }

    private static int end_seroLine(int num_seroLine) {
        int num_garoLine = 1;

        while (num_garoLine <= h) {
            if (ladder_game[num_garoLine][num_seroLine] == 1) {
                num_seroLine += 1;
            } else if (ladder_game[num_garoLine][num_seroLine] == 2) {
                num_seroLine -= 1;
            }
            num_garoLine += 1;
        }
        return num_seroLine;
    }
}
