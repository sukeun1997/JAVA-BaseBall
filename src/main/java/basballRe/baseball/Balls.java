package basballRe.baseball;

import java.util.ArrayList;
import java.util.List;

import static basballRe.baseball.utils.NumberGenerator.generate;

public class Balls {
    public static final int COUNT = 3;
    private final List<Integer> balls;

    private Balls() {
        this.balls = createNumber();
    }

    public Balls(List<Integer> balls) {
        this.balls = balls;
    }

    public static Balls of() {
        return new Balls();
    }

    public int getNumberOfIndex(int idx) {
        return balls.get(idx);
    }

    public boolean hasNumber(int number) {
        return balls.contains(number);
    }

    private ArrayList<Integer> createNumber() {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < COUNT; i++) {
            int number = getDifferentNumber(list);
            list.add(number);
        }

        Validation.hasThreeBalls(list);
        return list;
    }

    private int getDifferentNumber(ArrayList<Integer> list) {

        int number = generate();

        while (list.contains(number)) {
            number = generate();
        }

        return number;
    }
}
