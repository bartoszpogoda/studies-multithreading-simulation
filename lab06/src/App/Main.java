package App;

import controllers.ViewRefresher;
import model.WaterBowl;
import model.WaterBowlList;
import model.threads.Flower;
import view.MainView;
import view.impl.MainViewTestImpl;

public class Main {
	
	// polaczyc te watki w jakis ThreadPool czy cos i zrobic przycisk pause + run ? 
	
	public static void main(String[] args) {
		WaterBowlList waterBowlList = new WaterBowlList();
		
		Flower flower1 = new Flower(waterBowlList,0);
		Flower flower2 = new Flower(waterBowlList,1);
		
		MainView mainView = new MainViewTestImpl();
		
		ViewRefresher viewRefresher = new ViewRefresher();
		viewRefresher.setFlowers(new Flower[]{flower1,flower2});
		viewRefresher.setWaterBowlList(waterBowlList);
		viewRefresher.setMainView(mainView);
		
		
		viewRefresher.start();
		
		flower1.start();
		flower2.start();

	}

}
