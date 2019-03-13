package demo;

import java.util.Random;

public class RandomFortuneService implements FortuneService{

	private String[] data= {
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	//random number generator
	private Random myRandom = new Random();
	
	
	@Override
	public String getFortune() {
		//chose a random string from the array
		int index = myRandom.nextInt(data.length);
		String theFortune = data[index];
		
		return theFortune;
	}
	
	

}
