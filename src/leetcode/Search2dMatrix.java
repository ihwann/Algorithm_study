package leetcode;

public class Search2dMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1}};

        System.out.println(searchMatrix(matrix, 0));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length;
        int row = matrix.length;

        boolean[][] visit = new boolean[row][col];

        int startCol = col / 2;
        int startRow = 0;

        while (!visit[startRow][startCol]) {
            visit[startRow][startCol] = true;
            int val = matrix[startRow][startCol];

            if (val == target) {
                return true;
            }

            if (val < target) {
                if (startCol < col - 1) {
                    startCol += 1;
                } else {
                    startCol = 0;
                    if (startRow < row - 1) {
                        startRow += 1;
                    }
                }
            }
            if (val > target) {
                if (startCol > 0) {
                    startCol -= 1;
                } else {
                    if (startCol < col - 1) {
                        startCol += 1;
                    }
                    startRow = 0;
                }
            }
        }

        return false;
    }
}
