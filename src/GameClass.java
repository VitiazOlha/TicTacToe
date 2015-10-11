/**
 * Created by admin on 11.10.2015.
 */
public class GameClass
{
    public static void main(String[] args) {
        byte N = 2;
        DefaultPlayer [] players = new DefaultPlayer[N];
        players[0] = new HumanPlayer();
        players[1] = new AutoPlayer();
        startNewGame(players);


    }


    public static void startNewGame(DefaultPlayer[] players){
        boolean flag = true;
        for (int i = 0; (i < 9) && flag; i++) {
            flag = players[i % 2].makeAMove();
        }

    }
}
