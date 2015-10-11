/**
 * Created by admin on 11.10.2015.
 */
public class Board {
    public static char[][] Field =
            {{'+', '+', '+'},
                    {'+', '+', '+'},
                    {'+', '+', '+'}};

    public static void PrintField() {
        int i;
        for (i = 0; i < 3; i++) {
            int j;
            for (j = 0; j < 3; j++) {
                System.out.print(Field[i][j]);
            }
            System.out.println();
        }

    }
}