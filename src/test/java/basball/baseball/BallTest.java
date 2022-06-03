package basball.baseball;

import basball.baseball.model.Balls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    Balls com = new Balls(List.of(1,2,3));
    Balls player;
    BaseBall baseBall = new BaseBall();

    @Test
    @DisplayName("1번째 자리 1 볼")
    void oneBall() {
        player = new Balls(List.of(3, 0, 0));
        isBallOfIndex(0);
    }

    @Test
    @DisplayName("1번째 자리 1 스트라이크")
    void oneStrike() {
        player = new Balls(List.of(1, 0, 0));
        isStrikeOfIndex(0);
    }

    @Test
    @DisplayName("2번째 자리 볼")
    void oneBall_2() {
        player = new Balls(List.of(0, 1, 0));
        isBallOfIndex(1);
    }

    @Test
    @DisplayName("2번째 자리 스트라이크")
    void oneStrike_2() {
        player = new Balls(List.of(0, 2, 0));
        isStrikeOfIndex(1);
    }

    @Test
    @DisplayName("3번째 자리 볼")
    void oneBall_3() {
        player = new Balls(List.of(0, 0, 1));
        isBallOfIndex(2);
    }

    @Test
    @DisplayName("3번째 자리 스트라이크")
    void oneStrike_3() {
        player = new Balls(List.of(0, 0, 3));
        isStrikeOfIndex(2);
    }

    private void isBallOfIndex(int idx) {
        baseBall.judgeBallOfIndex(com, player, idx);
        assertThat(baseBall.getBall()).isEqualTo(1);
        assertThat(baseBall.getStrike()).isEqualTo(0);
        assertThat(baseBall.isNothing()).isFalse();

    }

    private void isStrikeOfIndex(int idx) {
        baseBall.judgeBallOfIndex(com, player, idx);
        assertThat(baseBall.getStrike()).isEqualTo(1);
        assertThat(baseBall.getBall()).isEqualTo(0);
        assertThat(baseBall.isNothing()).isFalse();
    }
}
