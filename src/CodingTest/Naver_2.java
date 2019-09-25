package CodingTest;


public class Naver_2 {
    static int answer = 0;

    public static void main(String[] args) {
        String[] drum = {"######", ">#*###", "####*#", "#<#>>#", ">#*#*<", "######"};


        System.out.println(solution(drum));
    }

    private static int solution(String[] drum) {
        String[][] map = new String[drum.length][drum.length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = String.valueOf(drum[i].charAt(j));
            }
        }

        for (int i = 0; i < map.length; i++) {
            boolean check = false;
            dfs(map, 0, i, 0, check);
        }

        return answer;
    }

    private static void dfs(String[][] map, int x, int y, int dept, boolean check) {
        if (dept == map.length - 1) {
            answer += 1;
            return;
        }

        if (map[x][y].equals("#")) {
            dfs(map, x + 1, y, dept + 1, check);
        }
        if (map[x][y].equals(">")) {
            dfs(map, x, y + 1, dept, check);
        }
        if (map[x][y].equals("<")) {
            dfs(map, x, y - 1, dept, check);
        }
        if (map[x][y].equals("*")) {
            if (!check) {
                check = true;
                dfs(map, x + 1, y, dept + 1, check);
            } else {
                return;
            }
        }
    }
}
