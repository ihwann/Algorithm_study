package CodingTest;

public class estSecurity_2 {

    public static void main(String[] args) {
        int u = 2;
        int l = 2;
        int[] c = {2, 0, 2, 0};

        System.out.println(solution(u, l, c));
    }

    private static String solution(int u, int l, int[] c) {
        String answer = "";

        int[][] board = new int[2][c.length];

        int maxIndex = c.length * 2;
        StringBuilder sb = new StringBuilder();
        dfs(board, u, l, c, 1, maxIndex, sb);

        if (sb.length() == 0) {
            answer = "IMPOSSIBLE";
        } else {
            answer = sb.substring(0, c.length * 2 + 1);
        }
        return answer;
    }

    private static void dfs(int[][] board, int u, int l, int[] c, int cnt, int maxIndex, StringBuilder sb) {

        if (cnt == maxIndex) {
            int sumUpper = 0;
            int sumLower = 0;
            for (int i = 0; i < c.length; i++) {
                if (c[i] != board[0][i] + board[1][i]) return;
                sumUpper += board[0][i];
                sumLower += board[1][i];
            }
            if (sumUpper == u && sumLower == l) {

                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < c.length; j++) {
                        sb.append(board[i][j]);
                    }
                    sb.append(",");
                }
                return;
            } else {
                return;
            }
        }

        if (cnt % 2 == 0) {
            board[1][(cnt / 2) - 1] = 0;
            dfs(board, u, l, c, cnt + 1, maxIndex, sb);
            board[1][(cnt / 2) - 1] = 1;
            dfs(board, u, l, c, cnt + 1, maxIndex, sb);
        } else {
            board[0][cnt / 2] = 0;
            dfs(board, u, l, c, cnt + 1, maxIndex, sb);
            board[0][cnt / 2] = 1;
            dfs(board, u, l, c, cnt + 1, maxIndex, sb);
        }
    }
}
