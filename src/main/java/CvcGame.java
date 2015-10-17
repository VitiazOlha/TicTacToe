public class CvcGame extends Game {
    public CvcGame(BoardStateAnalyzer boardStateAnalyzer) {
        super(new AutoPlayer(), new AutoPlayer(), boardStateAnalyzer);
    }
}
