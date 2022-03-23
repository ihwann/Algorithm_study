package brute_force;

import java.util.ArrayList;
import java.util.Scanner;

public class Q_2529_dfs_backTracking {
    static int k;
    static boolean[] check = new boolean[10]; // 숫자 방문 체크
    static String compare[];
    static ArrayList<String> answer = new ArrayList<String>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        sc.nextLine();

        compare = new String[k];
        compare = sc.nextLine().split(" "); // 부등호 입력
        sc.close();

        for (int i = 0; i <= 9; i++) {
            check[i] = true;
            dfs(0, i, i + ""); // 첫번째 인자 : 인덱스 두번째 인자 비교값 세번째 인자 : 출력할 문자열
        }

        System.out.println(answer.get(answer.size() - 1));
        System.out.println(answer.get(0));
    }

    private static void dfs(int idx, int num, String str) { // num 현재 숫자

        if (idx == k) { // 인덱스가 문자열 끝에 도달한다면
            answer.add(str);
        } else {
            for (int i = 0; i <= 9; i++) {
                if (!check[i]) {
                    if (compare[idx].equals("<")) {
                        if (i <= num)
                            continue;
                    } else {
                        if (i >= num)
                            continue;
                    }
                    check[i] = true;
                    dfs(idx + 1, i, str + i);
                }
            }
        }
        check[num] = false;
    }
}
