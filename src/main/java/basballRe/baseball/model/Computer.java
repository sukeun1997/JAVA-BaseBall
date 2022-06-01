package basballRe.baseball.model;

/**
 * 서로 다른 3개의 숫자를 가지는 컴퓨터
 */
public final class Computer extends AbstractPlayer {

    private Computer() {
        super(Balls.ofComputer());
    }

    public static Computer of() {
        return new Computer();
    }
}
