package basballRe.baseball;

import basballRe.baseball.model.Player;
import basballRe.view.InputView;
import basballRe.view.OutputView;

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
}
