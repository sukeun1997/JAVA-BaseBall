package basball.baseball;

import basball.baseball.model.Balls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {


    Balls com = new Balls(List.of(1,2,3));
    Balls player;
    BaseBall baseBall = new BaseBall();

    @Test
    @DisplayName("n볼")
    void NBall() {
        player = new Balls(List.of(2, 3, 4));
        baseBall.judgeBalls(com,player);
        assertThat(baseBall.getBall()).isEqualTo(2);
    }

    @Test
    @DisplayName("n볼 m 스트라이크")
    void NBallAndMStrike() {
        player = new Balls(List.of(2, 1, 3));
        baseBall.judgeBalls(com,player);
        assertThat(baseBall.getBall()).isEqualTo(2);
        assertThat(baseBall.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("m 스트라이크")
    void MStrike() {
        player = new Balls(List.of(1, 2, 4));
        baseBall.judgeBalls(com,player);
        assertThat(baseBall.getStrike()).isEqualTo(2);
    }

    @Test
    @DisplayName("낫싱")
    void nothing() {
        player = new Balls(List.of(4, 5, 6));
        baseBall.judgeBalls(com,player);
        assertThat(baseBall.isNothing()).isTrue();
    }
}
