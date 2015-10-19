public class PvpGame extends Game {
    public PvpGame(ConsoleUserInputProvider userInputProvider, BoardStateAnalyzer boardStateAnalyzer) {
        super(new HumanPlayer(userInputProvider), new HumanPlayer(userInputProvider), boardStateAnalyzer);
    }
}
