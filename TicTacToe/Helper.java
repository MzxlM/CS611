
//import ChessBoard.java;
//import ChessBoardGame.java;
//import ChessPiece.java;
//import ChessPlayer.java;
//import OrderAndChaos.java;
//import TicTacToe.java;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @param: null
 * @description: this class is designed for some helper methods that's running for board games. Like print the instructions
 * @return:
 * @author: Xinlong Zhang
 * @date: 2021/9/29 4:40 PM
 */
public class Helper {

    //game starts
    public static void gameStart() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ChessPlayer player1 = new ChessPlayer();
        ChessPlayer player2 = new ChessPlayer();
        //ask for gamer names
        playerNameInput(player1,player2,reader);
        //start the game
        gameStarter(reader, player1, player2);
    }

    /**
     * @param: reader
     * @param: player1
     * @param: player2
     * @description: print instructions and ask for choices
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:40 PM
     */
    private static void gameStarter(BufferedReader reader, ChessPlayer player1, ChessPlayer player2) throws Exception {
        //read the inputs
        System.out.println("welcome to Board Games designed by Xinlong. There are two games currently available." +
                " They are Tic-Tac-Toe and Order-and-Chaos. You can choose to play either one of them. " +
                "Choose Tic-Tac-Toe by entering T and Order-and-Chaos by entering O." +
                "if you want to quit the game, please enter Q to quit");
        String userChoice = reader.readLine();
        //if the input is not in the correct form re-input it
        while (!(userChoice.equals("T") || userChoice.equals("O") || userChoice.equals("Q"))) {
            System.out.println("Choose Game by Entering T or O. Please try it again");
            userChoice = reader.readLine();
        }
        //goes to tic tac toe game
        if (userChoice.equals("T")){
            new TicTacToe(player1, player2);
        }
        //goes to OAC game
        if (userChoice.equals("O")) {
            new OrderAndChaos(player1, player2);
        }
        //ends the game
        if (userChoice.equals("Q")) {
            System.exit(0);
        }else {
            gameStarter(reader, player1, player2);
        }
    }

    /**
     * @param: player1
     * @param: player2
     * @param: reader
     * @description: let player input their names
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:41 PM
     */
    public static void playerNameInput(ChessPlayer player1, ChessPlayer player2, BufferedReader reader) throws IOException {
        System.out.println("welcome to Board Games designed by Xinlong. There are two games currently available." +
                        " They are Tic-Tac-Toe and Order-and-Chaos. Before gaming you should create your profile for two players.\n");
        System.out.println("Player 1 please create your profile by inputting your name");
        String name1 = nameCheck(reader);

        System.out.println("Player 2 please create your profile by inputting your name");
        String name2 = nameCheck(reader);

        player1.setPlayer(new ChessPlayer(name1));
        player2.setPlayer(new ChessPlayer(name2));

    }

    // check if the name is empty of not
    private static String nameCheck(BufferedReader reader) throws IOException {
        String name = reader.readLine();
        // name cannot be empty
        while (name.isEmpty()) {
            System.out.println("your name cannot be empty");
            name = reader.readLine();
        }
        return name;
    }





    }