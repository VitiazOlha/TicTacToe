public class CvpGame extends Game {
    public CvpGame(BoardStateAnalyzer boardStateAnalyzer) {
        super(new AutoPlayer(), new HumanPlayer(), boardStateAnalyzer);
    }
}