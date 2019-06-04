package Brute_Force;

import java.util.Scanner;

public class Q_14889_1 {

    static int n; // 인원 수
    static int answer = Integer.MAX_VALUE;
    static boolean[] visit; // dfs 위한 방문 체크
    static int[][] s; // 팀원들 능력치

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 인원 수

        s = new int[n][n]; // 팀원들 능력치
        visit = new boolean[n]; // dfs 위한 방문 체크

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = sc.nextInt();
            }
        }
        sc.close();

        dfs(0, 0); // 팀원을 나누는 경우의 수를 구하기 위한 dfs 탐색

        System.out.println(answer);
    }

    private static void dfs(int i, int j) { // i : 인덱스 j: 탐색 깊이

        if (j == n / 2) { // 탐색 깊이가 인원의 반만큼 왔다면 팀을 나눔
            divideTeam();
        } else {
            for (int k = i; k < n; k++) {
                if (!visit[k]) {
                    visit[k] = true;
                    dfs(k, j + 1);
                    visit[k] = false; // 반드시 방문을 했다면 다시 초기화
                }
            }
        }
    }

    private static void divideTeam() {

        int[] start_Team = new int[n / 2];
        int[] link_Team = new int[n / 2];

        int start_idx = 0;
        int link_idx = 0;

        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                start_Team[start_idx++] = i;
            } else {
                link_Team[link_idx++] = i;
            }
        }


        int startTeam_Score = getScore(start_Team);
        int linkTeam_Score = getScore(link_Team);

        int diff_score = Math.abs(startTeam_Score - linkTeam_Score);

        System.out.println("startTeam_Score : " + startTeam_Score);
        System.out.println("linkTeam_Score : " + linkTeam_Score);

        if (answer > diff_score) {
            answer = diff_score;
        }
    }

    private static int getScore(int[] team) {
        int result = 0;

        for (int i = 0; i < team.length - 1; i++) {
            for (int j = i + 1; j < team.length; j++) { // j 도 0 부터 시작하면 중복 계산이 됨
                result += s[team[i]][team[j]] + s[team[j]][team[i]];
            }
        }
        return result;
    }

}
