/**
 * Created by admin on 15.10.2015.
 */
public class CvcGame extends Game {

    public CvcGame(BoardStateAnalyzer boardStateAnalyzer) {
        super(new AutoPlayer(), new AutoPlayer(), boardStateAnalyzer);
    }

    @Override
    protected boolean isOver() {
        return false;
    }
}
