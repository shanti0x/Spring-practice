package demo.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Instructor;
import demo.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();
			
			// get the instructor detail object
			int theId = 9;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// print the instr detail
			System.out.println("TempIntructorDetail: " + tempInstructorDetail);

			// print the associated instructor
			System.out.println("The associated instructor: " + tempInstructorDetail.getInstructor());

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} 
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			//handle connection  leak issue
			session.close();
			factory.close();

		}
	}

}
