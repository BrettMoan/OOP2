import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class EagerSingletonTests {
	EagerSingletonExample outerThreadSingleton;

	
	@Test
	public void testMultiThreading()
	{
		   
		EagerSingletonExample t;
		// Testing Multi-Threading is actually a lot harder than than this.
		// This is because trying to get 2 exactly simultaneous calls to 
		// anything is very difficult.
		
		final Thread outerThread = new Thread(new Runnable()
		{
			public void run()
			{
				try{
					outerThreadSingleton = EagerSingletonExample.getSingletonInstance();
					outerThreadSingleton.i+=1;
					outerThreadSingleton.i+=1;
					outerThreadSingleton.i+=1;
					outerThreadSingleton.i+=1;
					
				}catch (Exception e1) {
					e1.printStackTrace();
				}		
			}
		});
		outerThread.start();
		t = EagerSingletonExample.getSingletonInstance();
		t.i+=1;
		t.i+=1;	
		try {
			outerThread.join();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
		
		assertEquals(t, outerThreadSingleton);
		assertEquals(6, t.i);
		assertEquals(6, outerThreadSingleton.i);
	}
	
	@Test
	public void testSameInstanceViaCallToPrintSingleton()
	{
		EagerSingletonExample s;   
		EagerSingletonExample t;   
		t = EagerSingletonExample.getSingletonInstance();
		s = EagerSingletonExample.getSingletonInstance();
		s.i+=1;
		t.i+=1;
		s.i+=1;
		t.i+=1;
		assertEquals(s, t);
		assertEquals(4, t.i);
		assertEquals(4, s.i);	
		s.i=0;
	}
	
	@Test
	public void testClone()
	{
		EagerSingletonExample s;   
		EagerSingletonExample t;   
		EagerSingletonExample foo;   
		
		t = EagerSingletonExample.getSingletonInstance();
		s = EagerSingletonExample.getSingletonInstance();
		try {
			foo = (EagerSingletonExample)t.clone();
			fail("CloneNotSupportedException was not thrown");
		} catch (CloneNotSupportedException e) {	}
		
	}
	
	@Test
	public void testConstructorIsPrivate()
	{
		EagerSingletonExample s;   
		EagerSingletonExample t;
		EagerSingletonExample foo;
		t = EagerSingletonExample.getSingletonInstance();
		s = EagerSingletonExample.getSingletonInstance();
		try {
			Class<EagerSingletonExample> NonLazySingletonClass = (Class<EagerSingletonExample>) Class.forName("SingletonExample");		 
			foo = NonLazySingletonClass.newInstance();
			fail("newInstance() called. Consructor needs to be private");
		} 
		catch (Exception e) {	}
	}
	
	
	@Test
	public void testConstructorMadePublicUsingReflection()
	{
		EagerSingletonExample s;   
		EagerSingletonExample t;   
		t = EagerSingletonExample.getSingletonInstance();
		s = EagerSingletonExample.getSingletonInstance();
		try {
			Constructor c[] = LazySingletonExample.class.getDeclaredConstructors();
			c[0].setAccessible(true);
			t = (EagerSingletonExample)c[0].newInstance(null);
			fail("InstantiationErrorException was not thrown");	
		} catch (Exception e) {		}
	}
	
	
	
	
	
}	
