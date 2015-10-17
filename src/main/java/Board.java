public class Board {
    private int[][] field;
    final static int N = 3;

    public Board() {
        this.field = new int[N][N];
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

    public String convertToString() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (; i < 2; i++) {
            builder.append(String.format(" %c | %c | %c \n",
                    makeSymbol(field[i][0]),
                    makeSymbol(field[i][1]),
                    makeSymbol(field[i][2])));
            builder.append("---+---+---\n");
        }
        builder.append(String.format(" %c | %c | %c \n",
                makeSymbol(field[i][0]),
                makeSymbol(field[i][1]),
                makeSymbol(field[i][2])));
        return builder.toString();
    }

    public boolean isPossibleToMove(int x, int y) {
        if (field[x - 1][y - 1] == 0) {
            return false;
        } else {
            System.out.println("Sell is full, choose another position ");
            return true;
        }
    }

    public void setFieldValue(int x, int y, int value) {
        field[x][y] = value;
    }

    public int getFieldValue(int x, int y) {
        return field[x][y];
    }
}