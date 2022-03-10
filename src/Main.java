/**
 * @className: Main
 * @description: This class contains the main function.
 **/

public class Main {
    public static void main(String[] args) {
        int count = 0; //count the number of games played
        while (true) {
            GamesController.runAGame(GamesController.select(), count);
            count++;
        }
    }
}
