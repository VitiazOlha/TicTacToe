public class PvcGame extends Game {
    private ConsoleUserInputProvider userInputProvider;

    public PvcGame(ConsoleUserInputProvider userInputProvider, BoardStateAnalyzer boardStateAnalyzer) {
        super(new HumanPlayer(userInputProvider), new AutoPlayer(), boardStateAnalyzer);
        this.userInputProvider = userInputProvider;
    }
}
