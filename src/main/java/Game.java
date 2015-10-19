//todo write tests (Ilya)

public abstract class Game {
    protected Player player1;
    protected Player player2;
    protected Board board;
    private BoardStateAnalyzer boardStateAnalyzer;
    private GameState currentState;

    public Game(Player player1, Player player2, BoardStateAnalyzer boardStateAnalyzer) {
        this.player1 = player1;
        this.player2 = player2;
        this.boardStateAnalyzer = boardStateAnalyzer;
        this.currentState = GameState.PENDING_GAME;
        board = new Board();
    }

    protected boolean isOver() {
        return currentState != GameState.PENDING_GAME;
    }

    public void startNewGame() {
        while (!isOver()) {
            System.out.println("Goes the player1 \"X\" : ");
            player1.doStep(board, 1);
            currentState = boardStateAnalyzer.getNewGameState(board);
            if (!isOver()) {
                System.out.println("Goes the player2 \"O\" : ");
                player2.doStep(board, -1);
                currentState = boardStateAnalyzer.getNewGameState(board);
            }
        }
        System.out.println("Game over with status: " + currentState);
    }

    public enum GameState {
        PENDING_GAME,
        DRAW,
        PLAYER1_WIN,
        PLAYER2_WIN,
    }
}