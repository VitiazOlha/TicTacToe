public class CvpGame extends Game {
    public CvpGame(ConsoleUserInputProvider userInputProvider, BoardStateAnalyzer boardStateAnalyzer) {
        super(new AutoPlayer(), new HumanPlayer(userInputProvider), boardStateAnalyzer);
    }
}