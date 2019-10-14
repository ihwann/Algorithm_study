package CodingTest;

public class Danal_5 {
    static int answer = -1;
    static int[][] grid = {{2, 1, 1, 0, 1}, {1, 2, 0, 3, 0}, {0, 1, 5, 1, 2}, {0, 0, 1, 3, 1}, {1, 2, 0, 1, 1}};

    public static void main(String[] args) {
        int K = 2;
        System.out.println(solution(grid, K));
    }

    private static int solution(int[][] grid, int k) {

        int n = grid.length;
        boolean[][] visit = new boolean[n][n];
        dfs(grid, 0, 0, k, visit, 0, 0);

        return answer;
    }

    private static void dfs(int[][] grid, int i, int j, int k, boolean[][] visit, int cnt, int sum) {
        if (cnt >= 2) {
            answer = Math.max(answer, sum);
        } else {
            for (int x1 = i; x1 < grid.length - k + 1; x1++) {
                for (int y1 = j; y1 < grid.length - k + 1; y1++) {
                    if (visit[x1][y1]) continue;
                    int temp = 0;
                    for (int a = 0; a < k; a++) {
                        for (int b = 0; b < k; b++) {
                            if (x1 + a >= grid.length || y1 + b >= grid.length) return;
                            if (visit[x1 + a][y1 + b]) return;
                            temp += grid[x1 + a][y1 + b];
                            visit[x1 + a][y1 + b] = true;
                        }
                    }

                    dfs(grid, x1, y1, k, visit, cnt + 1, sum + temp);

                    for (int a = 0; a < k; a++) {
                        for (int b = 0; b < k; b++) {
                            visit[x1 + a][y1 + b] = false;
                        }
                    }
                }
            }
        }
    }
}
