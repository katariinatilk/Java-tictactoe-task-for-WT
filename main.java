import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    
    System.out.println("Let's play tic-tac-toe!"); 
    System.out.println("Player 1, you are X. Player 2, you are O.");

    boolean player1 = true;
    boolean gameOver = false;
    // creating a board
  // - for space; x - player 1; o -player 2; 3x3 board
    
  char[][] board = new char [3][3];

    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++) {
        board[i][j] = '_';
      }
    }

    // main game loop 

    while(!gameOver){
    createBoard(board); 
    char marker;
    if(player1) {
      marker = 'X';
    } else {
      marker = 'O';
    }
    playerInput(board, marker);      
    gameOver = checkWin(board) || checkDraw(board);
    if(!gameOver){
      player1=!player1;
     }
    }

    createBoard(board);
    System.out.println("Game over!");

    scanner.close();

  }
  
  // visual of the board/printing
  public static void createBoard(char[][] board) {
    for(int i=0; i < 3; i++){
      for(int j=0; j < 3; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }

    // user input for x and o

    public static void playerInput(char[][] board, char marker) {

    int userRow;
    int userColumn;

    Scanner scanner = new Scanner(System.in);

    while (true) {
      if(marker == 'X'){
        System.out.println("It's player 1's turn - X. Enter a row number from 1-3: ");
      } else {
        System.out.println("It's player 2's turn - O. Enter a row number from 1-3: ");
      }
      
    userRow = scanner.nextInt() - 1;
    System.out.println("Enter a column number from 1-3: ");
    userColumn = scanner.nextInt() - 1;
      
      if (userRow >= 0 && userRow < 3 && userColumn >= 0 && userColumn < 3) {
          if(board[userRow][userColumn] == '_') {
             board[userRow][userColumn] = marker; 
              break;
      } else {
        System.out.println("This cell is occupied. Check and enter again.");
          }
      } else {
        System.out.println("Invalid input. Enter again as per instructions.");
      }
    }  
  }
    public static boolean checkWin (char[][] board) {
      // check rows
      for(int i = 0; i < 3; i++) {
        if(board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '_') {
          return true;
        }
      }
      // check columns
      for(int j = 0; j < 3; j++){
        if(board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '_') {
             return true;
        }  
      }

      // check diagonals
      if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '_'){
          return true; 
      }
      if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '_'){
        return true; 
      }
      return false;
    
    }
  

    public static boolean checkDraw (char[][] board) {
      for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
          if(board[i][j] == '_'){
            return false;
          }
        }
      }
      return true; 
    }
}
