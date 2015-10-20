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

