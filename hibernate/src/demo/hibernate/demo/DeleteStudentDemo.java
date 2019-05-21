package demo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Updating student....");
			myStudent.setFirstName("Scooby");//numele este updatat in memorie, dupa commit devine update si in db

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			//new code
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			System.out.println("update email for all students");
			session.createQuery("update Student set email='foo@yahoo.com'")
			.executeUpdate();
			
			// commit the transaction
						session.getTransaction().commit();

		} finally {
			factory.close();

		}
	}

}
