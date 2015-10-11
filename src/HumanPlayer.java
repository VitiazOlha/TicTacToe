import java.util.Scanner;

/**
 * Created by admin on 11.10.2015.
 */
public class HumanPlayer extends DefaultPlayer
{

    public byte inputX(){
        while(true) {
            System.out.println("Enter X (1..3): ");
            Scanner scanner = new Scanner(System.in);
            byte x = scanner.nextByte();
            if ((x > 0) && (x <= 3)) return x;
            else System.out.println("Invalid value");
        }
    }

    public byte inputY(){
        while(true) {
            System.out.println("Enter Y (1..3): ");
            Scanner scanner = new Scanner(System.in);
            byte y = scanner.nextByte();
            if ((y > 0) && (y <= 3)) return y;
            else System.out.println("Invalid value");
        }
    }

    @Override
    public void makeAMove(byte value) {
        Board.getCoordinates(inputX(),inputY(), value);
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
