package Dynamic_Programming;

import java.util.Scanner;

public class Q_4811 {

    static long[][] d = new long[31][31];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0)
                break;
            System.out.println(calc(n, 0));
        }
        sc.close();
    }

    // d[f][h] 약통에 한 조각 짜리 f개 반 조각 짜리 h개 있을 떄 약을 먹는 방법의 수
    // 한 조각만 먹는 경우, 반 조각만 먹는 경우 고민
    public static long calc(int f, int h) { // f : 알약 한 조각 h : 한약 반 조각
        if (d[f][h] != 0)
            return d[f][h];
        if (h == 0)
            return d[f][h] = calc(f - 1, h + 1);
        if (f == 0)
            return 1;

        return d[f][h] = calc(f - 1, h + 1) + calc(f, h - 1);
    }

}
