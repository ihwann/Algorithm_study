package brute_force;

import java.util.ArrayList;
import java.util.Scanner;

public class Q_16198 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 구슬의 갯수
        ArrayList<Integer> energy_bead = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            energy_bead.add(sc.nextInt());
        }

        System.out.println(solve(energy_bead));
    }

    private static int solve(ArrayList<Integer> energy_bead) {
        int len = energy_bead.size();

        // 첫 번째와 마지막 구슬을 선택할 수 없다.(정답에 영향 x)
        if (len == 2) {
            return 0;
        }
        int answer = -1;
        for (int i = 1; i < energy_bead.size() - 1; i++) {
            int sumOfEnergy = energy_bead.get(i - 1) * energy_bead.get(i + 1);
            ArrayList<Integer> next_energy_bead = new ArrayList<>(energy_bead);
            next_energy_bead.remove(i);
            sumOfEnergy += solve(next_energy_bead);
            if (answer < sumOfEnergy) {
                answer = sumOfEnergy;
            }
        }
        return answer;
    }
}
