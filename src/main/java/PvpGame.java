/**
 * Created by admin on 15.10.2015.
 */
public class PvpGame extends Game {
    private ConsoleUserInputProvider userInputProvider;

    public PvpGame(ConsoleUserInputProvider userInputProvider, BoardStateAnalyzer boardStateAnalyzer) {
        super(new HumanPlayer(userInputProvider), new HumanPlayer(userInputProvider), boardStateAnalyzer);
        this.userInputProvider = userInputProvider;
    }

    @Override
    protected boolean isOver() {
        return false;
    }
}
