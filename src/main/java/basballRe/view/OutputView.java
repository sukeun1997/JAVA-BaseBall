package basballRe.view;

import basballRe.baseball.BaseBall;

public class OutputView {


    public void result(BaseBall baseBall) {
        println(baseBall);
        baseBall.resetResult();
    }

    private void println(BaseBall baseBall) {
        System.out.println(baseBall);
    }
}
