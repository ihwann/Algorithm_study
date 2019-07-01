package Graph_and_BFS_DFS;

public class teseeee {
    public static void main(String[] args) {
        int brown = 10;
        int red = 2;
        Solution(brown, red);
    }

    private static void Solution(int brown, int red) {
        int[] answer = new int[2];
        // 가로는 세로보다 같거나 길다.
        int area = brown + red;
        int garo = 0;
        int sero = 0;

        // 세로 길이는 최소 3부터
        for (int i = 3; i <= Math.sqrt(area)+1; i++) {
            if (area % i == 0) {
                // 가로의 길이는 세로보다 작거나 같다.
                for (int j = 3; j <= i; j++) {
                    if(area % j ==0){
                        if ((j - 2) * (i - 2) == red) {
                            answer[0] = i;
                            answer[1] = j;
                            break;
                        }
                    }
                }
            }
        }
    }
}
