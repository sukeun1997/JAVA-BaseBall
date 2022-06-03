package basball.baseball.model;

public class Player {

    private Balls balls;

    public static Player createComputer() {
        return new Player(Balls.ofComputer());
    }

    public static Player createPlayer(int[] number) {
        return new Player(Balls.ofPlayer(number));
    }

    public Balls getBalls() {
        return balls;
    }

    public Player(Balls balls) {
        this.balls = balls;
    }
}
