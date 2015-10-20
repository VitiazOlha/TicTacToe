import org.junit.Assert;
import org.junit.Test;

public class CheckWinnerTest {

    @Test(timeout = 100)
    public void testCheckWinner() throws Exception {

        int[][] board = {{1, -1, 1},
                         {1, -1, 1},
                         {1, 0, 0}}; //Создаем заполненную доску с одним или двумя пустыми ячеками (0)
        Assert.assertEquals(1, CheckTheValue.checkCell(1, 0, board));

        int[][] board1 ={{-1, 1, 1},
                         {-1, 1, -1},
                         {-1, -1, 0}};
        Assert.assertEquals(-1, CheckTheValue.checkCell(1, 0, board1));


        int[][] board2 = {{-1, -1, 1},
                          {1, 1, -1},
                          {-1, 1, 0}};
        Assert.assertEquals(0, CheckTheValue.checkCell(1, 0, board2));


    }



}
