package Base;
public class Calculator extends AbstractCalculator<Number> {

	@Override
	public Number add(Number a, Number b) {
		// TODO Auto-generated method stub
		
		try
		{
			a=(Integer)a;
			b=(Integer)b;
			return a.intValue()+b.intValue();			
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
			return a.doubleValue()+b.doubleValue();
		}
	}

	@Override
	public Number subtract(Number a, Number b) {
		// TODO Auto-generated method stub
		
		try
		{
			a=(Integer)a;
			b=(Integer)b;
			return a.intValue()-b.intValue();			
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
			return a.doubleValue()-b.doubleValue();
		}
	}

	@Override
	public Number multiply(Number a, Number b) {
		// TODO Auto-generated method stub
		
		try
		{
			a=(Integer)a;
			b=(Integer)b;
			return a.intValue()*b.intValue();			
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
			return a.doubleValue()*b.doubleValue();
		}
	}

	@Override
	public Number divide(Number a, Number b) {
		// TODO Auto-generated method stub
		
		try
		{
			a=(Integer)a;
			b=(Integer)b;
			return a.intValue()/b.intValue();			
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
			return a.doubleValue()/b.doubleValue();
		}
	}

}
