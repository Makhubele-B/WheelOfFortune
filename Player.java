import java.util.*;
public class Player {
	
	private int playerNumber;
	private char playerGuess;
	
	public Player(int number)
	{
		playerNumber = number;
	}
	
	public int getPlayerNumber()
	{
		return playerNumber;
	}
	
	public void setPlayerGuess(char guess)
	{
		playerGuess = guess;
	}
	
	public char getPlayerGuess()
	{
		return playerGuess;
	}

}
