package Dynamic_Programming;

import java.util.Scanner;

public class Q_16194 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 구매할려는 카드 수
        int[] card_price = new int[n + 1];
        int[] min_price = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            card_price[i] = sc.nextInt();
            min_price[i] = Integer.MAX_VALUE;
        }

        min_price[1] = card_price[1];

        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= x; y++) {
                min_price[x] = Math.min(min_price[x], card_price[y] + min_price[x - y]);
            }
        }

        System.out.println(min_price[n]);
    }
}
