
import Beans.Student;
public class JavaBeans
{
   
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    
    	Student brett = new Student();
    	brett.setAge(22);
    	brett.setCredits(105);
    	brett.setFirstName("Brett");
    	brett.setLastName("Moan");
    	brett.setGpa(3.8);
    	printStudent(brett);
    	
    	Student matt = new Student(30,80,3.2,"Matt","Mason");
    	printStudent(matt);
    	System.out.println(brett.toString());
    	try 
    	{
    		Class aClass = Student.class;
    		Student bob = (Student) aClass.newInstance();
		} catch (Exception e) 
    	{
			// TODO: handle exception
			
		}
    	
    	
    	
    }
    
    public static void printStudent(Student s)
    {
    	
    	System.out.println("Name: "+s.getFirstName()+ " " +s.getLastName());
    	System.out.println("Age: "+s.getAge());
    	System.out.println("Credits: "+s.getCredits());
    	System.out.println("Gpa: "+s.getGpa());
    }
    
//    public Student newStudent(int age, int credits, double gpa, String firstName, String lastName)
//	{
//    	Student s = new Student();
//    	s.setAge(age);
//    	s.setCredits(credits);
//    	s.setGpa(gpa);
//    	s.setFirstName(firstName);
//    	s.setLastName(lastName);
//	 	return s;
//	
//	}

}