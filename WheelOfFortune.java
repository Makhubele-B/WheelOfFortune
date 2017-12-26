import java.util.*;
public class WheelOfFortune 
{
	public static void main (String [] args) 
	{
		//Prints welcome message
		System.out.println("Welcome to the Wheel of Fortune\n");
		
		//Creates a new board
		GameBoard fortuneBoard = new GameBoard("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 
				"The Secret Life of Bees", "Movies"); 
		
		//Creates 3 new players
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		Player player3 = new Player(3);
		
		//Display available letters
		fortuneBoard.displayLetters();
		
		//Update puzzle
		fortuneBoard.updatePuzzle();
		
		//Display updated puzzle
		fortuneBoard.displayPuzzle();	
		
		play(player1);
		
	}
	
	public static void play (Player player) 
	{
		Wheel fortuneWheel = new Wheel();
		int playerChoice=-1;
		
		Scanner keyboard = new Scanner(System.in);
		
		while (playerChoice != 1 && playerChoice!=2) 
		{
			System.out.print("Player " + player.getPlayerNumber() + " - would you like to Spin (1)"
					+ " or Guess (2) the puzzle? ");
			playerChoice = keyboard.nextInt();
		}
		
		if(playerChoice == 1)
		{
			fortuneWheel.spin();
		}
		else
		{
			/*
			 * guess
			 */
		}
		
	}
	
}
