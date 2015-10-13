public class Board {
    private static int[][] field = new int[3][3];

    //todo rewrite like toString(formating) !!!! REWRITE !!!!
    public static String convertToString() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (; i < 2; i++) {
            builder.append(String.format(" %c # %c # %c \n", makeSymbol(field[i][0]), makeSymbol(field[i][1]), makeSymbol(field[i][2])));
            builder.append("###########\n");
        }
        builder.append(String.format(" %c # %c # %c \n", makeSymbol(field[i][0]), makeSymbol(field[i][1]), makeSymbol(field[i][2])));
        return builder.toString();
    }

    public static char makeSymbol(int value) {
        switch (value) {
            case 1:
                return 'X';
            case -1:
                return 'O';
            default:
                return ' ';
        }
    }

    public static void cleanBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = 0;
            }
        }
    }

    public static boolean isPossibleToMove(int x, int y) {
        if (field[x - 1][y - 1] == 0) {
            return false;
        } else {
            System.out.println("Sell is full, choose another position ");
            return true;
        }
    }

    public static void setCoordinates(int x, int y, int value) {
        field[x][y] = value;
    }

    public static int getCoordinates(int x, int y) {
        return field[x][y];
    }

    public static int checkWinner(int x, int y) {
        return CheckTheValue.checkCell(x,y,field);
    }
}