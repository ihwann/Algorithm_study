package Brute_Force;

import java.util.HashSet;
import java.util.Scanner;

public class Q_2210 {
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    // 중복을 없애기 위해 hashset 이용
    static HashSet<String> ans = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                solve(x, y, String.valueOf(map[x][y]), 1);
            }
        }

        System.out.println(ans.size());
    }

    private static void solve(int x, int y, String num, int len) {

        // 문자열길이가 6이 된다면 hashset에 추가
        if (len == 6) {
            ans.add(num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                solve(nx, ny, num + map[nx][ny], len + 1);
            }
        }
    }
}
