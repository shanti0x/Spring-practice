package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		//load the spring configuratiom file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-ApplicationContext.xml");
			
		
		//retrieve bean form spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		
		
		
		//close the context
		context.close();
		
	}

}
