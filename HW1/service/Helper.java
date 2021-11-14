package main.HW1.service;

import main.HW1.object.ChessBoard;
import main.HW1.object.ChessPiece;

public class Helper {

    // print current board
    public static void printBoard(ChessPiece[][] board) {
        for (Integer i = 0; i <= 2; i++) {
            System.out.println("+--+--+--+");
            for (Integer j = 0; j < 3; j++) {
                if (board[i][j].isEmpty()) {
                    System.out.print("|" + "  ");
                } else {
                    System.out.print("|" + board[i][j].getType() + " ");
                }
            }
            System.out.print("|" + "\n");
        }
        System.out.println("+--+--+--+");
    }

    //check if the board is already full
    public static boolean fullCheck(ChessPiece[][] board) {
        for (Integer i = 0; i <= 2; i++) {
            for (Integer j = 0; j < 3; j++) {
                if (board[i][j].isEmpty()) return false;
            }
        }
        return true;
    }

    //check if one is already win.
    public static boolean winCheck(ChessPiece[][] board, String player) {
        //check horizontally
        for (Integer i = 0; i <= 2; i++) {
            if (board[i][0].getType().equals(board[i][1].getType()) && board[i][0].getType().equals(
                    board[i][2].getType()) && board[i][0].getType().equals(player)) return true;
        }

        //check vertically
        for (Integer i = 0; i <= 2; i++) {
            if (board[0][i].getType().equals(board[1][i].getType()) && board[0][i].getType().equals(
                    board[2][i].getType()) && board[0][i].getType().equals(player)) return true;
        }

        //check two special case which is a slope line
        if (board[0][0].getType().equals(board[1][1].getType()) && board[0][0].getType().equals(
                board[2][2].getType()) && board[0][0].getType().equals(player)) return true;

        if (board[2][0].getType().equals(board[1][1].getType()) && board[2][0].getType().equals(
                board[0][2].getType()) && board[2][0].getType().equals(player)) return true;

        return false;
    }

    //check the input format if its X x O or o its legal otherwise its illegal
    public static boolean playerInputCheck(String firstPlayer) {
        if (firstPlayer.equals("X")) {
            return true;
        }
        if (firstPlayer.equals("x")) {
            return true;
        }
        if (firstPlayer.equals("O")) {
            return true;
        }
        if (firstPlayer.equals("o")) {
            return true;
        }
        return false;
    }

    //check if the movement is valid
    public static boolean movementInputCheck(String movement, ChessPiece[][] board) {
        if (movement.equals("1")) {
            if (ChessBoard.canMove(0, 0, board)) return true;
        }
        if (movement.equals("2")) {
            if (ChessBoard.canMove(0, 1, board)) return true;
        }
        if (movement.equals("3")) {
            if (ChessBoard.canMove(0, 2, board)) return true;
        }
        if (movement.equals("4")) {
            if (ChessBoard.canMove(1, 0, board)) return true;
        }
        if (movement.equals("5")) {
            if (ChessBoard.canMove(1, 1, board)) return true;
        }
        if (movement.equals("6")) {
            if (ChessBoard.canMove(1, 2, board)) return true;
        }
        if (movement.equals("7")) {
            if (ChessBoard.canMove(2, 0, board)) return true;
        }
        if (movement.equals("8")) {
            if (ChessBoard.canMove(2, 1, board)) return true;
        }
        if (movement.equals("9")) {
            if (ChessBoard.canMove(2, 2, board)) return true;
        }
        return false;
    }

    //make the move
    public static void move(String movement, String player, ChessPiece[][] board) {
        //by calling move function from ChessBoard to make the move
        if (movement.equals("1")) {
            ChessBoard.move(0, 0, player, board);
        }
        if (movement.equals("2")) {
            ChessBoard.move(0, 1, player, board);
        }
        if (movement.equals("3")) {
            ChessBoard.move(0, 2, player, board);
        }
        if (movement.equals("4")) {
            ChessBoard.move(1, 0, player, board);
        }
        if (movement.equals("5")) {
            ChessBoard.move(1, 1, player, board);
        }
        if (movement.equals("6")) {
            ChessBoard.move(1, 2, player, board);
        }
        if (movement.equals("7")) {
            ChessBoard.move(2, 0, player, board);
        }
        if (movement.equals("8")) {
            ChessBoard.move(2, 1, player, board);
        }
        if (movement.equals("9")) {
            ChessBoard.move(2, 2, player, board);
        }
    }
}