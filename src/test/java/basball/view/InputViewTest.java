package basball.view;

import basball.baseball.Running.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {


    @Test
    @DisplayName("숫자가 아닌 문자 입력")
    void hasThreeNumberTest_1() throws Exception {
        // given
        String Number = "1a2";

        // when
        //then
        assertThrows(IllegalArgumentException.class, () -> Validator.hasThreeNumber(Number));
    }

    @Test
    @DisplayName("숫자 3개 미만")
    void hasThreeNumberTest_2() throws Exception {
        // given
        String Number = "12";

        // when
        //then
        assertThrows(IllegalArgumentException.class, () -> Validator.hasThreeNumber(Number));
    }

    @Test
    @DisplayName("숫자 4개 이상")
    void hasThreeNumberTest_3() throws Exception {
        // given
        String Number = "1234";

        // when
        //then
        assertThrows(IllegalArgumentException.class, () -> Validator.hasThreeNumber(Number));
    }

    @Test
    @DisplayName("숫자 3개")
    void hasThreeNumberTest_4() throws Exception {
        // given
        String Number = "123";

        // when
        //then
        Validator.hasThreeNumber(Number);
    }
}