import java.util.Scanner;

/**
 * TODO Implement retrieving commands from console
 */
public class ConsoleUserInputProvider implements AutoCloseable{
    private Scanner scanner;

    public ConsoleUserInputProvider() {
        this.scanner = new Scanner(System.in);
    }

    public GameType getGameType() {
        return GameType.PVC;
    }

    public boolean exitCommandSend() {
        return false;
    }

    @Override
    public void close() throws Exception {
        scanner.close();
    }

    public boolean restartGameCommandSend() {
        return false;
    }
}
