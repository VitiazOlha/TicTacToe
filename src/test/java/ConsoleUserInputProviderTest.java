import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ilya on 20.10.15.
 */
public class ConsoleUserInputProviderTest {



    @Test(timeout = 100)
    public void testGetGameType() throws Exception {

String value;

        value =  "pvp";

        assertEquals(GameType.PVP, value);

        value = "pvc";

        assertEquals(GameType.PVC, value);

        value = "cvc";

        assertEquals(GameType.CVC, value);

        value = "cvp";

        assertEquals(GameType.CVP, value);


    }
}