package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_14890_v2 {
    /*
    경사로가 가능한 경우
    -경사로는 낮은 칸에 놓으며, L개의 연속된 칸에 경사로의 바닥이 모두 접해야 한다.
    -낮은 칸과 높은 칸의 높이 차이는 1이어야 한다.
    -경사로를 놓을 낮은 칸의 높이는 모두 같아야 하고, L개의 칸이 연속되어 있어야 한다.

    경사로가 불가능한 경우
    -경사로를 놓은 곳에 또 경사로를 놓는 경우
    -낮은 칸과 높은 칸의 높이 차이가 1이 아닌 경우
    -낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
    -경사로를 놓다가 범위를 벗어나는 경우
    */
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]); // 지도의 가로세로 크기
        int l = Integer.parseInt(input[1]); // 경사로의 길이

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        // 행 경로 검사
        for (int i = 0; i < n; i++) {
            int[] path = new int[n];
            for (int j = 0; j < n; j++) {
                path[j] = map[i][j];
            }
            if (pathChk(path, l)) {
                ans += 1;
            }
        }

        // 열 경로 검사
        for (int j = 0; j < n; j++) {
            int[] path = new int[n];
            for (int i = 0; i < n; i++) {
                path[i] = map[i][j];
            }
            if (pathChk(path, l)) {
                ans += 1;
            }
        }

        System.out.println(ans);

    }

    private static boolean pathChk(int[] path, int l) {
        int len = path.length;
        boolean[] chk = new boolean[len]; // 경로에 경사로를 놓았는지 검사

        for (int i = 1; i < len; i++) {
            if (path[i] == path[i - 1]) continue; // 두 지점 높이가 같다면 다음 검색
            if (path[i] != path[i - 1]) { // 두 지점 높이가 1이 아니라면 경로불가
                int diff = Math.abs(path[i] - path[i - 1]);
                if (diff != 1) return false;
            }

            // 왼쪽 지점 높이가 더 클 때
            if (path[i] < path[i - 1]) {
                for (int k = 0; k < l; k++) {
                    if (i + k >= len) return false;
                    if (path[i] != path[i + k]) return false;
                    if (chk[i + k]) {
                        return false;
                    } else {
                        chk[i + k] = true;
                    }
                }

            } else { // 오른쪽 지점 높이가 더 클 때
                for (int k = 1; k <= l; k++) {
                    if (i - k < 0) return false;
                    if (path[i - 1] != path[i - k]) return false;
                    if (chk[i - k]) {
                        return false;
                    } else
                        chk[i - k] = true;
                }
            }
        }
        return true;
    }
}
