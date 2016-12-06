package model;

public class WaterBowl {
	private float maxWaterLevel = 100;
	private float currentWaterLevel = 100;
	
	// empty --> currentWaterLevel == 0
	// maxWaterLevel - 100? - %?
	
	/**
	 * refills to full
	 */
	public void refill(){
		currentWaterLevel = maxWaterLevel;
	}
	
	public void refill(float ammountOfWater){
		currentWaterLevel += ammountOfWater;
		
		if(currentWaterLevel > maxWaterLevel) currentWaterLevel = maxWaterLevel;
	}
	
	public float drainWater(float hydrationLevel){
		if(currentWaterLevel >= 100 - hydrationLevel){
			currentWaterLevel -= (100 - hydrationLevel);
			return (100 - hydrationLevel);
		}
		else{
			currentWaterLevel = 0;
			return currentWaterLevel;
		}
	}
	
	public float getAmountOfWater(){
		return currentWaterLevel;
	}
	
}
