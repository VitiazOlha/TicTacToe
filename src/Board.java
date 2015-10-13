public class Board {
    private static int[][] field = new int[3][3];
    final static int N = 3;

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
        return checkCell(x,y,field);
    }

    private static int checkCell(int row, int column, int[][] field) {
        int res = checkRow(row, field);
        res += checkColumn(column, field);
        if (row == column) {
            res += checkMainDiagonal(field);
        }
        if (row == N - 1 - column) {
            res += checkSideDiagonal(field);
        }
        return res / 3;
    }

    private static int checkRow(int row, int[][] field) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += field[row][i];
        }
        if (Math.abs(sum) == 3) {
            return sum;
        } else {
            return 0;
        }
    }

    private static int checkColumn(int column, int[][] field) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += field[i][column];
        }
        if (Math.abs(sum) == 3) {
            return sum;
        } else {
            return 0;
        }
    }

    private static int checkMainDiagonal(int[][] field) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += field[i][i];
        }
        if (Math.abs(sum) == 3) {
            return sum;
        } else {
            return 0;
        }
    }

    private static int checkSideDiagonal(int[][] field) {
        int sum = 0;
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