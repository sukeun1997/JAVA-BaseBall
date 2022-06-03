package basball.baseball.model;

public enum GameStatus {
    RUNNING(1), END(2);

    private int value;

    GameStatus(int value) {
        this.value = value;
    }
}
