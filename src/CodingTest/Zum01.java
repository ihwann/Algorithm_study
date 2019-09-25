package CodingTest;

public class Zum01 {

    static int answer = 0;

    public static void main(String[] args) {
        int[] X = {1, 1, 1};
        int[] Y = {2, 2, 2};

        System.out.println(Solution(X, Y));
    }

    private static int Solution(int[] X, int[] Y) {
        double[] arr = new double[X.length];

        for (int i = 0; i < X.length; i++) {
            arr[i] = (double) X[i] / (double) Y[i];
        }


        for (int i = 0; i < arr.length; i++) {
            double total = 0.0;
            dfs(i, total, arr);
        }
        return answer;
    }

    private static void dfs(int i, double total, double[] arr) {
        total += arr[i];

        if (total == 1.0) {
            answer += 1;
            return;
        } else if (total < 1.0) {
            for (int j = i + 1; j < arr.length; j++) {
                dfs(j, total, arr);
            }
        }
        total -= arr[i];
    }
}
