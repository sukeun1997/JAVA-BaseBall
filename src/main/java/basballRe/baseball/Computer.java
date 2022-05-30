package basballRe.baseball;

import basballRe.baseball.utils.NumberGenerator;
import org.graalvm.compiler.api.replacements.Snippet;

import java.util.HashSet;
import java.util.Set;

import static basballRe.baseball.utils.NumberGenerator.generate;

public final class Computer {

    public static final int COUNT = 3;
    private final Set<String> set;


    private Computer() {
        this.set = createNumber();
    }

    public Set<String> getSet() {
        return set;
    }

    private Set<String> createNumber() {

        Set<String> set = new HashSet<>();

        for (int i = 0; i < COUNT; i++) {
            String number = getDifferentNumber(set);
            set.add(number);
        }

        return set;
    }

    private String getDifferentNumber(Set<String> set) {
        String number = String.valueOf(generate());

        while (set.contains(number)) {
            number = String.valueOf(generate());
        }

        return number;
    }

    public static Computer of() {
        return new Computer();
    }
}
