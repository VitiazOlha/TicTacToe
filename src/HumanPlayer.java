import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by admin on 11.10.2015.
 */
public class HumanPlayer extends DefaultPlayer
{
    @Override
    public boolean makeAmove() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Make your move. || Choose from 1 to 3 on X and Y coordinates.");
        String myMove = br.readLine();
        Byte myBestMove = Byte.parseByte(myMove);

        if ()

    }

    @Override
    public boolean makeAMove() {
        return false;
    }

    @Override
    public boolean canMove() {

    }
}
