package SortAlgorithm;

public class bubbleSort {
    static long startTime;
    static long endTime;

    public static void main(String[] args) {

        startTime = System.currentTimeMillis();
        int[] data = {66, 10, -1, 21, 5, 9, 93, 4, 11, -32, 57, 52, 89, -12, 0};

        runBubbleSort(data);
        System.out.println("실행시간 " + (endTime - startTime) / 1000.0 + " 초");

    }

    private static void runBubbleSort(int[] data) {

        boolean numberSwited;

        do {
            numberSwited = false;
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i + 1] < data[i]) {
                    int temp = data[i + 1];
                    data[i + 1] = data[i];
                    data[i] = temp;
                    numberSwited = true;
                }
            }
        } while (numberSwited);

        for (int item : data) {
            System.out.print(item + " ");
        }
        System.out.println();
        endTime = System.currentTimeMillis();
    }
}
