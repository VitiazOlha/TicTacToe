import org.junit.Assert;
import org.junit.Test;


public class MakeSymbolTest {

    @Test(timeout = 100)
    public void testMakeSymbol() throws Exception {
        int value = -1;
        Assert.assertEquals('O', Board.makeSymbol(value));

        value = 1;
        Assert.assertEquals('X', Board.makeSymbol(value));

        value = 0;
        Assert.assertEquals(' ', Board.makeSymbol(value));

        value = Integer.MAX_VALUE;
        Assert.assertEquals(' ', Board.makeSymbol(value));

        value = Integer.MIN_VALUE;
        Assert.assertEquals(' ', Board.makeSymbol(value));
    }
}