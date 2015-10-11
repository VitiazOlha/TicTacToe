public class GameClass
{
    public static void main(String[] args) {
        startNewGame();
    }

    public static void startNewGame(){
        byte NUM_OF_PLAYERS = 2;
        DefaultPlayer [] players = new DefaultPlayer[NUM_OF_PLAYERS];
        players[0] = new HumanPlayer();
        players[1] = new HumanPlayer();
        Board.cleanBoard();


        boolean flag = true;
        for (int i = 0; (i < 9) && flag; i++) {
            players[i % NUM_OF_PLAYERS].makeAMove(i % NUM_OF_PLAYERS == 0? (byte)1 : (byte)(-1));
            Board.printBoard();



        }

    }
}
