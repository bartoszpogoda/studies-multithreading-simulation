package controllers;

import App.Constants;
import model.WaterBowlList;
import model.threads.Flower;
import view.MainView;

public class ViewRefresher extends Thread {
	
	private MainView mainView;
	private WaterBowlList waterBowlList;
	private Flower[] flowers;
	
	private volatile boolean alive;
	
	public ViewRefresher(){
		alive = true;
	}
	
	public void setMainView(MainView mainView){
		this.mainView = mainView;
	}
	
	public void setWaterBowlList(WaterBowlList waterBowlList) {
		this.waterBowlList = waterBowlList;
	}

	public void setFlowers(Flower[] flowers) {
		this.flowers = flowers;
	}

	/**
	 * should refresh view with data from all flowers and bowls
	 */
	@Override
	public void run(){
		while(alive){
			
			// flower data refresh
			for(int i = 0 ; i < flowers.length ; i++){
				mainView.setNthFlowerHydrationLevel(i, flowers[i].getHydrationLevel());
				mainView.setNthFlowerDehydrationCycleCounter(i, flowers[i].getDehydrationCycleCounter());
			}
			
			// water bowls data refresh
			mainView.setCurrentWaterLevels(waterBowlList.getCurrentWaterLevels());
			
			try {
				sleep(Constants.VIEW_REFRESHER_INTERVAL);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
