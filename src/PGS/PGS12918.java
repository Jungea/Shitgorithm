package PGS;

import java.util.regex.Pattern;

public class PGS12918 {
    public static void main(String[] args) {
        System.out.println(solution1("1234"));
        System.out.println(solution("s123"));
    }

    private static boolean solution1(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    public static boolean solution(String s) {
//        return Pattern.matches("[0-9]{4}|[0-9]{6}", s);
        return s.matches("\\d{4}|\\d{6}");
    }


}
