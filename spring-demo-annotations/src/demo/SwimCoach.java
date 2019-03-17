package demo;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
public SwimCoach(FortuneService thefortuneService) {
	fortuneService =  thefortuneService;
}
	
	@Override
	public String getDailyWorkout() {
		
		return "Swim 1000 meters as a warm up";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
