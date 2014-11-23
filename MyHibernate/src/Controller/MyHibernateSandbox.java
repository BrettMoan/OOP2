package Controller;
/*
 *  * SillyHibernateUseExample.java source code
 * The purpose of this class is to show how some of the abilities of Hibernate
 * are used.  Covered in this example application are; adding records to tables,
 * modifying records in tables, removing records from tables, and
 * using a Many-To-Many relationship between tables.
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;

import model.ClassSection;
import model.HibernateUtilSingleton;
import model.Student;
import model.SystemUser;
import model.DatabaseFacade;

public class MyHibernateSandbox
{
//    private List<Student> students;

    public MyHibernateSandbox() {
        // TODO Auto-generated constructor stub
    }
    /*
     * @param args
     */
    public static void main(String[] args) {

    	Scanner in = new Scanner(System.in);  
    	HashMap<String,Object> loginInfo = view.view.login(in);

    	Integer userID = DatabaseFacade.getUserId(params);
    	if (userID == null)
    	{
    		view.view.invalidUser(params);
    	}
    	else
    	{
         	String brettsClasses =  DatabaseFacade.getStudentClasses(userID);
        	System.out.println(brettsClasses);
    	}
    	
    	
    	
		
//        MyHibernateSandbox aHibernateSandbox = new MyHibernateSandbox();
//        aHibernateSandbox.addNewUsers();
//        aHibernateSandbox.showAllUsers();
//        aHibernateSandbox.modifyUser();
//        aHibernateSandbox.deleteAddedUsers();
    	
        return;
    }
    /*
     * show how to add records to the database
     */
//    private void addNewUsers() {
//        Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
//        /*
//         * all database interactions in Hibernate are required to be inside a transaction.
//         */
//        Transaction transaction = session.beginTransaction();
//        /*
//         * create some User instances.
//         */
//        
//        Query singleUserQuery = session.createQuery("select s from SystemUser as s where s.systemUserName='HIBERNATE'");
//        SystemUser HibernateUser = (SystemUser)singleUserQuery.uniqueResult();
//        
//        
//        Student aStudent = new Student();
//        aStudent.setAge(23);
//        aStudent.setFullName("Jeremy Heiner");
//        aStudent.setEmail("j-dog@foo.com");
//        aStudent.setPassword("roflcopter");
//        aStudent.setSystemUserByCreatedBy(HibernateUser);
//        aStudent.setSystemUserByLastUpdatedBy(HibernateUser);
//        
//        
//        Student bStudent = new Student();
//        bStudent.setAge(24);
//        bStudent.setFullName("Jordan Harris");
//        bStudent.setPassword("jip jab jimmy");
//        bStudent.setEmail("JJ-diggity-dog@foo.com");
//        bStudent.setSystemUserByCreatedBy(HibernateUser);
//        bStudent.setSystemUserByLastUpdatedBy(HibernateUser); 
//        		
//
//        /*
//         * save each instance as a record in the database
//         */
//        session.save(aStudent);
//        session.save(bStudent);
//        
//        transaction.commit();
//        /*
//         * prove that the User instances were added to the database and that
//         * the instances were each updated with a database generated id.
//         */
//        System.out.println("aStudent generated ID is: " + aStudent.getStudentId());
//        System.out.println("bStudent generated ID is: " + bStudent.getStudentId());
//    }
//
//    /*
//     * show how to get a collection of type List containing all of the records in the app_user table
//     */
//    private void showAllUsers() {
//        SessionFactory sf =  HibernateUtilSingleton.getSessionFactory();
//        Session session = sf.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//        /*	
//         * execute a HQL query against the database.  HQL is NOT SQL.  It is object based.
//         */
//        Query allUsersQuery = session.createQuery("select u from Student as u order by u.studentId");
//        /*
//         * get a list of User instances based on what was found in the database tables.
//         */
//        students = allUsersQuery.list();
//        System.out.println("num users: "+students.size());
//        /*
//         * iterate over each User instance returned by the query and found in the list.
//         */
//        Iterator<Student> iter = students.iterator();;
//        while(iter.hasNext()) {
//        	Student element = iter.next();
//            System.out.println(element.toString());
//        }
//        transaction.commit();
//    }
//
//    /*
//     * show how to modify a database record
//     */
//    private void modifyUser() {
//
//        Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//        /*
//         * get a single User instance from the database.
//         */
//        Query singleStudentQuery = session.createQuery("select u from Student as u where u.fullName='Jeremy Heiner'");
//        Student aUser = (Student)singleStudentQuery.uniqueResult();
//        /*
//         * change the user name for the Java instance
//         */
//        aUser.setFullName("J Dog");
//        /*
//         * call the session merge method for the User instance in question.  This tells the database that the instance is ready to be permanently stored.
//         */
//        session.merge(aUser);
//
//        /*
//         * call the transaction commit method.  This tells the database that the changes are ready to be permanently stored.
//         */
//        transaction.commit();
//        /*
//         * permanently store the changes into the database tables.
//         */
//        showAllUsers();
//    }
//
//    private void deleteAddedUsers() {
//        // TODO Auto-generated method stub
//        Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//
//        int numStudents = students.size();
//        System.out.println("student count: "+numStudents);
//        for(int i = 0; i < numStudents; i++)
//        {
//        	String systemUser = students.get(i).getSystemUserByCreatedBy().getSystemUserName();
//        	
//        	if(systemUser.equals("HIBERNATE"))
//        	{
//                System.out.println("deleting user "+students.get(i).getFullName());
//                session.delete(students.get(i));
//        	}
//        	else
//        		{
//        			System.out.println("getSystemUserName() = [" + systemUser + "]");
//        			System.out.println(systemUser == "HIBERNATE");
//        		}
//        }
//        transaction.commit();
//            /*
//             * at this point the records have been removed from the database but still exist in our class list attribute.
//             * Do not store lists retrieved from the database since they will be out of synch with the database table from which they come.
//             * This example shows that you should not store retrieved lists.
//             */
//        System.out.println(students);
//        students.clear();
//            /*
//             * now the Java instances are also gone and the database is back to its original state so the example application can be run again.
//             */
//        System.out.println(students);
//        numStudents = students.size();
//        System.out.println("student count: "+numStudents);
//    }

}