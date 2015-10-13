import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        try {
            String gameType = gameTypeCatch();
            switch (gameType) {
                case "PvP":
                    players[0] = new HumanPlayer();
                    players[1] = new HumanPlayer();
                    break;
                case "CvC":
                    players[0] = new AutoPlayer();
                    players[1] = new AutoPlayer();
                    break;
                case "PvC":
                    String chooseWhoFirst = pVC();
                    switch (chooseWhoFirst) {
                        case "C":
                            players[0] = new AutoPlayer();
                            players[1] = new HumanPlayer();
                            break;
                        case "Me":
                            players[0] = new HumanPlayer();
                            players[1] = new AutoPlayer();
                            break;
                    }
                    break;
            }


            Board.cleanBoard();
            Scanner sc = new Scanner(System.in);
            //todo exit from game if player paste exit
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
                } else if (i == 8) {
                    System.out.println("It's a draw");
                }
                //todo rewrite if draw now it don`t works (Maksim)
                if (winnerFlag != 0 || i == 8) {
                    System.out.println("Do you want to play again? Enter yes or no");
                    String yes = sc.nextLine();
                    if (yes.equals("yes")) {
                        startNewGame();
                    } else {
                        break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String gameTypeCatch() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Chose the way of game: || PvP || PvC || CvC ||");
        String answer = br.readLine();
        return answer;
    }

    private static String pVC() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Chose who makes a first move: I make a first move (Me) || Computer makes a first move (C)");
        String answer = br.readLine();
        return answer;
    }

}
