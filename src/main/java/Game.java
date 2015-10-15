
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//todo write tests (Ilya)

public abstract class Game {

    private BoardStateAnalyzer boardStateAnalyzer;
    private GameState currentState;

    private static GameFactory gameFactory;
    protected Player player1;
    protected Player player2;
    private Board board;

    public Game(Player player1, Player player2, BoardStateAnalyzer boardStateAnalyzer) {
        this.player1 = player1;
        this.player2 = player2;
        this.boardStateAnalyzer = boardStateAnalyzer;
        this.currentState = GameState.NEW_GAME;
    }

    public void startNewGame() {
        while (!isOver()) {

            player1.doStep(board);
            currentState = boardStateAnalyzer.getNewGameState(board);

            if (!isOver()) {
                player2.doStep(board);
            }
        }


//        ===========================================================================

        int numOfPlayers = 2;
        Player[] players = new Player[numOfPlayers];

        try {
            chooseTypeGame(players);
            Board.cleanBoard();
            boolean flag = true;
            System.out.println(Board.convertToString());
            for (int i = 0; (i < 9) && flag; i++) {

                int whoIsMove = i % numOfPlayers;
                if (whoIsMove == 0) {
                    System.out.println(" \"X\" move now ");
                } else {
                    System.out.println(" \"O\" move now ");
                }
                System.out.println("If you want to exit-enter: \"0\"");
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

    protected abstract boolean isOver();

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
                    default:
                        System.out.println("Invalid input. Try again");
                        chooseTypeGame(players);
                }
                break;
                default:
                    System.out.println("Invalid input");
                    chooseTypeGame(players);

        }
    }

    public static String gameRestart() {
        System.out.println("Do you want to play again? Enter yes or no");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Created by admin on 15.10.2015.
     */
    public static enum GameState {
        NEW_GAME ,
        PENDING_GAME,
        DRAW,
        PLAYER1_WIN,
        PLAYER2_WIN,
    }
}