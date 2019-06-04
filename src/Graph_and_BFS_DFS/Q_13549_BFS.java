package Graph_and_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_13549_BFS {
    public static final int MAX = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[] check = new boolean[MAX];
        int[] dist = new int[MAX];
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> next_q = new LinkedList<Integer>();
        q.add(n);
        dist[n] = 0;
        check[n] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            if (x * 2 < MAX) {
                if (check[x * 2] == false) {
                    check[x * 2] = true;
                    dist[x * 2] = dist[x];
                    q.add(x * 2);
                }
            }
            if (x + 1 < MAX) {
                if (check[x + 1] == false) {
                    check[x + 1] = true;
                    dist[x + 1] = dist[x] + 1;
                    next_q.add(x + 1);
                }
            }
            if (x - 1 >= 0) {
                if (check[x - 1] == false) {
                    check[x - 1] = true;
                    dist[x - 1] = dist[x] + 1;
                    next_q.add(x - 1);
                }
            }
            if (q.isEmpty()) {
                q = next_q;
                next_q = new LinkedList<Integer>();
            }
        }
        System.out.println(dist[k]);
    }

}
