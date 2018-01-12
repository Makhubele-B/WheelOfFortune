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
		
		//Displays the initial board
		displayBoard(fortuneBoard);
		
		play(player1, fortuneBoard);
		
	}
	
	public static void displayBoard(GameBoard board)
	{
		
		//Display available letters
		board.displayLetters();
				
		//Update puzzle
		board.updatePuzzle();
				
		//Display updated puzzle
		board.displayPuzzle();	
		
	}
	
	public static void play (Player player, GameBoard board) 
	{
		Wheel fortuneWheel = new Wheel();
		int playerChoice=-1;
		boolean goAgain = true, puzzleSolved=false;
		Scanner keyboard; 
		
		/*This while executes under the condition that it is still the player's turn AND
		 *the puzzle is not yet solved. It will not execute if either the players turn has ended OR
		 *the puzzle was solved during the players turn
		 */
		while (goAgain==true && puzzleSolved==false)
		{
			
			boolean wasGuessed=false;
			
			/*This do-while loop prompts the player to spin (1) or guess(2) and continues to 
			 * loop while the player's input is not either 1 or 2
			 */
			do 
			{
				keyboard = new Scanner(System.in);
				
				/*this try-catch block handles the InputMismatchException thrown by Scanner's
				 * nextInt() method
				 */
				try 
				{
					//Prompts player to spin (1) or guess (2)
					System.out.print("Player " + player.getPlayerNumber() + " - would you like to Spin (1)"
						+ " or Guess (2) the puzzle? ");
					
					//Assigns player's input to variable
					playerChoice = keyboard.nextInt();
					
				}
				catch (InputMismatchException e)
				{
					//Assigns -1 to variable to prompt another loop iteration
					playerChoice=-1;
					System.out.println();
				}
				
			}while(playerChoice != 1 && playerChoice!=2);
			
			if(playerChoice == 1)
			{
				//Spins the wheel
				fortuneWheel.spin();
				
				/*This if-else block executes when the player lands on a wheel value 
				 * greater than 0.0
				 */
				if (fortuneWheel.getWheelValue()>0.0) 
				{
					
					do 
					{
						
						System.out.print("Select your letter from the available letters from above: ");
					
						player.setPlayerGuess(keyboard.next().charAt(0)); 
					
						wasGuessed = board.isLetterGuessed(player.getPlayerGuess());
						
					}while (wasGuessed);
					
					board.setCharacter(player.getPlayerGuess());
					
					System.out.println();
					board.updateAvailableLetters();
					
					if (board.isLetterInPuzzle(player.getPlayerGuess())==true)
					displayBoard(board);
					else
						goAgain=false;
				}
				else
				{
					goAgain = false;
				}
			}
			else
			{
				/*
				 * guess
				 */
			}
			
				//Insert a test here to check if puzzle solved
		}
		
	}
	
	
	
}
