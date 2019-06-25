package Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q_1181 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hashList = new HashSet<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            hashList.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<String>(hashList);

        Collections.sort(list, (o1, o2) -> {
            if(o1.length() < o2.length()){
                return -1;
            }else if(o1.length() > o2.length()){
                return 1;
            }else {
                return o1.compareTo(o2);
            }
        });

        for(String i : list){
            System.out.println(i);
        }

    }
}
