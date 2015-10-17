public class AutoPlayer implements Player {
    final static int N = 3;
    private int[][] oldField = new int[N][N];

    private void copyField(int[][] field, int[][] oldField) {
        for (int x = 0; x < N; x++) {
            field[x] = oldField[x].clone();
        }
    }

    private void copyBoard(Board board, int value) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                this.oldField[x][y] = value * board.getFieldValue(x, y);
            }
        }
    }

    @Override
    public void doStep(Board board, int value) {
        copyBoard(board, value);
        int[] moveCoordinate;
        moveCoordinate = minMaxAlgorithm();
        board.setFieldValue(moveCoordinate[0], moveCoordinate[1], value);
        System.out.print(board.convertToString());
    }

    private int[] minMaxAlgorithm() {
        int bestX = -1;
        int bestY = -1;
        int max = Integer.MIN_VALUE;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (oldField[x][y] == 0) {
                    int newMax = minMax(x, y, oldField, 1);
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

    private int minMax(int row, int column, int[][] oldField,int value) {
        int[][] field = new int[N][N];
        copyField(field, oldField);
        field[row][column] = value;
        int score = Integer.MAX_VALUE * value;
        if (CheckTheValue.checkCell(row, column, field) == 0) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (field[x][y] == 0) {
                        int newScore = minMax(x, y, field, -1 * value);
                        if (newScore * value < score * value) {
                            score = newScore;
                        }
                    }
                }
            }
            if (score == Integer.MAX_VALUE * value) {
                return 0;
            } else {
                return score;
            }
        } else {
            return value;
        }
    }
}