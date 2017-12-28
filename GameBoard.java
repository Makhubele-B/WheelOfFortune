import java.util.*;
public class GameBoard {
	
	private StringBuilder availableLetters;
	private final String PUZZLE;
	private StringBuilder pendingPuzzle;
	private String category;
	private char character;
	
	
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

}
