package CodingTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Danal_1 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 19, 20, 8, 25}, {21, 4, 3, 17, 24}, {12, 5, 6, 16, 15}, {11, 18, 10, 9, 23}, {7, 13, 14, 22, 2}};

        System.out.println(Solution(matrix));
    }

    private static int Solution(int[][] matrix) {
        int answer = 0;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            int[] sero = Arrays.copyOf(matrix[i], n);
            Arrays.sort(sero);
            int mid_sero = sero[n / 2];
            for (int j = 0; j < n; j++) {
                if (mid_sero == matrix[i][j]) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    for (int k = 0; k < n; k++) {
                        arr.add(matrix[k][j]);
                    }
                    Collections.sort(arr);

                    int mid_garo = arr.get(n / 2);
                    if (mid_garo == mid_sero) {
                        answer += 1;
                    }
                }
            }
        }
        return answer;
    }
}
