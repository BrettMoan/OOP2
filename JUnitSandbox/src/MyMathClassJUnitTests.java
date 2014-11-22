import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

public class MyMathClassJUnitTests {

	@Test
	public void testAddEquality()
	{
		Integer a = 8;
		Integer b = 22;
		Integer result=0;
		try {
			result = MyMathClass.add(a,b);
//			System.out.println("TEST:\ttestAddEquality"); 
//			System.out.println("\ta + b = result");
//			System.out.println("\t"+a+" + "+b+" = "+result+"\n");
			assertEquals((Integer)30,(Integer)result);
			
			a=-2;
			b= 22;
			result = MyMathClass.add(a,b);
//			System.out.println("TEST:\ttestAddEquality"); 
//			System.out.println("\ta + b = result");
//			System.out.println("\t"+a+" + "+b+" = "+result+"\n");
			assertEquals((Integer)20,(Integer)result);
			
			a=-2;
			b=-28;
			result = MyMathClass.add(a,b);
//			System.out.println("TEST:\ttestAddEquality"); 
//			System.out.println("\ta + b = result");
//			System.out.println("\t"+a+" + "+b+" = "+result+"\n");
			assertEquals((Integer)(-30),(Integer)result);
			
			a=48;
			b=-28;
			result = MyMathClass.add(a,b);
//			System.out.println("TEST:\ttestAddEquality"); 
//			System.out.println("\ta + b = result");
//			System.out.println("\t"+a+" + "+b+" = "+result+"\n");
			assertEquals((Integer)(20),(Integer)result);
			
		}
		catch (Exception e) {	
			fail(e.getMessage());
		}
	}

	@Test
	public void testSubtractEquality()
	{
		Integer a = 8;
		Integer b = 22;
		Integer result=0;
		try {
			result = MyMathClass.subtract(a,b);
//			System.out.println("TEST:\ttestsubtractEquality"); 
//			System.out.println("\ta - b = result");
//			System.out.println("\t"+a+" - "+b+" = "+result+"\n");
			assertEquals((Integer)(-14),(Integer)result);
			
			a=-2;
			b= 22;
			result = MyMathClass.subtract(a,b);
//			System.out.println("TEST:\ttestsubtractEquality"); 
//			System.out.println("\ta - b = result");
//			System.out.println("\t"+a+" - "+b+" = "+result+"\n");
			assertEquals((Integer)(-24),(Integer)result);
			
			a=-2;
			b=-28;
			result = MyMathClass.subtract(a,b);
//			System.out.println("TEST:\ttestsubtractEquality"); 
//			System.out.println("\ta - b = result");
//			System.out.println("\t"+a+" - "+b+" = "+result+"\n");
			assertEquals((Integer)(26),(Integer)result);
			
			a=48;
			b=-28;
			result = MyMathClass.subtract(a,b);
//			System.out.println("TEST:\ttestsubtractEquality"); 
//			System.out.println("\ta - b = result");
//			System.out.println("\t"+a+" - "+b+" = "+result+"\n");
			assertEquals((Integer)(76),(Integer)result);
			
		}
		catch (Exception e) {	
			fail(e.getMessage());
		}
	}
	@Test
	public void testMultiplyEquality()
	{
		Integer a = 0;
		Integer b = 0;
		Integer result=0;
		try {
			a=3;
			b=4;
			result = MyMathClass.multiply(a,b);
//			System.out.println("TEST:\ttestMultiplyEquality"); 
//			System.out.println("\ta * b = result");
//			System.out.println("\t"+a+" * "+b+" = "+result+"\n");
			assertEquals((Integer)(12),(Integer)result);
			
			a=-2;
			b= 22;
			result = MyMathClass.multiply(a,b);
//			System.out.println("TEST:\ttestMultiplyEquality"); 
//			System.out.println("\ta * b = result");
//			System.out.println("\t"+a+" * "+b+" = "+result+"\n");
			assertEquals((Integer)(-44),(Integer)result);
			
			a=-2;
			b=-50;
			result = MyMathClass.multiply(a,b);
//			System.out.println("TEST:\ttestMultiplyEquality"); 
//			System.out.println("\ta * b = result");
//			System.out.println("\t"+a+" * "+b+" = "+result+"\n");
			assertEquals((Integer)(100),(Integer)result);
			
			a=6;
			b=-36;
			result = MyMathClass.multiply(a,b);
//			System.out.println("TEST:\ttestMultiplyEquality"); 
//			System.out.println("\ta * b = result");
//			System.out.println("\t"+a+" * "+b+" = "+result+"\n");
			assertEquals((Integer)(-216),(Integer)result);
			
		}
		catch (Exception e) {	
			fail(e.getMessage());
		}
	}

	@Test
	public void testDivideEquality()
	{
		Integer a = 0;
		Integer b = 0;
		Integer result=0;
		try {
			a=11;
			b=4;
			result = MyMathClass.divide(a,b);
//			System.out.println("TEST:\ttestDivideEquality"); 
//			System.out.println("\ta / b = result");
//			System.out.println("\t"+a+" / "+b+" = "+result+"\n");
			assertEquals((Integer)(2),(Integer)result);
			
			a= 22;
			b= 2;
			result = MyMathClass.divide(a,b);
//			System.out.println("TEST:\ttestDivideEquality"); 
//			System.out.println("\ta / b = result");
//			System.out.println("\t"+a+" / "+b+" = "+result+"\n");
			assertEquals((Integer)(11),(Integer)result);
			
			a= 2;
			b= 22;
			result = MyMathClass.divide(a,b);
//			System.out.println("TEST:\ttestDivideEquality"); 
//			System.out.println("\ta / b = result");
//			System.out.println("\t"+a+" / "+b+" = "+result+"\n");
			assertEquals((Integer)(0),(Integer)result);		
			
			
			a=-50;
			b=-2;
			result = MyMathClass.divide(a,b);
//			System.out.println("TEST:\ttestDivideEquality"); 
//			System.out.println("\ta / b = result");
//			System.out.println("\t"+a+" / "+b+" = "+result+"\n");
			assertEquals((Integer)(25),(Integer)result);
			
			a=-49;
			b=-2;
			result = MyMathClass.divide(a,b);
//			System.out.println("TEST:\ttestDivideEquality"); 
//			System.out.println("\ta / b = result");
//			System.out.println("\t"+a+" / "+b+" = "+result+"\n");
			assertEquals((Integer)(24),(Integer)result);
			
			a=-2;
			b=-50;
			result = MyMathClass.divide(a,b);
//			System.out.println("TEST:\ttestDivideEquality"); 
//			System.out.println("\ta / b = result");
//			System.out.println("\t"+a+" / "+b+" = "+result+"\n");
			assertEquals((Integer)(0),(Integer)result);
			
			
			
			a=36;
			b=-6;
			result = MyMathClass.divide(a,b);
//			System.out.println("TEST:\ttestDivideEquality"); 
//			System.out.println("\ta / b = result");
//			System.out.println("\t"+a+" / "+b+" = "+result+"\n");
			assertEquals((Integer)(-6),(Integer)result);
			
			
			a=35;
			b=-6;
			result = MyMathClass.divide(a,b);
//			System.out.println("TEST:\ttestDivideEquality"); 
//			System.out.println("\ta / b = result");
//			System.out.println("\t"+a+" / "+b+" = "+result+"\n");
			assertEquals((Integer)(-5),(Integer)result);
			
			a=6;
			b=-7;
			result = MyMathClass.divide(a,b);
//			System.out.println("TEST:\ttestDivideEquality"); 
//			System.out.println("\ta / b = result");
//			System.out.println("\t"+a+" / "+b+" = "+result+"\n");
			assertEquals((Integer)(0),(Integer)result);
			
			a=-60;
			b=10;
			result = MyMathClass.divide(a,b);
//			System.out.println("TEST:\ttestDivideEquality"); 
//			System.out.println("\ta / b = result");
//			System.out.println("\t"+a+" / "+b+" = "+result+"\n");
			assertEquals((Integer)(-6),(Integer)result);		
			
			a=-59;
			b=10;
			result = MyMathClass.divide(a,b);
//			System.out.println("TEST:\ttestDivideEquality"); 
//			System.out.println("\ta / b = result");
//			System.out.println("\t"+a+" / "+b+" = "+result+"\n");
			assertEquals((Integer)(-5),(Integer)result);	
			
			a=-10;
			b=60;
			result = MyMathClass.divide(a,b);
//			System.out.println("TEST:\ttestDivideEquality"); 
//			System.out.println("\ta / b = result");
//			System.out.println("\t"+a+" / "+b+" = "+result+"\n");
			assertEquals((Integer)(0),(Integer)result);			
			
		}
		catch (Exception e) {	
			fail(e.getMessage());
		}
	}



	public void testAddPositivetoMAXVALUE()
	{
		try {
			Integer a = Integer.MAX_VALUE ;
			Integer b = 1;
			Integer result = MyMathClass.add(a,b);
//			System.out.println("TEST:\ttestAddPositivetoMAXVALUE"); 
//			System.out.println("\ta + b = result");
//			System.out.println("\t"+a+" + "+b+" = "+result+"\n");

			fail("Should Throw MaxIntOverFlowException");
		} catch (MaxIntOverFlowException e) { }
		catch (Exception e) {
			e.printStackTrace();
			fail("Should Throw MaxIntOverFlowException");
		}
	}

	@Test
	public void testAddNegativeToMINVALUE()
	{
		try {
			Integer a = Integer.MIN_VALUE;
			Integer b = -1;
			Integer result = MyMathClass.add(a,b);
//			System.out.println("TEST:\ttestAddNegativeToMINVALUE");
//			System.out.println("\ta + b = result");
//			System.out.println("\t"+a+" + "+b+" = "+result+"\n");
			fail("Should Throw MinIntOverFlowException");
		} catch (MinIntOverFlowException e) { }
		catch (Exception e) {
			e.printStackTrace();
			fail("Should Throw MinIntOverFlowException");
		}

	}
	@Test
	public void testSubtractNegativeFromMAXVALUE()
	{
		try {
			Integer a = Integer.MAX_VALUE ;
			Integer b = -1;
			Integer result = MyMathClass.subtract(a, b);
//			System.out.println("TEST:\ttestSubtractNegativeFromMAXVALUE"); 
//			System.out.println("\ta - b = result");
//			System.out.println("\t"+a+" - "+b+" = "+result+"\n");

			fail("Should Throw MaxIntOverFlowException");
		} catch (MaxIntOverFlowException e) { }
		catch (Exception e) {
			e.printStackTrace();
			fail("Should Throw MaxIntOverFlowException");
		}
	}
	@Test
	public void testSubtractMINVALUEFromZero()
	{
		try {
			Integer b = Integer.MIN_VALUE ;
			Integer a = 0;
			Integer result = MyMathClass.subtract(a, b);
//			System.out.println("TEST:\ttestSubtractNegativeFromMAXVALUE"); 
//			System.out.println("\ta - b = result");
//			System.out.println("\t"+a+" - "+b+" = "+result+"\n");

			fail("Should Throw MaxIntOverFlowException");
		} catch (MaxIntOverFlowException e) { }
		catch (Exception e) {
			e.printStackTrace();
			fail("Should Throw MaxIntOverFlowException");
		}
	}

	@Test
	public void testSubtractPostiveFromMINVALUE()
	{
		try {
			Integer a = Integer.MIN_VALUE;
			Integer b = 1;
			Integer result = MyMathClass.subtract(a,b);
//			System.out.println("TEST:\ttestSubtractPostiveFromMINVALUE");
//			System.out.println("\ta - b = result");
//			System.out.println("\t"+a+" - "+b+" = "+result+"\n");
			fail("Should Throw MinIntOverFlowException");
		} catch (MinIntOverFlowException e) { }
		catch (Exception e) {
			e.printStackTrace();
			fail("Should Throw MinIntOverFlowException");
		}

	}

	@Test
	public void testMultiplyOverMAXVALUE()
	{
		try {
			Integer a = Integer.MAX_VALUE;
			Integer b = 2;
			Integer result = MyMathClass.multiply(a,b);
//			System.out.println("TEST:\ttestMultiplyOverMAXVALUE");
//			System.out.println("\ta * b = result");
//			System.out.println("\t"+a+" * "+b+" = "+result+"\n");
			fail("Should Throw MaxIntOverFlowException");
		} catch (MaxIntOverFlowException e) { }
		catch (Exception e) {
			e.printStackTrace();
			fail("Should Throw MaxIntOverFlowException");
		}
	}


	@Test
	public void testMultiplyUnderMINVALUE()
	{
		try {
			Integer a = Integer.MIN_VALUE;
			Integer b = 2;
			Integer result = MyMathClass.multiply(a,b);
//			System.out.println("TEST:\ttestMultiplyUnderMINVALUE");
//			System.out.println("\ta * b = result");
//			System.out.println("\t"+a+" * "+b+" = "+result+"\n");
			fail("Should Throw MinIntOverFlowException");
		} catch (MinIntOverFlowException e) { }
		catch (Exception e) {
			e.printStackTrace();
			fail("Should Throw MinIntOverFlowException");
		}

	}	

	@Test
	public void testDivideByZero()
	{		
		try {
			Integer a = 42;
			Integer b = 0;
			Integer result = MyMathClass.divide(a,b);
//			System.out.println("TEST:\ttestDivideByZero");
//			System.out.println("\ta / b = result");
//			System.out.println("\t"+a+" / "+b+" = "+result+"\n");
			fail("Should Throw ArithmeticException");
		} catch (ArithmeticException e) { }
		catch (Exception e) {
			e.printStackTrace();
			fail("Should Throw ArithmeticException");
		}
	}

	@Test
	public void testValueAddNull()
	{
		try {
			Integer a = 42;
			Integer b = null;
			Integer result = MyMathClass.add(a,b);
//			System.out.println("TEST:\ttestValueAddNull");
//			System.out.println("\ta + b = result");
//			System.out.println("\t"+a+" + "+b+" = "+result+"\n");
			fail("Should Throw NullPointerException");
		} catch (NullPointerException e) { }
		catch (Exception e) {
			e.printStackTrace();
			fail("Should Throw NullPointerException");
		}

	}

	@Test
	public void testNullAddValue()
	{
		try {
			Integer b = 42;
			Integer a = null;
			Integer result = MyMathClass.add(a,b);		
//			System.out.println("TEST:\ttestNullAddValue");
//			System.out.println("\ta + b = result");
//			System.out.println("\t"+a+" + "+b+" = "+result+"\n");
			fail("Should Throw NullPointerException");
		} catch (NullPointerException e) { }
		catch (Exception e) {
			e.printStackTrace();
			fail("Should Throw NullPointerException");
		}

	}

	@Test
	public void testValueSubtractNull()
	{
		try {
			Integer a = 42;
			Integer b = null;
			Integer result = MyMathClass.subtract(a,b);
//			System.out.println("TEST:\ttestValueSubtractNull");
//			System.out.println("\ta - b = result");
//			System.out.println("\t"+a+" - "+b+" = "+result+"\n");
			fail("Should Throw NullPointerException");
		}catch (NullPointerException e) { }
		catch (Exception e) {
			e.printStackTrace();
			fail("Should Throw NullPointerException");
		}
	}

	@Test
	public void testNullSubtractValue()
	{
		try {
			Integer b = 42;
			Integer a = null;
			Integer result = MyMathClass.subtract(a,b);
//			System.out.println("TEST:\ttestNullSubtractValue");
//			System.out.println("\ta - b = result");
//			System.out.println("\t"+a+" - "+b+" = "+result+"\n");
			fail("Should Throw NullPointerException");
		} catch (NullPointerException e) { }
		catch (Exception e) {
			e.printStackTrace();
			fail("Should Throw NullPointerException");
		}
	}

	@Test
	public void testValueMultiplyNull()
	{
		try {
			Integer a = 42;
			Integer b = null;
			Integer result = MyMathClass.multiply(a,b);
//			System.out.println("TEST:\ttestValueMultiplyNull");
//			System.out.println("\ta + b = result");
//			System.out.println("\t"+a+" + "+b+" = "+result+"\n");
			fail("Should Throw NullPointerException");
		} catch (NullPointerException e) { }
		catch (Exception e) {
			e.printStackTrace();
			fail("Should Throw NullPointerException");
		}
	}

	@Test
	public void testNullMultiplyValue()
	{
		try {
			Integer a = 42;
			Integer b = null;
			Integer result = MyMathClass.multiply(a,b);
//			System.out.println("TEST:\ttestNullMultiplyValue");
//			System.out.println("\ta * b = result");
//			System.out.println("\t"+a+" * "+b+" = "+result+"\n");
			fail("Should Throw NullPointerException");
		} catch (NullPointerException e) { }
		catch (Exception e) {
			e.printStackTrace();
			fail("Should Throw NullPointerException");
		}
	}

	@Test
	public void testValueDivideByNull()
	{
		try {
			Integer a = 42;
			Integer b = null;
			Integer result = MyMathClass.divide(a,b);
//			System.out.println("TEST:\ttestDivideByNull");
//			System.out.println("\ta / b = result");
//			System.out.println("\t"+a+" / "+b+" = "+result+"\n");
			fail("Should Throw NullPointerException");
		} catch (NullPointerException e) { }
		catch (Exception e) {
			e.printStackTrace();
			fail("Should Throw NullPointerException");
		}
	}
	@Test
	public void testNullDivideByValue()
	{
		try {
			Integer a = null;
			Integer b = 42;
			Integer result = MyMathClass.divide(b,a);
//			System.out.println("TEST:\ttestDivideByNull");
//			System.out.println("\ta / b = result");
//			System.out.println("\t"+a+" / "+b+" = "+result+"\n");
			fail("Should Throw NullPointerException");
		} catch (NullPointerException e) { }
		catch (Exception e) {
			e.printStackTrace();
			fail("Should Throw NullPointerException");
		}
	}
}
