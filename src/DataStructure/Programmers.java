package DataStructure;

public class Programmers {
    public static void main(String[] args) {

        String[] phone_book = {"123", "456", "789"};

        System.out.println(Solution(phone_book));

    }

    private static boolean Solution(String[] phone_book) {

        boolean answer = true;
        int cnt = 0;

        for (String item : phone_book) {
            for(String item2 : phone_book){

                if(item.equalsIgnoreCase(item2)) continue;

                if(item.startsWith(item2)){
                    cnt++;
                }

                if(cnt >= 1){
                    return false;
                }
            }
        }

        return answer;
    }
}
