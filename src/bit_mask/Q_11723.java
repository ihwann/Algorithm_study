package bit_mask;

import java.util.Scanner;

public class Q_11723 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();
        int S = 0;
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            String command = sc.next();
            if (command.equals("add")) {
                int x = sc.nextInt();
                S = (S | 1 << x);
            } else if (command.equals("remove")) {
                int x = sc.nextInt();
                S = (S & ~(1 << x));
            } else if (command.equals("check")) {
                int x = sc.nextInt();
                if ((S & 1 << x) > 0) {
                    answer.append("1\n");
                } else
                    answer.append("0\n");
            } else if (command.equals("toggle")) {
                int x = sc.nextInt();
                S = (S ^ 1 << x);
            } else if (command.equals("all")) {
                S = (1 << 21) - 1;
            } else
                S = 0;
        }
        sc.close();
        System.out.print(answer);
    }

}
