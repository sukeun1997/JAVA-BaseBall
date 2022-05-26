
package basballRe.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public final class InputView {

    static final String INPUT_NUMBER = "숫자를 입력해 주세요";
    private static final Scanner sc = new Scanner(System.in);
    private static final Pattern PATTERN = Pattern.compile("[0-9]{3}");

    public String[] InputNumber() {
        print(INPUT_NUMBER);
        String next = sc.next().trim();

        hasThreeNumber(next);

        next.split("");
        return null;
    }

    public void hasThreeNumber(String next) {

        if (!isMatches(next)) {
            throw new IllegalArgumentException("숫자를 입력 해 주세요.");
        }
    }

    private boolean isMatches(String next) {
        return PATTERN.matcher(next).matches();
    }

    private void print(String message) {
        System.out.println(message);
    }

}
