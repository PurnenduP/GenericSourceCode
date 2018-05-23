package mypkg;
import mypkg2.*;

public class helloworld
{
	public static void main(String args[])
	{
		display d = new display("Say Hello World from a different package");
		System.out.println(d.getValue());
	}
	
}