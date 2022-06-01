package basballRe.baseball.model;

import basballRe.baseball.Balls;

public class Player extends AbstractPlayer{

    public Player(String[] numbers) {
        super(Balls.ofPlayer(numbers));
    }


}
