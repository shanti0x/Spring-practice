package demo.hibernate1.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Employee;
import demo.hibernate.demo.entity.Student;

public class UpdateEmployeeDemo {
	
	public static void main(String[] args) {
		
		// create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
						.buildSessionFactory();

				// create session
				Session session = factory.getCurrentSession();
				int employeeId = 1;

				// now get a new session and start transaction
				session = factory.getCurrentSession();
				session.beginTransaction();

				// retrieve employee based on the id: primary key
				System.out.println("\nGetting student with id: " + employeeId);

				Employee myStudent = session.get(Employee.class, employeeId);

				//delete
//				System.out.println("Deleting employee: " +myEmployee);
//				session.delete(myEmployee);
				
				//delete student id=2
				System.out.println("delete student id=2");
				session.createQuery("delete from Student where id=2").executeUpdate();
				
				
				// commit the transaction
				session.getTransaction().commit();
				System.out.println("Done!");

			} finally {
				factory.close();

			}
		
		
		
		
		
		
		
		
	}

}
