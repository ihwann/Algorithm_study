package brute_force;

import java.util.ArrayList;
import java.util.Scanner;

public class Q_14889 {
    static int n;
    static int[][] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        sc.close();
        ArrayList<Integer> teamA = new ArrayList<Integer>();
        ArrayList<Integer> teamB = new ArrayList<Integer>();
        System.out.println(solve(0, teamA, teamB));
    }

    private static int solve(int index, ArrayList<Integer> teamA, ArrayList<Integer> teamB) {
        if (index == n) {
            if (teamA.size() != n / 2)
                return -1;
            if (teamB.size() != n / 2)
                return -1;

            int t1 = 0;
            int t2 = 0;
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    if (i == j)
                        continue;
                    t1 += a[teamA.get(i)][teamA.get(j)];
                    t2 += a[teamB.get(i)][teamB.get(j)];
                }
            }
            int diff = Math.abs(t1 - t2);
            return diff;
        }
        if (teamA.size() > n / 2)
            return -1;
        if (teamB.size() > n / 2)
            return -1;

        int ans = -1;
        teamA.add(index);
        int t1 = solve(index + 1, teamA, teamB);
        if (ans == -1 || (t1 != -1 && ans > t1)) {
            ans = t1;
        }
        teamA.remove(teamA.size() - 1);
        teamB.add(index);
        int t2 = solve(index + 1, teamA, teamB);
        if (ans == -1 || (t2 != -1 && ans > t2)) {
            ans = t2;
        }
        teamB.remove(teamB.size() - 1);
        return ans;
    }

}
