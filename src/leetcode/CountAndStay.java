package leetcode;

public class CountAndStay {

    public static void main(String[] args) {
        System.out.println(countAndSay(3));
        //System.out.println(runLengthEncoding("1"));
    }

    public static String countAndSay(int n) {

        String answer = "1";
        if (n == 1) {
            return answer;
        }

        for (int i = 1; i < n; i++) {
            answer = runLengthEncoding(answer);
        }

        return answer;
    }


    public static String runLengthEncoding(String str) {
        StringBuilder encoding = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            int repeatCount = 1;
            int curNum = Character.getNumericValue(str.charAt(i));

            while (i + 1 < str.length() && curNum == Character.getNumericValue(str.charAt(i + 1))) {
                repeatCount += 1;
                i++;
            }

            encoding.append(repeatCount).append(curNum);
        }

        return encoding.toString();
    }


}
