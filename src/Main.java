/**
 * Created by Сергей on 14.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        do {
            Game.startNewGame();
        } while (Game.gameRestart().equals("yes"));

    }
}

