import java.lang.reflect.Constructor;
public class Lazy {

	public static void main(String[] args) 
	{
		LazySingletonExample s = LazySingletonExample.getSingletonInstance();
		LazySingletonExample t = LazySingletonExample.getSingletonInstance();

		s.printSingleton();
		t.printSingleton();
		t.printSingleton();
		
		if(s.equals(t))
			System.out.println("s & t are the same SingletonExample!");
		else
			System.err.println("s & t are different SingletonExamples!");
		System.out.println("\n\n");
		try {
			Class<LazySingletonExample> singletonClass = (Class<LazySingletonExample>) Class.forName("SingletonExample");		 
			LazySingletonExample r = singletonClass.newInstance();
		} 
		catch (Exception e) {	
			System.err.println("ERROR: Fails because the Constuctor is Private!");
			e.printStackTrace(System.err);
		}
		System.out.println("\n\n");
		try {
			
			Constructor c[] = LazySingletonExample.class.getDeclaredConstructors();
//			System.out.print("Number of SingletonExample Constructors: "+ c.length + "\n");;
			c[0].setAccessible(true);
			t = (LazySingletonExample)c[0].newInstance(null);
			System.out.println("New Object created because Constuctor was made public!");	
		} catch (Exception e) {
			System.err.println("ERROR: Fails because Constructor conatins if(singletonInstance != null ) throw new InstantiationError.");
			e.printStackTrace();
		}
		
		finally
		{
			t.printSingleton();
			t.printSingleton();
			t.printSingleton();
			if(s.equals(t))
				System.err.println("s & t are the same SingletonExample!");
			else
				System.err.println("s & t are different SingletonExamples!");
		}

	}
}
