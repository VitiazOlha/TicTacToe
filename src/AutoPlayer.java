public class AutoPlayer extends Player {
    final static int N = 3;
    private int[][] oldField = new int[N][N];

    private void copyBoard(int value) {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                oldField[x][y] = value * Board.getCoordinates(x, y);
            }
        }
    }

    @Override
    public int makeAMove(int value) {
        copyBoard(value);
        int bestX = -1;
        int bestY = -1;
        int max = -100;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (oldField[x][y] == 0) {
                    int newMax = maxMove(x, y, oldField);
                    if (newMax > max) {
                        max = newMax;
                        bestX = x;
                        bestY = y;
                    }
                }
            }
        }
        Board.setCoordinates(bestX, bestY, value);
        return 0;
    }

    private int maxMove(int row, int column, int[][] field) {
        field[row][column] = 1;
        int max = -100;
        if (checkCell(row, column, field) == 0) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (field[x][y] == 0) {
                        int newMax = minMove(x, y, field);
                        if (newMax >= max) {
                            max = newMax;
                        }
                    }
                }
            }
            if (max == -100) {
                return 0;
            } else {
                return max;
            }
        } else {
            return 1;
        }
    }

    private int minMove(int row, int column, int[][] field) {
        field[row][column] = -1;
        int min = 100;
        if (checkCell(row, column, field) == 0) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (field[x][y] == 0) {
                        int newMin = maxMove(x, y, field);
                        if (newMin <= min) {
                            min = newMin;
                        }
                    }
                }
            }
            if (min == 100) {
                return 0;
            } else {
                return min;
            }
        } else {
            return -1;
        }
    }

    private int checkCell(int row, int column, int[][] field) {
        int sum = 0;
        sum += checkRow(row, field);
        sum += checkColumn(column, field);
        if (row == column) {
            sum += checkMainDiagonal(field);
        }
        if (row == N - 1 - column) {
            sum += checkSideDiagonal(field);
        }
        return sum;
    }

    private int checkRow(int row, int[][] field) {
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

    private int checkColumn(int column, int[][] field) {
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

    private int checkMainDiagonal(int[][] field) {
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

    private int checkSideDiagonal(int[][] field) {
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