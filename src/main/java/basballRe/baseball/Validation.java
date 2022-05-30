package basballRe.baseball;

import java.util.List;

public final class Validation {


    public static void hasThreeBalls(List<Integer> list) {
        if (list.size() != 3) {
            throw new IllegalStateException("생성된 볼 사이즈는 " + list.size() + " 입니다.");
        }
    }
}
