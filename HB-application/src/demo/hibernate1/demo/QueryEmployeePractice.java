package demo.hibernate1.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Employee;

public class QueryEmployeePractice {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query Employee
			List<Employee> theEmployees = session.createQuery("from Employee").getResultList();

			// display the Employees
			displayEmployees(theEmployees);
			
			//query Employee: lastName='escu'
			theEmployees=session.createQuery("from Employee s where s.lastName ='Dumitru' ").getResultList();
			
			//display the students
			System.out.println("\n\nStudents who have last name of Ionescu");
			displayEmployees(theEmployees);
			
			//query students: lastName-'Dumitru' OR 'Maria'
			
			theEmployees=
					session.createQuery("from Employee s where" 
			+ " s.lastName ='Ionescu' OR s.firstName='Iliuta'").getResultList();
			
			System.out.println("\n\nEmployees who have last name of Ionescu OR first name Iliuta");
			displayEmployees(theEmployees);
			
			
			//query Employee where company LIKE 'UPC'
			theEmployees = session.createQuery("from Employee s where"
					+ " s.company LIKE 'UPC'").getResultList();
			
			System.out.println("\n\nEmployees whose company ends with UPC");
			displayEmployees(theEmployees);
			
			
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();

		}
	}



	private static void displayEmployees(List<Employee> theEmployees) {
		for (Employee tempEmployee : theEmployees) {
			System.out.println(tempEmployee);
		}
	}

}
