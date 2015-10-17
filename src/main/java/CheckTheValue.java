public class CheckTheValue {
    final static int N = 3;

    public static int checkCell(int row, int column, int[][] field) {
        int res = checkRow(row, field);
        res += checkColumn(column, field);
        if (row == column) {
            res += checkMainDiagonal(field);
        }
        if (row == N - 1 - column) {
            res += checkSideDiagonal(field);
        }
        if (res == 0) {
            return 0;
        } else if (res > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    private static int checkRow(int row, int[][] field) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += field[row][i];
        }
        if (Math.abs(sum) == N) {
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
        if (Math.abs(sum) == N) {
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
        if (Math.abs(sum) == N) {
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
        if (Math.abs(sum) == N) {
            return sum;
        } else {
            return 0;
        }
    }
}
