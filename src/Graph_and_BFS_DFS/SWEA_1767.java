package Graph_and_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class CorePoint {
    int x;
    int y;

    CorePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class SWEA_1767 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] coreMap;
    static ArrayList<CorePoint> coreList;
    static int ans, temp_countOfCore, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        int testCase = 1;

        while (tc-- > 0) {

            n = Integer.parseInt(br.readLine());

            coreMap = new int[n][n];
            coreList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    coreMap[i][j] = Integer.parseInt(st.nextToken());
                    if (coreMap[i][j] == 1) {
                        if (i - 1 < 0 || i + 1 >= n || j - 1 < 0 || j + 1 >= n) continue;
                        coreList.add(new CorePoint(i, j)); // 벽에 붙지 않은 코어만 저장
                    }
                }
            }

            ans = Integer.MAX_VALUE;
            temp_countOfCore = Integer.MIN_VALUE;

            StringBuilder output = new StringBuilder();

            dfs(0, 0, 0);

            output.append("#").append(testCase).append(" ").append(ans);

            System.out.println(output);
            testCase++;
        }
    }

    private static void dfs(int index, int countOfCore, int lenOfWire) {
        /*
        index : 탐색 인덱스
        countOfCore : 코어의 갯수
        len : 전선의 길이
         */

        // 모든 탐색을 마쳤다면 종료
        if (index == coreList.size()) {

            // 코어의 갯수가 더 많아져서 갱신
            if (temp_countOfCore < countOfCore) {
                temp_countOfCore = countOfCore;
                ans = lenOfWire;

                // 코어의 갯수가 같아진다면 전선의 최소 길이 저장
            } else if (temp_countOfCore == countOfCore) {
                ans = Math.min(ans, lenOfWire);
            }
            return;
        }

        // 현재 코어 좌표
        int x = coreList.get(index).x;
        int y = coreList.get(index).y;

        // 4 방향 진행
        for (int dir = 0; dir < 4; dir++) {

            int temp_lenOfWire = 0;
            int nx = x;
            int ny = y;
            int originX = x;
            int originY = y;

            while (true) {

                nx += dx[dir];
                ny += dy[dir];

                // 코어를 벗어나 거나 전선 혹은 코어를 만난다면 while문 탈출
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) break;
                if (coreMap[nx][ny] == 1) {
                    temp_lenOfWire = 0;
                    break;
                }
                temp_lenOfWire += 1;
            }

            // 연결가능한 전선이 있다면 전선 경로를 1로
            if (temp_lenOfWire != 0) {
                for (int i = 0; i < temp_lenOfWire; i++) {
                    originX += dx[dir];
                    originY += dy[dir];
                    coreMap[originX][originY] = 1;
                }
            }

            //연결할 수 있는 전선이 없다면 다음 탐색
            if (temp_lenOfWire == 0) {
                dfs(index + 1, countOfCore, lenOfWire);

                //연결할 수 있는 전선이 있다면 다음 탐색(백트래킹 + 전선을 원래상태로)
            } else {
                dfs(index + 1, countOfCore + 1, lenOfWire + temp_lenOfWire);
                originX = x;
                originY = y;

                for (int i = 0; i < temp_lenOfWire; i++) {
                    originX += dx[dir];
                    originY += dy[dir];
                    coreMap[originX][originY] = 0;
                }
            }
        }
    }
}
