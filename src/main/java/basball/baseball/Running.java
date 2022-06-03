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

}

