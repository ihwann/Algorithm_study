package Programmers;

public class SkillTree {
    public static void main(String[] args) {

        String skill = "CBDK";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        int answer = 0;
        for (String skill_tree : skill_trees) {
            for (int i = 0; i < skill_tree.length(); i++) {
                String s = String.valueOf(skill_tree.charAt(i));
                if (!skill.contains(s)) {
                    skill_tree = skill_tree.replace(s, " ");
                }
            }
            String s = skill_tree.replaceAll(" ", "");
            if(s.equals(skill.substring(0, s.length()))) answer+=1;
        }

        System.out.println("answer = " + answer);







        String a = "a-b";
        String s = a.replaceAll("-", "");
        System.out.println("a = " + s);
    }
}
