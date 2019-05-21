package demo.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Course;
import demo.hibernate.demo.entity.Instructor;
import demo.hibernate.demo.entity.InstructorDetail;
import demo.hibernate.demo.entity.Review;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
            			
			// start a transaction
			session.beginTransaction();
			
			//creez cursul
			Course tempCourse = new Course("Pacman - How To Score One Million Points");
			
			//aduc reviews
			tempCourse.addReview(new Review("Great course .... loved it!"));
			tempCourse.addReview(new Review("Cool course, job well done"));
			tempCourse.addReview(new Review("What a dumb course, you are an idiot"));
			
			
			//salvez cursul
			System.out.println("Saving the course");
			session.save(tempCourse);
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			
			
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
