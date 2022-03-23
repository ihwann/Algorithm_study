package math;

import java.util.ArrayList;
/*
nPn 순열 구하기
 */
public class Permutation {
    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 3, 4};
        doPermutation(arr, 0);
    }

    private static void doPermutation(int[] arr, int startIdx) {
        int length = arr.length;
        if (startIdx == length - 1) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int n : arr){
                list.add(n);
            }
            System.out.println(list.toString());
            System.out.println();
            return;
        }

        for (int i = startIdx; i < length; i++) {
            swap(arr, startIdx, i);
            doPermutation(arr, startIdx + 1);
            swap(arr, startIdx, i);
        }
    }

    private static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }
}
