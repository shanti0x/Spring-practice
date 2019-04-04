package demo.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Course;
import demo.hibernate.demo.entity.Instructor;
import demo.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
            			
			// start a transaction
			session.beginTransaction();
			
			//obtin inst din db
			int theId =1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			//creez cursuri
			Course tempCourse1 = new Course("Mate");
			Course tempCourse2 = new Course("Fizica");
			Course tempCourse3 = new Course("Sport");
			
			//aduc cursurile in instr
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			tempInstructor.add(tempCourse3);
			
			//salvez cursurile
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse2);
			
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
