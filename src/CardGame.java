import java.util.List;
import java.util.Scanner;
/**
 * @author: Xinlong Zhang,Xudong Gao
 * @className: CardGame
 * @description: This is an abstract class of the card game.
 **/
//General card game class for all types card game
public abstract class CardGame {
    //list of players
    protected List<? extends BasePlayer> players;
    //object shoe
    protected Shoe shoe;

    //Card game constructor
    public CardGame(List<? extends BasePlayer> players) {
        this.players = players;
    }

    //game initialize for each card game
    public abstract void gameInitialize();

    //the game process for each game
    public abstract void gameProcess();

    //getters and setters
    public List<? extends BasePlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<? extends BasePlayer> players) {
        this.players = players;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }
    static Scanner in = new Scanner(System.in);
    public static boolean exit() {
        System.out.println("Do you want to play another game? (yes/no) ");
        while (true) {
            String ex = in.next();
            if (ex.equals("yes")) {

                return true;
            } else if (ex.equals(("no"))) {
                System.out.println("Thank you for playing. Have a nice day! ");
                return false;
            } else System.out.println("Please re-enter your choice, which must be \"yes\" or \"no\".");
        }
    }
}