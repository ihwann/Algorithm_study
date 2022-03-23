package math;

import java.util.Scanner;

public class Q_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        boolean check[] = new boolean[N + 1];
        sc.close();
        check[0] = check[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (check[i] == true) {
                continue;
            }
            for (int j = i + i; j <= N; j += i) {
                check[j] = true;
            }
        }
        for (int i = M; i <= N; i++) {
            if (check[i] == false) {
                System.out.println(i);
            }
        }
    }

}
