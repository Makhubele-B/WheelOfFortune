import java.util.*;
public class Wheel 
{
	private Random rando;
	private int wheelSpot;
	private double wheelValue;
	
	public void spin()
	{
		rando = new Random();
		wheelSpot = rando.nextInt(9)+1;
		wheelValue = wheelValue(wheelSpot);
		System.out.println("You landed on $" + wheelValue );
		System.out.println();
	}
	
	private double wheelValue(int spot)
	{
		double [] wheelValues = {100.0, 300.0, 500.0, 700.0, 900.0,
									2000.0, 3000.0, 5000.0, -1000.0, 0.0};
		
		return wheelValues[spot];
	}
	
	public double getWheelValue()
	{
		return wheelValue;
	}
	
}
