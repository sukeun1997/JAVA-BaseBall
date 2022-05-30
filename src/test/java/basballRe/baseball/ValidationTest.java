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
}