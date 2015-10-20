import org.junit.Assert;
import org.junit.Test;

public class CheckTheValueTest {

    @Test(timeout = 100)
    public void testCheckCell() throws Exception {
        int[][] field = {{1, -1, 1},
                {1, -1, 1},
                {1, 0, 0}};
        Assert.assertEquals(1, CheckTheValue.checkCell(2, 0, field));
        int[][] field2 = {{1, -1, 1},
                {1, -1, 1},
                {0, -1, 0}};
        Assert.assertEquals(-1, CheckTheValue.checkCell(2, 1, field2));
        int[][] field3 = {{1, -1, 1},
                {1, -1, 1},
                {0, 0, 0}};
        Assert.assertEquals(0, CheckTheValue.checkCell(1, 1, field3));
        // ================================================================
        int[][] field4 = {{1, 1, 1},
                {1, -1, 1},
                {0, 0, 0}};
        Assert.assertEquals(3, CheckTheValue.checkRow(0, field4));
        int[][] field5 = {{1, -1, -1},
                {-1, -1, -1},
                {0, 0, 0}};
        Assert.assertEquals(-3, CheckTheValue.checkRow(1, field5));
        int[][] field6 = {{0, -1, -1},
                {1, 1, -1},
                {0, 0, 0}};
        Assert.assertEquals(0, CheckTheValue.checkRow(0, field6));
        //================================================================
        int[][] field7 = {{1, 1, 0},
                {1, -1, 1},
                {1, 0, 0}};
        Assert.assertEquals(3, CheckTheValue.checkColumn(0, field7));
        int[][] field8 = {{1, -1, -1},
                {-1, -1, 0},
                {0, -1, 0}};
        Assert.assertEquals(-3, CheckTheValue.checkColumn(1, field8));
        int[][] field9 = {{1, -1, -1},
                {1, 1, -1},
                {0, 0, 0}};
        Assert.assertEquals(0, CheckTheValue.checkColumn(0, field9));
        //==================================================================
        int[][] field10 = {{1, -1, 0},
                {-1, 1, -1},
                {0, 0, 1}};
        Assert.assertEquals(3, CheckTheValue.checkMainDiagonal(field10));
        int[][] field11 = {{-1, 1, 1},
                {1, -1, 0},
                {0, 1, -1}};
        Assert.assertEquals(-3, CheckTheValue.checkMainDiagonal(field11));
        int[][] field12 = {{1, -1, -1},
                {1, 1, -1},
                {0, 0, 0}};
        Assert.assertEquals(0, CheckTheValue.checkMainDiagonal(field12));
        //==================================================================
        int[][] field13 = {{0, -1, 1},
                {-1, 1, -1},
                {1, 0, -1}};
        Assert.assertEquals(3, CheckTheValue.checkSideDiagonal(field13));
        int[][] field14 = {{1, 1, -1},
                {1, -1, 0},
                {-1, 1, 0}};
        Assert.assertEquals(-3, CheckTheValue.checkSideDiagonal(field14));
        int[][] field15 = {{1, -1, -1},
                {1, -1, 1},
                {0, 0, 0}};
        Assert.assertEquals(0, CheckTheValue.checkMainDiagonal(field15));
    }

}