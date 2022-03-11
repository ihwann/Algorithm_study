package CodingTest;

/**
 * 히스토그램은 N개의 직사각형 모양의 막대가 아래 그림과 같이 붙어있는 그래프입니다. 아래 그림은 N = 6인 경우의 예시입니다.
 * 히스토그램의 각 칸의 간격은 1이며 높이는 정수로 주어집니다.
 *
 * 히스토그램의 영역이란 히스토그램의 막대 중 두 개를 선택한 후 두 막대 사이에 물을 채웠을 때 물이 최대로 차오를 수 있는 영역의 넓이를 말합니다.
 * 다음 그림은 두 개의 막대를 선택했을 때 두 막대 사이에 물을 최대로 채운 예시를 나타냅니다.
 *
 * 즉, 위와 같은 방식으로 두 개의 막대를 선택했을 때 물이 최대로 차오를 수 있는 영역의 넓이는 12입니다.
 *
 * 히스토그램의 높이가 배열 형태로 주어질 때 만들 수 있는 히스토그램의 영역중 최댓값을 반환하는 함수를 완성해 주세요.
 */
public class Zoom03 {
    public static void main(String[] args) {
        int[] histogram = {2, 2, 2, 3};

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < histogram.length - 2; i++) {
            for (int j = i + 2; i < histogram.length; i++) {
                int width = j - i;
                int height = Math.min(histogram[i], histogram[j]);
                answer = Math.max(answer, width * height);
            }
        }

        System.out.println("answer = " + answer);
    }
}
