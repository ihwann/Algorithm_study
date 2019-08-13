package SortAlgorithm;

import org.junit.Test;

import java.util.List;

public class BinarySearch {
    public boolean binarySearch(List<Integer> inputData, Integer value) {

        if (inputData.size() == 0) {
            return false;
        }

        int comparison = inputData.get(inputData.size() / 2);
        if (comparison == value) {
            return true;
        }

        if (value > comparison) {
            return binarySearch(inputData.subList(inputData.size() / 2, inputData.size()), value);
        } else {
            return binarySearch(inputData.subList(0, inputData.size() / 2), value);
        }
    }
}
