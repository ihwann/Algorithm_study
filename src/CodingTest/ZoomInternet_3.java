package CodingTest;

public class ZoomInternet_3 {

    private static int[][] square = {{1, 1, 1, 1, 1}, {1, 5, 3, 4, 1}, {1, 1, 5, 8, 1}, {1, 6, 4, 2, 1}, {1, 1, 1, 1, 2}};
    private static int height = 0;
    private static int width = 0;

    public static void main(String[] args) {

        height = square.length;
        width = square[0].length;


        int answer = 1;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int temp = solution(i, j);
                answer = Math.max(answer, temp);
            }
        }
        System.out.println(answer);
    }

    private static int solution(int i, int j) {
        int result = 0;
        int diagonal = square[i][j];
        int garo = square[i][j];
        int sero = square[i][j];

        int k = 0;

        while (i + k < height && j + k < width) {

            if (diagonal == garo && garo == sero) {
                result++;
            }

            diagonal += square[i + k][j + k];
            garo += square[i][j + k];
            sero += square[i + k][j];

            k++;
        }
        return result;
    }
}
