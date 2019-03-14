package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class TennisCoach implements Coach {
	
private FortuneService fortuneService;

@Autowired
//injectarea FortuneService in implementarea Coach
//Autowiring, presupune ca spring scaneaza o componenta care implementeaza interfata FortuneService, adica HappyFortuneSService, va crea o instanta pe care o va injecta in TennisCoach
public TennisCoach(FortuneService theFortuneService) {
	fortuneService=theFortuneService;
}
	@Override
	public String getDailyWorkout() {
		
		return "TennisCoach - Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
