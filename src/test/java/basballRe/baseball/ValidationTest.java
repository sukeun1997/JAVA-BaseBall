package basballRe.baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @Test
    @DisplayName("볼 사이즈 3개라 성공")
    void ballSize3() {
        Validation.hasThreeBalls(List.of(1,2,3));
    }

    @Test
    @DisplayName("볼 사이즈 3개 아니라 실패")
    void ballSize4() {
        assertThrows(IllegalStateException.class, () -> Validation.hasThreeBalls(List.of(1, 2, 3, 4)));
    }


    @Test
    @DisplayName("게임 종료 후 값이 1 또는 2 인경우")
    void finishNumber0Or1() {
        Validation.validateAnswer(1);
        Validation.validateAnswer(2);
    }

    @Test
    @DisplayName("게임 종료 후 값이 1 또는 0 이 아닌경우")
    void finishNumberNot0Or1() {
        assertThrows(IllegalArgumentException.class, () -> Validation.validateAnswer(3));
        assertThrows(IllegalArgumentException.class, () -> Validation.validateAnswer(-1));
    }

    @Test
    @DisplayName("0,1 번째 숫자가 동일")
    void sameNumberCheck1() {
        String[] strings = {"0", "0", "2"};
        assertThrows(IllegalArgumentException.class, () -> Validation.isDifferentNumbers(strings));
    }

    @Test
    @DisplayName("1,2 번째 숫자가 동일")
    void sameNumberCheck2() {
        String[] strings = {"0", "1", "1"};
        assertThrows(IllegalArgumentException.class, () -> Validation.isDifferentNumbers(strings));
    }

    @Test
    @DisplayName("2,3 번째 숫자가 동일")
    void sameNumberCheck3() {
        String[] strings = {"2", "0", "2"};
        assertThrows(IllegalArgumentException.class, () -> Validation.isDifferentNumbers(strings));
    }
}