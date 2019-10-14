package CodingTest;

public class Danal_2 {
    public static void main(String[] args) {
        int n = 5;

        System.out.println(solution(n));
    }

    private static long solution(int n) {
        int answer = 0;

        int sum = 0;
        int i = 0;

        while (sum < n) {
            sum += getlength(++i);
        }

        if(sum != n){
            sum -= getlength(i);
        }

        answer = getNum(i,n-sum);

        return answer;
    }

    private static int getNum(int num, int index) {
        if(index==0) return num % 10;
        int length = getlength(num);
        int temp = (int) (num/Math.pow(10,length-index));
        return temp%10;
    }

    private static int getlength(int i) {
        int length = 0;
        while(i>0){
            i/=10;
            length++;
        }
        return length;
    }
}
