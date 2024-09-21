package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SpiralMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        boolean[][] visit = new boolean[col][row];

        Queue<Integer> q = new LinkedList<>();

        int direction = 1;
        q.offer(0);
        q.offer(0);
        while (!q.isEmpty()) {

            int currentCol = q.poll();
            int currentRow = q.poll();
            result.add(matrix[currentRow][currentCol]);
            visit[currentRow][currentCol] = true;

            switch (direction) {
                case 1: {
                    int nextRow = currentRow;
                    int nextCol = currentCol + 1;
                    if (nextCol < col && !visit[nextRow][nextCol]) {
                        q.offer(nextCol);
                        q.offer(nextRow);
                        break;
                    } else {
                        direction = 2;
                    }
                }
                case 2: {
                    int nextRow = currentRow + 1;
                    int nextCol = currentCol;
                    if (nextRow < row && !visit[nextRow][nextCol]) {
                        q.offer(nextCol);
                        q.offer(nextRow);
                        break;
                    } else {
                        direction = 3;
                    }

                }
                case 3: {
                    int nextRow = currentRow;
                    int nextCol = currentCol - 1;
                    if (nextCol >= 0 && !visit[nextRow][nextCol]) {
                        q.offer(nextCol);
                        q.offer(nextRow);
                        break;
                    } else {
                        direction = 4;
                    }
                }
                case 4: {
                    int nextRow = currentRow - 1;
                    int nextCol = currentCol;
                    if (nextRow >= 0 && !visit[nextRow][nextCol]) {
                        q.offer(nextCol);
                        q.offer(nextRow);
                        break;
                    } else {
                        if (!visit[currentRow][currentRow + 1]) {
                            q.offer(currentRow + 1);
                            q.offer(currentRow);
                        }
                        direction = 1;
                        break;
                    }
                }
            }

        }

        return result;
    }

}
