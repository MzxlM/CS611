package main.HW1.controller;

import main.HW1.object.ChessBoard;
import main.HW1.object.ChessPiece;
import main.HW1.service.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToeController {
    static ChessPiece[][] board;

    public static void main(String[] args) throws IOException {
        //declare variables
        Integer scoreX = 0;
        Integer scoreO = 0;

        //initialize board and example movement board.
        board = ChessBoard.setUpBoard();
        ChessPiece[][] movementBoard = ChessBoard.setUpBoard();
        movementBoard = ChessBoard.movementBoardTemple(movementBoard);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //instruction
        System.out.println("Welcome to Tic Tac Toe game designed by Xinlong. In this game Player 1 plays " +
                "with chess ‘X’ and player 2 plays with chess ‘O’. You can’t set your chess " +
                "outside of the board or on an existing chess. You will win if your chess can " +
                "form a straight line with 3 pieces in any direction. \n");
        Helper.printBoard(movementBoard);
        System.out.println("As shown above you have to input the number 1-9 to make the movement" +
                        " instead of entering of the row number and col number of the square. \n");

        //game starts
        gameProcess(reader,scoreX,scoreO);


    }

    private static void gameProcess(BufferedReader reader, Integer scoreX, Integer scoreO) throws IOException {
        board = ChessBoard.initializeBoard(board);

        //explain how to make movement
        System.out.println("The game board is the following one \n");
        Helper.printBoard(board);
        //who will go first?
        System.out.println("Now you can decide who will be the first one to play. (By entering X or O) ");
        String firstPlayer = reader.readLine();

        //if input is not in the correct form
        while (!Helper.playerInputCheck(firstPlayer)) {
            System.out.println("Input is illegal, please try it again \n");
            firstPlayer = reader.readLine();
        }

        //declare first and second player
        String secondPlayer;
        if (firstPlayer.equals("X") || firstPlayer.equals("x")) {
            firstPlayer = "X";
            secondPlayer = "O";
        } else {
            firstPlayer = "O";
            secondPlayer = "X";
        }

        //while the board isn't full, let player move
        Integer loopCounter = 1;
        while (!Helper.fullCheck(board)) {
            //decide who's tern is it
            String tempPlayer = "B";
            if (loopCounter%2 == 0) tempPlayer = secondPlayer;
            if (loopCounter%2 != 0) tempPlayer = firstPlayer;
            loopCounter+=1;

            //make the move by read the input
            System.out.println("Player " + tempPlayer + ". Enter your move: \n");
            String movement= reader.readLine();
            while (!Helper.movementInputCheck(movement,board)) {
                System.out.println("Input movement is illegal, please try another number between 1 and 9 \n");
                movement = reader.readLine();
            }
            Helper.move(movement, tempPlayer, board);
            Helper.printBoard(board);


            // winCheck if win break count the score;
            boolean status = Helper.winCheck(board, tempPlayer);
            if (status == Boolean.TRUE) {
                System.out.println("Player " + tempPlayer + " Wins. \n");
                if (tempPlayer.equals("X")) {
                    scoreX++;
                } else {
                    scoreO++;
                }
                break;
            }

            //check stalemate
            if (loopCounter == 10) {
                System.out.println("Stalemate! \n");
            }
        }
        //print scores
        System.out.println("The current score is : \n player X : " + scoreX + "\n player O : " + scoreO);

        //ask for continuation or not
        System.out.println("If you want to play one more game, please enter Y or y. Otherwise the game will shut down\n");
        String continueOrNot = reader.readLine();
        if (continueOrNot.equals("Y") || continueOrNot.equals("y")) {
            gameProcess(reader,scoreX,scoreO);
        }
    }


}
