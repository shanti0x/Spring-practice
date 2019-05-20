package demo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Course;
import demo.hibernate.demo.entity.Instructor;
import demo.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
            //creez ob
			Instructor tempInstructor=new Instructor("Susan", "Public", "susan.public@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "video game");
			
			//asociez obiectele
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			//salvez instructorul
			//se vor salva si detaliile ob din cauza ca am cascade all

			
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		 
		} 
		finally {
			//add clean up code
			session.close();
			factory.close();

		
		}
	}

}
