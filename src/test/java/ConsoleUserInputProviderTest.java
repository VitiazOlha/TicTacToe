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


        value =  "PVP";

        assertEquals(String.valueOf(GameType.PVP), value);

        value = "PVC";

        assertEquals(String.valueOf(GameType.PVC), value);

        value = "CVC";

        assertEquals(String.valueOf(GameType.CVC), value);

        value = "CVP";

        assertEquals(String.valueOf(GameType.CVP), value);


    }
}