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


public class MaxAreaOfIsland695 {
    private static boolean[][] visit;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int answer = 0;

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0, 0, 0, 0, 0}};

        visit = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j, grid);
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int i, int j, int[][] grid) {

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));
        visit[i][j] = true;
        int area = 0;

        while (!q.isEmpty()) {
            Point point = q.poll();
            int x = point.x;
            int y = point.y;
            area++;
            answer = Math.max(answer, area);

            for (int a = 0; a < 4; a++) {
                int nx = x + dx[a];
                int ny = y + dy[a];

                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                    if (!visit[nx][ny] && grid[nx][ny] == 1) {
                        visit[nx][ny] = true;
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
