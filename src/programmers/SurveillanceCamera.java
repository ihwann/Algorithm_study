package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class SurveillanceCamera {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }

    public static int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        int count = 1;
        int cameraPoint = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            if (cameraPoint >= routes[i][0]) {
                continue;
            }
            count++;
            cameraPoint = routes[i][1];
        }

        return count;
    }

}
