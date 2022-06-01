
package basballRe.view;

import basballRe.baseball.Validation;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.regex.Pattern;

public final class InputView {

    static final String INPUT_NUMBER = "숫자를 입력해 주세요 : ";
    private static final Scanner sc = new Scanner(System.in);
    private static final Pattern PATTERN = Pattern.compile("[1-9]{3}");

    public String[] InputNumber() {
        print(INPUT_NUMBER);
        String next = sc.next().trim();

        Validation.hasThreeNumber(next);

        return getNumberArray(next);
    }

    private String[] getNumberArray(String next) {
        return next.split("");
    }

    private void print(String message) {
        System.out.print(message);
    }

}
