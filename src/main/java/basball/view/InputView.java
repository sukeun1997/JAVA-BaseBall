
package basball.view;

import basball.baseball.model.GameStatus;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class InputView {

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final Scanner sc = new Scanner(System.in);

    public int[] getInputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String next = sc.next().trim();

        Validator.hasThreeNumber(next);

        return getNumberArray(next);
    }

    private int[] getNumberArray(String next) {
        return Arrays.stream(next.split("")).mapToInt(value -> Integer.parseInt(value)).toArray();
    }

    public GameStatus getRestartInput() {
        String answer = sc.next();
        Validator.validateAnswer(answer);

        if (answer.equals("1")) {
            return GameStatus.RUNNING;
        }
        return GameStatus.END;
    }

    public static class Validator {
        private static final Pattern PATTERN = Pattern.compile("[1-9]{3}");

        public static void hasThreeNumber(String next) {

            if (!PATTERN.matcher(next).matches()) {
                throw new IllegalArgumentException("서로 다른 3자리 숫자만 입력 해주세요");
            }
        }

        public static void isDifferentNumbers(int[] numbers) {

            if (isSameNumber(numbers[0], numbers[1]) || isSameNumber(numbers[0], numbers[2]) || isSameNumber(numbers[1], numbers[2])) {
                throw new IllegalArgumentException("서로 다른 수를 입력해주세요");
            }
        }

        private static boolean isSameNumber(int number1, int number2) {
            return number1 == number2;
        }

        public static void validateAnswer(String answer) {
            if (!answer.equals("1") && !answer.equals("2")) {
                throw new IllegalArgumentException("1 또는 2만 입력 해 주세요");
            }
        }
    }
}
