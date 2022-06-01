package basballRe.baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

        if (numbers[0].equals(numbers[1]) || numbers[1].equals(numbers[2]) || numbers[0].equals(numbers[2])) {
            throw new IllegalStateException("서로 다른 수를 입력해주세요");
        }
    }
}
