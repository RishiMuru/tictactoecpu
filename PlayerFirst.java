import java.util.ArrayList; //import arrayList package
import java.util.Scanner; //import scanner package
import javax.swing.*;

public class PlayerFirst{

  public void play() throws InterruptedException{
      Scanner scan = new Scanner(System.in);
      System.out.print("\033[H\033[2J");
      System.out.flush(); 
      TicTacToeCPU game = new TicTacToeCPU();
      int row;
      int col;
      while(!game.checkWin("X") && !game.checkWin("O") && !game.isBoardFull())
      {
          game.printBoard();
          System.out.println("Row? 1-3");
          while (!scan.hasNextInt())
          {
            System.out.println("Invalid input. Please enter a number: ");
            scan.next();
          }
          row = scan.nextInt();
          while (row < 1 || row > 3)
          {
            System.out.println("Try again");
            while (!scan.hasNextInt()) 
            {
              System.out.println("Invalid input. Please enter a number: ");
              scan.next();
            }
          row = scan.nextInt();
          }
          System.out.println("Column? 1-3");
          while (!scan.hasNextInt()) 
          {
            System.out.println("Invalid input. Please enter a number: ");
            scan.next(); 
          }
          col = scan.nextInt();
          while (col < 1 || col > 3)
          {
            System.out.println("Try again");
            while (!scan.hasNextInt()) 
            {
              System.out.println("Invalid input. Please enter a number: ");
              scan.next();
            }
            col = scan.nextInt();
          }  
          if (game.getVal(row, col) != null)
          {
            System.out.print("That spot is full. Try again.");
            Thread.sleep(1000);
          }
          else
          {
            game.play(row,col);
            System.out.print("\033[H\033[2J");
            System.out.flush(); 
            game.printBoard();
            if (!game.checkWin("X") && !game.checkWin("O") && !game.isBoardFull()){
              Thread.sleep(1000);
              game.CPUmove();
            }
          } 
          System.out.print("\033[H\033[2J");
          System.out.flush(); 
      }
      game.printBoard();
      if(game.checkWin("X"))
        System.out.println("Player Wins!");
       else if (game.checkWin("O"))
        System.out.println("Computer Wins!");
      else
        System.out.println("Tie.");
    
  }
}