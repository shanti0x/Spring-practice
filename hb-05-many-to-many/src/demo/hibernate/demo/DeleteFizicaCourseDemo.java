package demo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Course;
import demo.hibernate.demo.entity.Instructor;
import demo.hibernate.demo.entity.InstructorDetail;
import demo.hibernate.demo.entity.Review;
import demo.hibernate.demo.entity.Student;

public class DeleteFizicaCourseDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			//get the fizica course from db
			int courseId = 10;
			Course tempCourse = session.get(Course.class, courseId);
			
			//delete the course
			System.out.println("Deleting course: " + tempCourse);
			session.delete(tempCourse);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {

			// add clean up code
			session.close();

			factory.close();
		}
	}
}