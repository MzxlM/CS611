
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @description: this is the unique ticTacToe
 * @author: Xinlong Zhang
 * @date: 2021/9/29 5:17 PM
 */
public class TicTacToe extends ChessBoardGame{
    private static final Integer ticTacToeBoardSize = 3;

    public TicTacToe (ChessPlayer player1, ChessPlayer player2) throws Exception {
        super(new ChessBoard(),player1,player2,1);
        gameStart();
    }

    /**
     * @param:
     * @description: start the tic tac toe game. Print instructions
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 5:19 PM
     */
    public void gameStart() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //create a 3*3 chessBoard for game TicTacToe

        //instruction
        System.out.println("Welcome to Tic Tac Toe game designed by Xinlong. What's the board size you want to play with?" +
                " (please input an Integer that is greater or equal to 3 and smaller than 10)");
        String boardSize = reader.readLine();
        int size = 0;
        size = inputBoardSize(boardSize, size);
        while (!(size >= ticTacToeBoardSize && size <= 10)) {
            System.out.println("Input is illegal, please try an Integer between 3 and 10");
            boardSize = reader.readLine();
            size = inputBoardSize(boardSize, size);
        }

        ChessBoard board = new ChessBoard(size);
        super.setWinCond(size);

        System.out.println("In this game Player can choose to play " +
                "with either chess 'X' or chess 'O'. You can’t set your chess " +
                "outside of the board or on an existing chess. You will win if your chess can " +
                "form a straight line with "+ boardSize +" pieces in any direction.");
        boardSetupAndPrint(board);
        gameProcess(board,reader);
    }

    /**
     * @param: board
     * @param: reader
     * @description: the unique game process for tic tac toe
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 5:20 PM
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

        //let player choose Chess
        String firstPlayerChess = choosePlayerChess(reader);
        String secondPlayerChess = "";
        if (firstPlayerChess.equals("X") || firstPlayerChess.equals("x")) {
            firstPlayerChess = "X";
            secondPlayerChess = "O";
        }
        if (firstPlayerChess.equals("O") || firstPlayerChess.equals("o")) {
            firstPlayerChess = "O";
            secondPlayerChess = "X";
        }

        //if current player is player1
        currentPlayer = getCurrentPlayer();
        if (currentPlayer.equals(player1)) {
            currentPlayer.setChessType(firstPlayerChess);
            player1.setChessType(firstPlayerChess);
            player2.setChessType(secondPlayerChess);
            setPlayer1(player1);
            setPlayer2(player2);
            playerMoveFirst = player1;
            playerMoveSecond = player2;
        }else if (currentPlayer.equals(player2)) {
            //if current player is player2
            currentPlayer.setChessType(firstPlayerChess);
            player2.setChessType(firstPlayerChess);
            player1.setChessType(secondPlayerChess);
            setPlayer1(player1);
            setPlayer2(player2);
            playerMoveFirst = player2;
            playerMoveSecond = player1;
        }else {
            throw new Exception("player error");
        }

        //while the board isn't full, let player move
        int loopCounter = 1;
        while (!board.fullCheck()) {
            //decide who's tern is it
            if (loopCounter%2 == 0) setCurrentPlayer(playerMoveSecond);
            if (loopCounter%2 != 0) setCurrentPlayer(playerMoveFirst);
            loopCounter+=1;

            currentPlayer = getCurrentPlayer();
            //make the move by read the input
            if (playerMakeMove(board, reader, player1, player2, currentPlayer)) break;
        }
        //check if there's a stalemate
        if (board.fullCheck() && super.getFinished().equals(Boolean.FALSE)) {
            System.out.println("Stalemate! \n");
            super.setTie(Boolean.TRUE);
        }

        //game is finished and print score
        gameFinished(board, reader, player1, player2);

    }




}
