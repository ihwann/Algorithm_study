package CodingTest;

public class Zoom01 {
    public static void main(String[] args) {

        long n  = 100000;
        int answer = 0;
        for(long i=n; i<n*n; i++){
            long mok = i/n;
            long mod = i%n;

            if(mok == mod) answer+=i;
        }

        System.out.println(answer);
    }
}
