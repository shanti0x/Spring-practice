package demo;

public class CricketCoach implements Coach {
	private FortuneService fortuneService;
	
	//add new fields for emailAddress and team
	private String emailAddress;
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		
		return Team;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method - setTeam");
		Team = team;
	}

	private String Team;
	
	//create a no-arg constructor
	public  CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	//our setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}


	@Override
	public String getDailyWorkout() {
		
		return "Practice fast bowling for 15 minute a day";
	}

	@Override
	public String getDailyFortune() {
	
		return fortuneService.getFortune();
	}

}
