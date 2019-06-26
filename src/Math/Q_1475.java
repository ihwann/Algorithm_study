package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_1475 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberRoom = Integer.parseInt(br.readLine());
        int[] num = new int[10];
        int ans = 0;

        if(numberRoom == 0){
            System.out.println(1);
            return;
        }
        while (numberRoom > 0) {
            int chk = numberRoom % 10;

            // 나머지가 6 혹은 9 이면 한곳에 넣기
            if (chk == 6 || chk == 9) {
                num[6] += 1;
            } else {
                num[chk] = num[chk] + 1;
            }
            numberRoom /= 10;
        }

        // 방 번호가 669 인 경우 반례
        if (num[6] % 2 == 0) {
            num[6] /= 2;
        } else {
            num[6] = num[6] / 2 + 1;
        }

        for (int i = 0; i < num.length; i++) {
            if (ans < num[i]) {
                ans = num[i];
            }
        }
        System.out.println(ans);
    }
}
