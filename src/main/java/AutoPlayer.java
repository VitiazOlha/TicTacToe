public class AutoPlayer implements Player {
    final static int N = 3;
    private int[][] oldField = new int[N][N];

    @Override
    public void doStep(Board board, int value) {
        copyBoard(board, value);
        int[] moveCoordinate;
        moveCoordinate = minMaxAlgorithm();
        board.setFieldValue(moveCoordinate[0], moveCoordinate[1], value);
        System.out.print(board.convertToString());
        // TODO implement putting symbol by min-max algorithm
    }

    private void copyBoard(Board board, int value) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                this.oldField[x][y] = value * board.getFieldValue(x, y);
            }
        }
    }

    private int[] minMaxAlgorithm() {
        int bestX = -1;
        int bestY = -1;
        int max = Integer.MIN_VALUE;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (oldField[x][y] == 0) {
                    int newMax = maxMove(x, y, oldField);
                    if (newMax >= max) {
                        max = newMax;
                        bestX = x;
                        bestY = y;
                    }
                }
            }
        }
        return new int[]{bestX, bestY};
    }

    private int maxMove(int row, int column, int[][] oldField) {
        int[][] field = new int[N][N];
        copyField(field, oldField);
        field[row][column] = 1;
        int max = Integer.MAX_VALUE;
        if (CheckTheValue.checkCell(row, column, field) == 0) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (field[x][y] == 0) {
                        int newMax = minMove(x, y, field);
                        if (newMax < max) {
                            max = newMax;
                        }
                    }
                }
            }
            if (max == Integer.MAX_VALUE) {
                return 0;
            } else {
                return max;
            }
        } else {
            return 1;
        }
    }

    private int minMove(int row, int column, int[][] oldField) {
        int[][] field = new int[N][N];
        copyField(field, oldField);
        field[row][column] = -1;
        int min = Integer.MIN_VALUE;
        if (CheckTheValue.checkCell(row, column, field) == 0) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (field[x][y] == 0) {
                        int newMin = maxMove(x, y, field);
                        if (newMin > min) {
                            min = newMin;
                        }
                    }
                }
            }
            if (min == Integer.MIN_VALUE) {
                return 0;
            } else {
                return min;
            }
        } else {
            return -1;
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