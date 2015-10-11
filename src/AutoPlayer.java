/**
 * Created by admin on 11.10.2015.
 */
public class AutoPlayer extends DefaultPlayer
{
public static void ComputerMove()
{
    int x = (int) (Math.random() * 3), y = (int) (Math.random() * 3);
    while (Board[x][y] == -1 || Board[x][y] == 1) {
        x = (int) (Math.random() * 3);
        y = (int) (Math.random() * 3);
    }
    Board[x][y] = '0';

}

    @Override
    public boolean makeAMove() {
        return false;
    }

    @Override
    public boolean canMove() {
        return false;
    }

    public static char[][] algoritm(char [][] bordArray) {
        if ( bordArray[2][2] == 'X' && RAUND = 1 ) { bordArray[1][1] = 'O'; RAUND++}
            else if (bordArray[2][2] == '' && RAUND = 1) { bordArray[2][2] = 'O'; RAUND++}
        }

        }
    }
}
