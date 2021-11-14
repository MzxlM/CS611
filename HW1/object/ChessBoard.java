package main.HW1.object;

public class ChessBoard {
    private static final Integer rowSize = 3;
    private static final Integer columnSize = 3;

    //create the board object
    public static ChessPiece[][] setUpBoard () {
        return new ChessPiece[rowSize][columnSize];
    }

    public static ChessPiece[][] initializeBoard (ChessPiece[][] board) {
        //give the board initialized value instead of keeping it null
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ChessPiece chessPiece = new ChessPiece("*");
                board[i][j] = chessPiece;
            }
        }
        return board;
    }

    //check if the designed position is movable
    public static boolean canMove (Integer row, Integer column, ChessPiece[][] board){
        if (row > rowSize || column > columnSize) {
            System.out.println("Illegal movement. Reason: out of boundary");
            return false;
        }

        // it's only movable if it's empty
        if (board[row][column].isEmpty()){
            return true;
        }
        System.out.println("Illegal movement. Reason: Not empty");
        return false;
    }

    //make the movement to the designed location
    public static void move (Integer row, Integer column, String player, ChessPiece[][] board){
        //generate a chess for player
        ChessPiece chessPiece = new ChessPiece(player);
        //make the movement
        board[row][column] = chessPiece;

        return;
    }

    //make the temple board for instruction.
    public static ChessPiece[][] movementBoardTemple (ChessPiece[][] board) {
        //give an example of how to input movement
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Integer number = i*3 + j + 1;
                ChessPiece chessPiece = new ChessPiece(number.toString());
                board[i][j] = chessPiece;
            }
        }
        return board;
    }

}
