public class Board {
    private static byte[][] field = new byte[3][3];


    //todo rewrite like toString(formating) !!!! REWRITE !!!!
    public static String printBoard() {
        StringBuilder builder = new StringBuilder();

        int i = 0;
        for (; i < 2; i++) {
            builder.append(String.format(" %c ║ %c ║ %c \n", makeSymbol(field[i][0]), makeSymbol(field[i][1]), makeSymbol(field[i][2])));
            builder.append("═══╬═══╬═══\n");
        }
        builder.append(String.format(" %c ║ %c ║ %c \n", makeSymbol(field[i][0]), makeSymbol(field[i][1]), makeSymbol(field[i][2])));
        return builder.toString();
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
    public static byte checkGame() {
        byte winner = 0;
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == field[i][1] && field[i][1] == field[i][2]) {
                winner = field[i][0];
            } else if (field[0][i] == field[1][i] && field[1][i] == field[2][i]) {
                winner = field[0][i];
            }
        }
        if (winner == 0) {
            if (field[0][0] == field[1][1] && field[1][1] == field[2][2]) {
                winner = field[0][0];
            } else if (field[0][2] == field[1][1] && field[1][1] == field[2][0]) {
                winner = field[0][2];
            }

        }
        return winner;

    }
}

