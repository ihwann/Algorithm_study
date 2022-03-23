package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_6064 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.valueOf(bf.readLine());
            while (t-- > 0) {
                String[] line = bf.readLine().split(" ");
                int m = Integer.valueOf(line[0]);
                int n = Integer.valueOf(line[1]);
                int x = Integer.valueOf(line[2]) - 1;
                int y = Integer.valueOf(line[3]) - 1;
                boolean ok = false;
                System.out.println("x: " + x);
                System.out.println("y: " + y);
                for (int k = x; k < (m * n); k += m) {
                    if ((k % n) == y) {
                        System.out.println(k + 1);
                        ok = true;
                        break;
                    }
                }
                if (!ok) {
                    System.out.println("-1");
                }

            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
