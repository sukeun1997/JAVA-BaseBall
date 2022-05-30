package basballRe.baseball;

import basballRe.baseball.model.Computer;
import basballRe.baseball.utils.NumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    private Computer computer;
    @BeforeEach
    void before() {
        computer = Computer.of();
    }

    @Test
    @DisplayName("0~9 랜덤 숫자 생성 확인")
    void generatorRandomNumber() throws Exception {

        for (int i = 0; i < 100; i++) {

            int number = NumberGenerator.generate();

            if (!(number >= 1 && number <= 9)) {
                System.out.println(number);
                Assertions.fail();
            }
        }
    }


    @Test
    @DisplayName("컴퓨터 서로 다른 숫자 3개 생성 확인")
    void generatorFirstNumber() throws Exception {

        for (int i = 0; i < 100; i++) {
            Computer of = Computer.of();
            assertEquals(of.getBalls(), 3);
        }
    }

}