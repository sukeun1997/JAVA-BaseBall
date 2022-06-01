package basballRe.baseball;

import basballRe.baseball.model.Computer;
import basballRe.baseball.model.Player;
import basballRe.view.InputView;
import basballRe.view.OutputView;

public class Running {

    private static boolean finish;
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static BaseBall baseBall;

    public static void start() {
        init();
        Computer computer = Computer.of();

        while (!finish) {
            Player player = new Player(inputView.InputNumber());
            baseBall.judgeBalls(computer.getBalls(),player.getBalls());
            outputView.result(baseBall);
        }
    }

    private static void init() {
         baseBall = new BaseBall();
    }
}
