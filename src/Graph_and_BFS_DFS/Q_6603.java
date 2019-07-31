package Graph_and_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q_6603 {
    static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            if (n == 0) break;
            int[] lotto = new int[n];

            for (int i = 0; i < lotto.length; i++) {
                lotto[i] = Integer.parseInt(input[i + 1]);
            }

            dfs(lotto, 0, 0);
            System.out.println();
        }
    }

    private static void dfs(int[] lotto, int index, int select) {
        int len = lotto.length;
        if (select == 6) {
            for (int item : ans) {
                System.out.print(item + " ");
            }
            System.out.println();
            return;
        }
        if (index >= len) return;

        // 해당 번호 선택
        ans.add(lotto[index]);
        dfs(lotto, index + 1, select + 1);
        // 해당 번호 선택하지 않음
        ans.remove(ans.size() - 1);
        dfs(lotto, index + 1, select);
    }
}
