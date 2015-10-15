/**
 * Created by Сергей on 14.10.2015.
 */
public class GameRunner {
    public static void main(String[] args) {

        try (ConsoleUserInputProvider userInputProvider = new ConsoleUserInputProvider()){
            do {
                Game game = GameFactory.createGame(userInputProvider);
                game.startNewGame();
            } while (userInputProvider.restartGameCommandSend());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

