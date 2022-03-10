Name : Xinlong Zhang
Email : xinlongz@bu.edu

Description of each class:
Main.java: the main function of whole program
ChessBoard.java: ChessBoard object and its basic functions
ChessBoardGame.java: this is a Class created for a unique board game that can be use such as tic tac toe and Order and Chaos
ChessPiece.java: this is ChessPiece object
ChessPlayer.java: Chess Player object that contains some basic features.
OrderAndChaos.java: game Order and Chaos object which extends ChessBoardGame. It implements some unique game feature for OAC
TicTacToe.java: this is the unique ticTacToe game logic that extends ChessBoardGame
Helper.java: some helper function which extracted from main.


Here is an example of running my program: (I have marked all the input with  "----input" below)


welcome to Board Games designed by Xinlong. There are two games currently available. They are Tic-Tac-Toe and Order-and-Chaos. Before gaming you should create your profile for two players.

Player 1 please create your profile by inputting your name
DQ							----input
Player 2 please create your profile by inputting your name
ZXL							----input
welcome to Board Games designed by Xinlong. There are two games currently available. They are Tic-Tac-Toe and Order-and-Chaos. You can choose to play either one of them. Choose Tic-Tac-Toe by entering T and Order-and-Chaos by entering O.if you want to quit the game, please enter Q to quit
O							----input
Welcome to Order and Chaos game designed by Xinlong.
In this game Player can choose to play with either chess ‘X’ or chess ‘O’. You can’t set your chess outside of the board or on an existing chess. Order wins by 5-in-a-row. Chaos wins if order doesnt win or 6-in-a-row at Chaos' turn
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
As shown below you have to input the number 1-36 to make the movement instead of entering of the row number and col number of the square. 

+--+--+--+--+--+--+
|1 |2 |3 |4 |5 |6 |
+--+--+--+--+--+--+
|7 |8 |9 |10|11|12|
+--+--+--+--+--+--+
|13|14|15|16|17|18|
+--+--+--+--+--+--+
|19|20|21|22|23|24|
+--+--+--+--+--+--+
|25|26|27|28|29|30|
+--+--+--+--+--+--+
|31|32|33|34|35|36|
+--+--+--+--+--+--+
Now you can decide who will be the first one to play. (By entering 1 or 2) 
player 1 is :DQ
player 2 is :ZXL
1							----input
DQ, Choose your chessPiece  (By entering X or O) 
x							----input
Player DQ. Enter your move: 

8							----input
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |X |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
o							----input
Player ZXL. Enter your move: 

22							----input
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |X |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |O |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
DQ, Choose your chessPiece  (By entering X or O) 
X							----input
Player DQ. Enter your move: 

14							----input
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |X |  |  |  |  |
+--+--+--+--+--+--+
|  |X |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |O |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
o							----input
Player ZXL. Enter your move: 

2							----input
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|  |X |  |  |  |  |
+--+--+--+--+--+--+
|  |X |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |O |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
DQ, Choose your chessPiece  (By entering X or O) 
x							----input
Player DQ. Enter your move: 

15							----input
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|  |X |  |  |  |  |
+--+--+--+--+--+--+
|  |X |X |  |  |  |
+--+--+--+--+--+--+
|  |  |  |O |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
o							----input
Player ZXL. Enter your move: 

18							----input
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|  |X |  |  |  |  |
+--+--+--+--+--+--+
|  |X |X |  |  |O |
+--+--+--+--+--+--+
|  |  |  |O |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
DQ, Choose your chessPiece  (By entering X or O) 
x							----input
Player DQ. Enter your move: 

16							----input
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|  |X |  |  |  |  |
+--+--+--+--+--+--+
|  |X |X |X |  |O |
+--+--+--+--+--+--+
|  |  |  |O |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
o							----input
Player ZXL. Enter your move: 

9							----input
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|  |X |O |  |  |  |
+--+--+--+--+--+--+
|  |X |X |X |  |O |
+--+--+--+--+--+--+
|  |  |  |O |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
DQ, Choose your chessPiece  (By entering X or O) 
x							----input
Player DQ. Enter your move: 

11							----input
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|  |X |O |  |X |  |
+--+--+--+--+--+--+
|  |X |X |X |  |O |
+--+--+--+--+--+--+
|  |  |  |O |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
o							----input
Player ZXL. Enter your move: 

26							----input
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|  |X |O |  |X |  |
+--+--+--+--+--+--+
|  |X |X |X |  |O |
+--+--+--+--+--+--+
|  |  |  |O |  |  |
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
DQ, Choose your chessPiece  (By entering X or O) 
x							----input
Player DQ. Enter your move: 

21							----input
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|  |X |O |  |X |  |
+--+--+--+--+--+--+
|  |X |X |X |  |O |
+--+--+--+--+--+--+
|  |  |X |O |  |  |
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
o							----input
Player ZXL. Enter your move: 

13							----input
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|  |X |O |  |X |  |
+--+--+--+--+--+--+
|O |X |X |X |  |O |
+--+--+--+--+--+--+
|  |  |X |O |  |  |
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
DQ, Choose your chessPiece  (By entering X or O) 
x							----input
Player DQ. Enter your move: 

28							----input
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|  |X |O |  |X |  |
+--+--+--+--+--+--+
|O |X |X |X |  |O |
+--+--+--+--+--+--+
|  |  |X |O |  |  |
+--+--+--+--+--+--+
|  |O |  |X |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
o							----input
Player ZXL. Enter your move: 

7							----input
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|O |X |O |  |X |  |
+--+--+--+--+--+--+
|O |X |X |X |  |O |
+--+--+--+--+--+--+
|  |  |X |O |  |  |
+--+--+--+--+--+--+
|  |O |  |X |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
DQ, Choose your chessPiece  (By entering X or O) 
x							----input
Player DQ. Enter your move: 

10							----input
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|O |X |O |X |X |  |
+--+--+--+--+--+--+
|O |X |X |X |  |O |
+--+--+--+--+--+--+
|  |  |X |O |  |  |
+--+--+--+--+--+--+
|  |O |  |X |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
o							----input
Player ZXL. Enter your move: 

20							----input
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|O |X |O |X |X |  |
+--+--+--+--+--+--+
|O |X |X |X |  |O |
+--+--+--+--+--+--+
|  |O |X |O |  |  |
+--+--+--+--+--+--+
|  |O |  |X |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
DQ, Choose your chessPiece  (By entering X or O) 
o							----input
Player DQ. Enter your move: 

17							----input
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|O |X |O |X |X |  |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|  |O |X |O |  |  |
+--+--+--+--+--+--+
|  |O |  |X |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
x							----input
Player ZXL. Enter your move: 

27							----input
+--+--+--+--+--+--+
|  |O |  |  |  |  |
+--+--+--+--+--+--+
|O |X |O |X |X |  |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|  |O |X |O |  |  |
+--+--+--+--+--+--+
|  |O |X |X |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
DQ, Choose your chessPiece  (By entering X or O) 
o							----input
Player DQ. Enter your move: 

1							----input
+--+--+--+--+--+--+
|O |O |  |  |  |  |
+--+--+--+--+--+--+
|O |X |O |X |X |  |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|  |O |X |O |  |  |
+--+--+--+--+--+--+
|  |O |X |X |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
x							----input
Player ZXL. Enter your move: 

19							----input
+--+--+--+--+--+--+
|O |O |  |  |  |  |
+--+--+--+--+--+--+
|O |X |O |X |X |  |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|X |O |X |O |  |  |
+--+--+--+--+--+--+
|  |O |X |X |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
DQ, Choose your chessPiece  (By entering X or O) 
o							----input
Player DQ. Enter your move: 

4							----input
+--+--+--+--+--+--+
|O |O |  |O |  |  |
+--+--+--+--+--+--+
|O |X |O |X |X |  |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|X |O |X |O |  |  |
+--+--+--+--+--+--+
|  |O |X |X |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
x							----input
Player ZXL. Enter your move: 

3							----input
+--+--+--+--+--+--+
|O |O |X |O |  |  |
+--+--+--+--+--+--+
|O |X |O |X |X |  |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|X |O |X |O |  |  |
+--+--+--+--+--+--+
|  |O |X |X |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
DQ, Choose your chessPiece  (By entering X or O) 
o							----input
Player DQ. Enter your move: 

6							----input
+--+--+--+--+--+--+
|O |O |X |O |  |O |
+--+--+--+--+--+--+
|O |X |O |X |X |  |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|X |O |X |O |  |  |
+--+--+--+--+--+--+
|  |O |X |X |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
o							----input
Player ZXL. Enter your move: 

12							----input
+--+--+--+--+--+--+
|O |O |X |O |  |O |
+--+--+--+--+--+--+
|O |X |O |X |X |O |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|X |O |X |O |  |  |
+--+--+--+--+--+--+
|  |O |X |X |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
DQ, Choose your chessPiece  (By entering X or O) 
o							----input
Player DQ. Enter your move: 

36							----input
+--+--+--+--+--+--+
|O |O |X |O |  |O |
+--+--+--+--+--+--+
|O |X |O |X |X |O |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|X |O |X |O |  |  |
+--+--+--+--+--+--+
|  |O |X |X |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |O |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
x							----input
Player ZXL. Enter your move: 

24							----input
+--+--+--+--+--+--+
|O |O |X |O |  |O |
+--+--+--+--+--+--+
|O |X |O |X |X |O |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|X |O |X |O |  |X |
+--+--+--+--+--+--+
|  |O |X |X |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |O |
+--+--+--+--+--+--+
DQ, Choose your chessPiece  (By entering X or O) 
o							----input
Player DQ. Enter your move: 

30							----input
+--+--+--+--+--+--+
|O |O |X |O |  |O |
+--+--+--+--+--+--+
|O |X |O |X |X |O |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|X |O |X |O |  |X |
+--+--+--+--+--+--+
|  |O |X |X |  |O |
+--+--+--+--+--+--+
|  |  |  |  |  |O |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
x							----input
Player ZXL. Enter your move: 

31							----input
+--+--+--+--+--+--+
|O |O |X |O |  |O |
+--+--+--+--+--+--+
|O |X |O |X |X |O |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|X |O |X |O |  |X |
+--+--+--+--+--+--+
|  |O |X |X |  |O |
+--+--+--+--+--+--+
|X |  |  |  |  |O |
+--+--+--+--+--+--+
DQ, Choose your chessPiece  (By entering X or O) 
o							----input
Player DQ. Enter your move: 

32							----input
+--+--+--+--+--+--+
|O |O |X |O |  |O |
+--+--+--+--+--+--+
|O |X |O |X |X |O |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|X |O |X |O |  |X |
+--+--+--+--+--+--+
|  |O |X |X |  |O |
+--+--+--+--+--+--+
|X |O |  |  |  |O |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
x							----input
Player ZXL. Enter your move: 

33							----input
+--+--+--+--+--+--+
|O |O |X |O |  |O |
+--+--+--+--+--+--+
|O |X |O |X |X |O |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|X |O |X |O |  |X |
+--+--+--+--+--+--+
|  |O |X |X |  |O |
+--+--+--+--+--+--+
|X |O |X |  |  |O |
+--+--+--+--+--+--+
DQ, Choose your chessPiece  (By entering X or O) 
o							----input
Player DQ. Enter your move: 

34							----input
+--+--+--+--+--+--+
|O |O |X |O |  |O |
+--+--+--+--+--+--+
|O |X |O |X |X |O |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|X |O |X |O |  |X |
+--+--+--+--+--+--+
|  |O |X |X |  |O |
+--+--+--+--+--+--+
|X |O |X |O |  |O |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
o							----input
Player ZXL. Enter your move: 

35							----input
+--+--+--+--+--+--+
|O |O |X |O |  |O |
+--+--+--+--+--+--+
|O |X |O |X |X |O |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|X |O |X |O |  |X |
+--+--+--+--+--+--+
|  |O |X |X |  |O |
+--+--+--+--+--+--+
|X |O |X |O |O |O |
+--+--+--+--+--+--+
DQ, Choose your chessPiece  (By entering X or O) 
x							----input
Player DQ. Enter your move: 

5							----input
+--+--+--+--+--+--+
|O |O |X |O |X |O |
+--+--+--+--+--+--+
|O |X |O |X |X |O |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|X |O |X |O |  |X |
+--+--+--+--+--+--+
|  |O |X |X |  |O |
+--+--+--+--+--+--+
|X |O |X |O |O |O |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
x							----input
Player ZXL. Enter your move: 

23							----input
+--+--+--+--+--+--+
|O |O |X |O |X |O |
+--+--+--+--+--+--+
|O |X |O |X |X |O |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|X |O |X |O |X |X |
+--+--+--+--+--+--+
|  |O |X |X |  |O |
+--+--+--+--+--+--+
|X |O |X |O |O |O |
+--+--+--+--+--+--+
DQ, Choose your chessPiece  (By entering X or O) 
x							----input
Player DQ. Enter your move: 

29							----input
+--+--+--+--+--+--+
|O |O |X |O |X |O |
+--+--+--+--+--+--+
|O |X |O |X |X |O |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|X |O |X |O |X |X |
+--+--+--+--+--+--+
|  |O |X |X |X |O |
+--+--+--+--+--+--+
|X |O |X |O |O |O |
+--+--+--+--+--+--+
ZXL, Choose your chessPiece  (By entering X or O) 
x							----input
Player ZXL. Enter your move: 

25							----input
+--+--+--+--+--+--+
|O |O |X |O |X |O |
+--+--+--+--+--+--+
|O |X |O |X |X |O |
+--+--+--+--+--+--+
|O |X |X |X |O |O |
+--+--+--+--+--+--+
|X |O |X |O |X |X |
+--+--+--+--+--+--+
|X |O |X |X |X |O |
+--+--+--+--+--+--+
|X |O |X |O |O |O |
+--+--+--+--+--+--+
ZXLWins as Chaos! 
Player ZXL Wins as Chaos.
The current score is : 
 player1 DQ : 0
player2 ZXL : 1
If you want to play one more current game, please enter Y or y. Otherwise the game will shut down and back to main menu

k							----input
welcome to Board Games designed by Xinlong. There are two games currently available. They are Tic-Tac-Toe and Order-and-Chaos. You can choose to play either one of them. Choose Tic-Tac-Toe by entering T and Order-and-Chaos by entering O.if you want to quit the game, please enter Q to quit
T							----input
Welcome to Tic Tac Toe game designed by Xinlong. What's the board size you want to play with? (please input an Integer that is greater or equal to 3)
3							----input
In this game Player can choose to play with either chess ‘X’ or chess ‘O’. You can’t set your chess outside of the board or on an existing chess. You will win if your chess can form a straight line with 3 pieces in any direction.
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
As shown below you have to input the number 1-9 to make the movement instead of entering of the row number and col number of the square. 

+--+--+--+
|1 |2 |3 |
+--+--+--+
|4 |5 |6 |
+--+--+--+
|7 |8 |9 |
+--+--+--+
Now you can decide who will be the first one to play. (By entering 1 or 2) 
player 1 is :DQ
player 2 is :ZXL
1							----input
DQ, Choose your chessPiece  (By entering X or O) 
X							----input
Player DQ. Enter your move: 

5							----input
+--+--+--+
|  |  |  |
+--+--+--+
|  |X |  |
+--+--+--+
|  |  |  |
+--+--+--+
Player ZXL. Enter your move: 

1							----input
+--+--+--+
|O |  |  |
+--+--+--+
|  |X |  |
+--+--+--+
|  |  |  |
+--+--+--+
Player DQ. Enter your move: 

2							----input
+--+--+--+
|O |X |  |
+--+--+--+
|  |X |  |
+--+--+--+
|  |  |  |
+--+--+--+
Player ZXL. Enter your move: 

8							----input
+--+--+--+
|O |X |  |
+--+--+--+
|  |X |  |
+--+--+--+
|  |O |  |
+--+--+--+
Player DQ. Enter your move: 

3							----input
+--+--+--+
|O |X |X |
+--+--+--+
|  |X |  |
+--+--+--+
|  |O |  |
+--+--+--+
Player ZXL. Enter your move: 

7							----input
+--+--+--+
|O |X |X |
+--+--+--+
|  |X |  |
+--+--+--+
|O |O |  |
+--+--+--+
Player DQ. Enter your move: 

4							----input
+--+--+--+
|O |X |X |
+--+--+--+
|X |X |  |
+--+--+--+
|O |O |  |
+--+--+--+
Player ZXL. Enter your move: 

6							----input
+--+--+--+
|O |X |X |
+--+--+--+
|X |X |O |
+--+--+--+
|O |O |  |
+--+--+--+
Player DQ. Enter your move: 

9							----input
+--+--+--+
|O |X |X |
+--+--+--+
|X |X |O |
+--+--+--+
|O |O |X |
+--+--+--+
Stalemate! 

The current score is : 
 player1 DQ : 0
player2 ZXL : 1
If you want to play one more current game, please enter Y or y. Otherwise the game will shut down and back to main menu

k							----input
welcome to Board Games designed by Xinlong. There are two games currently available. They are Tic-Tac-Toe and Order-and-Chaos. You can choose to play either one of them. Choose Tic-Tac-Toe by entering T and Order-and-Chaos by entering O.if you want to quit the game, please enter Q to quit
Q							----input

Process finished with exit code 0
