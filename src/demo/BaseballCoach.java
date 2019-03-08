package demo;

public class BaseballCoach implements Coach {
	//define a private field for the dependency
	private  FortuneService fortuneService;
	
	//define constructor for dependency injection
	
	public BaseballCoach(FortuneService thefortuneService) {
		fortuneService = thefortuneService;
	}
	
	
	@Override
	
public String getDailyWorkout() {
	return "Spend 30 minutes on batting practice";
}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}
}
