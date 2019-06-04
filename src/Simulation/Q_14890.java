package Simulation;

import java.util.Scanner;

public class Q_14890 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 지도의 크기
        int l = sc.nextInt(); // 경사로 길이

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int ans = 0;

        // 행 검사
        for (int i = 0; i < n; i++) {
            int[] path = new int[n]; // 경로
            for (int j = 0; j < n; j++) {
                path[j] = map[i][j];
            }
            if (solution(path, l)) { // 경사로 유효 검사
                ans += 1;
            }
        }

        // 열 검사
        for (int j = 0; j < n; j++) {
            int[] path = new int[n]; // 경로
            for (int i = 0; i < n; i++) {
                path[i] = map[i][j];
            }
            if (solution(path, l)) { // 경사로 유효 검사
                ans += 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean solution(int[] path, int l) {
        // TODO Auto-generated method stub
        int n = path.length;
        boolean[] check = new boolean[n];

        for (int i = 1; i < n; i++) {
            if (path[i] != path[i - 1]) { // 높낮이가 다르다면
                int diff = path[i] - path[i - 1];
                if (diff < 0) {
                    diff = -diff;
                }
                if (diff != 1) { // 낮은 칸과 높은 칸의 높이 차이가 1이 아닌 경우
                    return false;
                }
                if (path[i] > path[i - 1]) {
                    for (int j = 1; j <= l; j++) {
                        // 경사로를 놓다가 범위를 벗어나는 경우
                        if (i - j < 0) {
                            return false;
                        }
                        // 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
                        if (path[i - 1] != path[i - j]) {
                            return false;
                        }

                        // 경사로를 놓은 곳에 또 경사로를 놓는 경우
                        if (check[i - j]) {
                            return false;
                        }
                        check[i - j] = true;
                    }
                } else { // path[i] < path[i - 1]
                    for (int j = 0; j < l; j++) {
                        if (i + j >= n) {
                            return false;
                        }
                        if (path[i] != path[i + j]) {
                            return false;
                        }
                        if (check[i + j]) {
                            return false;
                        }
                        check[i + j] = true;
                    }
                }
            } else if (path[i] == path[i - 1]) { // 높낮이가 같다면
                continue;
            }
        }

        return true;
    }

}
