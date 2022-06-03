package basball.view;

import basball.baseball.BaseBall;
import basball.baseball.model.Balls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OutputViewTest {

    OutputView outputView = new OutputView();
    BaseBall baseBall;

    @BeforeEach
    void beforeEach() {
        baseBall = new BaseBall();
    }

    @Test
    @DisplayName("3 스트라이크가 아니라서 false")
    void resultTest_1() {
        Balls com = new Balls(List.of(1, 2, 3));
        Balls player = new Balls(List.of(1, 2, 4));

        baseBall.judgeBalls(com, player);
        boolean result = outputView.getResult(baseBall);

        assertFalse(result);
    }

    @Test
    @DisplayName("3 스트라이크라서 true")
    void resultTest_2() {
        Balls com = new Balls(List.of(1, 2, 3));
        Balls player = new Balls(List.of(1, 2, 3));

        baseBall.judgeBalls(com, player);
        boolean result = outputView.getResult(baseBall);

        assertTrue(result);
    }
}