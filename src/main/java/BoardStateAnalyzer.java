public class BoardStateAnalyzer {
    final static int N = 3;

    public Game.GameState getNewGameState(Board board) {
        for (int i = 0; i < N; i++) {
            int sumRow = 0;
            int sumColumn = 0;
            for (int j = 0; j < N; j++) {
                sumRow += board.getFieldValue(i, j);
                sumColumn += board.getFieldValue(j, i);
            }
            if (Math.abs(sumRow) == N) {
                return sumRow == -N ? Game.GameState.PLAYER2_WIN : Game.GameState.PLAYER1_WIN;
            } else if (Math.abs(sumColumn) == N) {
                return sumColumn == -N ? Game.GameState.PLAYER2_WIN : Game.GameState.PLAYER1_WIN;
            }
        }
        int sumMainDiagonal = 0;
        int sumSideDiagonal = 0;
        for (int i = 0; i < N; i++) {
            sumMainDiagonal += board.getFieldValue(i, i);
            sumSideDiagonal += board.getFieldValue(i, N - 1 - i);
        }
        if (Math.abs(sumMainDiagonal) == N) {
            return sumMainDiagonal == -N ? Game.GameState.PLAYER2_WIN : Game.GameState.PLAYER1_WIN;
        } else if (Math.abs(sumSideDiagonal) == N) {
            return sumSideDiagonal == -N? Game.GameState.PLAYER2_WIN : Game.GameState.PLAYER1_WIN;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board.getFieldValue(i, j) == 0) return Game.GameState.PENDING_GAME;
            }
        }
        return Game.GameState.DRAW;
    }
}
