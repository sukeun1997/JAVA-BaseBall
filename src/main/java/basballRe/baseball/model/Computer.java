package basballRe.baseball.model;

import basballRe.baseball.Balls;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static basballRe.baseball.utils.NumberGenerator.generate;

/**
 * 서로 다른 3개의 숫자를 가지는 컴퓨터
 */
public final class Computer {

    public static final int COUNT = 3;
    private final Balls balls;

    public Balls getBalls() {
        return balls;
    }

    private Computer() {
        this.balls = Balls.of();
    }

    public static Computer of() {
        return new Computer();
    }
}
