public class AutoPlayer extends Player {
    final static byte N = 3;
    private byte[][] oldField = new byte[N][N];

    private void copyBoard(byte value) {
        for (byte x = 0; x < 3; x++) {
            for (byte y = 0; y < 3; y++) {
                oldField[x][y] = (byte) (value * Board.getCoordinates(x, y));
            }
        }
    }

    @Override
    public byte makeAMove(byte value) {
        copyBoard(value);
        byte bestX = -1, bestY = -1, max = -100;
        for (byte x = 0; x < N; x++) {
            for (byte y = 0; y < N; y++) {
                if (oldField[x][y] == 0) {
                    byte newMax = maxMove(x, y, oldField);
                    if (newMax >= max) {
                        max = newMax;
                        bestX = x;
                        bestY = y;
                    }
                }
            }
        }
        Board.setCoordinates((byte) (bestX + 1), (byte) (bestY + 1), value);
        return 0;
    }

    private byte maxMove(byte row, byte column, byte[][] field) {
        field[row][column] = 1;
        byte max = -100;
        if (checkCell(row, column, field) == 0) {
            for (byte x = 0; x < N; x++) {
                for (byte y = 0; y < N; y++) {
                    if (field[x][y] == 0) {
                        byte newMax = minMove(x, y, field);
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

    private byte minMove(byte row, byte column, byte[][] field) {
        field[row][column] = -1;
        byte min = 100;
        if (checkCell(row, column, field) == 0) {
            for (byte x = 0; x < N; x++) {
                for (byte y = 0; y < N; y++) {
                    if (field[x][y] == 0) {
                        byte newMin = maxMove(x, y, field);
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

    private byte checkCell(byte row, byte column, byte[][] field) {
        byte sum = 0;
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

    private byte checkRow(byte row, byte[][] field) {
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

    private byte checkColumn(byte column, byte[][] field) {
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

    private byte checkMainDiagonal(byte[][] field) {
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

    private byte checkSideDiagonal(byte[][] field) {
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