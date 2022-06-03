package basball.view;

import basball.baseball.BaseBall;

public class OutputView {


    private static final String GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public boolean getResult(BaseBall baseBall) {
        System.out.println(baseBall.getResult());

        if (isGameEnd(baseBall)) return true;

        return false;
    }

    private boolean isGameEnd(BaseBall baseBall) {
        if (baseBall.getStrike() == 3) {
            System.out.println(GAME_FINISH_MESSAGE);
            System.out.println(GAME_END_MESSAGE);
            return true;
        }
        return false;
    }

}
