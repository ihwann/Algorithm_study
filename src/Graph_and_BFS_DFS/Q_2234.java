package Graph_and_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair_2234 {
    int x;
    int y;

    Pair_2234(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q_2234 {
    private static int n, m;
    private static int[][] roomWall; // 정사각형 마다 있는 벽 위치 정보
    private static int[][] roomInfo;
    private static int[] roomArea; // 각 방의 넓이
    private static boolean[][] check_room;
    private static int[] dx = {0, -1, 0, 1}; // 벽 위치정보 순서에 따라서
    private static int[] dy = {-1, 0, 1, 0}; // 벽 위치정보 순서에 따라서

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        roomWall = new int[m][n];
        roomInfo = new int[m][n];
        roomArea = new int[m * n + 1];
        check_room = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                roomWall[i][j] = sc.nextInt();
            }
        }

        int roomNum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!check_room[i][j]) {
                    roomNum++;
                    roomArea[roomNum] = bfs_room(i, j, roomNum);
                }
            }
        }

        System.out.println(roomNum); // 방의 갯수

        int maxArea = 0;
        for (int i = 1; i < roomArea.length; i++) {
            if (maxArea < roomArea[i]) maxArea = roomArea[i];
        }

        System.out.println(maxArea); // 가장 넓은 방의 크기


        int maxArea2 = 0; // 벽을 부수고 가장 넓은 방의 크기

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = i;
                int y = j;
                for (int k = 0; k < 4; k++) {
                    int nx = dx[k];
                    int ny = dy[k];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        // 방 번호가 다르고
                        if (roomInfo[x][y] != roomInfo[nx][ny]) {
                            //벽이 막혀있기 때문에 뚫음
                            if ((roomWall[x][y] & (1 << k)) > 0) {
                                if (maxArea2 < roomArea[roomInfo[x][y]] + roomArea[roomInfo[nx][ny]]) {
                                    maxArea2 = roomArea[roomInfo[x][y]] + roomArea[roomInfo[nx][ny]];
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(maxArea2);
    }


    private static int bfs_room(int i, int j, int roomNum) {
        int area = 0; // 각 방의 넓이 계산
        Queue<Pair_2234> q = new LinkedList<>();
        q.offer(new Pair_2234(i, j));
        check_room[i][j] = true; // 방문 검사
        roomInfo[i][j] = roomNum; // 각 방마다 roomNum 입력

        while (!q.isEmpty()) {
            Pair_2234 p = q.remove();
            int x = p.x;
            int y = p.y;
            area += 1;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (!check_room[nx][ny]) {
                        // 벽 정보에서 해당 방향(dx,dy) 으로 비트연산을 통해 0이 되면 벽이 뚫려있음(0이 넘으면 벽으로 막혀있음)
                        if ((roomWall[x][y] & (1 << k)) == 0) {
                            check_room[nx][ny] = true;
                            roomInfo[nx][ny] = roomNum;
                            q.offer(new Pair_2234(nx, ny));
                        }
                    }
                }
            }
        }
        return area;
    }
}
