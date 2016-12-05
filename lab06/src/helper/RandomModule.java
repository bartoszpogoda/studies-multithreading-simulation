package helper;

import java.util.Random;

public class RandomModule {
	
	private Random random;

	private RandomModule(){
		this.random = new Random();
	}
	
	// singleton
	
	private static RandomModule instance;
	public static RandomModule getInstance(){
		if(instance == null) instance = new RandomModule();
		
		return instance;
	}
	
	
	/**
	 * 
	 * @param value value of which percentage range should be computed
	 * @param percentage 5 gives 5% etc.
	 * @return calculated random within +- percentage range
	 */
	public float getRandomFloatInPercentageRange(float value, int percentage){
		
		boolean positive = random.nextBoolean();
		
		float randomFloat = random.nextFloat();
		float randomValue = randomFloat*(((float)percentage/(float)100)*value);
		
		return positive ? (randomValue) : (-randomValue);
	}
}
