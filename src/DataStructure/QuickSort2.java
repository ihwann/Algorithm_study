package DataStructure;


public class QuickSort2 {

    static int cnt = 0;

    public static void main(String[] args) {

        int[] data = {66, 10, -1, 21, 5, 9, 93, 4, 11, -32, 57, 52, 89, -12, 0};

        runQiuckSort(data, 0, data.length - 1);

        System.out.println("결과");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    private static void runQiuckSort(int[] data, int left, int right) {

        if (left < right) {
            int pivotIndex = partition(data, left, right);

            runQiuckSort(data, left, pivotIndex - 1);
            runQiuckSort(data, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] data, int left, int right) {

        int pivot = data[(left + right) / 2];

        while (left < right) {
            while (data[left] < pivot && left < right) {
                left++;
            }
            while (data[right] > pivot && left < right) {
                right--;
            }

            if (left < right) {
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            }
        }

        return left;
    }
}
