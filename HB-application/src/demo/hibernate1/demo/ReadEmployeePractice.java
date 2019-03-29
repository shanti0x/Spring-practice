package demo.hibernate1.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Employee;



public class ReadEmployeePractice {

	public static void main(String[] args) {
		
		// session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		//  session
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Creating new employee object...");
			Employee tempEmployee = new Employee("Oana", "Mihnea", "sap");
			

			// start a transaction
			session.beginTransaction();

			// save the employee obj
			System.out.println("Saving the employee...");
			System.out.println(tempEmployee);
			session.save(tempEmployee);

			// commit transaction
			session.getTransaction().commit();
			
			// find out the student`s id: primary key
			System.out.println("Saved student. Generate id: " + tempEmployee.getId());

			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: " + tempEmployee.getId());
			Employee myStudent = session.get(Employee.class, tempEmployee.getId());

			System.out.println("Get complete: " + myStudent);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();

		
		}
	}

}
