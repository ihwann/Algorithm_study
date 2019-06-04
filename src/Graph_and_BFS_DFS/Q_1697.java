package Graph_and_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_1697 {
    public static final int MAX = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 누나 위치
        int K = sc.nextInt(); // 동생 위치
        boolean[] check = new boolean[MAX];
        int[] dist = new int[MAX];
        check[N] = true; // N을 방문했는지
        dist[N] = 0; // N을 몇번만에 방문했는지
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(N);
        while (!q.isEmpty()) {
            int now = q.remove();
            if (now - 1 >= 0) {
                if (check[now - 1] == false) {
                    check[now - 1] = true;
                    dist[now - 1] = dist[now] + 1;
                    q.add(now - 1);
                }

            }
            if (now + 1 < MAX) {
                if (check[now + 1] == false) {
                    check[now + 1] = true;
                    dist[now + 1] = dist[now] + 1;
                    q.add(now + 1);

                }
                if (now * 2 < MAX) {
                    if (check[now * 2] == false) {
                        check[now * 2] = true;
                        dist[now * 2] = dist[now] + 1;
                        q.add(now * 2);
                    }
                }
            }
        }
        System.out.println(dist[K]);
    }
}
