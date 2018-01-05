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
		Scanner keyboard = new Scanner(System.in);
		
		
		while (goAgain==true && puzzleSolved==false)
		{
			
			boolean wasGuessed=false;
			
			do 
			{
				
				System.out.print("Player " + player.getPlayerNumber() + " - would you like to Spin (1)"
						+ " or Guess (2) the puzzle? ");
				playerChoice = keyboard.nextInt();
				
			}while(playerChoice != 1 && playerChoice!=2);
			
			if(playerChoice == 1)
			{
				
				fortuneWheel.spin();
				if (fortuneWheel.getWheelValue()>0.0) 
				{
					
					do {
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
