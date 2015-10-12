import java.util.Scanner;

//todo write tests (Ilya)

public class Game {
    public static void main(String[] args) {
        startNewGame();
    }

    public static void startNewGame() {
        byte numOfPlayers = 2;
        Player[] players = new Player[numOfPlayers];
        //todo Add player choose (Sergey)
        players[0] = new HumanPlayer();
        players[1] = new HumanPlayer();
        Board.cleanBoard();
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        for (int i = 0; (i < 9) && flag; i++) {
            byte whoIsMove = (byte) (i % numOfPlayers);
            if (whoIsMove == 0) {
                System.out.println(" \"X\" move now ");
            } else {
                System.out.println(" \"O\" move now ");
            }
            players[whoIsMove].makeAMove((byte) (whoIsMove * (-2) + 1));// 0 -> 1; 1 -> -1
            System.out.println(Board.convertToString());
            byte winnerFlag = Board.checkWinner();
            if (winnerFlag != 0) {
                flag = false;
                if (winnerFlag == 1) {
                    System.out.println("X winner");
                } else {
                    System.out.println("O winner");
                }
            } else  if(i == 8){
                System.out.println("It's a draw");
            }
            //todo rewrite if draw now it don`t works (Maksim)
            if (winnerFlag != 0 || i==8) {
                System.out.println("Do you want to play again? Enter yes or no");
                String y = sc.nextLine();
                if (y.equals("yes")) {
                    startNewGame();
                } else {
                    break;
                }
            }
        }
    }
}
