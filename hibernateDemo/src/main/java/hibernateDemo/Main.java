package hibernateDemo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {

		@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
  
		System.out.println("Line 1");
		Configuration configuration = new Configuration();
		System.out.println("Line 2");
		configuration.configure("hibernate.cfg.xml");
		System.out.println("Line 3");
	SessionFactory sessionFactory	=configuration.buildSessionFactory();
	System.out.println("Line 4");
	Session session = sessionFactory.openSession();
	System.out.println("Line 5");
	Transaction transaction=session.beginTransaction();
	
	
	@SuppressWarnings("deprecation")
	Query query = session.createQuery("from Student");
	List<Student> students= query.list();
	
	
	for(Student student: students) {
		
		System.out.println("Id>>" +student.getId());
		System.out.println("name>>" + student.getName());
		System.out.println("city>>" +student.getCity());
		
		
		
	}
	
	
	
session.getTransaction().commit();


	
		session.close();
	sessionFactory.close();
	System.out.println("record show");
	

	}

}
