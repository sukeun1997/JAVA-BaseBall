package basball.baseball;

import basball.baseball.model.Balls;

public class BaseBall {

    private int ball = 0;
    private int strike = 0;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isNothing() {
        if (ball != 0 || strike != 0) {
            return false;
        }

        return true;
    }

    public void judgeBalls(Balls com, Balls player) {

        for (int i = 0; i < 3; i++) {
            judgeBallOfIndex(com, player, i);
        }
    }

    public void judgeBallOfIndex(Balls com, Balls player, int idx) {

        int comNumber = com.getNumberOfIndex(idx);
        int playerNumber = player.getNumberOfIndex(idx);

        if (isStrike(comNumber, playerNumber)) {
            strike++;
            return;
        }

        if (isBall(com, playerNumber)) {
            ball++;
            return;
        }
    }

    private boolean isBall(Balls com, int playerNumber) {
        return com.hasNumber(playerNumber);
    }

    private boolean isStrike(int comNumber, int playerNumber) {
        return comNumber == playerNumber;
    }

    public String getResult() {
        if (isNothing()) {
            return "낫싱";
        }

        String result = "";

        if (ball > 0)
            result = addBallResult(result);

        if (strike > 0)
            result = addStrikeResult(result);

        return result;
    }

    private String addStrikeResult(String result) {
        if (ball > 0) {
            result += " ";
        }
        result += strike + " 스트라이크";

        return result;
    }

    private String addBallResult(String result) {

        result += ball + " 볼";

        return result;
    }

    public void resetVariable() {
        ball = 0;
        strike = 0;
    }
}
