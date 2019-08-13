package Math;

import java.util.ArrayList;

/*
5C3 조합 구하기
 */
public class Combination {
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        int r = 3;
        int[] comArr = new int[r];

        doCombination(comArr, arr, 0, 0, n, r);
    }

    private static void doCombination(int[] comArr, int[] arr, int index, int target, int n, int r) {
        if (r == 0) {
            // 프린트
            for (int item : comArr) {
                System.out.print(item + " ");
            }
            System.out.println();
        } else if (target == n) { // r 개를 구하지 않았지만 배열 끝까지 검색 했을 경우 종료
            return;
        } else {
            comArr[index] = arr[target];
            doCombination(comArr, arr, index + 1, target + 1, n, r - 1);
            doCombination(comArr, arr, index, target + 1, n, r);
        }
    }
}
