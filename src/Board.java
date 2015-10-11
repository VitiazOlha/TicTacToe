/**
 * Created by admin on 11.10.2015.
 */
public class Board {
    public static byte[][] field =
            {       {0, 0, 0},
                    {0, 0, 0},
                    {0, 0, 0}
            };

    //todo rewrite like toString(formating)
    public void printBoard() {
        for ( int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j]);
            }
        }
            System.out.println();
    }

    public void getCooedinates(byte x, byte y, byte value) {
        field[x][y] = value;
    }
}

