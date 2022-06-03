package basball.baseball;

import basball.baseball.model.GameStatus;
import basball.baseball.model.Player;
import basball.view.InputView;
import basball.view.OutputView;

import java.util.regex.Pattern;

public class Running {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BaseBall baseBall = new BaseBall();
    private static GameStatus status = GameStatus.RUNNING;
    private static boolean isFinished;

    public static void start() {

        // 게임 시작
        while (status == GameStatus.RUNNING) {

            // 컴퓨터 생성
            Player computer = Player.createComputer();

            // 3 스트라이크가 아니라면 반복하며 게임 진행
            while (!isFinished) {
                baseBall.resetVariable();
                Player player = Player.createPlayer(inputView.getInputNumber());
                baseBall.judgeBalls(computer.getBalls(), player.getBalls());
                isFinished = outputView.getResult(baseBall);
            }

            // 게임 끝난후 시작 or 종료
            status = inputView.getRestartInput();

            if (status != GameStatus.END) {
                isFinished = false;
            }
        }
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

