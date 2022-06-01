package basballRe.baseball.utils;

import java.util.List;
import java.util.regex.Pattern;

public final class Validation {
    private static final Pattern PATTERN = Pattern.compile("[1-9]{3}");
    private static boolean isMatches(String next) {
        return PATTERN.matcher(next).matches();
    }
    public static void hasThreeNumber(String next) {

        if (!isMatches(next)) {
            throw new IllegalArgumentException("서로 다른 3자리 숫자만 입력 해주세요");
        }
    }
    public static void hasThreeBalls(List<Integer> list) {
        if (list.size() != 3) {
            throw new IllegalStateException("생성된 볼 사이즈는 " + list.size() + " 입니다.");
        }
    }

    public static void isDifferentNumbers(String []  numbers) {

        if (isSameNumber(numbers[0], numbers[1]) || isSameNumber(numbers[0],numbers[2]) || isSameNumber(numbers[1],numbers[2])) {
            throw new IllegalArgumentException("서로 다른 수를 입력해주세요");
        }
    }

    private static boolean isSameNumber(String number1, String number2) {
        return number1.equals(number2);
    }

    public static void validateAnswer(int answer) {

        if (answer != 1 && answer != 2) {
            throw new IllegalArgumentException("0 또는 1만 입력 해 주세요");
        }
    }
}
