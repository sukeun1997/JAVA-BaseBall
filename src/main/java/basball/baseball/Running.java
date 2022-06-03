package basball.baseball;

import basball.baseball.model.Player;
import basball.view.InputView;
import basball.view.OutputView;

import java.util.regex.Pattern;

public class Running {

    private static boolean finish;
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static BaseBall baseBall;

    public static void start() {
        // 게임 시작
        init();

        // 컴퓨터 생성
        Player computer = Player.createComputer();

        // 3 스트라이크가 아니라면 반복하며 게임 진행
        while (!finish) {
            baseBall.resetVariable();
            Player player = Player.createPlayer(inputView.InputNumber());
            baseBall.judgeBalls(computer.getBalls(),player.getBalls());
            finish = outputView.result(baseBall);
        }

        // 게임 끝난후 시작 or 종료
        int answer = inputView.inputRestart();

        if (answer == 1) {
            restart();
            return;
        }

        end();


    }

    private static void end() {
        System.exit(0);
    }

    private static void restart() {
        finish = false;
        start();
    }

    private static void init() {
         baseBall = new BaseBall();
    }

    public static class Validator {
        private static final Pattern PATTERN = Pattern.compile("[1-9]{3}");
        public static void hasThreeNumber(String next) {

            if (!PATTERN.matcher(next).matches()) {
                throw new IllegalArgumentException("서로 다른 3자리 숫자만 입력 해주세요");
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
                throw new IllegalArgumentException("1 또는 2만 입력 해 주세요");
            }
        }
    }

}

