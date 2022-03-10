import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Xudong Gao,Xinlong Zhang
 * @className: GamesController
 * @description: This class provides methods for selecting games and running a game.
 **/
public class GamesController {
    /**
     * Allows the user to enter a number to select the game to play.
     *
     * @return Entered number
     */
    public static String select() {
        System.out.println("Welcome to our Games!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~ 1  Black Jack         ~");
        System.out.println("~ 2  Trianta Ena        ~");
        System.out.println("~                       ~");
        System.out.println("~ 0  EXIT               ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Please enter the integer number before the game to enter the game:");
        Scanner in = new Scanner(System.in);
        String choice;
        choice = in.next();
        return choice;
    }

    public static void runAGame(String choice, int count) {
        /**
         *Create objects to run based on the selected game
         * @param choice entered number
         * @param count count the number of games played
         */
        List players = playerInitialize();

        if (choice.equals("1")) {

            BlackJack bj;
            if(BlackJack.initializeCheck(players)) {
                while (true) {
                    bj = new BlackJack(players);
                    bj.gameInitialize();
                    bj.gameProcess();
                    players = bj.getALLPlayers();
                    if (!TriantaEna.tryAgain(count)) {
                        if (CardGame.exit()) break;
                        else System.exit(0);
                    }
                }
            }
        }
        else if (choice.equals("2")) {
            TriantaEna te;
            if(TriantaEna.initializeCheck(players)) {
                te = new TriantaEna(players);
                while (true) {
                    te.gameInitialize();
                    te.gameProcess();
                    if (!TriantaEna.tryAgain(count)) {
                        if (CardGame.exit()) break;
                        else System.exit(0);
                    }
                }
            }

        }
        else if (choice.equals("0")) {
            System.exit(0);
        } else System.out.println("Please enter the integer number before the game!");
    }

    public static List playerInitialize(){
        List<BJPlayers_base> players = new ArrayList<>();
        System.out.println("Please create your game players before starting to select the game");
        Integer numPlayer = 0;
        Scanner in = new Scanner(System.in);

        while (true){
            System.out.println("Please create the player "+numPlayer+":");
            System.out.println("    NAME:");
            String name = in.next();
            Integer curr;
            System.out.println("    CURRENCY:");
            while (true) {
                String currency = in.next();
                try{
                    curr = Integer.parseInt(currency);
                    if(curr >= 10 && curr <= 100000){
                        players.add(new BJPlayer(name, curr));
                        break;
                    }
                }catch (NumberFormatException e) {
                }
                System.out.println("Please Enter a Number Between 10 and 100000 for currency.");

            }
            System.out.println("Do you want to add another player?(y/n)");

            String another;
            while (true) {
                another = in.next();
                if ((!another.equals("n"))&&(!another.equals("y"))) {
                    System.out.println("The answer is expected to be y or n");
                }
                else break;
            }
            if(another.equals("n"))
            {
                break;
            }
            numPlayer++;
        }
        return players;
    }
}
