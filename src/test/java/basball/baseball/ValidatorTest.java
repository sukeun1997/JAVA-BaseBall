package basball.baseball;

import basball.baseball.Running.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    @DisplayName("게임 종료 후 값이 숫자가 아닌경우")
    void validateAnswerTest_1() {
        validateWrongAnswer("a");
        validateWrongAnswer("test");
        validateWrongAnswer("-");
        validateWrongAnswer("a1");
        validateWrongAnswer("a2");
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
        validateWrongAnswer("3");
        validateWrongAnswer("-1");
    }

    private IllegalArgumentException validateWrongAnswer(String answer) {
        return assertThrows(IllegalArgumentException.class, () -> Validator.validateAnswer(answer));
    }

    @Test
    @DisplayName("1,2 번째 숫자가 동일")
    void isDifferentNumbersTest_1() {
        validateSameNumber(1, 2, 1);
    }

    @Test
    @DisplayName("2,3 번째 숫자가 동일")
    void isDifferentNumbersTest_2() {
        validateSameNumber(2, 1, 1);
    }

    @Test
    @DisplayName("1,3 번째 숫자가 동일")
    void isDifferentNumbersTest_3() {
        validateSameNumber(2, 1, 2);
    }

    private void validateSameNumber(int n1, int n2, int n3) {
        int[] numbers = {n1, n2, n3};
        assertThrows(IllegalArgumentException.class, () -> Validator.isDifferentNumbers(numbers));
    }

    @Test
    @DisplayName("3개의 1~9 숫자 만 입력")
    void hasThreeNumberTest_1() {
        String number = "231";
        Validator.hasThreeNumber(number);
    }

    @Test
    @DisplayName("0 을 포함한 숫자 입력")
    void hasThreeNumberTest_2() {
        validateWrongNumber("230");
    }

    @Test
    @DisplayName("숫자 3개 미만 입력")
    void hasThreeNumberTest_3() {
        validateWrongNumber("23");
    }

    @Test
    @DisplayName("숫자 4개 이상 입력")
    void hasThreeNumberTest_4() {
        validateWrongNumber(" 2314");
    }

    @Test
    @DisplayName("숫자가 아닌 문자 입력")
    void hasThreeNumberTest_5() {
        validateWrongNumber(" 23a");
    }

    @Test
    @DisplayName("입력값 없음")
    void hasThreeNumberTest_6() {
        validateWrongNumber("");
    }

    private void validateWrongNumber(String number) {
        assertThrows(IllegalArgumentException.class, () -> Validator.hasThreeNumber(number));
    }
}