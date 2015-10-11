import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends DefaultPlayer
{
    @Override
    public Byte makeAmove() throws IOException
    {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Make your move. || Choose from 1 to 3 on X and Y coordinates.");
        try {
            String myMove = br.readLine();
            Byte myBestMove = Byte.parseByte(myMove);
            if (myBestMove <= 0 || myBestMove >= 3 ) {
            }
        }
        catch ()...

    }

    @Override
    public boolean makeAMove() {
        return false;
    }

    @Override
    public boolean canMove() {

    }
}
