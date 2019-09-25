package CodingTest;

public class Naver_1 {
    public static void main(String[] args) {
        String[] emails = {"e@x.con", "abc", "abc@defx", "abc@defx.org"};

        System.out.println(solution(emails));
    }

    private static int solution(String[] emails) {
        int answer = 0;
        String rep = "^[a-z.]+@[a-z]+\\.(com|net|org)$";
        for(String email : emails){
            boolean check = email.matches(rep);
            if(check){
                answer++;
            }
        }

        return answer;
    }
}
