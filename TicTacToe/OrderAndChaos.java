
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @description: game Order and Chaos object which extends ChessBoardGame. It implements some unique game feature for OAC
 * @author: Xinlong Zhang
 * @date: 2021/9/29 4:43 PM
 */
public class OrderAndChaos extends ChessBoardGame{
    private static final Integer ORDER_AND_CHAOS_BOARD_SIZE = 6;
    private static final Integer ORDER_WIN = 5;
    private static final Integer CHAOS_WIN = 6;


    public OrderAndChaos (ChessPlayer player1, ChessPlayer player2) throws Exception {
        super(new ChessBoard(),player1,player2,1);
        gameStart();
    }
    /**
     * @param:
     * @description: print instructions and start the OAC game process
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:47 PM
     */
    public void gameStart() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //create a 6*6 chessBoard for game TicTacToe

        //instruction
        System.out.println("Welcome to Order and Chaos game designed by Xinlong.");
        //creating board
        ChessBoard board = new ChessBoard(ORDER_AND_CHAOS_BOARD_SIZE);
        super.setWinCond(ORDER_WIN);

        System.out.println("In this game Player can choose to play " +
                "with either chess 'X' or chess 'O'. You can’t set your chess " +
                "outside of the board or on an existing chess. Order wins by 5-in-a-row. Chaos wins if order doesnt win" +
                " or 6-in-a-row at Chaos' turn");
        //print instructions
        boardSetupAndPrint(board);
        //start game process for OAC
        gameProcess(board,reader);

    }

    /**
     * @param: board
     * @param: reader
     * @description: the unique gameProcess
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:53 PM
     */
    @Override
    public void gameProcess(ChessBoard board, BufferedReader reader) throws Exception {
        //initialize the board
        boardGameInitialize(board);
        ChessPlayer player1 = getPlayer1();
        ChessPlayer player2 = getPlayer2();
        ChessPlayer currentPlayer;
        ChessPlayer playerMoveFirst = new ChessPlayer();
        ChessPlayer playerMoveSecond = new ChessPlayer();

        decideFirstPlayer(reader, player1, player2);


        //if current player is player1
        currentPlayer = getCurrentPlayer();
        if (currentPlayer.equals(player1)) {
            playerMoveFirst = player1;
            playerMoveSecond = player2;
        } else if (currentPlayer.equals(player2)) {
            playerMoveFirst = player2;
            playerMoveSecond = player1;
        } else {
            throw new Exception("player error");
        }

        //while the board isn't full, let player move
        int loopCounter = 1;
        while (!board.fullCheck()) {
            //decide who's tern is it
            if (loopCounter%2 == 0) {
                setCurrentPlayer(playerMoveSecond);
                setWinCond(CHAOS_WIN);
            }
            if (loopCounter%2 != 0) {
                setCurrentPlayer(playerMoveFirst);
                setWinCond(ORDER_WIN);
            }
            loopCounter+=1;

            //let the player choose their chess either X or O
            currentPlayer = getCurrentPlayer();
            String playerChoice = choosePlayerChess(reader);
            currentPlayer.setChessType(playerChoice);

            //make the move by read the input
            if (playerMakeMove(board, reader, player1, player2, currentPlayer)) break;

        }
        if (board.fullCheck()) {
//            System.out.println(playerMoveSecond.getName()+ "Wins as Chaos! ");
            super.setTie(Boolean.TRUE);
        }
        if (getTie().equals(Boolean.TRUE)) {
            System.out.println(playerMoveSecond.getName()+ "Wins as Chaos! ");
            System.out.println("Player " + currentPlayer.getName() + " Wins as Chaos.");
            if (currentPlayer.equals(player1)) {
                player1.setWins(player1.getWins()+1);
            }
            if (currentPlayer.equals(player2)) {
                player2.setWins(player2.getWins()+1);
            }
        }
        //finish the game
        gameFinished(board, reader, player1, player2);


    }




}
