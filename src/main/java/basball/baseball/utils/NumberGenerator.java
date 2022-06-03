package basball.baseball.utils;

import java.util.Random;

public final class NumberGenerator {

    public static int generate() {
        Random random = new Random();
        return random.nextInt(9)+1;
    }

}
