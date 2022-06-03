package basball.view;

import basball.baseball.Running;
import basball.baseball.Running.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {


    @Test
    @DisplayName("[실패] 숫자가 아닌 문자 입력")
    void fail_01() throws Exception {
        // given
        String Number = "1a2";

        // when
        //then
        assertThrows(IllegalArgumentException.class, () -> Validator.hasThreeNumber(Number));
    }

    @Test
    @DisplayName("[실패] 숫자 3개 미만")
    void fail_02() throws Exception {
        // given
        String Number = "12";

        // when
        //then
        assertThrows(IllegalArgumentException.class, () -> Validator.hasThreeNumber(Number));
    }

    @Test
    @DisplayName("[실패] 숫자 4개 이상")
    void fail_03() throws Exception {
        // given
        String Number = "1234";

        // when
        //then
        assertThrows(IllegalArgumentException.class, () -> Validator.hasThreeNumber(Number));
    }

    @Test
    @DisplayName("[성공] 숫자 3개")
    void success() throws Exception {
        // given
        String Number = "123";

        // when
        //then
        Validator.hasThreeNumber(Number);
    }
}