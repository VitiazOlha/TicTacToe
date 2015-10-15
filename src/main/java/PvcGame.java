/**
 * Created by admin on 15.10.2015.
 */
public class PvcGame extends Game {
    private ConsoleUserInputProvider userInputProvider;

    public PvcGame(ConsoleUserInputProvider userInputProvider, BoardStateAnalyzer boardStateAnalyzer) {
        super(new HumanPlayer(userInputProvider), new AutoPlayer(), boardStateAnalyzer);
        this.userInputProvider = userInputProvider;
    }

    @Override
    protected boolean isOver() {
        return userInputProvider.exitCommandSend();
    }
}
