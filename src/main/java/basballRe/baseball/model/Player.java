package basballRe.baseball.model;

public class Player extends AbstractPlayer{

    public Player(String[] numbers) {
        super(Balls.ofPlayer(numbers));
    }


}
