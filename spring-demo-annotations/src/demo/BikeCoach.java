package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("thatSillyHill")

public class BikeCoach implements Coach {
	private FortuneService fortuneService;

	@Autowired
	//spring scaneaza o componenta care implementeaza interfata FortuneService, adica HappyFortuneSService, va crea o instanta pe care o va injecta in TennisCoach
	public BikeCoach(FortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "BikeCoach - If you go up hills you will find success";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
