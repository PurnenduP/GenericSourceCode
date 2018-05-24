package Base;

public abstract class AbstractCalculator<T extends Number> {

	public abstract T add(T a, T b);
	public abstract T subtract(T a, T b);
	public abstract T multiply(T a, T b);
	public abstract T divide(T a, T b);
}

