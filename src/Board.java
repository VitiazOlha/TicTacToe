/**
 * Created by admin on 11.10.2015.
 */
public class Board {
    private static byte[][] field =
            {{0, 0, 0},
                    {0, 0, 0},
                    {0, 0, 0}
            };

    //todo rewrite like toString(formating)
    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    public static void cleanBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                field[i][j] = 0;
    }

    //todo rewrite value
    public static boolean getCoordinates(byte x, byte y, byte value) {
        if (field[x - 1][y - 1] != 0) {
            System.out.println("Sell is full, choose another position ");
            return false;
        } else {
            field[x - 1][y - 1] = value;
            return true;
        }
    }


}


