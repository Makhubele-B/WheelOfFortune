
public class WheelOfFortune 
{
	public static void main (String [] args) 
	{
		//Prints welcome message
		System.out.println("Welcome to the Wheel of Fortune\n");
		
		//Creates a new board
		GameBoard fortuneBoard = new GameBoard("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 
				"The Secret Life of Bees", "Movies");
		
		fortuneBoard.displayLetters();
		
		System.out.println();
		
		fortuneBoard.updatePuzzle();
		
		fortuneBoard.displayPuzzle();
	}
}
