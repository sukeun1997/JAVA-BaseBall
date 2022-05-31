package basballRe.baseball;

import org.assertj.core.api.Assertions;
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
        baseBall.judgeBallOfIndex(com, player, 0);
        assertThat(baseBall.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("1번째 자리 1 스트라이크")
    void oneStrike() {
        player = new Balls(List.of(1, 0, 0));
        baseBall.judgeBallOfIndex(com, player, 0);
        assertThat(baseBall.getStrike()).isEqualTo(1);
        assertThat(baseBall.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("1번째 자리 낫싱")
    void Nothing() {
        player = new Balls(List.of(0, 0, 0));
        baseBall.judgeBallOfIndex(com, player, 0);
        assertThat(baseBall.getStrike()).isEqualTo(0);
        assertThat(baseBall.getBall()).isEqualTo(0);
        assertThat(baseBall.isNothing()).isTrue();
    }
}
