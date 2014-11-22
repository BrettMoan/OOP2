
public class MyMathClass {

	public static Integer add(Integer a, Integer b) throws NullPointerException, MaxIntOverFlowException, MinIntOverFlowException
	{
		if ((a > 0 && b > 0)&&(b > Integer.MAX_VALUE - a))
		{
			throw new MaxIntOverFlowException();
		}
		else if ((a < 0 && b < 0)&&(b < Integer.MIN_VALUE - a))
		{
			throw new MinIntOverFlowException();
		}
		return a + b;
	}
	public static Integer subtract(Integer a, Integer b) throws NullPointerException,MaxIntOverFlowException, MinIntOverFlowException
	{
		if ((a >= 0 && b < 0)&&(a > b + Integer.MAX_VALUE))
		{
			throw new MaxIntOverFlowException();
		}
		else if ((a < 0 && b > 0)&&(a < b + Integer.MIN_VALUE))
		{
			throw new MinIntOverFlowException();
		}
		return a - b;
	}
	public static Integer multiply(Integer a, Integer b) throws MaxIntOverFlowException, MinIntOverFlowException, NullPointerException
	{
		if ((a > 0 && b > 0) && (a > Integer.MAX_VALUE / b))
			throw new MaxIntOverFlowException();
		if ((a < 0 && b < 0) && (a < Integer.MAX_VALUE / b))
			throw new MaxIntOverFlowException();
		else if ((a > 0 && b < 0) && (b < Integer.MIN_VALUE / a))
			throw new MinIntOverFlowException();
		else if ((a < 0 && b > 0) && (a < Integer.MIN_VALUE / b))
			throw new MinIntOverFlowException();
		return a * b;
	}
	public static Integer divide(Integer a, Integer b) throws NullPointerException, ArithmeticException
	{
		return a / b;
	}
}
