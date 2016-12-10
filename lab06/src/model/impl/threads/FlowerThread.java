package model.impl.threads;

import App.Constants;
import model.Flower;
import model.WaterBowlList;
import model.impl.WaterBowlListImpl;

public class FlowerThread extends Thread implements Flower {

	private volatile float hydrationLevel;
	private volatile float dehydrationLimit;
	private volatile float dehydrationStep;
	private volatile int dehydrationCycleCounter = 0;
	private int number;
	
	private WaterBowlList waterBowlList;
	
	public FlowerThread(WaterBowlList waterBowlList, int number, float hydrationLevel, float dehydrationLimit, float dehydrationStep){
		this.waterBowlList = waterBowlList;
		this.number = number;
		
		this.hydrationLevel = hydrationLevel;
		this.dehydrationLimit = dehydrationLimit;
		this.dehydrationStep = dehydrationStep;
	}
	
	@Override
	public void run() {
		while(dehydrationCycleCounter != Constants.CYCLES_OF_DEHYDRATION_TO_DIE){
			
			
			dehydratingProcess();
			
			if(hydrationLevel <= dehydrationLimit){
				drinkingProcess();
			}else{
				dehydrationCycleCounter = 0;
			}
			
			dyingProcess();
			
			try {
				sleep(Constants.DEHYDRATION_MS_INTERAVAL);
			} catch (InterruptedException e) {
			}
			
		}
		
		System.out.println("Flower " + number + " has just died.");
	}
	
	private void dehydratingProcess(){
		hydrationLevel -= dehydrationStep;
		
		if(hydrationLevel < 0) hydrationLevel = 0;
	}
	
	private void drinkingProcess(){
		float waterDrained = waterBowlList.askForWater(number, hydrationLevel);
		hydrationLevel += waterDrained;
		if(hydrationLevel > 100) hydrationLevel = 100;
	}
	
	private void dyingProcess(){
		//flowers are dying when below 1/3 of dehydration limit TODO: make sure ?
		//instead the cycle counter should reset when flower is up the hydration limit
		//if(hydrationLevel <= dehydrationLimit/3){				
		if(hydrationLevel <= 0.01f){				
			if(hydrationLevel<0) hydrationLevel = 0;
			dehydrationCycleCounter++;
		}
	}
	
	
	
	@Override
	public float getHydrationLevel() {
		return hydrationLevel;
	}

	@Override
	public void setDehydrationLimit(float dehydrationLimit) {
		this.dehydrationLimit = dehydrationLimit;
	}

	@Override
	public void setDehydrationStep(float dehydrationStep) {
		this.dehydrationStep = dehydrationStep;
	}

	public int getDehydrationCycleCounter() {
		return dehydrationCycleCounter;
	}

	@Override
	public float getDehydrationLimit() {
		return dehydrationLimit;
	}
	
	public void kill(){
		dehydrationCycleCounter = Constants.CYCLES_OF_DEHYDRATION_TO_DIE;
	}

}
