package basball.baseball;

import basball.baseball.Running.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    @DisplayName("게임 종료 후 값이 숫자가 아닌경우")
    void validateAnswerTest_1() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateAnswer("a"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateAnswer("test"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateAnswer("-"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateAnswer("a1"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateAnswer("a2"));
    }


    @Test
    @DisplayName("게임 종료 후 값이 1 또는 2 인경우")
    void validateAnswerTest_2() {
        Validator.validateAnswer("1");
        Validator.validateAnswer("2");
    }

    @Test
    @DisplayName("게임 종료 후 값이 1 또는 2가 아닌경우")
    void validateAnswerTest_3() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateAnswer("3"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateAnswer("-1"));
    }

    @Test
    @DisplayName("1,2 번째 숫자가 동일")
    void isDifferentNumbersTest_1() {
        int[] numbers = {1, 1, 2};
        assertThrows(IllegalArgumentException.class, () -> Validator.isDifferentNumbers(numbers));
    }

    @Test
    @DisplayName("2,3 번째 숫자가 동일")
    void isDifferentNumbersTest_2() {
        int[] numbers = {2, 1, 1};
        assertThrows(IllegalArgumentException.class, () -> Validator.isDifferentNumbers(numbers));
    }

    @Test
    @DisplayName("1,3 번째 숫자가 동일")
    void isDifferentNumbersTest_3() {
        int[] numbers = {2, 1, 2};
        assertThrows(IllegalArgumentException.class, () -> Validator.isDifferentNumbers(numbers));
    }
}