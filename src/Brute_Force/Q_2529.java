package Brute_Force;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q_2529 {
    static int k; // 부등호 입력 갯수
    static String[] a; // 부등호 문자열
    static ArrayList<String> answer = new ArrayList<String>();
    static boolean[] check = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        a = new String[k];
        sc.nextLine();

        a = sc.nextLine().split(" ");
        sc.close();

        solve(0, "");

        Collections.sort(answer);
        System.out.println(answer.get(answer.size() - 1));
        System.out.println(answer.get(0));

    }

    private static void solve(int idx, String str) {

        if (idx == k + 1) {
            answer.add(str);
            return;
        } else {
            for (int i = 0; i <= 9; i++) {
                if (!check[i]) {
                    if (idx == 0 || chk_compare(str.charAt(idx - 1), (char) (i + '0'), a[idx - 1])) {
                        check[i] = true;
                        solve(idx + 1, str + i);
                        check[i] = false;
                    }
                }
            }
        }

    }

    private static boolean chk_compare(char pre_idx, char cur_idx, String compare) {

        if (compare.equals("<")) {
            if (pre_idx >= cur_idx)
                return false;
        } else {
            if (pre_idx <= cur_idx)
                return false;
        }
        return true;
    }
}
