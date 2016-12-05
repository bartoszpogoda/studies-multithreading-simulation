package model;

public class WaterBowl {
	private float maxWaterLevel;
	private float currentWaterLevel;
	
	// empty --> currentWaterLevel == 0
	
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
}
