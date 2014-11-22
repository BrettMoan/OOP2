package backup_two;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.*;

/*
 * This class follows the singleton pattern.
 */

public class HibernateUtilSingleton
{

    private static final SessionFactory sessionFactory;

    static{
        Configuration config = new Configuration();

        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

        //change the next line of code to match your MySQL URL and port

       
        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate");

        //change the next two lines of code to match your MySQL user name and password.

        config.setProperty("hibernate.connection.username", "hibernate");

        config.setProperty("hibernate.connection.password", "hibernate");

        //change the pool size to reflect how many users you expect your application to have initially

        config.setProperty("hibernate.connection.pool_size", "1");

        config.setProperty("hibernate.connection.autocommit", "true");

        config.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");

		/*
		 * un-comment the next line of code if you want to be able to drop and recreate tables for your data classes listed below.  This is generally a bad idea for security reasons.
		 */

        //config.setProperty("hibernate.hbm2ddl.auto", "create-drop");

        config.setProperty("hibernate.show_sql", "true");

        config.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");

        config.setProperty("hibernate.current_session_context_class", "thread");

		/*
		 *  Add your classes here that you want to match your database tables
		 *  The example has a User and a PhoneNumber class.
		 */
        
        config.addAnnotatedClass(SystemUser.class);
        config.addAnnotatedClass(Student.class);
        config.addAnnotatedClass(Department.class);
        config.addAnnotatedClass(Employee.class);
        config.addAnnotatedClass(Classes.class);
        config.addAnnotatedClass(ClassSection.class);
        config.addAnnotatedClass(StudentClassSection.class);
        
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();

        sessionFactory = config.buildSessionFactory(serviceRegistry);
        sessionFactory.getCurrentSession();
    }

    public static SessionFactory getSessionFactory(){

        return sessionFactory;

    }

    //make a private default constructor so that no other HibernateUtil can be created.

    private HibernateUtilSingleton()
    {

    }

}
