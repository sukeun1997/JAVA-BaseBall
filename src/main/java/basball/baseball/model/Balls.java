package basball.baseball.model;

import basball.baseball.Running;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static basball.baseball.Running.Validator.*;
import static basball.baseball.model.Balls.NumberGenerator.generate;

public class Balls {
    private static final int COUNT = 3;
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
        isDifferentNumbers(numbers);
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

        public static int generate() {
            Random random = new Random();
            return random.nextInt(9)+1;
        }

    }
}
