/**
 * 
 */
package Beans;

import java.io.Serializable;
import java.util.HashMap;
/**
 * @author Brett
 */

public class Student implements Serializable
{

	private static final long serialVersionUID = -7299967617992798187L;
	
	private Long age;
	private String firstName;
	private String lastName;
	private Double gpa;
	private Long credits
	;
	public Student()
	{
		/*empty constructor*/
		
	}
	public Student(Long age, Long credits, Double gpa, String firstName, String lastName){
    	this.setAge(age);
    	this.setCredits(credits);
    	this.setGpa(gpa);
    	this.setFirstName(firstName);
    	this.setLastName(lastName);
	}
	public Student(HashMap<String, Object> map)
	{
    	this.setAge((Long)map.get("age"));
    	this.setCredits((Long)map.get("credits"));
    	this.setGpa((Double)map.get("gpa"));
    	this.setFirstName((String)map.get("firstName"));
    	this.setLastName((String)map.get("lastName"));
	}
	public String toString(){
		return "Student [FirstName:"+firstName+", lastName:"+lastName+" age:"+age+" GPA:"+gpa+" credits:"+credits+"]";  
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Double getGpa() {
		return gpa;
	}
	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}
	public Long getCredits() {
		return credits;
	}
	public void setCredits(Long credits) {
		this.credits = credits;
	}
	
}
