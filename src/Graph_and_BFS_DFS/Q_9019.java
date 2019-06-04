package Graph_and_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_9019 {
    static final int MAX = 10001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean[] check = new boolean[MAX];
            int[] dist = new int[MAX];
            int[] from = new int[MAX];
            char[] how = new char[MAX];

            dist[n] = 0;
            check[n] = true;
            from[n] = -1;
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(n);
            while (!q.isEmpty()) {
                int now = q.remove();
                int next = (now * 2) % 10000;
                if (!check[next]) {
                    check[next] = true;
                    q.add(next);
                    from[next] = now;
                    dist[next] = dist[now] + 1;
                    how[next] = 'D';
                }
                next = now - 1;
                if (next == -1)
                    next = 9999;
                if (!check[next]) {
                    check[next] = true;
                    q.add(next);
                    from[next] = now;
                    dist[next] = dist[now] + 1;
                    how[next] = 'S';
                }
                next = (now / 1000) + ((now % 1000) * 10);
                if (!check[next]) {
                    check[next] = true;
                    q.add(next);
                    from[next] = now;
                    dist[next] = dist[now] + 1;
                    how[next] = 'L';
                }
                next = (now / 10) + (now % 10) * 1000;
                if (!check[next]) {
                    check[next] = true;
                    q.add(next);
                    from[next] = now;
                    dist[next] = dist[now] + 1;
                    how[next] = 'R';
                }
            }
            StringBuilder ans = new StringBuilder();
            while (n != m) {
                ans.append(how[m]);
                m = from[m];
            }
            System.out.println(ans.reverse());
        }
    }

}
