public class BoardStateAnalyzer {
    public Game.GameState getNewGameState(Board board) {
        for (int i = 0; i < 3; i++) {
            if ((board.getFieldValue(i, 0) == board.getFieldValue(i, 1)) && (board.getFieldValue(i, 1) == board.getFieldValue(i, 2)) && (board.getFieldValue(i, 0) != 0)) {
                return board.getFieldValue(i, 0) == -1 ? Game.GameState.PLAYER2_WIN : Game.GameState.PLAYER1_WIN;
            } else if ((board.getFieldValue(0, i) == board.getFieldValue(1, i)) && (board.getFieldValue(1, i) == board.getFieldValue(2, i)) && (board.getFieldValue(0, i) != 0)) {
                return board.getFieldValue(0, i) == -1 ? Game.GameState.PLAYER2_WIN : Game.GameState.PLAYER1_WIN;
            }
        }
        if ((board.getFieldValue(0, 0) == board.getFieldValue(1, 1)) && (board.getFieldValue(1, 1) == board.getFieldValue(2, 2)) && (board.getFieldValue(0, 0) != 0)) {
            return board.getFieldValue(0, 0) == -1 ? Game.GameState.PLAYER2_WIN : Game.GameState.PLAYER1_WIN;
        } else if ((board.getFieldValue(0, 2) == board.getFieldValue(1, 1)) && (board.getFieldValue(1, 1) == board.getFieldValue(2, 0)) && (board.getFieldValue(0, 2) != 0)) {
            return board.getFieldValue(0, 2) == -1 ? Game.GameState.PLAYER2_WIN : Game.GameState.PLAYER1_WIN;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getFieldValue(i, j) == 0) return Game.GameState.PENDING_GAME;
            }
        }
        return Game.GameState.DRAW;
    }
}
