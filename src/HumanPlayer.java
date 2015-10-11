import java.util.Scanner;

public class HumanPlayer extends DefaultPlayer
{

    public byte inputX(){
        while(true) {
            System.out.println("Enter X (1..3): ");
            Scanner scanner = new Scanner(System.in);
            try {
                byte x = scanner.nextByte();
                if ((x > 0) && (x <= 3)) return x;
                else System.out.println("Invalid value");
            } catch (Exception e) {
                System.out.println("You can use only digits from 1 to 3.");
            }

        }
    }

    public byte inputY(){
        while(true) {
            System.out.println("Enter Y (1..3): ");
            Scanner scanner = new Scanner(System.in);
            try {
                byte y = scanner.nextByte();
                if ((y > 0) && (y <= 3)) return y;
                else System.out.println("Invalid value");
            } catch (Exception e) {
                System.out.println("You can use only digits from 1 to 3.");
            }
        }
    }

    @Override
    public void makeAMove(byte value) {

        while(!Board.getCoordinates(inputX(),inputY(), value));
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
