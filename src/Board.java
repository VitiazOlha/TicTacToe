public class Board {
    private static byte[][] field =
            {       {0, 0, 0},
                    {0, 0, 0},
                    {0, 0, 0}
            };

    public static void printBoard() {
        int i = 0;
        for (; i < 2; i++) {
            System.out.printf(" %c ║ %c ║ %c \n",makeSymbol(field[i][0]),makeSymbol(field[i][1]),makeSymbol(field[i][2]));
            System.out.println("═══╬═══╬═══");
        }
        System.out.printf(" %c ║ %c ║ %c \n",makeSymbol(field[i][0]),makeSymbol(field[i][1]),makeSymbol(field[i][2]));
    }

    public static char makeSymbol(byte value){
        switch (value){
            case 1: return 'X';
            case -1: return 'O';
            default: return ' ';
        }
    }


    public static void cleanBoard() {
        for ( int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                field[i][j] = 0;
    }

    public static boolean getCoordinates(byte x, byte y,byte value) {
        if (field[x - 1][y - 1] != 0)
        {
            System.out.println("Sell is full, choose another position ");
            return false;
        }
        else{
            field[x - 1][y - 1] = value;
            return true;
        }
    }
}

