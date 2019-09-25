package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class STUnitas_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] inputData = br.readLine().split(" ");

            int a = Integer.parseInt(inputData[0]);
            int b = Integer.parseInt(inputData[1]);

            HashSet<Integer> hash = new HashSet<>();
            ArrayList<Integer> arr = new ArrayList<>();

            int start = a;
            while (!hash.contains(start)) {
                hash.add(start);
                arr.add(start);
                start = (start * a) % 10;

            }

            int size = arr.size();

            int sub = b % size;

            int answer = 0;
            if (sub == 0) {
                answer = arr.get(size-1);
            } else {
                answer = arr.get(size-2);
            }

            System.out.println(answer);
        }
    }
}
