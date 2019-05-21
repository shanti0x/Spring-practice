package demo.hibernate1.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Employee;

public class DeleteEmployeePractice {

	public static void main(String[] args) {

		// session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		//  session
		Session session = factory.getCurrentSession();

		try {

			int employeeId = 1;

			// get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve Employee based on the id: primary key
			System.out.println("\nGetting Employee with id: " + employeeId);

			Employee myEmployee = session.get(Employee.class, employeeId);

			System.out.println("Updating Employee....");
			myEmployee.setFirstName("Misha");//numele este updatat in memorie, dupa commit devine update si in db

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			//new code
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update company for all Employee
			System.out.println("update company for all employees");
			session.createQuery("update Employee set company='Microsoft'")
			.executeUpdate();
			
			// commit the transaction
						session.getTransaction().commit();

		} finally {
			factory.close();

		}
	}

}
