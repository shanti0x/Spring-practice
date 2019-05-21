package demo.hibernate1.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Employee;

public class PrimaryKeyPractice {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating new employee objects...");
			Employee tempEmployee1 = new Employee("Ana", "Mihailescu", "Mitral");
			Employee tempEmployee2 = new Employee("Ioana", "Mihai", "UPC");
			Employee tempEmployee3 = new Employee("Sebe", "Iliescu", "UPC");
			Employee tempEmployee4 = new Employee("Iliuta", "Ionescu", "Mitral");
			Employee tempEmployee5 = new Employee("Vlad", "Ionascu", "UPC");
			Employee tempEmployee6 = new Employee("Irina", "Costescu", "Mitral");

			// start a transaction
			session.beginTransaction();

			// save the employee obj
			System.out.println("Saving the employee...");
			session.save(tempEmployee1);
			session.save(tempEmployee2);
			session.save(tempEmployee3);
			session.save(tempEmployee4);
			session.save(tempEmployee5);
			session.save(tempEmployee6);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();

		}
	}
}