import java.util.ArrayList; //import arrayList package
import java.util.Scanner; //import scanner package
import javax.swing.*;


class Main {
  public static void main(String[] args) throws InterruptedException{
      
    System.out.print("\033[H\033[2J");
    System.out.flush(); 
    
    String sentence = "Welcome to Tic Tac Toe!" +"\n" + "You will be playing against the CPU." + "\n" + "Type 1 if you wish to play." + "\n" + "Type another number if you wish to stop.";

    System.out.println(sentence);

    Scanner scan = new Scanner(System.in);
    while (!scan.hasNextInt()) {
          System.out.println("Invalid input. Please enter a number: ");
          scan.next();
        }
    int answer = scan.nextInt();
    if(answer == 1)
    {
      System.out.print("\033[H\033[2J");
      System.out.flush(); 
      System.out.println("Do you want to go first? (1 for yes 2 for no)");
      while (!scan.hasNextInt()) 
        {
          System.out.println("Invalid input. Please enter a number: ");
          scan.next();
        }
      answer = scan.nextInt(); 
      while (answer < 1 || answer > 2)
      {
        System.out.println("Try again.");
        while (!scan.hasNextInt()) 
        {
          System.out.println("Invalid input. Please enter a number: ");
          scan.next();
        }
        answer = scan.nextInt(); 
      }

      if (answer == 1)
      {
        PlayerFirst game = new PlayerFirst();
        game.play();
      }
      else
      {
        CPUFirst game = new CPUFirst();
        game.play();
      }
    }
    else
      System.out.println("See you later!");
 
  /*
    TicTacToeCPU game = new TicTacToeCPU();
    game.playCPU(0,0);
    game.playCPU(0,1);
    game.play(2,2);
    game.play(2,3);
    game.play(3,3);
    game.printBoard();
    System.out.println(game.calcMove(0,2));
    System.out.println(game.calcMove(1,0));
   System.out.println(game.calcMove(2,0));
    System.out.println(game.calcMove(2,1));
*/
  
    }
  }
