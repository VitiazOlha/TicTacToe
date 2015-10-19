public class PvcGame extends Game {
    public PvcGame(ConsoleUserInputProvider userInputProvider, BoardStateAnalyzer boardStateAnalyzer) {
        super(new HumanPlayer(userInputProvider), new AutoPlayer(), boardStateAnalyzer);
    }
}
