package demo.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Instructor;
import demo.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			        
			
			// start a transaction
			session.beginTransaction();
			
			//obtin instructorul dupa cheia primara
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class,  theId);
			System.out.println("Found Instructor: " + tempInstructor);
			
			//sterg instructorul
			if(tempInstructor!=null) {
				
				System.out.println("Deleting: " + tempInstructor);
				//vor fi sterse si detaliile obiectelor pt ca am cascadeType.ALL
				
				session.delete(tempInstructor);
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		 
		} 
		finally {
			factory.close();

		
		}
	}

}
