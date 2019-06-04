package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q_12869 {
    static final int[][] damage = {{1, 3, 9}, {1, 9, 3}, {3, 1, 9}, {3, 9, 1}, {9, 3, 1}, {9, 1, 3}};
    static int[] scv = new int[3];
    static boolean[][][] check = new boolean[61][61][61];

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            String[] hp = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                scv[i] = Integer.parseInt(hp[i]);
            }

            Queue<Integer> q = new LinkedList<Integer>();
            check[scv[0]][scv[1]][scv[2]] = true;
            q.add(scv[0]);
            q.add(scv[1]);
            q.add(scv[2]);
            q.add(0); // count

            while (!q.isEmpty()) {
                int hpA = q.poll();
                int hpB = q.poll();
                int hpC = q.poll();
                int count = q.poll();

                if (hpA == 0 && hpB == 0 && hpC == 0) {
                    System.out.println(count);
                    break;
                }

                for (int i = 0; i < 6; i++) {
                    int new_hpA = hpA - damage[i][0];
                    int new_hpB = hpB - damage[i][1];
                    int new_hpC = hpC - damage[i][2];

                    if (new_hpA < 0)
                        new_hpA = 0;
                    if (new_hpB < 0)
                        new_hpB = 0;
                    if (new_hpC < 0)
                        new_hpC = 0;

                    if (check[new_hpA][new_hpB][new_hpC] == false) {
                        check[new_hpA][new_hpB][new_hpC] = true;
                        q.add(new_hpA);
                        q.add(new_hpB);
                        q.add(new_hpC);
                        q.add(count + 1);
                    }
                }
            }

        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
