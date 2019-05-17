package demo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Course;
import demo.hibernate.demo.entity.Instructor;
import demo.hibernate.demo.entity.InstructorDetail;
import demo.hibernate.demo.entity.Review;
import demo.hibernate.demo.entity.Student;

public class AddCoursesForMariaDemo {

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

			// get the student mary from database
						int studentId = 1;
						Student tempStudent = session.get(Student.class, studentId);
						
						System.out.println("\nLoaded student: " + tempStudent);
						System.out.println("Courses: " + tempStudent.getCourses());
						
						// create more courses 
						Course tempCourse1 = new Course("Matematica");
						Course tempCourse2 = new Course("Istorie");
						Course tempCourse3 = new Course("Geografie");
									
						// add student to courses
						tempCourse1.addStudent(tempStudent);
						tempCourse2.addStudent(tempStudent);
						tempCourse3.addStudent(tempStudent);
									
						// save the courses
						System.out.println("\nSaving the courses ...");
						
						session.save(tempCourse1);
						session.save(tempCourse2);
						session.save(tempCourse3);

						
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