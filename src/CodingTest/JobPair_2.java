package CodingTest;

import java.util.LinkedList;
import java.util.Queue;

class bishop {
    int x;
    int y;

    bishop(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class JobPair_2 {
    static boolean[][] map = new boolean[8][8];
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, 1, -1};

    public static void main(String[] args) {

        String[] bishops = {"D5", "E8", "G2"};

        System.out.println(solution(bishops));

    }

    private static int solution(String[] bishops) {
        int answer = 0;

        Queue<bishop> q = new LinkedList<>();
        for (String str : bishops) {
            int x = 0;
            int y = 0;
            String point = String.valueOf(str.charAt(0));
            switch (point) {
                case "A":
                    y = 0;
                    break;
                case "B":
                    y = 1;
                    break;
                case "C":
                    y = 2;
                    break;
                case "D":
                    y = 3;
                    break;
                case "E":
                    y = 4;
                    break;
                case "F":
                    y = 5;
                    break;
                case "G":
                    y = 6;
                    break;
                case "H":
                    y = 7;
                    break;
            }
            x = Character.getNumericValue(str.charAt(1));
            q.offer(new bishop(8 - x, y));
        }


        while (!q.isEmpty()) {
            bishop bishop = q.poll();
            int x = bishop.x;
            int y = bishop.y;

            map[x][y] = true;
            for (int dir = 0; dir < 4; dir++) {
                int nx = x;
                int ny = y;

                while (true) {
                    nx += dx[dir];
                    ny += dy[dir];
                    if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) break;
                    map[nx][ny] = true;
                }
            }
        }


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!map[i][j]) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}
