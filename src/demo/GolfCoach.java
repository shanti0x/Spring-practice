package demo;

public class GolfCoach implements Coach{
	private FortuneService fortuneService;
	
	
	public GolfCoach() {
		
	}

	public GolfCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Practice skills for 4 hours today";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}
	

}
