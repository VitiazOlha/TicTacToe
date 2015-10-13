public class Board {
    private static byte[][] field = new byte[3][3];
    final static byte N = 3;

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

    public static char makeSymbol(byte value) {
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

    public static boolean isPossibleToMove(byte x, byte y) {
        if (field[x - 1][y - 1] == 0) {
            return false;
        } else {
            System.out.println("Sell is full, choose another position ");
            return true;
        }
    }

    public static void setCoordinates(byte x, byte y, byte value) {
        field[x][y] = value;
    }

    public static byte getCoordinates(byte x, byte y) {
        return field[x][y];
    }

    public static byte checkWinner(byte x, byte y) {
        return checkCell(x,y,field);
    }

    private static byte checkCell(byte row, byte column, byte[][] field) {
        byte res = checkRow(row, field);
        res += checkColumn(column, field);
        if (row == column) {
            res += checkMainDiagonal(field);
        }
        if (row == N - 1 - column) {
            res += checkSideDiagonal(field);
        }
        return (byte)(res / 3);
    }

    private static byte checkRow(byte row, byte[][] field) {
        byte sum = 0;
        for (int i = 0; i < N; i++) {
            sum += field[row][i];
        }
        if (Math.abs(sum) == 3) {
            return sum;
        } else {
            return 0;
        }
    }

    private static byte checkColumn(byte column, byte[][] field) {
        byte sum = 0;
        for (int i = 0; i < N; i++) {
            sum += field[i][column];
        }
        if (Math.abs(sum) == 3) {
            return sum;
        } else {
            return 0;
        }
    }

    private static byte checkMainDiagonal(byte[][] field) {
        byte sum = 0;
        for (int i = 0; i < N; i++) {
            sum += field[i][i];
        }
        if (Math.abs(sum) == 3) {
            return sum;
        } else {
            return 0;
        }
    }

    private static byte checkSideDiagonal(byte[][] field) {
        byte sum = 0;
        for (int i = 0; i < N; i++) {
            sum += field[i][N - 1 - i];
        }
        if (Math.abs(sum) == 3) {
            return sum;
        } else {
            return 0;
        }
    }
}