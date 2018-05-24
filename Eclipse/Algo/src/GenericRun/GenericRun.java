package GenericRun;
//import java.util.ArrayList;


public class GenericRun {

	public static void main(String[] args)
	{
//		int number = 10;
//		int fact = Factorial.computeFactorial(number);
//		System.out.printf("Factorial of %d is %d",number,fact);
		
//		ArrayList<Integer> a = new ArrayList(10);
//		a.add(10);
//		System.out.println(a.get(0));
		
		ConcreteStack<Double> s = new ConcreteStack<Double>();
		s.Push(1.2);
		s.Push(5.3);
		System.out.println(s.Pop());
		System.out.println(s.Pop());
		System.out.println(s.Pop());
		
	}
}

