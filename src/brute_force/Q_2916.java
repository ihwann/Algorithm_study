package brute_force;

import java.util.Scanner;

public class Q_2916 {
    static int angle[]; // 갖고 있는 각도
    static boolean check_angle[] = new boolean[360]; // 각도를 계산 할 수 있는지, 없는지

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 만들 수 있는 각의 수
        int k = sc.nextInt(); // 현우가 퀴즈로 외칠 각의 갯수

        angle = new int[n];
        for (int i = 0; i < n; i++) {
            angle[i] = sc.nextInt();
        }
        check_angle[0] = true;
        for (int i = 0; i < n; i++) {
            // 반복 횟수
            for (int cnt = 0; cnt < 360; cnt++) {
                // 만들수 있는 각도
                for (int cur_angle = 0; cur_angle < 360; cur_angle++) {
                    if (!check_angle[cur_angle]) continue;
                    check_angle[(cur_angle + angle[i]) % 360] = true;
                    check_angle[(cur_angle - angle[i] + 360) % 360] = true;
                }
            }
        }
        while (k-- > 0) {
            int quiz_angle = sc.nextInt();
            if (check_angle[quiz_angle]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
