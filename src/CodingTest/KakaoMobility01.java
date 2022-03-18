package CodingTest;

import java.util.*;

class Name {
    String firstName;
    String middleName;
    String lastName;

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = setLastName(lastName);
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = setLastName(lastName);
    }

    private String setLastName(String lastName) {
        String modifyLastName = lastName;
        if (lastName.contains("-")) {
            modifyLastName = lastName.replaceAll("-", "");
        }
        return modifyLastName.length() > 8 ? modifyLastName.substring(0, 8) : modifyLastName;
    }


    @Override
    public String toString() {
        if (middleName != null) {
            return firstName + middleName + lastName;
        } else {
            return firstName + lastName;
        }
    }
}

public class KakaoMobility01 {
    private final String EMAIL_DOMAIN = "@example.com";
    private static Map<String, Integer> nameMap = new HashMap<>();

    public static void main(String[] args) {
        String c = "Example";
        String s = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";


        StringBuffer answer = new StringBuffer();
        String[] nameArr = s.split(",");
        for (String name : nameArr) {
            String[] splitName = name.trim().split(" ");
            String firstName = "";
            String middleName = "";
            String lastName = "";

            firstName = String.valueOf(splitName[0].toLowerCase().charAt(0));
            // middle name 없음

            String completeName = "";
            if (splitName.length == 2) {
                lastName = setLastName(splitName[1].toLowerCase());
                completeName = firstName + lastName;
                // middle name 있음
            } else if (splitName.length == 3) {
                middleName = String.valueOf(splitName[1].toLowerCase().charAt(0));
                lastName = setLastName(splitName[2].toLowerCase());
                completeName = firstName + middleName + lastName;
            }


            if (nameMap.containsKey(completeName)) {
                nameMap.put(completeName, nameMap.get(completeName) + 1);
            } else {
                nameMap.put(completeName, 1);
            }
            answer.append(name).append(emailMaker(completeName, s));
        }

        System.out.println(answer.deleteCharAt(answer.lastIndexOf(",")));
    }

    private static String setLastName(String lastName) {
        String modifyLastName = lastName;
        if (lastName.contains("-")) {
            modifyLastName = lastName.replaceAll("-", "");
        }
        return modifyLastName.length() > 8 ? modifyLastName.substring(0, 8) : modifyLastName;
    }

    private static String emailMaker(String id, String c) {
        if (nameMap.get(id) > 1) {
            return " <" + id + nameMap.get(id) + "@" + c.toLowerCase() + ".com" + ">,";
        } else {
            return " <" + id + "@" + c.toLowerCase() + ".com" + ">,";
        }
    }
}
