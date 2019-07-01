package Brute_Force;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_1019 {
    static int[]num = new int[10] ;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 쪽 수
        solve(n);

        for(int i : num){
            System.out.print(i+" ");
        }
    }

    private static void solve(int n){

    }
}
