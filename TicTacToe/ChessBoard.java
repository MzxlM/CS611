
/**
 * @description: ChessBoard obejct
 * @author: Xinlong Zhang
 * @date: 2021/9/29 5:26 PM
 */
public class ChessBoard {
    private Integer row;
    private Integer column;
    private ChessPiece[][] board;
    private ChessPiece[][] movementBoardTemple;

    public ChessBoard(Integer row, Integer column){
        setRow(row);
        setColumn(column);
    }

    //constructor
    public ChessBoard(){
        this(0,0);
    }

    public ChessBoard(Integer size){
        this(size,size);
    }

    // getters and setters
    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        if (column<0) {
            throw new IllegalArgumentException("column size should be greater or equal to 0");
        }
        this.column = column;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        if (row<0) {
            throw new IllegalArgumentException("row size should be greater or equal to 0");
        }
        this.row = row;
    }

    public void setBoard(ChessPiece[][] board) {
        this.board = board;
    }

    public ChessPiece[][] getBoard() {
        return board;
    }

    public ChessPiece[][] getMovementBoardTemple() {
        return movementBoardTemple;
    }

    public void setMovementBoardTemple(ChessPiece[][] movementBoardTemple) {
        this.movementBoardTemple = movementBoardTemple;
    }

    /**
     * @param:
     * @description: initialize the board and temples
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 5:27 PM
     */
    public void setupBoard(){
        clearBoard();
        movementBoardTempleInitialize();
    }

    /**
     * @param:
     * @description: clear the board object
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 5:28 PM
     */
    private void clearBoard() {
        board = new ChessPiece[this.row][this.column];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column; j++) {
                board[i][j] = new ChessPiece("*");
            }
        }
    }

    /**
     * @param:
     * @description: make the temple board for instruction.
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 5:28 PM
     */
    private void movementBoardTempleInitialize() {
        this.movementBoardTemple = new ChessPiece[this.row][this.column];
        //give an example of how to input movement
        for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < getColumn(); j++) {
                Integer number = i*getColumn() + j + 1;
                ChessPiece chessPiece = new ChessPiece(number.toString());
                this.movementBoardTemple[i][j] = chessPiece;
            }
        }
    }

    /**
     * @param: board
     * @description:  print the board we want
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 5:29 PM
     */
    public void printBoard(ChessPiece[][] board) {
        // go over the board and print it
        for (Integer i = 0; i < row; i++) {
            for (Integer j = 0; j < column; j++) {
                System.out.print("+--");
            }
            System.out.print("+" + "\n");

            for (Integer j = 0; j < row; j++) {
                // if empty print "  "
                if (board[i][j].isEmpty()) {
                    System.out.print("|" + "  ");
                } else {
                    // specific methods for print templet to make it looks nicer
                    Integer temp = 0;
                    try{
                        temp = Integer.parseInt(board[i][j].getType());
                    }catch (Exception ignored){
                    }
                    if (temp>=10){
                        System.out.print("|" + board[i][j].getType());
                    }else {
                        System.out.print("|" + board[i][j].getType() + " ");
                    }
                }
            }
            System.out.print("|" + "\n");
        }
        for (Integer i = 0; i < row; i++) {
            System.out.print("+--");
        }
        System.out.print("+" + "\n");
    }

    /**
     * @description: check if the board is already full
     * @return: boolean
     * @author: Xinlong Zhang
     * @date: 2021/9/29 5:30 PM
     */
    public boolean fullCheck() {

        for (Integer i = 0; i < row; i++) {
            for (Integer j = 0; j < column; j++) {
                if (board[i][j].isEmpty()) return false;
            }
        }
        return true;
    }

}
