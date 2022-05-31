package basballRe.baseball;

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
}
