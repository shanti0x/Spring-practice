package demo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	//add  multiple students
	
	public static void main(String[] args) {
		
		// create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
						.buildSessionFactory();

				// create session
				Session session = factory.getCurrentSession();
				
				try {
					// create 3 students object
					System.out.println("Creating 3 students objects...");
					Student tempStudent1 = new Student("Maria", "Ilies", "Maria@gmail.com");
					Student tempStudent2 = new Student("Ion", "Giugean", "Ion@gmail.com");
					Student tempStudent3 = new Student("Vlad", "Dumitru", "Vlad@gmail.com");
					Student tempStudent4 = new Student("Maia", "Dumitru", "Maia@gmail.com");
					
					// start a transaction
					session.beginTransaction();

					// save the student obj
					System.out.println("Saving the student...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					session.save(tempStudent4);

					// commit transaction
					session.getTransaction().commit();
					System.out.println("Done!");

				} finally {
					factory.close();

				
				}
			}

	}


