package basball.baseball.model;

import basball.baseball.utils.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static basball.baseball.utils.NumberGenerator.generate;

public class Balls {
    public static final int COUNT = 3;
    private final List<Integer> balls;

    private Balls() {
        this.balls = createNumber();
    }

    public Balls(List<Integer> balls) {
        this.balls = balls;
    }



    public static Balls ofComputer() {
        return new Balls();
    }

    public static Balls ofPlayer(String [] numbers) {
        Validation.isDifferentNumbers(numbers);
        List<Integer> balls = Arrays.stream(numbers)
                .map(s -> Integer.valueOf(s))
                .collect(Collectors.toList());
        return new Balls(balls);
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
