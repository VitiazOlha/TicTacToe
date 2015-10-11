/**
 * Created by admin on 11.10.2015.
 */
public class Board {
    public static byte[][] Field =
            {       {'0', '0', '0'},
                    {'0', '0', '0'},
                    {'0', '0', '0'}
            };

    public static void PrintField() {
        for ( int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(Field[i][j]);
            }
            System.out.println();
        }

    }
}