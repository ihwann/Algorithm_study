package DataStructure;

public class MergeSort {
    public static void main(String[] args) {
        /*
        데이터를 절반으로 나눔
        각각을 순환적으로 정렬
        정렬된 두 개의 배열을 합쳐 전체로 정렬
         */

        int[] data = {66, 10, -1, 21, 5, 9, 93, 4, 11, -32, 57, 52, 89, -12, 0};

        runPartition(data, 0, data.length - 1);


        for (int i : data) {
            System.out.print(i + ", ");
        }
    }

    private static void runPartition(int[] data, int startPoint, int endPoint) {

        if (startPoint < endPoint) {
            int pivot = (startPoint + endPoint) / 2;

            runPartition(data, startPoint, pivot);
            runPartition(data, pivot + 1, endPoint);

            runMerge(data, startPoint, endPoint, pivot);
        }
    }

    private static void runMerge(int[] data, int startPoint, int endPoint, int pivot) {

        int[] temp = new int[data.length];

        int tempIndex = startPoint;
        int leftIndex = startPoint;
        int rightIndex = pivot + 1;

        while (leftIndex <= pivot && rightIndex <= endPoint) {
            if (data[leftIndex] < data[rightIndex]) {
                temp[tempIndex++] = data[leftIndex++];
            } else {
                temp[tempIndex++] = data[rightIndex++];
            }
        }

        while (leftIndex <= pivot) {
            temp[tempIndex++] = data[leftIndex++];
        }
        while (rightIndex <= endPoint) {
            temp[tempIndex++] = data[rightIndex++];
        }

        for (int i = startPoint; i < tempIndex; i++) {
            data[i] = temp[i];
        }
    }
}
