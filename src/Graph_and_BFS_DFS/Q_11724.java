package Graph_and_BFS_DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q_11724 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정점의 갯수
        int M = sc.nextInt(); // 간선의 갯수(무방향)
        ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }
        sc.close();
        for (int i = 1; i <= N; i++) {
            Collections.sort(a[i]);
        }

        boolean[] check = new boolean[N + 1];
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            if (check[i] == false) {
                dfs(a, check, i);
                ans += 1;
            }
        }

        System.out.println(ans);
    }

    public static void dfs(ArrayList<Integer>[] a, boolean[] c, int x) {
        if (c[x])
            return;
        c[x] = true;
        for (int y : a[x]) {
            if (c[y] == false) {
                dfs(a, c, y);
            }
        }
    }

}
