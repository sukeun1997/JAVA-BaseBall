package basball.view;

import basball.baseball.BaseBall;

public class OutputView {


    public static final String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String GAME_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public boolean result(BaseBall baseBall) {
        println(baseBall.toString());

        if (isGameEnd(baseBall)) return true;

        return false;
    }

    private boolean isGameEnd(BaseBall baseBall) {
        if (baseBall.getStrike() == 3) {
            println(GAME_FINISH_MESSAGE);
            println(GAME_END_MESSAGE);
            return true;
        }
        return false;
    }

    private void println(String message) {
        System.out.println(message);
    }
}
