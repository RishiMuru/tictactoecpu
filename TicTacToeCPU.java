import java.util.Random;

public class TicTacToeCPU{
  private String[][] board;

  public TicTacToeCPU(){
    board = new String[3][3];
  }
  
  public void printBoard(){
    System.out.println("   1  2  3");
    System.out.println("  ---------");
    int rowNum = 1;
    for (int r = 0; r < board.length; r++)
      {
        System.out.print(rowNum + " ");
        rowNum++;
        for (int c = 0; c < board[0].length; c++)
          {
            if (board[r][c] == null)
              System.out.print("| |");
            else
              System.out.print("|" + board[r][c] + "|");
            if (c == 2)
              
              System.out.println();
          }
        System.out.println("  ---------");
      }
  }

  public void play(int row, int col){
    if (board[row-1][col-1] == null)
    {
      board[row-1][col-1] = "X";
    }
  }
  
   public void playCPU (int row, int col){
    if (board[row][col] == null)
    {
      board[row][col] = "O";
    }
  }

  
  
  public boolean checkWin(String character) {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == character && board[row][1] == character && board[row][2] == character) {
                return true;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (board[0][col] == character && board[1][col] == character && board[2][col] == character) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == character && board[1][1] == character && board[2][2] == character) {
            return true;
        }
        if (board[0][2] == character && board[1][1] == character && board[2][0] == character) {
            return true;
        }

        return false;
    }

  public boolean isBoardFull(){
    for (int r = 0; r < board.length; r++)
      {
        for (int c = 0; c < board[0].length; c++)
          {
            if (board[r][c] == null)
              return false;
          }
      }
    return true;
  }

  
  public String getVal(int r, int c){
    return board[r-1][c-1];
  }

  

  public void CPUmove(){
    int bestScore = -1;
    int bestRow = 1;
    int bestCol = 1; 
    int move = -1; 
    boolean run = true; 
 
    for (int r = 0; r < board.length; r++)
      {
        
        for (int c = 0; c < board[0].length; c++)
          {
            if(board[r][c] == null)
            {
              move = calcMove(r,c);
              if (move > bestScore)
              {
                bestScore = move;
                bestRow = r;
                bestCol = c;
              }
            }
          }  
      }
  if (bestScore == 1 || bestScore == 2 || bestScore == 3)
     playCPU(bestRow, bestCol);
  else if(board[1][1] == null)
      playCPU(1,1);
  else
  {
    while(run)
      {
        bestRow = (int)(Math.random()*3);
        bestCol = (int)(Math.random()*3);
        if (board[bestRow][bestCol] == null)
          run = false;
      }
    playCPU(bestRow,bestCol);
  }
  }

  
  public int calcMove(int row, int col)
  {
    board[row][col] = "O";
      if ((checkWin("O")))
      {
        board[row][col] = null;
        return 3;
      } 
    board[row][col] = "X";
    if ((checkWin("X")))
      {
        board[row][col] = null;
        return 2;
      } 
    board[row][col] = null;
    return simSecondMove(row, col);
  }

  public int simSecondMove(int row, int col){
    int move; 
    board[row][col] = "O";
    for (int r = 0; r < board.length; r++)
      {
        for (int c = 0; c < board[0].length; c++)
          {
            if(board[r][c] == null)
            {
              move = calcSecondMove(r,c);
              if (move == 1)
              {
                board[row][col] = null;
                return 1; 
              }
            
            }  
          }
        }
    board[row][col] = null;
    return 0;
  }

  public int calcSecondMove(int row, int col){
    board[row][col] = "O";
      if ((checkWin("O")))
      {
        board[row][col] = null;
        return 1;
      } 
    board[row][col] = null;
    return 0; 
  }
}
