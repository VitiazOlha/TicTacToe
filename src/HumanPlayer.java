import java.util.Scanner;

public class HumanPlayer extends Player {
    //todo ! if exception is avaliable, code stops working !
    private byte inputValue(char nameCoordinate) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter " + nameCoordinate + " (1..3): ");
            try {
                byte coordinate = scanner.nextByte();
                if ((coordinate > 0) && (coordinate <= 3)) {
                    //scanner.close(); //code not worked with this string
                    return coordinate;
                } else {
                    System.out.println("Invalid value");
                }
            } catch (Exception e) {
                System.out.println("You can use only digits from 1 to 3.");
            }
        }
    }

    @Override
    public void makeAMove(byte value) {
        byte x, y;
        do {
            x = inputValue('X');
            y = inputValue('Y');
        } while (Board.isPossibleToMove(x, y));
        Board.getCoordinates(x, y, value);
    }
}
