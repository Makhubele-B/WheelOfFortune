import java.util.*;
public class GameBoard {
	
	private StringBuilder availableLetters;
	private final String PUZZLE;
	private StringBuilder pendingPuzzle;
	private String category;
	private char character;
	
	/**
	 * This constructor initializes a new game board with the letters available to the players
	 * at the start of the game, the puzzle to be guessed by the players, and the category pertaining
	 * to the puzzle. Constructor sets the initial value of the character currently on the board to 
	 * a blank character
	 * @param letters Letters made available to players at the start of the game
	 * @param puzzle Puzzle to be solved by players
	 * @param category Category pertaining to puzzle
	 */
	public GameBoard (String letters, String puzzle, String category)
	{
		
		availableLetters = new StringBuilder(letters.toUpperCase());
		PUZZLE = puzzle;
		this.category = category;
		character = ' ';
		
		pendingPuzzle = new StringBuilder(puzzle);
		
		for (int i=0; i<PUZZLE.length();i++)
		{
			pendingPuzzle.setCharAt(i, character);
					
		}
		
	}
	
	public void setCharacter(char character)
	{
		this.character = character;
	}
	
	public void updateAvailableLetters()
	{
		
		int index = availableLetters.toString().toLowerCase().indexOf(Character.toLowerCase(character));
		
		availableLetters.setCharAt(index, ' ');
	}
	
	public void displayLetters()
	{
		System.out.println("Available letters - " + availableLetters);
		System.out.println();
	}
	
	/**
	 * This method checks whether the player's letter guess was previously guessed.
	 * Returns true if it was previously guessed and false otherwise.
	 * @param letterGuess The letter currently on the board (The letter being played)
	 * @return Whether or not the current letter was previously guessed
	 */
	public boolean isLetterGuessed(char letterGuess)
	{
		
		if ((availableLetters.toString().toLowerCase().indexOf(Character.toLowerCase(letterGuess)))==-1)
				return true;
		else
			return false;
		
	}
	
	public boolean isLetterInPuzzle(char letterGuess)
	{
		
		boolean status = false;
		
		for (int i=0; i<PUZZLE.length();i++)
		{
			if (Character.toLowerCase(character) == Character.toLowerCase(PUZZLE.charAt(i)))
			{
				status = true;
				break;
			}
			else
				status = false;
			
					
		}
		return status;
	}
	public void updatePuzzle()
	{
		for (int i=0; i<PUZZLE.length();i++)
		{
			if (Character.toLowerCase(character) == Character.toLowerCase(PUZZLE.charAt(i)))
			pendingPuzzle.setCharAt(i, PUZZLE.charAt(i));
					
		}
	}
	
	public void displayPuzzle()
	{
		System.out.println("Here is the puzzle (" + category + "):");
		
		System.out.print(pendingPuzzle.toString());
		
		System.out.println();
		
		for (int i=0; i<PUZZLE.length();i++)
		{
			
			if (Character.isLetter(PUZZLE.charAt(i))) {
				System.out.print("-");
				
			}
			else
				System.out.print(" ");
					
		}
		
		System.out.println();

	}
	
	public void setPendingPuzzle(String puzzleGuess) 
	{
		pendingPuzzle = new StringBuilder(puzzleGuess.trim());
	}
	
	public String getPendingPuzzle() 
	{
		return this.pendingPuzzle.toString();
	}
	
	public String getPuzzle() 
	{
		return this.PUZZLE;
	}

}
