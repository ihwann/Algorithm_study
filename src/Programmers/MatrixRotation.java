package Programmers;

public class MatrixRotation {
    static int[][] matrix;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) {
        int rows = 3;
        int columns = 3;
        //int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[][] queries = {{1, 1, 2, 2}, {1,2,2,3},{2,1,3,2},{2,2,3,3}};

        int value = 0;
        matrix = new int[rows + 1][columns + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                value++;
                matrix[i][j] = value;
            }
        }
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            answer[i] = solve(queries[i]);
        }

        for (int i : answer) {
            System.out.println("i = " + i);
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int solve(int[] point) {
        int result = Integer.MAX_VALUE;
        int sX = point[0];
        int sY = point[1];
        int eX = point[2];
        int eY = point[3];

        int temp = matrix[sX][sY];
        int curX = sX;
        int curY = sY;
        int direction = 0;
        while (direction < 4) {
            int nextX = curX + dx[direction];
            int nextY = curY + dy[direction];

            if (nextX < sX || nextY < sY || nextX > eX || nextY > eY) {
                direction++;
            } else {
                matrix[curX][curY] = matrix[nextX][nextY];
                result = Math.min(result, matrix[curX][curY]);
                curX = nextX;
                curY = nextY;
            }
        }
        matrix[sX][sY+1] = temp;
        return Math.min(result, matrix[sX][sY+1]);
    }
}
