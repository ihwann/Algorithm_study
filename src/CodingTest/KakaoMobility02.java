package CodingTest;

import java.util.HashSet;
import java.util.Set;

public class KakaoMobility02 {
    public static void main(String[] args) {

        int[] t = {0,0,0,0,0,0,0,1};
        int[] a = {7};

        int answer = 0;
        Set<Integer> skillSet = new HashSet<>();
        skillSet.add(0);


        for (int skillNum : a) {
            int precedingSkill = t[skillNum]; // 선행스킬
            int currentSkill = skillNum; // 현재 배우고자 하는 스킬

            if(!skillSet.contains(precedingSkill)) {
                skillSet.add(precedingSkill);
                skillSet.add(currentSkill);
            } else {
                skillSet.add(currentSkill);
            }
        }

        System.out.println(skillSet.size());
    }
}
