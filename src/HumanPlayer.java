import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends DefaultPlayer
{
    @Override
    public boolean makeAmove () throws IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Make your move. || Choose from 1 to 3 on X and Y coordinates.");
        if (makeAmove())

    }





}
