/**
 * Created by admin on 11.10.2015.
 */
public class Board {
    private static byte[][] field =
            {       {0, 0, 0},
                    {0, 0, 0},
                    {0, 0, 0}
            };

    //todo rewrite like toString(formating)
    public static void printBoard() {
        for ( int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j]);
            }
        }
            System.out.println();
    }

    public static void cleanBoard() {
        for ( int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                field[i][j] = 0;
    }

//todo rewrite value
    public static void getCoordinates(byte x, byte y,byte value) {
        field[x - 1][y - 1] = value;
    }
}

