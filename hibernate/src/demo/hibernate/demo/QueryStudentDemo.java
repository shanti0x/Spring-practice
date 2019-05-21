package demo.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();

			// display the students
			displayStudents(theStudents);
			
			//query students: lastName='Doe'
			theStudents=session.createQuery("from Student s where s.lastName ='Dumitru' ").getResultList();
			
			//display the students
			System.out.println("\n\nStudents who have last name of Dumitru");
			displayStudents(theStudents);
			
			//query students: lastName-'Dumitru' OR 'Maria'
			
			theStudents=
					session.createQuery("from Student s where" 
			+ " s.lastName ='Dumitru' OR s.firstName='Maria'").getResultList();
			
			System.out.println("\n\nStudents who have last name of Dumitru OR first name Maria");
			displayStudents(theStudents);
			
			
			//query students where email LIKE 'gmail'
			theStudents = session.createQuery("from Student s where"
					+ " s.email LIKE '%gmail.com'").getResultList();
			
			System.out.println("\n\nStudents whose email ends with gmail.com");
			displayStudents(theStudents);
			
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();

		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
