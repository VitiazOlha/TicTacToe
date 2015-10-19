public class PvcGame extends Game {
    public PvcGame(BoardStateAnalyzer boardStateAnalyzer) {
        super(new HumanPlayer(), new AutoPlayer(), boardStateAnalyzer);
    }
}
