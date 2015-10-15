import java.util.Scanner;

public class HumanPlayer extends Player {
    //todo ! if exception is avaliable, code stops working !
    private int inputValue(char nameCoordinate) {
        //Scanner scanner = new Scanner(System.in);// if scanner here code stop working
        while (true) {
            Scanner scanner = new Scanner(System.in);// if scanner here code working
            System.out.print("Enter " + nameCoordinate + " (1..3): ");
            try {
                int coordinate = scanner.nextInt();
                if ((coordinate > 0) && (coordinate <= 3)) {
                    //scanner.close(); //code not worked with this string
                    return coordinate;
                } else if (coordinate == 9) {
                    break;
                } else if (coordinate == 0) {
                    System.exit(0);
                }else {
                } System.out.println("Invalid value");

            } catch (Exception e) {
                System.out.println("You can use only digits from 1 to 3.");
            }
        }
        return 0;
    }

    @Override
    public int makeAMove(int value) {
        int x, y;
        do {
            x = inputValue('X');
            y = inputValue('Y');
        } while (Board.isPossibleToMove(x, y));
        Board.setCoordinates(x - 1, y - 1, value);
        return Board.checkWinner(x - 1, y - 1);
    }


}
