package basball.baseball.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static basball.baseball.model.Balls.NumberGenerator.generate;
import static basball.view.InputView.Validator.isDifferentNumbers;

public class Balls {
    private static final int COUNT = 3;
    private final List<Integer> balls;

    public Balls(List<Integer> balls) {
        this.balls = balls;
    }

    private Balls() {
        this.balls = createNumber();
    }



    public static Balls ofComputer() {
        return new Balls();
    }

    public static Balls ofPlayer(int [] numbers) {
        isDifferentNumbers(numbers);

        return new Balls(getBalls(numbers));
    }

    private static List<Integer> getBalls(int[] numbers) {
        List<Integer> list = new ArrayList<>();

        for (int number : numbers) {
            list.add(number);
        }

        return list;
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

        return list;
    }

    private int getDifferentNumber(ArrayList<Integer> list) {

        int number = generate();

        while (list.contains(number)) {
            number = generate();
        }

        return number;
    }

    public static class NumberGenerator {

        private final static Random random = new Random();
        public static int generate() {
            return random.nextInt(9)+1;
        }

    }
}