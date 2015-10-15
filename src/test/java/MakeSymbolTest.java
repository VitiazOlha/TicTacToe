import org.junit.Assert;
import org.junit.Test;
import sun.invoke.empty.Empty;

import static org.junit.Assert.*;

/*
 * Created by admin on 15.10.2015.
 */
public class MakeSymbolTest {

    @Test(timeout = 100)
    public void testMakeSymbol() throws Exception {

        int value = -1;
        Assert.assertEquals('O',Board.makeSymbol(value));

        int value1 = 1;
        Assert.assertEquals('X', Board.makeSymbol(value1));

        int value2 = 5;
        Assert.assertEquals(' ', Board.makeSymbol(value2));

        int value3 = -99;
        Assert.assertEquals(' ', Board.makeSymbol(value3));

        int value4 = Integer.parseInt(null);
        Assert.assertEquals(' ', Board.makeSymbol(value4));

        int value5 = (int) -99.6;
        Assert.assertEquals(' ', Board.makeSymbol(value5));





    }
}