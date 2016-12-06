package model;

import App.Constants;

public class WaterBowl {
	private float maxWaterLevel;
	private float currentWaterLevel;
	
	public WaterBowl(){
		maxWaterLevel = Constants.WATER_BOWL_WATER_MAX_LEVEL;
		currentWaterLevel = Constants.WATER_BOWL_WATER_INIT_LEVEL;
	}
	
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
			float waterDrained = currentWaterLevel;
			currentWaterLevel = 0;
			
			return waterDrained;
		}
	}
	
	public float getAmountOfWater(){
		return currentWaterLevel;
	}
	
}
