public class AutoPlayer extends Player {
    final static int N = 3;
    final static int DEPTH = 5;
    private int[][] oldField = new int[N][N];

    //todo add depth of analiz alhoritm

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
                    int newMax = maxMove(x, y, oldField, DEPTH);
                    if (newMax > max) {
                        max = newMax;
                        bestX = x;
                        bestY = y;
                    }
                }
            }
        }
        Board.setCoordinates(bestX, bestY, value);
        return Board.checkWinner(bestX, bestY);
    }

    private int maxMove(int row, int column, int[][] field, int depth) {
        field[row][column] = 1;
        int max = Integer.MIN_VALUE;
        if (depth > 0) {
            if (CheckTheValue.checkCell(row, column, field) == 0) {
                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        if (field[x][y] == 0) {
                            int newMax = minMove(x, y, field, depth - 1);
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
        } else {
            return 0;
        }
    }

    private int minMove(int row, int column, int[][] field, int depth) {
        field[row][column] = -1;
        int min = Integer.MAX_VALUE;
        if (depth > 0) {
            if (CheckTheValue.checkCell(row, column, field) == 0) {
                for (int x = 0; x < N; x++) {
                    for (int y = 0; y < N; y++) {
                        if (field[x][y] == 0) {
                            int newMin = maxMove(x, y, field, depth - 1);
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
        } else {
            return 0;
        }
    }
}