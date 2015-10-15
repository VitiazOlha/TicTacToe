/**
 * Created by admin on 15.10.2015.
 */
public class GameFactory {
    public static Game createGame(ConsoleUserInputProvider userInputProvider) {
        BoardStateAnalyzer boardStateAnalyzer = new BoardStateAnalyzer();

        GameType type = userInputProvider.getGameType();
        switch (type) {
            case PVP:
                return new PvpGame(userInputProvider, boardStateAnalyzer);
            case PVC:
                return new PvcGame(userInputProvider, boardStateAnalyzer);
            case CVC:
            default:
                return new CvcGame(boardStateAnalyzer);
        }
    }
}
