package threads;

import App.Constants;
import model.WaterBowlList;
import view.DrawableFlower;

public class Flower extends Thread implements DrawableFlower {

	private volatile float hydrationLevel;
	private volatile float dehydrationLimit;
	private volatile float dehydrationStep;
	private volatile int dehydrationCycleCounter = 0;
	private int number;
	
	private WaterBowlList waterBowlList;
	
	public Flower(WaterBowlList waterBowlList, int number){
		this.waterBowlList = waterBowlList;
		this.number = number;
		
		this.hydrationLevel = Constants.INIT_HYDRATION_LEVEL;
		this.dehydrationLimit = Constants.DEFAULT_DEHYDRATION_LIMIT;
		this.dehydrationStep = Constants.DEFAULT_DEHYDRATION_STEP;
	}
	
	@Override
	public void run() {
		while(dehydrationCycleCounter != Constants.CYCLES_OF_DEHYDRATION_TO_DIE){
			
			System.out.println("Flower " + number + " Hydration: " + hydrationLevel);
			
			hydrationLevel -= dehydrationStep;
			
			if(hydrationLevel <= 0){				
				hydrationLevel = 0;
				dehydrationCycleCounter++;
			} else{
				dehydrationCycleCounter = 0;
			}
			
			if(hydrationLevel <= dehydrationLimit){
				float waterDrained = waterBowlList.askForWater(number, hydrationLevel);
				hydrationLevel += waterDrained;
				if(hydrationLevel > 100) hydrationLevel = 100;
			}
			
			try {
				sleep(Constants.DEHYDRATION_MS_INTERAVAL);
			} catch (InterruptedException e) {
			}
			
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

}
