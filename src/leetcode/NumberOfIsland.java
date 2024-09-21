package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class Point {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class NumberOfIsland {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static boolean[][] visit;

    public static void main(String[] args) {

        System.out.println();
    }

    public static int numIslands(char[][] grid) {
        int result = 0;

        visit = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    result += 1;
                    bfs(i, j, grid);
                }
            }
        }

        return result;
    }

    private static void bfs(int i, int j, char[][] grid) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));

        while (!q.isEmpty()) {
            Point point = q.poll();
            int x = point.x;
            int y = point.y;

            visit[x][y] = true;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < grid.length) {
                    if (ny >= 0 && ny < grid[0].length) {
                        if(grid[nx][ny] == '1' && !visit[nx][ny]) {
                            visit[nx][ny] = true;
                            q.add(new Point(nx, ny));
                        }
                    }
                }
            }

        }
    }
}
