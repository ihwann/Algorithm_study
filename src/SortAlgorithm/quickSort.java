package SortAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class quickSort {
    static long startTime;
    static long endTime;

    public static void main(String[] args) {


        Integer[] data = {66, 10, -1, 21, 5, 9, 93, 4, 11, -32, 57, 52, 89, -12, 0};


        List<Integer> unsortedData = Arrays.asList(data);

        startTime = System.currentTimeMillis();
        System.out.println(runQuickSort(unsortedData).toString());
        endTime = System.currentTimeMillis();

        System.out.println("실행시간 " + (endTime - startTime) / 1000.0 + " 초");
    }

    private static List<Integer> runQuickSort(List<Integer> data) {
        if (data.size() < 2) return data;

        Integer pivot = data.get(0);
        List<Integer> lower = new ArrayList<>();
        List<Integer> higer = new ArrayList<>();

        for (int i = 1; i < data.size(); i++) {
            if (pivot < data.get(i)) {
                higer.add(data.get(i));
            } else {
                lower.add(data.get(i));
            }
        }

        List<Integer> sorted = runQuickSort(lower);
        sorted.add(pivot);
        sorted.addAll(runQuickSort(higer));

        return sorted;
    }
}
