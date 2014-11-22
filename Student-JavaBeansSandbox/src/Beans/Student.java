/**
 * 
 */
package Beans;

import java.io.Serializable;

/**
 * @author Brett
 *
 */

public class Student implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7299967617992798187L;
	
	private int age;
	private String firstName;
	private String lastName;
	private double gpa;
	private int credits;
	public Student()
	{
		// empty contructor
	}
	public Student(int age, int credits, double gpa, String firstName, String lastName)
	{
    	this.setAge(age);
    	this.setCredits(credits);
    	this.setGpa(gpa);
    	this.setFirstName(firstName);
    	this.setLastName(lastName);
	
	}
	
	public String toString()
	{
		return "Student [FirstName:"+firstName+", lastName:"+lastName+" age:"+age+" GPA:"+gpa+" credits:"+credits+"]";  
		//return "User [id=" + id + ", pword=" + pword + ", uname=" + uname + ", phoneNumbers]";
		
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
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
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
}
