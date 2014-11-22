import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class LazySingletonTests {
	@Before
	public void setUp() throws Exception {
		LazySingletonExample s= LazySingletonExample.getSingletonInstance();
		LazySingletonExample t= LazySingletonExample.getSingletonInstance();
	}
	
	@Test
	public void testSameInstanceViaCallToPrintSingleton()
	{
		LazySingletonExample s= LazySingletonExample.getSingletonInstance();
		LazySingletonExample t= LazySingletonExample.getSingletonInstance();
		s.printSingleton();
		t.printSingleton();
		s.printSingleton();
		t.printSingleton();
		assertEquals(s, t);
		assertEquals(4, t.i);
		assertEquals(4, s.i);	
	}
	
	@Test
	public void testClone()
	{
		LazySingletonExample s= LazySingletonExample.getSingletonInstance();
		try {
			LazySingletonExample t = (LazySingletonExample)s.clone();
			fail("CloneNotSupportedException was not thrown");
		} catch (CloneNotSupportedException e) {	}
		
	}
	
	@Test
	public void testConstructorIsPrivate()
	{
		try {
			Class<LazySingletonExample> singletonClass = (Class<LazySingletonExample>) Class.forName("SingletonExample");		 
			LazySingletonExample t = singletonClass.newInstance();
			fail("newInstance() called. Consructor needs to be private");
		} 
		catch (Exception e) {	}
	}
	
	
	@Test
	public void testConstructorMadePublicUsingReflection()
	{
		try {
			Constructor c[] = LazySingletonExample.class.getDeclaredConstructors();
			c[0].setAccessible(true);
			LazySingletonExample t = (LazySingletonExample)c[0].newInstance(null);
			fail("InstantiationErrorException was not thrown");	
		} catch (Exception e) {		}
	}
	
	
	
	
	
}	
