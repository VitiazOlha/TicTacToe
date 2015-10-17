import java.util.Scanner;

public class ConsoleUserInputProvider implements AutoCloseable {
    private Scanner scanner;

    public ConsoleUserInputProvider() {
        this.scanner = new Scanner(System.in);
    }

    public GameType getGameType() {
        System.out.println("Chose the way of game: || PvP || PvC (Player move first) || CvP (Computer move first) || CvC ||");
        String gameType = scanner.nextLine();
        switch (gameType.toLowerCase()) {
            case "pvp":
                return GameType.PVP;
            case "cvc":
                return GameType.CVC;
            case "cvp":
                return GameType.CVP;
            case "pvc":
            default:
                return GameType.PVC;
        }
    }

    public int inputCoordinatesForNextHumanStep(char nameCoordinate) {
        while (true) {
            System.out.print("Enter " + nameCoordinate + " (1..3): ");
            try {
                int coordinate = scanner.nextInt();
                if ((coordinate > 0) && (coordinate <= 3)) {
                    return coordinate;
                } else if (coordinate == 0) {
                    System.exit(0);
                } else {

                    System.out.println("Invalid value");
                }
            } catch (Exception e) {
                System.out.println("You can use only digits from 1 to 3.");
            }
        }
    }

    public boolean restartGameCommandSend() {
        System.out.println("Do you want to play again? Enter yes or no");
        return scanner.nextLine()
                .toLowerCase()
                .equals("yes");
    }

    //todo exit command
    public boolean exitCommandSend() {
        return false;
    }

    @Override
    public void close() throws Exception {
        scanner.close();
    }
}
