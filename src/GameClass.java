import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        for (int i = 0; (i < 9) && flag; i++) {
            players[i % NUM_OF_PLAYERS].makeAMove((byte) (i % NUM_OF_PLAYERS == 0 ? 1 : (-1)));
            System.out.println(Board.printBoard());
            byte winnerFlag = Board.checkGame();
            if (winnerFlag != 0) {
                flag = false;
                if (winnerFlag == 1)  System.out.println("X winner");
                else System.out.println("O winner");
            }
            if (winnerFlag != 0){
                System.out.println("Do you want to play again? Enter yes or no");
                String y = sc.nextLine();
                if (y.equals("yes"))
                {
                    startNewGame();
                } else break;
            }
        }


    }
}
