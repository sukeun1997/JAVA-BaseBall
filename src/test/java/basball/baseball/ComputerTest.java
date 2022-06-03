package basball.baseball;

import basball.baseball.model.Balls.NumberGenerator;
import basball.baseball.model.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ComputerTest {

    @Test
    @DisplayName("1~9 랜덤 숫자 생성 확인")
    void numberGenerateTest() {

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
    void createComputerTest() {

        for (int i = 0; i < 100; i++) {
            Player of = Player.createComputer();
            int firstNumber = of.getBalls().getNumberOfIndex(0);
            int secondNumber = of.getBalls().getNumberOfIndex(1);
            int thirdNumber = of.getBalls().getNumberOfIndex(2);
            assertNotEquals(firstNumber,secondNumber);
            assertNotEquals(secondNumber,thirdNumber);
            assertNotEquals(firstNumber,thirdNumber);
        }
    }

}