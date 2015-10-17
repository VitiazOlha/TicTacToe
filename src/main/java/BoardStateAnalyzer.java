public class BoardStateAnalyzer {
    public Game.GameState getNewGameState(Board board) {
        for (int i = 0; i < 3; i++) {
            int sumRow = 0;
            int sumColumn = 0;
            for (int j = 0; j < 3; j++) {
                sumRow += board.getFieldValue(i, j);
                sumColumn += board.getFieldValue(j, i);
            }
            if (Math.abs(sumRow) == 3) {
                return sumRow == -3 ? Game.GameState.PLAYER2_WIN : Game.GameState.PLAYER1_WIN;
            } else if (Math.abs(sumColumn) == 3) {
                return sumColumn == -3 ? Game.GameState.PLAYER2_WIN : Game.GameState.PLAYER1_WIN;
            }
        }
        int sumMainDiagonal = 0;
        int sumSideDiagonal = 0;
        for (int i = 0; i < 3; i++) {
            sumMainDiagonal += board.getFieldValue(i, i);
            sumSideDiagonal += board.getFieldValue(i, 2 - i);
        }
        if (Math.abs(sumMainDiagonal) == 3) {
            return sumMainDiagonal == -3 ? Game.GameState.PLAYER2_WIN : Game.GameState.PLAYER1_WIN;
        } else if (Math.abs(sumSideDiagonal) == 3) {
            return sumSideDiagonal == -3? Game.GameState.PLAYER2_WIN : Game.GameState.PLAYER1_WIN;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getFieldValue(i, j) == 0) return Game.GameState.PENDING_GAME;
            }
        }
        return Game.GameState.DRAW;
    }
}
