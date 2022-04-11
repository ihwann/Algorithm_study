package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class Image {
    int x;
    int y;

    public Image(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class FloodFill733 {
    private static int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
    private static int sr = 1;
    private static int sc = 1;
    private static int newColor = 2;

    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {

        visited = new boolean[image.length][image[0].length];

        bfs(sr, sc, newColor);
    }

    private static void bfs(int sr, int sc, int newColor) {

        Queue<Image> q = new LinkedList<>();
        q.add(new Image(sr, sc));
        visited[sr][sc] = true;
        int oldColor = image[sr][sc];
        while (!q.isEmpty()) {
            Image point = q.poll();
            int x = point.x;
            int y = point.y;

            image[x][y] = newColor;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < image.length && ny >= 0 && ny < image[0].length) {
                    if (!visited[nx][ny] && image[nx][ny] == oldColor) {
                        visited[nx][ny] = true;
                        image[nx][ny] = newColor;
                        q.add(new Image(nx, ny));
                    }
                }
            }
        }
    }
}
