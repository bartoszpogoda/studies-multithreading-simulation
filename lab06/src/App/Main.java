package App;

import model.WaterBowl;
import model.WaterBowlList;
import threads.Flower;

public class Main {
	
	// polaczyc te watki w jakis ThreadPool czy cos i zrobic przycisk pause + run ? 
	
	public static void main(String[] args) {
		WaterBowlList waterBowlList = new WaterBowlList();
		
		Flower flower1 = new Flower(waterBowlList,0);
		flower1.run();

	}

}
