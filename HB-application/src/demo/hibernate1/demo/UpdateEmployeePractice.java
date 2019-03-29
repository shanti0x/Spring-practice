package demo.hibernate1.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Employee;

public class UpdateEmployeePractice {

	public static void main(String[] args) {

			// session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

			// session
		Session session = factory.getCurrentSession();

		try {
			int employeeId = 1;
			//  get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve employee based on the id: primary key
			System.out.println("\nGetting employee with id: " + employeeId);

			Employee myStudent = session.get(Employee.class, employeeId);

			// delete
			// System.out.println("Deleting employee: " +myEmployee);
			// session.delete(myEmployee);

			// delete student id=2
			System.out.println("delete employee id=2");
			session.createQuery("delete from employee where id=2").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();

		}

	}
}
