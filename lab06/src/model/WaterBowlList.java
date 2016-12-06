package model;

import java.util.ArrayList;
import java.util.List;

public class WaterBowlList {
	
	private List<WaterBowl> waterBowlList;
	private List<Boolean> avaliabilityOfWaterBowls;
	
	
	public WaterBowlList(){
		this.waterBowlList = new ArrayList<WaterBowl>();
		this.avaliabilityOfWaterBowls = new ArrayList<Boolean>();
		
		waterBowlList.add(new WaterBowl());
		waterBowlList.add(new WaterBowl());
		waterBowlList.add(new WaterBowl());
		
		avaliabilityOfWaterBowls.add(true);
		avaliabilityOfWaterBowls.add(true);
		avaliabilityOfWaterBowls.add(true);
	}
	
	public synchronized void refillAll(float ammountOfWater){
		for(WaterBowl waterBowl : waterBowlList){
			synchronized(waterBowl){
				waterBowl.refill(ammountOfWater);
			}
		}
	}
	
	
	/**
	 * handles ask for water
	 * @param nthFlower index of flower which is asking - 0 1 or 2
	 * @return water drained
	 */
	public float askForWater(int nthFlower, float hydrationLevel){
		
		int firstBowl = nthFlower;
		int nextBowl = firstBowl + 1;
		if(nextBowl > 2) nextBowl = 0;
		
		int whichBowlToUse = -1;
		
		synchronized(avaliabilityOfWaterBowls){
			while(whichBowlToUse == -1){
				if(avaliabilityOfWaterBowls.get(firstBowl) && avaliabilityOfWaterBowls.get(nextBowl)){
					if(waterBowlList.get(firstBowl).getAmountOfWater() >= waterBowlList.get(nextBowl).getAmountOfWater()){
						whichBowlToUse = firstBowl;
					} else{
						whichBowlToUse = nextBowl;
					}

					avaliabilityOfWaterBowls.set(whichBowlToUse, false);
				}
				else if(avaliabilityOfWaterBowls.get(firstBowl) && !avaliabilityOfWaterBowls.get(nextBowl)){
					whichBowlToUse = firstBowl;
					avaliabilityOfWaterBowls.set(whichBowlToUse, false);
				}
				else if(!avaliabilityOfWaterBowls.get(firstBowl) && avaliabilityOfWaterBowls.get(nextBowl)){
					whichBowlToUse = nextBowl;
					avaliabilityOfWaterBowls.set(whichBowlToUse, false);
				}
				else{
					try {
						avaliabilityOfWaterBowls.wait();
					} catch (InterruptedException e) {
						
					}
				}
			}
		}
		
		float waterDrained = 0;
		
		synchronized(waterBowlList.get(whichBowlToUse)){
			WaterBowl waterBowl = waterBowlList.get(whichBowlToUse);
			waterDrained = waterBowl.drainWater(hydrationLevel);
		}
		
		
		synchronized(avaliabilityOfWaterBowls){
			avaliabilityOfWaterBowls.set(whichBowlToUse, true);
			
			avaliabilityOfWaterBowls.notify();
		}
		
		
		return waterDrained;
	}
}
