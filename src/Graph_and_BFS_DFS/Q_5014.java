package Graph_and_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_5014 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt(); // 전체 층 수
        int s = sc.nextInt(); // 현재 위치
        int g = sc.nextInt(); // 목적지
        int u = sc.nextInt(); // u만큼 위로
        int d = sc.nextInt(); // d만큼 아래로

        int[] building = new int[f + 1];
        boolean[] check = new boolean[f + 1];
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(s);
        check[s] = true;
        building[s] = 0;
        while (!q.isEmpty()) {
            int x = q.remove(); // 현재 위치
            if (x + u <= f && check[x + u] == false) {
                check[x + u] = true;
                q.add(x + u);
                building[x + u] = building[x] + 1;
            }
            if (x - d > 0 && check[x - d] == false) {
                check[x - d] = true;
                q.add(x - d);
                building[x - d] = building[x] + 1;
            }
        }
        if (check[g]) {
            System.out.println(building[g]);
        } else {
            System.out.println("use the stairs");
        }
    }

}
