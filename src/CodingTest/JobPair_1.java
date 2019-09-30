package CodingTest;
/*


미해결


 */
public class JobPair_1 {
    static int answer = 0;

    public static void main(String[] args) {
        int[] goods = {3, 8, 6};
        int[] boxes = {5, 6, 4};

        System.out.println(solution(goods, boxes));
    }

    private static int solution(int[] goods, int[] boxes) {

        boolean[] inbox = new boolean[boxes.length]; // 박스가 사용 되었는지 확인
        dfs(goods, boxes, inbox, 0, 0);

        return answer;
    }

    private static void dfs(int[] goods, int[] boxes, boolean[] inbox, int cnt, int select) {

        /*
        cnt : 박스에 담긴 상품 갯수
        select : 탐색 깊이(상품의 갯수)
         */

        if (select == goods.length) {
            answer = Math.max(answer, cnt);
            return;
        }

        for (int i = 0; i < goods.length; i++) {
            for (int j = 0; j < boxes.length; j++) {
                if (inbox[j] == false && goods[i] <= boxes[j]) {
                    inbox[j] = true; // 박스를 사용중으로
                    dfs(goods, boxes, inbox, cnt + 1, select + 1);
                    inbox[j] = false; // 박스를 다시 사용하지 않는 것으로
                }else{
                    dfs(goods, boxes, inbox, cnt , select + 1);
                }
            }
        }
    }
}
