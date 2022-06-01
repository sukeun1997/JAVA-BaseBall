
package basballRe.view;

import basballRe.baseball.utils.Validation;

import java.util.Scanner;

public final class InputView {

    static final String INPUT_NUMBER = "숫자를 입력해 주세요 : ";
    private static final Scanner sc = new Scanner(System.in);

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

    public int inputRestart() {
        int answer = sc.nextInt();
        Validation.validateAnswer(answer);
        return answer;
    }
}
