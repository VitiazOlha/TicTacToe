public class CvpGame extends Game {
    private ConsoleUserInputProvider userInputProvider;

    public CvpGame(ConsoleUserInputProvider userInputProvider, BoardStateAnalyzer boardStateAnalyzer) {
        super(new AutoPlayer(), new HumanPlayer(userInputProvider),  boardStateAnalyzer);
        this.userInputProvider = userInputProvider;
    }
}