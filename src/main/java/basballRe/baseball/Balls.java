package basballRe.baseball;

import java.util.ArrayList;

import static basballRe.baseball.utils.NumberGenerator.generate;

public class Balls {
    public static final int COUNT = 3;
    private final ArrayList<Integer> balls;

    private Balls() {
        this.balls = createNumber();
    }

    public static Balls of() {
        return new Balls();
    }

    public int getNumberOfIndex(int idx) {
        return balls.get(idx);
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
