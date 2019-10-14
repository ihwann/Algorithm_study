package CodingTest;

import java.util.LinkedList;
import java.util.List;

/*
 * 안녕하세요!
 * 힐링페이퍼의 코딩테스트입니다.
 * 각 문제별 제한 시간은 20분 입니다.
 * 기본 언어는 Java 로 되어있지만, 본인이 편한 언어로 바꿔서 푸셔도 괜찮습니다.
 *
 * 1. string to integer
 *
 * string 으로 존재하는 정수를 integer 로 변환하는 함수를 작성해주세요.
 * 이 문제의 의도는 string 을 iteration 하면서 경계조건, 예외 케이스 등을 잘 처리할 수 있는지에 있습니다.
 * 즉, 다른 함수들을 이용해 Integer.parseInt/1 같은 함수를 직접 만든다고 생각하시면 됩니다.
 *
 * 단계
 *
 * 1) string 의 내용이 양의 정수인 경우 integer 로 변환합니다.
 * input -> string: "123"
 * output -> integer: 123
 *
 * 2) string 의 내용이 정수가 아닌 경우는 null 을 반환해야 합니다.
 * input -> string: "123.456"
 * output -> null
 *
 * 3) string 의 내용이 음의 정수인 경우도 변환이 가능해야합니다.
 * input -> string: "-123"
 * output -> integer: -123
 *
 *
 * 2. list rotation
 *
 * list 와 count 를 받아 count 만큼 list 를 rotation 하는 함수를 구현해주세요.
 * 이 문제의 의도는 enumerable 을 잘 다룰 수 있는가, 조건을 단순화할 수 있는가에 있습니다.
 *
 * 단계
 *
 * 1) list 의 크기보다 작은 count 를 받아 rotation 을 합니다.
 * input -> list: [1, 2, 3, 4, 5], count: 2
 * output -> list: [3, 4, 5, 1, 2]
 *
 * 2) list 의 크기보다 큰 count 를 받아 rotation 을 합니다.
 * input -> list: [1, 2, 3, 4, 5], count: 8
 * output -> list: [4, 5, 1, 2, 3]
 *
 * 3) 0 보다 작은 count 를 받아 rotation 을 합니다.
 *
 * input -> list: [1, 2, 3, 4, 5], count: -1
 * output -> list: [5, 1, 2, 3, 4]
 *
 */
public class HealingPaper_1 {
    public static void main(String[] args) {
        System.out.println(stringTointeger());

        System.out.println(listRotation().toString());
    }

    private static Integer stringTointeger() {

        String input = "23332323";
        Integer output = null;
        String[] arr = input.split("");

        StringBuffer sb = new StringBuffer();
        for (String item : arr) {
            if (item.equals(".")) {
                sb.setLength(0);
                break;
            } else {
                sb.append(item);
            }
        }

        if (sb.length() != 0) {
            output = Integer.valueOf(sb.toString());
        }

        return output;
    }

    private static List<Integer> listRotation() {

        int[] arr = {1, 2, 3, 4, 5};
        int count = 89;

        List<Integer> list = new LinkedList<>();
        for (int item : arr) {
            list.add(item);
        }

        int index = count % list.size();

        if(index < 0){
            index += list.size();
        }
        int num = 0;
        for (int i = index; i < list.size(); i++) {
            list.add(num, list.get(i));
            list.remove(i + 1);
            num += 1;
        }
        return list;
    }
}
