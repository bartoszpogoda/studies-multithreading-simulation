package threads;

import model.WaterBowlList;

public class World implements Runnable {
	
	private volatile float hydrationStep;
	private volatile int hydrationInterval;
	
	private WaterBowlList waterBowlList;
	
	@Override
	public void run() {
		
		waterBowlList.refillAll(hydrationStep);
		
		try {
			Thread.sleep(hydrationInterval);
		} catch (InterruptedException e) {
			
		}

	}
	
	public void setHydrationStep(float hydrationStep){
		this.hydrationStep = hydrationStep;
	}

	public void setHydrationInterval(int hydrationInterval){
		this.hydrationInterval = hydrationInterval;
	}
}
