package Programmers;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static void main(String[] args) {

        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int matchCnt = 0;
        int unknownNum = 0;

        // Set<Integer> lottoSet = Arrays.stream(lottos).boxed().collect(Collectors.toSet());
        Set<Integer> winNumSet = Arrays.stream(win_nums).boxed().collect(Collectors.toSet());

        for (Integer num : lottos) {
            if (num == 0) unknownNum++;
            if (winNumSet.contains(num)) matchCnt++;
        }

        int[] answer = new int[2];
        answer[0] = setRank(matchCnt + unknownNum);
        answer[1] = setRank(matchCnt);

        for (int i : answer) {
            System.out.println(i);
        }
    }

    private static int setRank(int matchCnt) {
        if (matchCnt >= 6) matchCnt = 6;
        switch (matchCnt) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
