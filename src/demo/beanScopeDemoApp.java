package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beanScopeDemoApp {

	public static void main(String[] args) {
		
		//load the spring configuratiom file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-ApplicationContext.xml");
			
		
		//retrieve bean form spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		
		//check if are the same
		boolean result=(theCoach==alphaCoach);
		System.out.println("\nPointing to the same object: " + result);
		System.out.println("\nMemory location for theCoach: "  + theCoach);
		System.out.println("\nMemory location for alphaCoach: "  + alphaCoach +"\n");
		
		//close the context
		context.close();
		
	}

}
