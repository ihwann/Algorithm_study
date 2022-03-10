package CodingTest;

/**
 * 수평선 위에 점 여러 개가 놓여있습니다. 길이가 다양한 선분을 이용해 이 점들을 덮으려고 하는데, 선분을 최소 개수만큼 사용해야 합니다.
 * <p>
 * 예를 들어 점 위치가 [1, 5, 8]이고, 사용할 수 있는 선분 길이가 [1, 3, 4, 6]인 경우 다음과 같이 적어도 두 개의 선분을 사용해야 모든 점을 덮을 수 있습니다. (점의 위치와 선분의 끝이 일치하는 경우에는 점이 선분에 덮였다고 가정합니다.)
 * <p>
 * dots.png
 * <p>
 * 이 외에도 선분 두 개를 이용해 모든 점을 덮는 방법은 여러 가지가 있지만, 선분을 하나만 이용해 모든 점을 덮는 방법은 존재하지 않습니다. 따라서 적어도 선분 두 개를 이용해야 모든 점을 덮을 수 있습니다.
 * <p>
 * 점의 위치가 담긴 배열 dots, 선분들의 길이가 담긴 배열 lines가 매개변수로 주어질 때 모든 점을 선분으로 덮기 위해 사용해야 하는 선분 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요.
 * <p>
 * 제한사항
 * dots는 점의 위치가 담긴 배열로, 길이는 1 이상 20 이하입니다.
 * dots의 원소는 점의 위치를 나타내며, 1 이상 200 이하인 자연수입니다.
 * 서로 다른 두 점의 위치가 같은 경우는 주어지지 않습니다.
 * 점의 위치는 오름차순 정렬되어 주어집니다.
 * lines는 사용할 수 있는 선분들의 길이가 담긴 배열입니다.
 * lines의 길이(선분 개수)는 1 이상 10 이하입니다.
 * 선분 길이는 1 이상 100 이하인 자연수입니다.
 * 모든 점을 덮을 수 없는 경우에는 -1을 return 해주세요
 */


public class Trenbe03 {
    static int[] dots = {1, 3, 4, 6, 7, 10};

    static int endPoint = Integer.MIN_VALUE;
    static boolean[] useLine;
    static int answer = -1;

    public static void main(String[] args) {
        int[] lines = {2, 2, 2, 2};
        for (int i : dots) {
            endPoint = Math.max(endPoint, i);
        }

        for (int i = 0; i < lines.length; i++) {
            useLine = new boolean[lines.length];
            useLine[i] = true;
            dfs(lines, dots[0] + lines[i], 1);
        }

        System.out.println(answer);
    }

    private static void dfs(int[] lines, int startPoint, int useCount) {

        if (startPoint >= endPoint) {
            answer = useCount;
            return;
        }
        if (useCount > 4 && startPoint < endPoint) {
            answer = -1;
            return;
        }

        for (int i = 0; i < lines.length; i++) {
            if (useLine[i]) continue;
            useLine[i] = true;
            dfs(lines,startPoint + lines[i], useCount + 1);
        }
    }
}
