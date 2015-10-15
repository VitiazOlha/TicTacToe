public class AutoPlayer extends Player {
    final static int N = 3;
    final static int DEPTH = 3;
    private int[][] oldField = new int[N][N];

    //todo add depth of analiz alhoritm

    //todo hardcode for first 3 moves
    private int[] hardCode() {
        if (oldField[1][1] == 0) {
            return new int[]{1, 1};
        } else if (oldField[0][0] == 0) {
            return new int[]{0, 0};
        } else if (oldField[0][2] == 0) {
            return new int[]{0, 2};
        } else {
            return new int[]{2, 0};
        }
    }

    private int copyBoard(int value) {
        int filledCells = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                oldField[x][y] = value * Board.getCoordinates(x, y);
                if (oldField[x][y] != 0) filledCells++;
            }
        }
        return filledCells;
    }

    @Override
    public int makeAMove(int value) {
        int getMoveCounter = copyBoard(value);
        int[] moveCoordinate;
        if (getMoveCounter < 3) {
            moveCoordinate = hardCode();
        } else {
            moveCoordinate = minMaxAlgorithm();
        }

        Board.setCoordinates(moveCoordinate[0], moveCoordinate[1], value);
        return Board.checkWinner(moveCoordinate[0], moveCoordinate[1]);
    }

    private int[] minMaxAlgorithm() {
        int bestX = -1;
        int bestY = -1;
        int max = Integer.MAX_VALUE;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (oldField[x][y] == 0) {
                    int newMax = minMove(x, y, oldField, DEPTH);
                    //System.out.println(newMax);
                    if (newMax < max) {
                        max = newMax;
                        bestX = x;
                        bestY = y;
                    }
                }
            }
        }
        return new int[]{bestX, bestY};
    }

    private int maxMove(int row, int column, int[][] oldField, int depth) {
        int[][] field = new int[N][N];
        copyField(field, oldField);
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
                if (max == Integer.MIN_VALUE) {
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

    private int minMove(int row, int column, int[][] oldField, int depth) {
        int[][] field = new int[N][N];
        copyField(field, oldField);
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
                if (min == Integer.MAX_VALUE) {
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

    private void copyField(int[][] field, int[][] oldField) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                field[x][y] = oldField[x][y];
            }
        }

    }
}