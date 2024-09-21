package leetcode;


import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Point> pointList;

    public static void main(String[] args) {
        solve(new char[][]{{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}});
    }

    public static void solve(char[][] board) {

        int row = board.length;
        int col = board[0].length;
        boolean[][] visit = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visit[i][j] && board[i][j] == 'O') {
                    bfs(i, j, board, visit);
                }
            }
        }

        System.out.println();
    }

    private static void bfs(int row, int col, char[][] board, boolean[][] visit) {
        Queue<Point> boardQueue = new LinkedList<>();
        pointList = new LinkedList<>();

        boardQueue.offer(new Point(row, col));
        pointList.offer(new Point(row, col));
        visit[row][col] = true;
        boolean isEdge = false;

        while (!boardQueue.isEmpty()) {
            Point point = boardQueue.poll();
            int x = point.x;
            int y = point.y;

            if (x == 0 || x == board.length - 1 || y == 0 || y == board[0].length - 1) {
                isEdge = true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                    if (!visit[nx][ny] && board[nx][ny] == 'O') {
                        visit[nx][ny] = true;
                        boardQueue.offer(new Point(nx, ny));
                        pointList.offer(new Point(nx, ny));
                    }
                }
            }
        }
        if (!isEdge) {
            removeRegion(pointList, board);
        }
    }

    private static void removeRegion(Queue<Point> pointList, char[][] board) {
        while (!pointList.isEmpty()) {
            Point point = pointList.poll();
            board[point.x][point.y] = 'X';
        }
    }
}
