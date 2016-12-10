package model.impl.threads;

import model.World;
import model.impl.WaterBowlListImpl;

public class WorldThread implements Runnable, World {
	
	private volatile float refillSpeed;
	private volatile int refillInterval;
	
	private WaterBowlListImpl waterBowlList;
	
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
	
	public WorldThread(WaterBowlListImpl waterBowlList){
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
