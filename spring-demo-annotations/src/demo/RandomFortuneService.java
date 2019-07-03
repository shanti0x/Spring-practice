package demo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	//create an array of string
	private String[]data= {
			"RandomFortuneService - Beware of the wolf in sheeep`s clothing",
			"RandomFortuneService - Diligence is the mother of good luck",
			"RandomFortuneService - The journey is the reword"
	};
	
	// create a randm number generator
	private Random myRandom = new Random();
	
	
	@Override
	public String getFortune() {
		//pick a random string from the array
		int index = myRandom.nextInt(data.length);
		String theFortune = data[index];
		
		return theFortune ;
	}

}
