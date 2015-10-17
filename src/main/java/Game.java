//todo write tests (Ilya)

public abstract class Game {
    private BoardStateAnalyzer boardStateAnalyzer;
    private GameState currentState;

    private static GameFactory gameFactory;
    protected Player player1;
    protected Player player2;
    protected Board board;

    public Game(Player player1, Player player2, BoardStateAnalyzer boardStateAnalyzer) {
        this.player1 = player1;
        this.player2 = player2;
        this.boardStateAnalyzer = boardStateAnalyzer;
        this.currentState = GameState.PENDING_GAME;
        board = new Board();
    }

    protected boolean isOver() {
        if (currentState == GameState.PENDING_GAME) {
            return false;
        } else {
            return true;
        }
    }

    public void startNewGame() {
        while (!isOver()) {
            player1.doStep(board, 1);
            currentState = boardStateAnalyzer.getNewGameState(board);
            if (!isOver()) {
                player2.doStep(board, -1);
                currentState = boardStateAnalyzer.getNewGameState(board);
            }
        }
        System.out.println("Game over with status: " + currentState);
    }

    public static enum GameState {
        PENDING_GAME,
        DRAW,
        PLAYER1_WIN,
        PLAYER2_WIN,
    }
}