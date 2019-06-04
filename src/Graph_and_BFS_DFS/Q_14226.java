package Graph_and_BFS_DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_14226 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 입력하고자 하는 이모티콘 수
        int[][] check = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(check[i], -1);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(0);
        check[1][0] = 0;
        while (!q.isEmpty()) {
            int s = q.remove();
            int c = q.remove();
            if (check[s][s] == -1) {
                check[s][s] = check[s][c] + 1;
                q.add(s);
                q.add(s);
            }
            if (s + c <= N && check[s + c][c] == -1) {
                check[s + c][c] = check[s][c] + 1;
                q.add(s + c);
                q.add(c);
            }
            if (s - 1 >= 0 && check[s - 1][c] == -1) {
                check[s - 1][c] = check[s][c] + 1;
                q.add(s - 1);
                q.add(c);
            }
        }
        int time = -1;
        for (int i = 0; i <= N; i++) {
            if (check[N][i] != -1) {
                if (time == -1 || time > check[N][i]) {
                    time = check[N][i];
                }
            }
        }
        System.out.println(time);
    }

}
