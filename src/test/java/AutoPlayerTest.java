import org.junit.Assert;
import org.junit.Test;

public class AutoPlayerTest {
    @Test(timeout = 100)
    public void testMinMaxStart() throws Exception {
        AutoPlayer autoPlayer = new AutoPlayer();

        int[][] board =
                {{1, 0, -1},
                        {0, 0, 0},
                        {-1, 0, 1}};
        int[] coordinates = autoPlayer.minMaxStart(board);
        Assert.assertEquals(1, coordinates[0]);
        Assert.assertEquals(1, coordinates[1]);

        int[][] board1 =
                {{-1, -1, 0},
                        {0, 1, 0},
                        {0, 0, 0}};
        int[] coordinates1 = autoPlayer.minMaxStart(board1);
        Assert.assertEquals(0, coordinates1[0]);
        Assert.assertEquals(2, coordinates1[1]);

        int[][] board2 =
                {{1, 0, -1},
                        {0, 0, 0},
                        {1, 0, -1}};
        int[] coordinates2 = autoPlayer.minMaxStart(board2);
        Assert.assertEquals(1, coordinates2[0]);
        Assert.assertEquals(0, coordinates2[1]);
    }
}