import java.util.*;
public class WheelOfFortune 
{
	
	//Creates a new board
	private static GameBoard fortuneBoard = new GameBoard("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 
					"The Secret Life of Bees", "Movies"); 
	
	public static void displayBoard()
	{
		
		//Display available letters
		fortuneBoard.displayLetters();
				
		//Update puzzle
		fortuneBoard.updatePuzzle();
				
		//Display updated puzzle
		fortuneBoard.displayPuzzle();	
		
	}
	
	public static void play (Player player) 
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
					
				}
				
			}while(playerChoice != 1 && playerChoice!=2);
			
			if(playerChoice == 1)
			{
				//Spins the wheel
				fortuneWheel.spin();
				
				/*This if-else block executes when the player lands on a wheel value 
				 *greater than 0.0
				 */
				if (fortuneWheel.getWheelValue()>0.0) 
				{
					
					/*This do-while loop will execute as long as the player is guessing
					 * a letter that has already been guessed
					 */
					do 
					{
						//Prompts player to select a letter
						System.out.print("Select your letter from the available letters from above: ");
					
						//Gets player guess
						player.setPlayerGuess(keyboard.next().charAt(0)); 
					
						//Checks that the letter has not been guessed
						wasGuessed = fortuneBoard.isLetterGuessed(player.getPlayerGuess());
						
					}while (wasGuessed);
					
					/* Play the current letter on the board. 
					 * The validity of the letter has not been checked at this point
					 * Code has only checked that the letter is not a duplicate guess at this point
					 */
					fortuneBoard.setCharacter(player.getPlayerGuess());
					
					System.out.println();
					
					//Removes the current letter on the board from the list of available letters
					fortuneBoard.updateAvailableLetters();
					
					/* Now checking if current letter is in the puzzle
					 * If the player guesses a letter that is in the puzzle, player can go again
					 * else the player's turn terminates
					 */
					if (fortuneBoard.isLetterInPuzzle(player.getPlayerGuess())==true)
						displayBoard();
					else {
						goAgain=false;
						System.out.println("Incorrect!");
						System.out.println();
					}
	
				}
				
				else
				{
					//If wheel value is less than 0, turn terminates
					goAgain = false;
				}
			}
			else
			{
				System.out.print("Please Enter Your Guess: ");
				keyboard = new Scanner(System.in);
				String playerGuess = keyboard.next().trim();
				
				if (!playerGuess.equalsIgnoreCase(fortuneBoard.getPuzzle())) 
				{
					System.out.println("\nIncorrect!\n");
					goAgain = false;
				}
				
				else {
					fortuneBoard.setPendingPuzzle(playerGuess);
				}
			
		
						
				
			}
			
			/*Checks whether the puzzle has been solved
			 *Prints congratulatory message if puzzle is solved and terminates turn
			 */
			if(checkSolved()==true)
			{
				
				goAgain=false;
				System.out.println("Congratulations! You Solved the Puzzle!\n"+
							"Player " + player.getPlayerNumber()+ " Wins!");
			}
		}
		
	}//End Play
	
	public static boolean checkSolved()
	{
		boolean solved;
		if (fortuneBoard.getPendingPuzzle().equalsIgnoreCase(fortuneBoard.getPuzzle())) {
			solved = true;
			
		}
		else
			solved =  false;
		
		return solved;
	}
	
	public static void main (String [] args) 
	{
		//Prints welcome message
		System.out.println("Welcome to the Wheel of Fortune\n");
		
		//Creates 3 new players
		Player player1 = new Player(1);
		Player player2 = new Player(2);
		Player player3 = new Player(3);
		
		do {
			displayBoard();
			play(player1);
			
				if (checkSolved()==true)
				break;
				
			displayBoard();	
			play(player2);
			
				if (checkSolved()==true)
				break;
				
			displayBoard();
			play(player3);
			
				if (checkSolved()==true)
				break;
			
		}while(checkSolved()==false);
		
		
	}
	
	
}
