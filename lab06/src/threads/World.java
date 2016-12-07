package threads;

import model.WaterBowlList;
import view.IWorldGUI;

public class World implements Runnable, IWorldGUI {
	
	private volatile float refillSpeed;
	private volatile int refillInterval;
	
	private WaterBowlList waterBowlList;
	
	@Override
	public void run() {
		
		waterBowlList.refillAll(refillSpeed);
		
		try {
			Thread.sleep(refillInterval);
		} catch (InterruptedException e) {
			
		}

	}
	
	public void setHydrationStep(float hydrationStep){
		this.refillSpeed = hydrationStep;
	}

	public void setHydrationInterval(int hydrationInterval){
		this.refillInterval = hydrationInterval;
	}
	
	public World(WaterBowlList waterBowlList){
		this.waterBowlList = waterBowlList;
	}

	@Override
	public void setRefillSpeed(float refillSpeed) {
		this.refillSpeed = refillSpeed;
	}

	@Override
	public void setRefillInterval(int refillInterval) {
		this.refillInterval = refillInterval;
	}
}
