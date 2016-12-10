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
				dehydrationLimit = Float.parseFloat(mainView.getFlowerDehydrationLimits()[0]);
				dehydrationStep = Float.parseFloat(mainView.getFlowerDehydrationSteps()[0]);
			}catch(NumberFormatException e){
				mainView.reportError("Wartoœci musz¹ byæ typu float");
				return;
			}
			flowerThreads[0].kill();
			flowerThreads[0] = new FlowerThread(waterBowlList, 0, 100f, dehydrationLimit, dehydrationStep);
			flowerThreads[0].start();
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("RESTART_FLOWER_2")){
			//data validation
			float dehydrationLimit, dehydrationStep;
			try{
				dehydrationLimit = Float.parseFloat(mainView.getFlowerDehydrationLimits()[1]);
				dehydrationStep = Float.parseFloat(mainView.getFlowerDehydrationSteps()[1]);
			}catch(NumberFormatException e){
				mainView.reportError("Wartoœci musz¹ byæ typu float");
				return;
			}
			flowerThreads[1].kill();
			flowerThreads[1] = new FlowerThread(waterBowlList, 1, 100f, dehydrationLimit, dehydrationStep);
			flowerThreads[1].start();
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("RESTART_FLOWER_3")){
			//data validation
			float dehydrationLimit, dehydrationStep;
			try{
				dehydrationLimit = Float.parseFloat(mainView.getFlowerDehydrationLimits()[2]);
				dehydrationStep = Float.parseFloat(mainView.getFlowerDehydrationSteps()[2]);
			}catch(NumberFormatException e){
				mainView.reportError("Wartoœci musz¹ byæ typu float");
				return;
			}
			flowerThreads[2].kill();
			flowerThreads[2] = new FlowerThread(waterBowlList, 2, 100f, dehydrationLimit, dehydrationStep);
			flowerThreads[2].start();
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("UPDATE_DATA")){
			//data validation
			String[] strDehydrationLimits, strDehydrationSteps;
			strDehydrationLimits = mainView.getFlowerDehydrationLimits();
			strDehydrationSteps = mainView.getFlowerDehydrationSteps();
			
			float[] dehydrationLimits = new float[3];
			float[] dehydrationSteps = new float[3];
			
			try{
				for(int i=0; i < 3; i++){
					dehydrationLimits[i] = Float.parseFloat(strDehydrationLimits[i]);
					dehydrationSteps[i] = Float.parseFloat(strDehydrationSteps[i]);
				}
			}catch(NumberFormatException e){
				mainView.reportError("Wartoœci musz¹ byæ typu float");
				return;
			}
			
			for(int i=0; i < 3; i++){
				flowerThreads[i].setDehydrationLimit(dehydrationLimits[i]);
				flowerThreads[i].setDehydrationStep(dehydrationSteps[i]);
			}
		}
		else if(arg0.getActionCommand().equalsIgnoreCase("UPDATE_WORLD_DATA")){
			int worldRefillInterval;
			float worldRefillSpeed;
			
			try{
				worldRefillInterval = Integer.parseInt(mainView.getWorldRefillInterval());
				worldRefillSpeed = Float.parseFloat(mainView.getWorldRefillSpeed());
				
			}catch(NumberFormatException e){
				mainView.reportError("Interwa³ musi byc ca³kowity (ms), prêdkoœæ typu float");
				return;
			}
			
			worldThread.setRefillInterval(worldRefillInterval);
			worldThread.setRefillSpeed(worldRefillSpeed);
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
