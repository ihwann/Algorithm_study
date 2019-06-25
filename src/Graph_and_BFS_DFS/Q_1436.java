package Graph_and_BFS_DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q_1436 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        while(n>0){
            ans++;
            if(String.valueOf(ans).contains("666")){
                n--;
            }
        }
        System.out.println(ans);
    }
}
