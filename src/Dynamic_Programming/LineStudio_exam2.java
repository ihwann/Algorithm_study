package Dynamic_Programming;

import java.io.IOException;
import java.util.Arrays;

public class LineStudio_exam2 {

    public static void main(String[] args) throws IOException {


        int[] data = {0, 5, 0, 3, -1};
        // 0을 오른쪽 끝으로 몰아넣기

        System.out.println(Arrays.toString(solution(data)));
    }

    private static int[] solution(int[] data) {

        int index = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i] != 0) {
                swap(data, i, index);
                index++;
            }
        }
        return data;
    }

    private static void swap(int[] arr, int num1, int num2) {
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }
}
