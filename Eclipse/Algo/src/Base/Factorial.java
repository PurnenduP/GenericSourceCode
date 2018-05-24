package Base;

public class Factorial {

	
	public static int computeFactorial(int number)
	{
		if(number ==0)
			{return 1;}
		else
		{
		return number * Factorial.computeFactorial(number-1);
		}
	}
	
}
