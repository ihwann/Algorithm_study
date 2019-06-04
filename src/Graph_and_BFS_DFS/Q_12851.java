package Graph_and_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_12851 {
    static final int MAX = 200001;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 수빈 위치
        int k = sc.nextInt(); // 동생 위치
        sc.close();

        boolean[] check = new boolean[MAX]; // k까지 가는 경로의 방문 여부
        int[] dist = new int[MAX]; // k 까지 가는 시간
        int[] cnt = new int[MAX]; // k까지 가는 방법의 갯수

        check[n] = true;
        dist[n] = 0;
        cnt[n] = 1;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        while (!q.isEmpty()) {
            int now = q.remove();
            if (now - 1 >= 0) {
                if (!check[now - 1]) {
                    check[now - 1] = true;
                    dist[now - 1] = dist[now] + 1;
                    cnt[now - 1] = cnt[now];
                    q.add(now - 1);
                } else if (dist[now - 1] == dist[now] + 1) {
                    cnt[now - 1] += cnt[now];
                }
            }
            if (now + 1 < MAX) {
                if (!check[now + 1]) {
                    check[now + 1] = true;
                    dist[now + 1] = dist[now] + 1;
                    cnt[now + 1] = cnt[now];
                    q.add(now + 1);
                } else if (dist[now + 1] == dist[now] + 1) {
                    cnt[now + 1] += cnt[now];
                }
            }
            if (now * 2 < MAX) {
                if (!check[now * 2]) {
                    check[now * 2] = true;
                    dist[now * 2] = dist[now] + 1;
                    cnt[now * 2] = cnt[now];
                    q.add(now * 2);
                } else if (dist[now * 2] == dist[now] + 1) {
                    cnt[now * 2] += cnt[now];
                }
            }
        }
        System.out.println(dist[k]);
        System.out.println(cnt[k]);
    }

}
