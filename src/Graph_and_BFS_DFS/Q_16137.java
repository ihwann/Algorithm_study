package Graph_and_BFS_DFS;

import java.util.Scanner;

public class Q_16137 {

    static int [][]map;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        map = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }
    }
}
