
package basball.view;

import basball.baseball.Running.Validator;
import basball.baseball.model.GameStatus;

import java.util.Arrays;
import java.util.Scanner;

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
}
