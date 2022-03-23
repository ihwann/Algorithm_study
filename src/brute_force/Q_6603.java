package brute_force;

import java.util.ArrayList;
import java.util.Scanner;

//문제 실패 다시 풀어보기
public class Q_6603 {
    static ArrayList<Integer> lotto = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int k = sc.nextInt();
            if (k == 0)
                break;
            int[] S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = sc.nextInt();
            }
            // Arrays.sort(S);
            go(S, 0, 0);
            System.out.println();
        }
    }

    public static void go(int[] a, int index, int cnt) {
        if (cnt == 6) {
            for (int num : lotto) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        int n = a.length;
        if (index == n)
            return;

        lotto.add(a[index]);
        go(a, index + 1, cnt + 1);
        lotto.remove(lotto.size() - 1);
        go(a, index + 1, cnt + 1);
    }
}
