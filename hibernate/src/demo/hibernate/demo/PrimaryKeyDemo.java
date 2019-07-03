package demo.hibernate.demo;

import java.util.Date;

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
					
					String theDateOfBirthStr1 = "12/09/1998";
			        Date theDateOfBirth1 = DateUtils.parseDate(theDateOfBirthStr1);
					Student tempStudent1 = new Student("Maria", "Ilies",  "Maria@gmail.com", theDateOfBirth1);
					
					String theDateOfBirthStr2 = "15/105/1999";
			        Date theDateOfBirth2 = DateUtils.parseDate(theDateOfBirthStr2);
					Student tempStudent2 = new Student("Ion", "Giugean", "Ion@gmail.com", theDateOfBirth2);
					
					String theDateOfBirthStr3 = "30/03/1998";
			        Date theDateOfBirth3 = DateUtils.parseDate(theDateOfBirthStr3);
					Student tempStudent3 = new Student("Vlad", "Dumitru", "Vlad@gmail.com", theDateOfBirth3);
					
					String theDateOfBirthStr4 = "24/08/1998";
			        Date theDateOfBirth4 = DateUtils.parseDate(theDateOfBirthStr4);
					Student tempStudent4 = new Student("Maia", "Dumitru", "Maia@gmail.com", theDateOfBirth4);
					
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
				 } catch (Exception exc) {
			            exc.printStackTrace();
				} finally {
					factory.close();

				
				}
			}

	}


