import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
//todo write tests (Ilya)

public class Game {
    public static void startNewGame() {
        int numOfPlayers = 2;
        Player[] players = new Player[numOfPlayers];
        players[0] = new HumanPlayer();
        players[1] = new HumanPlayer();

        try {
            chooseTypeGame(players);
            Board.cleanBoard();
            //todo exit from game if player paste exit
            boolean flag = true;
            for (int i = 0; (i < 9) && flag; i++) {
                JTextField textField = new JTextField();
                textField.addKeyListener(new KeyAdapter() {public void keyPressed(KeyEvent e) {}
                });
                if (textField.equals(0x20)) break;
                int whoIsMove = i % numOfPlayers;
                if (whoIsMove == 0) {
                    System.out.println(" \"X\" move now ");
                } else {
                    System.out.println(" \"O\" move now ");
                }

                int winnerFlag = players[whoIsMove].makeAMove(whoIsMove * (-2) + 1);// 0 -> 1; 1 -> -1
                System.out.println(Board.convertToString());
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

    private static void chooseTypeGame(Player[] players) throws IOException {
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
    }

    public static String gameRestart() {
        System.out.println("Do you want to play again? Enter yes or no");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}