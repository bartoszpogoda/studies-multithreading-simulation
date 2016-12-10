package model.impl.threads;

import App.Constants;
import model.World;
import model.impl.WaterBowlListImpl;

public class WorldThread extends Thread implements World {
	
	private volatile float refillSpeed; 
	private volatile int refillInterval;
	private volatile boolean alive = true;
	
	private WaterBowlListImpl waterBowlList;
	
	
	public WorldThread(WaterBowlListImpl waterBowlList){
		this.waterBowlList = waterBowlList;
		refillSpeed = Constants.WORLD_INIT_REFILL_SPEED;
		refillInterval = Constants.WORLD_INIT_REFILL_INTERVAL;
		alive = true;
	}

	@Override
	public void run() {
		while(alive){
			waterBowlList.refillAll(refillSpeed);
			
			try {
				Thread.sleep(refillInterval);
			} catch (InterruptedException e) {
				
			}
		}
		System.out.println("World has just died");
	}
	
	@Override
	public void setRefillSpeed(float refillSpeed) {
		this.refillSpeed = refillSpeed;
	}

	@Override
	public void setRefillInterval(int refillInterval) {
		this.refillInterval = refillInterval;
	}
	
	public void kill(){
		alive = false;
	}

}
