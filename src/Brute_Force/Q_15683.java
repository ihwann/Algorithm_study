package Brute_Force;

import java.util.ArrayList;
import java.util.Scanner;

class CCTV {
    int x; // cctv 위치
    int y; // cctv 위치
    int type; // cctv 타입
    int dir; // cctv가 비추고 있는 방향

    CCTV(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.dir = 0;
    }
}

class Q_15683 {

    static int[] dx = {0, 1, 0, -1}; // cctv 회전 방향 first index = 3시 방향 second index = 6시 방향 third index = 9시 방향, fourth index = 12시 방향
    static int[] dy = {1, 0, -1, 0}; // cctv 회전 방향 first index = 3시 방향 second index = 6시 방향 third index = 9시 방향, fourth index = 12시 방향
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[][] map = new int[n][m];
        int[][] copy_map = new int[n][m];

        ArrayList<CCTV> cctv = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (1 <= map[i][j] && map[i][j] <= 5) {
                    cctv.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        System.out.println(solve(map, copy_map, cctv, 0));
    }

    private static int solve(int[][] map, int[][] copy_map, ArrayList<CCTV> cctv, int index) {
        if (cctv.size() == index) { // 모든 cctv 탐색을 마쳤다면
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    copy_map[i][j] = map[i][j];
                }
            }

            for (CCTV c : cctv) {
                int x = c.x;
                int y = c.y;
                int dir = c.dir;
                int type = c.type;

                if (type == 1) {
                    cal_blind_spot(map, copy_map, x, y, dir);
                } else if (type == 2) {
                    cal_blind_spot(map, copy_map, x, y, dir);
                    cal_blind_spot(map, copy_map, x, y, (dir + 2) % 4);
                } else if (type == 3) {
                    cal_blind_spot(map, copy_map, x, y, dir);
                    cal_blind_spot(map, copy_map, x, y, (dir + 1) % 4);
                } else if (type == 4) {
                    cal_blind_spot(map, copy_map, x, y, dir);
                    cal_blind_spot(map, copy_map, x, y, (dir + 1) % 4);
                    cal_blind_spot(map, copy_map, x, y, (dir + 2) % 4);
                } else if (type == 5) {
                    cal_blind_spot(map, copy_map, x, y, dir);
                    cal_blind_spot(map, copy_map, x, y, (dir + 1) % 4);
                    cal_blind_spot(map, copy_map, x, y, (dir + 2) % 4);
                    cal_blind_spot(map, copy_map, x, y, (dir + 3) % 4);
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copy_map[i][j] == 0) {
                        cnt += 1; // 사각지대 계산
                    }
                }
            }
            return cnt;
        }
        int ans = 100;
        for (int i = 0; i < 4; i++) {
            cctv.get(index).dir = i;
            int temp = solve(map, copy_map, cctv, index + 1);
            if (ans > temp) {
                ans = temp;
            }
        }
        return ans;
    }

    private static void cal_blind_spot(int[][] map, int[][] copy_map, int x, int y, int dir) {
        int i = x;
        int j = y;

        while (i >= 0 && i < n && j >= 0 && j < m) {
            if (map[i][j] == 6) break; // 벽에 막혀있으면
            copy_map[i][j] = map[x][y];
            i += dx[dir]; // cctv가 비추고 있는 방향대로 진행
            j += dy[dir]; // cctv가 비추고 있는 방향대로 진행
        }
    }
}