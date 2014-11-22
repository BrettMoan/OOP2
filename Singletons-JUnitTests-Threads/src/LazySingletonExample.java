// Serializable not needed but thrown in to test.
import java.io.Serializable;

public class LazySingletonExample implements Serializable{	
	private static final long serialVersionUID = 3119105548371608200L;
	
    // Static member holds only one instance of the SingletonExample class
    private static LazySingletonExample singletonInstance;
    
    // Real singleton's should not have attributes.
    // only exists to confirm that multiple Single Objects actually point to the same INSTANCE
    public int i;
    
    // Providing global point of access
    public static LazySingletonExample getSingletonInstance() {
        if (null == singletonInstance) 
        {
            singletonInstance = new LazySingletonExample();
        }
        return singletonInstance;
    }
 
    public void printSingleton(){
        System.out.println("calling printSingleton()... i = "+ i++	);
    }
    
    // code Added to prevent Instantiation of another SingletonExample object.
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of this class is not allowed"); 
    }
    
    protected Object readResolve() {
        return singletonInstance;
    }
    
    private LazySingletonExample() {
        if(singletonInstance != null ) 
        {
            throw new InstantiationError( "Creating of this object is not allowed." );
        }
    }
    
    
}