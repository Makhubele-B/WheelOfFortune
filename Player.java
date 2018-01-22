import java.util.*;
public class Player {
	
	private int playerNumber;
	private char playerGuess;
	private double total;
	
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
	
	//Under construction
	public double setTotal(double totalb)
	{
		return total;
	}

}
