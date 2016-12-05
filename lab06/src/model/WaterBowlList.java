package model;

import java.util.ArrayList;
import java.util.List;

public class WaterBowlList {
	
	private List<WaterBowl> waterBowlList;
	private List<Boolean> avaliabilityOfWaterBowls;
	
	
	public WaterBowlList(){
		this.waterBowlList = new ArrayList<WaterBowl>();
		this.avaliabilityOfWaterBowls = new ArrayList<Boolean>();
		
		for(Boolean b : avaliabilityOfWaterBowls){
			b = true;
		}
	}
	
	public synchronized void refillAll(float ammountOfWater){
		for(WaterBowl waterBowl : waterBowlList){
			waterBowl.refill(ammountOfWater);
		}
	}
	
	
	/**
	 * handles ask for water
	 * @param nthFlower index of flower which is asking - 0 1 or 2
	 * @return water drained
	 */
	public float askForWater(int nthFlower){
		
		int firstBowl = nthFlower;
		int nextBowl = firstBowl + 1;
		if(nextBowl > 2) nextBowl = 0;
		
		synchronized(avaliabilityOfWaterBowls){
			if(avaliabilityOfWaterBowls.get(firstBowl) && avaliabilityOfWaterBowls.get(nextBowl)){
				// check which has more water
			}
			else if(avaliabilityOfWaterBowls.get(firstBowl) && !avaliabilityOfWaterBowls.get(nextBowl)){
				// use first and leave synchronized block -- variable outside
			}
			else if(!avaliabilityOfWaterBowls.get(firstBowl) && avaliabilityOfWaterBowls.get(nextBowl)){
				// use snd and leave synchronized block -- variable outside
			}
			else{
				// wait() ?
			}
		}
		
		
		return 0; //for now
	}
}
