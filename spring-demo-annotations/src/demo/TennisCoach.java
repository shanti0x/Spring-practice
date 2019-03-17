package demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
@Autowired
@Qualifier("randomFortuneService")
private FortuneService fortuneService;

//default constructor
public TennisCoach() {
	System.out.println(">> TennisCoach: inside default constructor");
}

//define my init method
@PostConstruct
public void doMyStartupStuff() {
	System.out.println(">> TennisCoach - inside of doMyStartupStuff() method");
}


//define my destroy method
@PreDestroy
public void doMyCleanupStuff() {
	System.out.println(">>TennisCoach - inside of doMyCleanupStuff() method");
}
//define a setter method
/*
@Autowired
public void setFortuneService(FortuneService theFortuneService) {
	System.out.println(">> TennisCoach: inside setFortuneService() method");
	fortuneService = theFortuneService;
}
*/
/*
@Autowired
injectarea FortuneService in implementarea Coach
Autowiring, presupune ca spring scaneaza o componenta care implementeaza interfata FortuneService, adica HappyFortuneSService, va crea o instanta pe care o va injecta in TennisCoach
/*public TennisCoach(FortuneService theFortuneService) {
	fortuneService=theFortuneService;
}*/
	@Override
	public String getDailyWorkout() {
		
		return "TennisCoach - Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
