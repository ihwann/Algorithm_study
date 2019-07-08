package Brute_Force;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_3085 {
    static char[][] candy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        candy = new char[n][n];
        for (int i = 0; i < n; i++) {
            candy[i] = br.readLine().toCharArray();
        }

        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    swap1(i, j);
                    int temp = check(candy);
                    if (ans < temp) ans = temp;
                    swap1(i, j);

                }
                if (i + 1 < n) {
                    swap2(i, j);
                    int temp = check(candy);
                    if (ans < temp) ans = temp;
                    swap2(i, j);
                }
            }
        }
        System.out.println(ans);
    }

    private static int check(char[][] candy) {
        int ans = 1;

        for (int i = 0; i < candy.length; i++) {
            int cnt = 1;

            for (int j = 1; j < candy.length; j++) {
                if (candy[i][j] == candy[i][j - 1]) {
                    cnt += 1;
                }
                else{
                    cnt = 1;
                }
                if (ans < cnt) ans = cnt;
            }
            cnt = 1;
            for (int j = 1; j < candy.length; j++) {
                if (candy[j][i] == candy[j - 1][i]) {
                    cnt += 1;
                }else{
                    cnt = 1;
                }
                if (ans < cnt) ans = cnt;
            }
        }
        return ans;
    }

    private static void swap1(int i, int j) {
        char temp = candy[i][j];
        candy[i][j] = candy[i][j + 1];
        candy[i][j + 1] = temp;
    }

    private static void swap2(int i, int j) {
        char temp = candy[i][j];
        candy[i][j] = candy[i + 1][j];
        candy[i + 1][j] = temp;
    }


}
