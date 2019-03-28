package demo.hibernate1.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Employee;


public class CreateEmployeePractice {

	public static void main(String[] args) {
		
		// session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		//  session
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Creating new employee object...");
			Employee tempEmployee = new Employee("Ana", "Mihailescu", "Mitral");
			

			// start a transaction
			session.beginTransaction();

			// save the employee obj
			System.out.println("Saving the employee...");
			session.save(tempEmployee);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();

		
		}
	}

}
