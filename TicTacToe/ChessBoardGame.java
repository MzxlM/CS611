
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @description: this is a Class created for a unique board game that can be use such as tic tac toe and Order and Chaos
 * @author: Xinlong Zhang
 * @date: 2021/9/29 4:20 PM
 */
public abstract class ChessBoardGame{
    private ChessBoard chessBoard;
    private ChessPlayer player1;
    private ChessPlayer player2;
    private ChessPlayer currentPlayer;
    private ChessPlayer winner;

    private Integer winCondition;
    private Boolean isFinished = false; // true means finished with winner
    private Boolean isTie = false; // true means Tie without winner

    public ChessBoardGame(){
        this(new ChessBoard(),new ChessPlayer(),new ChessPlayer(),0);
    }

    public ChessBoardGame(ChessBoard chessBoard, ChessPlayer player1, ChessPlayer player2, Integer winCondition){
        setChessBoard(chessBoard);
        setPlayer1(player1);
        setPlayer2(player2);
        setWinCond(winCondition);
    }

    /**
     * @param: movement (the movement that user choose)
     * @description: check if the movement is valid
     * @return: boolean
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:22 PM
     */
    public boolean movementInputCheck(String movement) {
        int numbers = (chessBoard.getRow())*(chessBoard.getColumn());
        for (int i = 1; i <= numbers; i++) {
            if (movement.equals(Integer.toString(i))) {
                Integer row = 0;
                int temp = Integer.parseInt(movement);
//                boolean looped = false;
                while (temp - chessBoard.getColumn()> 0){
                    row++;
                    temp = temp - chessBoard.getColumn();
//                    looped = true;
                }
//                if (!looped){
//                    temp-=1;
//                }
                //todo check coordinates
                if (canMoveOnBoard(row,temp-1)) return true;
            }
        }
        return false;
    }

    /**
     * @param: movement
     * @param: player
     * @description: player make the move
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:23 PM
     */
    public void move(String movement, ChessPlayer player) {
        Integer row = 0;
        Integer temp = Integer.parseInt(movement);
        while (temp - chessBoard.getColumn() > 0){
            row++;
            temp = temp - chessBoard.getColumn();
        }
        moveOnBoard(row, temp-1, player);
    }

    /**
     * @param: row  (the coordinate that will be moved)
     * @param: column (the coordinate that will be moved)
     * @param: player (who did the move)
     * @description: check if someone wins and update the winner if have
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:23 PM
     */
    private void winCheck(Integer row, Integer column, ChessPlayer player){
        //counts the continuing number of the pieces
        Integer verticallyCount = 1;
        Integer horizontallyCount = 1;
        // start at top left to bottom right
        Integer leftDiagonalCount = 1;
        // start at top right to bottom left
        Integer rightDiagonalCount = 1;


        //rewrite winCheck
        //check horizontally right side
        Integer j = column;
        if (j+1 < chessBoard.getColumn()){
            j+=1;
            while (chessBoard.getBoard()[row][j].getType().equals(player.getChessType())) {
                horizontallyCount++;
                if (j.equals(chessBoard.getColumn()-1)) {
                    break;
                }
                j++;
            }
        }

        //check horizontally left side
        j = column;
        if (j-1 >= 0){
            j-=1;
            while (chessBoard.getBoard()[row][j].getType().equals(player.getChessType())) {
                horizontallyCount++;
                if (j.equals(0)) {
                    break;
                }
                j--;
            }
        }

        //check vertically downside
        Integer i = row;
        if (i+1 < chessBoard.getRow()){
            i+=1;
            while (chessBoard.getBoard()[i][column].getType().equals(player.getChessType())) {
                verticallyCount++;
                if (i.equals(chessBoard.getRow()-1)) {
                    break;
                }
                i++;
            }
        }

        i = row;
        //check vertically upside
        if (i-1 >=0){
            i-=1;
            while (chessBoard.getBoard()[i][column].getType().equals(player.getChessType())) {
                verticallyCount++;
                if (i.equals(0)) {
                    break;
                }
                i--;
            }
        }

        //check diagonally towards bottom right
        i = row;
        j = column;
        if (i+1 < chessBoard.getRow() && j+1 < chessBoard.getColumn()){
            i+=1;
            j+=1;
            while (chessBoard.getBoard()[i][j].getType().equals(player.getChessType())) {
                leftDiagonalCount++;
                if (i.equals(chessBoard.getRow()-1) || j.equals(chessBoard.getColumn()-1)) {
                    break;
                }
                i++;
                j++;
            }
        }

        //check diagonally towards top right
        i = row;
        j = column;
        if (i-1 >= 0 && j+1 < chessBoard.getColumn()){
            i-=1;
            j+=1;
            while (chessBoard.getBoard()[i][j].getType().equals(player.getChessType())) {
                rightDiagonalCount++;
                if (i.equals(0) || j.equals(chessBoard.getColumn()-1)) {
                    break;
                }
                i--;
                j++;
            }
        }

        //check diagonally towards top left
        i = row;
        j = column;
        if (i-1 >= 0 && j-1 >=0){
            i-=1;
            j-=1;
            while (chessBoard.getBoard()[i][j].getType().equals(player.getChessType())) {
                leftDiagonalCount++;
                if (i.equals(0) || j.equals(0)) {
                    break;
                }
                i--;
                j--;
            }
        }

        //check diagonally left side
        i = row;
        j = column;
        if (i+1 < chessBoard.getRow() && j-1 >=0){
            i+=1;
            j-=1;
            while (chessBoard.getBoard()[i][j].getType().equals(player.getChessType())) {
                rightDiagonalCount++;
                if (i.equals(chessBoard.getRow()-1)  || j.equals(0)) {
                    break;
                }
                i++;
                j--;
            }
        }


        //if anyone of the conditions is satisfied, player wins
//        System.out.println("horzon, vert, leftDiag, rightDiag  "+horizontallyCount +"  "+ verticallyCount +"  " + leftDiagonalCount + " " + rightDiagonalCount );
        if (leftDiagonalCount.equals(this.winCondition) || verticallyCount.equals(this.winCondition) ||
                horizontallyCount.equals(this.winCondition) || rightDiagonalCount.equals(this.winCondition) ) {
            setFinished(Boolean.TRUE);
            setWinner(player);
        }

    }

    /**
     * @param: winCond
     * @description: make the judgement for win condition
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:24 PM
     */
    public void setWinCond (Integer winCond) {
        if (winCond < 0) {
            throw new IllegalArgumentException("Win condition cannot be smaller than 0");
        }
        this.winCondition = winCond;
    }

    /**
     * @param: row
     * @param: column
     * @description: check if the designed position is movable
     * @return: boolean
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:24 PM
     */
    public boolean canMoveOnBoard (Integer row, Integer column){

        if (row > chessBoard.getRow() || column > chessBoard.getColumn()) {
            System.out.println("Illegal movement. Reason: out of boundary");
            return false;
        }

        // it's only movable if it's empty
        if (chessBoard.getBoard()[row][column].isEmpty()){
            return true;
        }
        System.out.println("Illegal movement. Reason: Not empty");
        return false;
    }

    /**
     * @param: row
     * @param: column
     * @param: player
     * @description: make the movement to the designed location
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:29 PM
     */
    public void moveOnBoard (Integer row, Integer column, ChessPlayer player){
        //generate a chess for player
        ChessPiece chessPiece = new ChessPiece(player.getChessType());
        //make the movement
        ChessPiece[][] board = chessBoard.getBoard();
        board[row][column] = chessPiece;
        chessBoard.setBoard(board);
        winCheck(row, column, player);
    }

    /**
     * @param: reader
     * @param: player1
     * @param: player2
     * @description: decide who will go first by the user input
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:31 PM
     */
    public void decideFirstPlayer(BufferedReader reader, ChessPlayer player1, ChessPlayer player2) throws IOException {
        //who will go first?
        System.out.println("Now you can decide who will be the first one to play. (By entering 1 or 2) ");
        System.out.println("player 1 is :"+ player1.getName()+ "\nplayer 2 is :"+ player2.getName());
        //read the input, if input is wrong reinput it
        String firstPlayer = reader.readLine();
        while (!(firstPlayer.equals("1") || firstPlayer.equals("2"))) {
            System.out.println("Input is illegal, please try it again \n");
            firstPlayer = reader.readLine();
        }
        //set current player to be the player that user choose
        if (firstPlayer.equals("1")) {
            setCurrentPlayer(player1);
        }
        if (firstPlayer.equals("2")) {
            setCurrentPlayer(player2);
        }
    }

    /**
     * @param: reader
     * @description: Player choose it's chess either O or X by input it
     * @return: java.lang.String
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:35 PM
     */
    public String choosePlayerChess(BufferedReader reader) throws IOException {
        //decide the piece of first player
        System.out.println(getCurrentPlayer().getName()+", Choose your chessPiece  (By entering X or O) ");
        String playerChoice = reader.readLine();

        //if input is not in the correct form
        while (!playerInputCheck(playerChoice)) {
            System.out.println("Input is illegal, please try it again");
            playerChoice = reader.readLine();
        }
        if (playerChoice.equals("X") || playerChoice.equals("x")) {
            playerChoice = "X";
        }
        if (playerChoice.equals("O") || playerChoice.equals("o")) {
            playerChoice = "O";
        }

        return playerChoice;
    }

    /**
     * @param: firstPlayer
     * @description: check the input format if its X x O or o its legal otherwise its illegal
     * @return: boolean
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:36 PM
     */
    private boolean playerInputCheck(String firstPlayer) {
        if (firstPlayer.equals("X")) {
            return true;
        }
        if (firstPlayer.equals("x")) {
            return true;
        }
        if (firstPlayer.equals("O")) {
            return true;
        }
        return firstPlayer.equals("o");
    }


    /**
     * @param: boardSize
     * @param: size
     * @description: check inputBoard size
     * @return: int
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:36 PM
     */
    public int inputBoardSize(String boardSize, int size) {
        try {
            size = Integer.parseInt(boardSize);// todo first to make sure its int
        } catch (Exception e) {
            System.out.println("please input an Integer");
        }
        return size;
    }

    /**
     * @param: board
     * @description:    setup board and print the movementBoardTemple
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:36 PM
     */
    public void boardSetupAndPrint(ChessBoard board) {
        board.setupBoard();
        setChessBoard(board);
        board.printBoard(board.getBoard());


        System.out.println("As shown below you have to input the number 1-"+ (board.getRow())*(board.getColumn()) +" to make the movement" +
                " instead of entering of the row number and col number of the square. \n");
        board.printBoard(board.getMovementBoardTemple());
    }

    /**
     * @param: board
     * @description:   initialize the board game for a new game
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:36 PM
     */
    public void boardGameInitialize(ChessBoard board) {
        board.setupBoard();
        setFinished(false);
        setTie(false);
    }

    /**
     * @param: board
     * @param: reader
     * @description: need subclass to write the unique game process
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:37 PM
     */
    abstract void gameProcess(ChessBoard board, BufferedReader reader) throws Exception;

    /**
     * @param: board
     * @param: reader
     * @param: player1
     * @param: player2
     * @description: game is already finished. Print scoreBoard and ask the players if they want to play more
     * @return: void
     * @author: Xinlong Zhang
     * @date: 2021/9/29 1:50 PM
     */
    public void gameFinished(ChessBoard board, BufferedReader reader, ChessPlayer player1, ChessPlayer player2) throws Exception {
        //print scores
        System.out.println("The current score is : \n player1 "+ player1.getName()+" : "+ player1.getWins() +
                "\nplayer2 "+ player2.getName()+" : "+ player2.getWins());

        //ask for continuation or not
        System.out.println("If you want to play one more current game, please enter Y or y. Otherwise the game will shut down and back to main menu\n");
        String continueOrNot = reader.readLine();
        if (continueOrNot.equals("Y") || continueOrNot.equals("y")) {
            gameProcess(board, reader);
        }
    }

    /**
     * @param: board
     * @param: reader
     * @param: player1
     * @param: player2
     * @param: currentPlayer
     * @description: for the current player to make the move
     * @return: boolean
     * @author: Xinlong Zhang
     * @date: 2021/9/29 4:58 下午
     */
    public boolean playerMakeMove(ChessBoard board, BufferedReader reader, ChessPlayer player1, ChessPlayer player2, ChessPlayer currentPlayer) throws IOException {
        System.out.println("Player " + currentPlayer.getName() + ". Enter your move: \n");
        String movement= reader.readLine();
        while (!movementInputCheck(movement)) {
            System.out.println("Input movement is illegal, please try another number between 1 and "+(board.getRow()+1)*(board.getColumn()+1));
            movement = reader.readLine();
        }
        move(movement, currentPlayer);
        board.printBoard(board.getBoard());

        // winCheck if win break count the score;
        if (getFinished().equals(Boolean.TRUE)) {
            System.out.println("Player " + currentPlayer.getName() + " Wins. \n");
            if (currentPlayer.equals(player1)) {
                player1.setWins(player1.getWins()+1);
            }
            if (currentPlayer.equals(player2)) {
                player2.setWins(player2.getWins()+1);
            }
            return true;
        }
        return false;
    }

    public ChessPlayer getPlayer2() {
        return player2;
    }

    public void setPlayer2(ChessPlayer player2) {
        this.player2 = player2;
    }

    public ChessPlayer getWinner() {
        return winner;
    }

    public void setWinner(ChessPlayer winner) {
        this.winner = winner;
    }

    public ChessPlayer getPlayer1() {
        return player1;
    }

    public void setPlayer1(ChessPlayer player1) {
        this.player1 = player1;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public ChessPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(ChessPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public Boolean getTie() {
        return isTie;
    }

    public void setTie(Boolean tie) {
        isTie = tie;
    }
}
