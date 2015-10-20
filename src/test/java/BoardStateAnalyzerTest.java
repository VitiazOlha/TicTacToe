import org.junit.Assert;
import org.junit.Test;

public class BoardStateAnalyzerTest {

    @Test
    public void testGetNewGameState() throws Exception {
        Board board = new Board();
        board.setFieldValue(0, 0, 1);
        board.setFieldValue(0, 1, -1);
        board.setFieldValue(0, 2, 0);
        board.setFieldValue(1, 0, 1);
        board.setFieldValue(1, 1, -1);
        board.setFieldValue(1, 2, 0);
        board.setFieldValue(2, 0, 1);
        board.setFieldValue(2, 1, 0);
        board.setFieldValue(2, 2, 0);
        Assert.assertEquals(Game.GameState.PLAYER1_WIN, new BoardStateAnalyzer().getNewGameState(board));
        board.setFieldValue(2, 0, 0);
        Assert.assertEquals(Game.GameState.PENDING_GAME, new BoardStateAnalyzer().getNewGameState(board));
        board.setFieldValue(2, 1, -1);
        Assert.assertEquals(Game.GameState.PLAYER2_WIN, new BoardStateAnalyzer().getNewGameState(board));
        board.setFieldValue(2, 1, 1);
        board.setFieldValue(2, 0, -1);
        board.setFieldValue(2, 2, 1);
        board.setFieldValue(0, 2, 1);
        board.setFieldValue(1, 2, -1);
        Assert.assertEquals(Game.GameState.DRAW, new BoardStateAnalyzer().getNewGameState(board));
    }


}