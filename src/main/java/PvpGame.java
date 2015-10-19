public class PvpGame extends Game {
    public PvpGame(BoardStateAnalyzer boardStateAnalyzer) {
        super(new HumanPlayer(), new HumanPlayer(), boardStateAnalyzer);
    }
}
