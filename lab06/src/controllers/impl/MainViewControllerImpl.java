package controllers.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import App.Constants;
import controllers.MainViewController;
import model.WaterBowlList;
import model.impl.threads.FlowerThread;
import model.impl.threads.WorldThread;
import view.MainView;

public class MainViewControllerImpl implements MainViewController{

	private WaterBowlList waterBowlList;
	private FlowerThread[] flowerThreads;
	private WorldThread worldThread;
	private ViewRefresherThread viewRefresherThread;
	private MainView mainView;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equalsIgnoreCase("GARDENER_1")){
			waterBowlList.refill(0);
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("GARDENER_2")){
			waterBowlList.refill(1);
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("GARDENER_3")){
			waterBowlList.refill(2);
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("RESTART_FLOWER_1")){
			//data validation
			float dehydrationLimit, dehydrationStep;
			try{
				dehydrationLimit = Float.parseFloat(mainView.getNthFlowerDehydrationLimit(0));
				dehydrationStep = Float.parseFloat(mainView.getNthFlowerDehydrationStep(0));
			}catch(NumberFormatException e){
				mainView.reportError("Wartoœci musz¹ byæ typu float");
				return;
			}
			flowerThreads[0].kill();
			flowerThreads[0] = new FlowerThread(waterBowlList, 0, Constants.F1_INIT_HYDRATION_LEVEL, dehydrationLimit, dehydrationStep);
			flowerThreads[0].start();
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("RESTART_FLOWER_2")){
			//data validation
			float dehydrationLimit, dehydrationStep;
			try{
				dehydrationLimit = Float.parseFloat(mainView.getNthFlowerDehydrationLimit(1));
				dehydrationStep = Float.parseFloat(mainView.getNthFlowerDehydrationStep(1));
			}catch(NumberFormatException e){
				mainView.reportError("Wartoœci musz¹ byæ typu float");
				return;
			}
			flowerThreads[1].kill();
			flowerThreads[1] = new FlowerThread(waterBowlList, 1, Constants.F2_INIT_HYDRATION_LEVEL, dehydrationLimit, dehydrationStep);
			flowerThreads[1].start();
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("RESTART_FLOWER_3")){
			//data validation
			float dehydrationLimit, dehydrationStep;
			try{
				dehydrationLimit = Float.parseFloat(mainView.getNthFlowerDehydrationLimit(2));
				dehydrationStep = Float.parseFloat(mainView.getNthFlowerDehydrationStep(2));
			}catch(NumberFormatException e){
				mainView.reportError("Wartoœci musz¹ byæ typu float");
				return;
			}
			flowerThreads[2].kill();
			flowerThreads[2] = new FlowerThread(waterBowlList, 2, Constants.F3_INIT_HYDRATION_LEVEL, dehydrationLimit, dehydrationStep);
			flowerThreads[2].start();
		}
		
	}

	@Override
	public void setWaterBowlList(WaterBowlList waterBowlList) {
		this.waterBowlList = waterBowlList;
		
	}
	
	@Override
	public void setFlowerThreads(FlowerThread[] flowerThreads) {
		this.flowerThreads = flowerThreads;
		
	}
	
	@Override
	public void setMainView(MainView mainView) {
		this.mainView = mainView;
		
	}

	@Override
	public void terminateThreads() {
		for(FlowerThread flowerThread : flowerThreads)
			flowerThread.kill();
		
		worldThread.kill();
		viewRefresherThread.kill();
	}

	@Override
	public void setWorldThread(WorldThread worldThread) {
		this.worldThread = worldThread;
		
	}

	@Override
	public void setViewRefresherThread(ViewRefresherThread viewRefresherThread) {
		this.viewRefresherThread = viewRefresherThread;
		
	}
	
	

}
