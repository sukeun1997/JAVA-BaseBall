package basballRe.baseball.model;

public abstract class AbstractPlayer {

    private Balls balls;

    public Balls getBalls() {
        return balls;
    }

    public AbstractPlayer(Balls balls) {
        this.balls = balls;
    }
}
