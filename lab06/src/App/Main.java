package App;

import controllers.MainViewController;
import controllers.impl.MainViewControllerImpl;
import controllers.impl.ViewRefresherThread;
import model.impl.WaterBowl;
import model.impl.WaterBowlListImpl;
import model.impl.threads.FlowerThread;
import view.MainView;
import view.impl.MainViewImpl;

public class Main {
	
	// polaczyc te watki w jakis ThreadPool czy cos i zrobic przycisk pause + run ? 
	
	public static void main(String[] args) {
		WaterBowlListImpl waterBowlList = new WaterBowlListImpl();
		
		FlowerThread flower1 = new FlowerThread(waterBowlList,0,Constants.F1_INIT_HYDRATION_LEVEL,Constants.F1_INIT_DEHYDRATION_LIMIT,Constants.F1_INIT_DEHYDRATION_STEP);
		FlowerThread flower2 = new FlowerThread(waterBowlList,1,Constants.F2_INIT_HYDRATION_LEVEL,Constants.F2_INIT_DEHYDRATION_LIMIT,Constants.F2_INIT_DEHYDRATION_STEP);
		FlowerThread flower3 = new FlowerThread(waterBowlList,2,Constants.F3_INIT_HYDRATION_LEVEL,Constants.F3_INIT_DEHYDRATION_LIMIT,Constants.F3_INIT_DEHYDRATION_STEP);
		
		MainView mainView = new MainViewImpl();
		
		ViewRefresherThread viewRefresher = new ViewRefresherThread();
		viewRefresher.setFlowers(new FlowerThread[]{flower1,flower2,flower3});
		viewRefresher.setWaterBowlList(waterBowlList);
		viewRefresher.setMainView(mainView);
		
		MainViewController mainViewController = new MainViewControllerImpl();
		mainViewController.setWaterBowlList(waterBowlList);
		
		mainView.setMainViewController(mainViewController);
		
		viewRefresher.start();
		
		flower1.start();
		flower2.start();
		flower3.start();
		
		mainView.setVisible(true);
		
		
	}

}
