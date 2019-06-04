package Graph_and_BFS_DFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_1525 {
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int n = 3;
        int start = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int temp = sc.nextInt();
                if (temp == 0)
                    temp = 9;
                start = (start * 10) + temp;
            }
        }
        sc.close();
        Queue<Integer> q = new LinkedList<Integer>();
        HashMap<Integer, Integer> d = new HashMap<Integer, Integer>();

        q.add(start);
        d.put(start, 0);
        while (!q.isEmpty()) {
            int now_num = q.remove();
            String now_str = Integer.toString(now_num);
            int z = now_str.indexOf("9");
            int x = z / 3;
            int y = z % 3;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    StringBuilder next_str = new StringBuilder(now_str);
                    char temp = next_str.charAt(x * 3 + y);
                    next_str.setCharAt(x * 3 + y, next_str.charAt(nx * 3 + ny));
                    next_str.setCharAt(nx * 3 + ny, temp);
                    int next_num = Integer.parseInt(next_str.toString());
                    if (!d.containsKey(next_num)) {
                        q.add(next_num);
                        d.put(next_num, d.get(now_num) + 1);
                    }
                }
            }
        }
        if (d.containsKey(123456789)) {
            System.out.println(d.get(123456789));
        } else {
            System.out.println("-1");
        }

    }

}
