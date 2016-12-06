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
			System.out.println("Needed" + (100 - hydrationLevel));
			System.out.println("Left" + currentWaterLevel);
			return (100 - hydrationLevel);
		}
		else{
			float waterDrained = currentWaterLevel;
			System.out.println("Got" + currentWaterLevel);
			currentWaterLevel = 0;
			return waterDrained;
		}
	}
	
	public float getAmountOfWater(){
		return currentWaterLevel;
	}
	
}
