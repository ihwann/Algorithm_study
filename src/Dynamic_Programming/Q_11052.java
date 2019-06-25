package Dynamic_Programming;

import java.util.Scanner;

public class Q_11052 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 민규가 구매하려는 카드의 갯수

        int[] card_price = new int[n + 1];
        int[] max_price = new int[n + 1];

        //max_price[1] = card_price[1];

        for (int i = 1; i <= n; i++) {
            card_price[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                max_price[i] = Math.max(max_price[i], card_price[j] + max_price[i - j]);
            }
        }

        System.out.println(max_price[n]);
    }
}
