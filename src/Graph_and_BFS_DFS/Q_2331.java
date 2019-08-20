package Graph_and_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q_2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int p = Integer.parseInt(input[1]);

        HashMap<Integer, Integer> hash = new HashMap<>();

        solution(hash, a, p, 1);

        int ans = 0;
        for (int item : hash.keySet()) {
            if (hash.get(item) == 1) {
                ans += 1;
            }
        }

        System.out.println(ans);
    }

    private static void solution(HashMap<Integer, Integer> hash, int a, int p, int value) {
        if (!hash.containsKey(a)) {
            hash.put(a, value);
        } else {
            if (hash.get(a) == 3) {
                return;
            } else {
                hash.replace(a, hash.get(a) + 1);
            }
        }

        int sum = 0;
        while (a != 0) {
            sum += Math.pow((double) a % 10, p);
            a /= 10;
        }
        solution(hash, sum, p, 1);
    }
}
