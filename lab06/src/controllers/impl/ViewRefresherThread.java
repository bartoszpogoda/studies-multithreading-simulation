package controllers.impl;

import App.Constants;
import helper.RandomModule;
import model.impl.WaterBowlListImpl;
import model.impl.threads.FlowerThread;
import view.MainView;

public class ViewRefresherThread extends Thread {
	
	private MainView mainView;
	private WaterBowlListImpl waterBowlList;
	private FlowerThread[] flowers;
	
	private volatile boolean alive;
	
	public ViewRefresherThread(){
		alive = true;
	}
	
	public void setMainView(MainView mainView){
		this.mainView = mainView;
	}
	
	public void setWaterBowlList(WaterBowlListImpl waterBowlList) {
		this.waterBowlList = waterBowlList;
	}

	public void setFlowers(FlowerThread[] flowers) {
		this.flowers = flowers;
	}

	public void kill(){
		alive=false;
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
				mainView.setNthFlowerDehydrationLimit(i, flowers[i].getDehydrationLimit());
			}
			
			// water bowls data refresh
			mainView.setCurrentWaterLevels(waterBowlList.getCurrentWaterLevels());
			
			try {
				sleep(Constants.VIEW_REFRESHER_INTERVAL);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// randomness monitor refresh
			mainView.setRandomnessAverage(RandomModule.getInstance().getCurrentAverage());
		}
	}
}
