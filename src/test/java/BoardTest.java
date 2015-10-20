import org.junit.Assert;
import org.junit.Test;



public class BoardTest {

      @Test(timeout = 100)
    public void testIsPossibleToMove() throws Exception {
Board board = new Board();
        board.setFieldValue(0,0,1);
        board.setFieldValue(0,1,-1);
        board.setFieldValue(0,2,0);
        board.setFieldValue(1,0,1);
        board.setFieldValue(1,1,1);
        board.setFieldValue(1,2,0);
        board.setFieldValue(2,0,1);
        board.setFieldValue(2,1,1);
        board.setFieldValue(2,2,1);

        Assert.assertEquals(false, board.isPossibleToMove(1, 1));
        Assert.assertEquals(true, board.isPossibleToMove(1, 3));
        Assert.assertEquals(false, board.isPossibleToMove(1, 2));
    }
}