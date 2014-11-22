package model;

import java.util.Date;
import java.util.HashMap;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DatabaseFacade {

	public Integer addNewUser(HashMap<String,Object> params) 
	{
		Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		Query singleStudentQuery = session.createQuery("select s from SystemUser as s "
				                                     + "where s.systemUserName='HIBERNATE'");
		SystemUser HibernateUser = (SystemUser)singleStudentQuery.uniqueResult();

		Student aStudent = new Student(HibernateUser,HibernateUser
				,(String)params.get("fullName"),(Integer)params.get("age")
				,(String)params.get("email"),(String)params.get("password"));

		session.save(aStudent);    		
		transaction.commit();
		return aStudent.getStudentId();
		
	}

	public Student getUserById(Integer studentId) 
	{
		Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		Query singleStudentQuery = session.createQuery("select u from Student as u "
				+ "where u.studentId="+studentId);
		Student aStudent = (Student)singleStudentQuery.uniqueResult();

		transaction.commit();

		return aStudent;
	}




	public Integer getUserId(HashMap<String,Object> params) 
	{
		Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();

		Query singleStudentQuery = session.createQuery("select s from SystemUser as s "
				+ "where s.password='" + (String)params.get("password")
				+ "' and s.email='" + (String)params.get("email")+ "'");
		Student aStudent = (Student)singleStudentQuery.uniqueResult();
		Integer studentId = aStudent.getStudentId();
		transaction.commit();

		return aStudent.getStudentId();
	}

	public boolean modifyStudent(HashMap<String,Object> params) 
	{
		Integer studentId = (Integer)params.get("studentId");
		String password = (String)params.get("password");
		String fullName = (String)params.get("fullName");
		String email = (String)params.get("email");
		Integer age = (Integer)params.get("age");

		if (studentId!=null && (password!=null || fullName!=null || email!=null || age!=null))
		{
			try
			{
				Session session = HibernateUtilSingleton.getSessionFactory().getCurrentSession();
				Transaction transaction = session.beginTransaction();
				Query singleStudentQuery = session.createQuery("select u from Student as u where u.studentId="+studentId);

				/*
				 * change the user name for the Java instance
				 */
				Student aUser = (Student)singleStudentQuery.uniqueResult();

				if (password!=null && !password.isEmpty())
					aUser.setPassword(password);
				if (fullName!=null && !fullName.isEmpty())
					aUser.setFullName(fullName);
				if (email!=null && !email.isEmpty())
					aUser.setEmail(email);
				if (age!=null)
					aUser.setAge(age);
				Date now = new Date();

				/*
				 * call the session merge method for the User instance in question.  
				 * This tells the database that the instance is ready to be permanently stored.
				 */
				session.merge(aUser);

				/*
				 * call the transaction commit method.  This tells the database
				 *  that the changes are ready to be permanently stored.
				 */
				transaction.commit();

				return transaction.wasCommitted();
				/*
				 * permanently store the changes into the database tables.
				 */

			} catch(Exception e){e.printStackTrace();}
		}
		return false;
	}





}
