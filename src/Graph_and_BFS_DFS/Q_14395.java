package Graph_and_BFS_DFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_14395 {

    final static long limit = 1000000000L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long s = sc.nextInt();
        long t = sc.nextInt();

        Queue<Long> q = new LinkedList<Long>(); // 계산된 숫자가 들어갈 큐
        Queue<String> str_q = new LinkedList<String>(); // 연산자가 들어갈 큐
        HashSet<Long> check_q = new HashSet<Long>();  // 연산된 숫자를 다시 했는지 검사(방문 체크와 비슷)

        q.add(s); // 초기 값
        str_q.add(""); // 아무런 연산을 하지 않았으므로
        check_q.add(s); // 초기 방문 값

        while (!q.isEmpty()) {
            long num = q.remove();
            String ans = str_q.remove();

            if (num == t) {
                // 초기 입력 값이 같다면
                if (ans.length() == 0) {
                    ans = "0";
                }
                System.out.println(ans);
                System.exit(0);
            }

            // * 연산 수행
            if (num * num >= 0 && num * num <= limit && !check_q.contains(num * num)) {
                q.add(num * num);
                str_q.add(ans+"*");
                check_q.add(num * num);
            }

            // + 연산 수행
            if (num + num >= 0 && num + num <= limit && !check_q.contains(num + num)) {
                q.add(num + num);
                str_q.add(ans+"+");
                check_q.add(num + num);
            }

            // - 연산 수행
            if (num - num >= 0 && num - num <= limit && !check_q.contains(num - num)) {
                q.add(num - num);
                str_q.add(ans+"-");
                check_q.add(num - num);
            }

            // / 연산 수행
            if (num != 0 && num / num >= 0 && num / num <= limit && !check_q.contains(num / num)) {
                q.add(num / num);
                str_q.add(ans+"/");
                check_q.add(num / num);
            }
        }
        System.out.println(-1);
    }
}
