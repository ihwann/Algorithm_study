package Graph_and_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_13913 {
    public static final int MAX = 100000;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        boolean[] check = new boolean[MAX];
        int[] dist = new int[MAX]; // 목적지
        int[] from = new int[MAX]; // 어디서 왔는지
        dist[n] = 0;
        from[n] = n;
        check[n] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.remove();
            if (now - 1 >= 0) {
                if (!check[now - 1]) {
                    check[now - 1] = true;
                    q.add(now - 1);
                    dist[now - 1] = dist[now] + 1;
                    from[now - 1] = now;
                }

            }
            if (now + 1 < MAX) {
                if (!check[now + 1]) {
                    check[now + 1] = true;
                    q.add(now + 1);
                    dist[now + 1] = dist[now] + 1;
                    from[now + 1] = now;
                }
            }
            if (now * 2 < MAX) {
                if (!check[now * 2]) {
                    check[now * 2] = true;
                    q.add(now * 2);
                    dist[now * 2] = dist[now] + 1;
                    from[now * 2] = now;
                }

            }
        }
        System.out.println(dist[k]);
        print(from, n, k);
    }

    private static void print(int[] from, int n, int k) {
        // TODO Auto-generated method stub
        if (n != k) {
            print(from, n, from[k]);
        }
        System.out.print(k + " ");
    }

}
