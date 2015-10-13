public class AutoPlayer extends Player {
    final static byte N = 3;
    private byte[][] field = new byte[N][N];

    private void copyBoard(byte value) {
        for (byte x = 0; x < 3; x++) {
            for (byte y = 0; y < 3; y++) {
                field[x][y] = (byte) (value * Board.getCoordinates(x, y));
            }
        }
    }

    @Override
    public void makeAMove(byte value) {
        copyBoard(value);
        byte bestX = -1, bestY = -1;
        for (byte x = 0; x < N; x++) {
            for (byte y = 0; y < N; y++) {
                byte max = -5;
                if (field[x][y] == 0) {
                    byte newMax = maxMove();
                    if (newMax > max){
                        max = newMax;
                        bestX = x;
                        bestY = y;
                    }
                }
            }
        }
        Board.setCoordinates(bestX, bestY, value);
    }

    private byte maxMove() {


        return 0;
    }

    private byte minMove() {


        return 0;
    }

    private byte checkRow(byte value) {//ряд
        for (int i = 0; i < N; i++) {

        }
        return 0;
    }

    private byte checkColumn(byte value) {//столбец
        for (int i = 0; i < N; i++) {

        }
        return 0;
    }

    private byte checkMainDiagonal() {

        return 0;
    }

    private byte checkSideDiagonal() {

        return 0;
    }





}

