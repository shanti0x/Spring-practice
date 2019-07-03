package demo.hibernate.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Course;
import demo.hibernate.demo.entity.Instructor;
import demo.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// obtin inst din db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("Debug - Instructor: " + tempInstructor);

			System.out.println("Debug - Courses: " + tempInstructor.getCourses());

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Debug - Done!");

		} finally {
			// add clean up code
			session.close();
			factory.close();

		}
	}

}
