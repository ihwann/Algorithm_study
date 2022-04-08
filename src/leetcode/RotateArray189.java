package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class RotateArray189 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        int len = nums.length;
        int rotateCnt = len % k;

        Queue<Integer> q = Arrays.stream(nums).boxed().collect(Collectors.toCollection(LinkedList::new));

        for (int i = 0; i < rotateCnt; i++) {
            q.add(q.poll());
        }

        int[] answer = q.stream().mapToInt(x->x).toArray();

    }
}
