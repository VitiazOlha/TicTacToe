public class GameFactory {
    public static Game createGame(ConsoleUserInputProvider userInputProvider) {
        BoardStateAnalyzer boardStateAnalyzer = new BoardStateAnalyzer();

        GameType type = userInputProvider.getGameType();
        switch (type) {
            case PVP:
                return new PvpGame(boardStateAnalyzer);
            case PVC:
                return new PvcGame(boardStateAnalyzer);
            case CVP:
                return new CvpGame(boardStateAnalyzer);
            case CVC:
            default:
                return new CvcGame(boardStateAnalyzer);
        }
    }
}
