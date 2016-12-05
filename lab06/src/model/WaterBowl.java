package model;

public class WaterBowl {
	private float maxWaterLevel;
	private float currentWaterLevel;
	
	// empty --> currentWaterLevel == 0
	
	/**
	 * refills to full
	 */
	public synchronized void refill(){
		
	}
	
	public synchronized void refill(float ammountOfWater){
		this.currentWaterLevel += ammountOfWater;
		//if
	}
}
