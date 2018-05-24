package myPkg;
import Base.Calculator;
import AnotherPkg.ScientificCalculator;

/**
 * 
 */
/**
 * @author india
 *
 */

class Add2Numbers
{
	private int first_number;
	private int second_number;
	
	public Add2Numbers()
	{
		this.first_number=0;
		this.second_number=0;
	}
	public Add2Numbers(int n1,int n2)
	{
		first_number = n1;
		second_number = n2;
		
	}
	
	public int Add()
	{
		return first_number+second_number;
	}
}
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Hello World");
		Calculator c = new Calculator();
		System.out.println("The result is :"+c.divide(4,0));
//		int a = 10;
//		a = 1/0;
		//ScientificCalculator d = new ScientificCalculator();
		//System.out.println("The xToY is :"+d.xToy(2,2));
			}

}
