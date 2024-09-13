import java.util.*;

class Main {
  public static void main(String[] args) {
    char[][] board = new char[3][3];
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        board[row][col] = ' ';
      }
    }

    char player = 'X';
    boolean over = false;
    Scanner sc = new Scanner(System.in);

    System.out.println("** NOTE: Enter your input in the form of row(0-2) col(0-2) **");


    while (!over) {
      printBoard(board);
      System.out.print("Player " + player + " enter: ");
      int row = sc.nextInt();
      int col = sc.nextInt();
      
      if(row<0 || row>2 ||col<0 || col>2){
        System.out.println("Enter a valid row/col number!");
        row = sc.nextInt();
        col = sc.nextInt();
      }
      
      System.out.println();

      if (board[row][col] == ' ') {
        board[row][col] = player; 
        over = won(board, player);
        if (over) {
          System.out.println("Player " + player + " has won. Congratulations!!! ");
        } 
        else {
          if (player == 'X') {
          player = 'O';
          } 
          else {
          player = 'X';
          }
        }
      } 
      else {
        System.out.println("Invalid move. Try again!");
      }
    }
    printBoard(board);
  }

  public static boolean won(char[][] board, char player) {
    // check for rows
    for (int row = 0; row < board.length; row++) {
      if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
        return true;
      }
    }

    // check for col
    for (int col = 0; col < board[0].length; col++) {
      if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
        return true;
      }
    }

    // diagonals
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
      return true;
    }

    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
      return true;
    }
    return false;
  }

  public static void printBoard(char[][] board) {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        System.out.print(board[row][col] + " | ");
      }
      System.out.println();
    }
  }
}