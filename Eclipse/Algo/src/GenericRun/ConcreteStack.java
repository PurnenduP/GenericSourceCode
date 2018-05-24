package GenericRun;
import java.util.*;
import Base.*;

public class ConcreteStack<T> extends AbstractStack<T>{
	
	ArrayList<T> st;
	
	public ConcreteStack()
	{
		st = new ArrayList<T>(10);
	}
	@Override
	public void Push(T n) {
		// TODO Auto-generated method stub
		st.add(n);
	}

	@Override
	public T Pop() {
		// TODO Auto-generated method stub
		if(st.size()==0)
			{System.out.println("Stack is Empty");return null;}
		T temp = (T) st.get(st.size()-1);
		st.remove(st.size()-1);
		return temp;
	}

}
