package CodingTest;

import java.util.Arrays;

/**
 * 스트링 s가 주어집니다. 스트링 s는 알파벳 소문자('a'~'z')와 대문자('A'~'Z')로만 이루어져 있습니다. 우리는 스트링 s에서 가장 많이 쓰인 알파벳을 찾아 해당 알파벳을 return 하는 solution 함수를 구현하려고 합니다. 이때, 소문자와 대문자는 같다고 판단합니다. 또한, 가장 많이 쓰인 알파벳을 반환할 때는 소문자로 반환하고, 가장 많이 쓰인 알파벳이 2개 이상이면 알파벳 순서대로 스트링을 이루어 반환합니다.
 * <p>
 * 예를 들어,
 * <p>
 * 스트링 s가 "aAb" 일때 : a가 1개, A가 1개, b가 1개로 이루어져 있고, 소문자와 대문자를 같다고 판단하기 때문에 a가 2개, b가 1개로 이루어져 있다고 판단할 수 있습니다. 또한, 알파벳을 반환할 때는 소문자로 반환하기 때문에 "a"를 return 합니다.
 * <p>
 * 스트링 s가 "BA" 일때 : B가 1개, A가 1개로 이루어져 있습니다. 또한, 알파벳을 반환할 때는 소문자로 반환하고, 가장 많이 쓰인 알파벳이 2개 이상이면 알파벳 순서대로 스트링을 이루어 반환하기 때문에 "ab"를 return 합니다.
 * <p>
 * 스트링 s가 "BbA" 일때 : B가 1개, b가 1개, A가 1개로 이루어져 있고, 소문자와 대문자를 같다고 판단하기 때문에 a가 1개, b가 2개로 이루어져 있다고 판단할 수 있습니다. 위 규칙에 따라서, "b"를 return 하면 됩니다.
 * <p>
 * 문자열이 매개변수 s로 주어졌을 때, 가장 많이 쓰인 알파벳을 찾아 해당 알파벳을 return 하는 solution 함수를 구현해 보세요. 알파벳을 반환할 때는 string형으로 반환해 주세요.
 * <p>
 * 제한사항
 * 스트링 s는 알파벳 소문자('a'~'z')와 대문자('A'~'Z')로만 이루어져 있습니다.
 * 스트링 s의 길이 : 1,000,000 이하의 자연수
 */
public class Trenbe01 {
    public static void main(String[] args) {

        String s = "ab";
        //String s = "abA";
        String[] strArr = s.split("");

        int maxNum = Integer.MIN_VALUE;
        int[] charCnt = new int[123];
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i)).toLowerCase();
            charCnt[str.charAt(0)] += 1;

            maxNum = Math.max(maxNum, charCnt[str.charAt(0)]);
        }

        int finalMaxNum = maxNum;

        StringBuffer ans = new StringBuffer();

        for (int i = 0; i < charCnt.length; i++) {
            if (charCnt[i] == finalMaxNum) ans.append(new Character((char) i));
        }

        System.out.println("ans = " + ans);
    }
}
